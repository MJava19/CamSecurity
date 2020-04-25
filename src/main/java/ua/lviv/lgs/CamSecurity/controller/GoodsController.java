package ua.lviv.lgs.CamSecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.CamSecurity.entity.*;
import ua.lviv.lgs.CamSecurity.exeption.NotFoundExeption;
import ua.lviv.lgs.CamSecurity.servise.*;
import ua.lviv.lgs.CamSecurity.servise.impl.GoodsDTO;
import ua.lviv.lgs.CamSecurity.validator.GoodsValidator;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsServise goodsServise;
    private final ImageService imageSrevice;
    private final GroupService groupService;
    private final BasketController basketController;
    private final GoodsValidator goodsValidator;

    @Secured("ROLE_ADMIN")
    @GetMapping("/create")
    public String getGoodsPage(Model model) {
        model.addAttribute("goodsForm", new GoodsDTO());
        model.addAttribute("groups", groupService.findAll());
        return "goods";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/update")
    public String updateGoods(@ModelAttribute GoodsDTO goodsDTO, BindingResult bindingResult) {
        Goods goods = mapToEntity(goodsDTO);
        mapImage(goodsDTO, goods);
        goodsValidator.validate(goods, bindingResult);
        if (bindingResult.hasErrors()) {
            return "goods";
        }
        goodsServise.create(goods);
        groupService.addGoodsToGroup(goods.getId(), goods.getGroup().getId());
        return "redirect:/goods";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public String createGoods(@ModelAttribute ("goodsForm") GoodsDTO goodsDTO, BindingResult bindingResult) {
        Goods goods = mapToEntity(goodsDTO);
        mapImage(goodsDTO, goods);
        goodsValidator.validate(goods, bindingResult);
        if (bindingResult.hasErrors()) {
            return "goods";
        }
        goodsServise.create(goods);
        groupService.addGoodsToGroup(goods.getId(), goods.getGroup().getId());
        return "redirect:/goods";
    }

    private Goods mapToEntity(GoodsDTO goodsDTO) {
        Goods rezult = new Goods();
        rezult.setId(goodsDTO.getId());
        rezult.setCode(goodsDTO.getCode());
        rezult.setName(goodsDTO.getName());
        rezult.setPrice(goodsDTO.getPrice());
        rezult.setDescription(goodsDTO.getDescription());
        rezult.setGroup(goodsDTO.getGroup());
        return rezult;
    }

    private void mapImage(GoodsDTO goodsDTO, Goods goods) {
        List<MultipartFile> multipartFile = goodsDTO.getImage();
        List<Image> images = new LinkedList<>();
        for(int i = 0; i < multipartFile.size(); i++ ){
            try {
                Image image = new Image();
                image.setBase64image(Base64.getEncoder().encodeToString(multipartFile.get(i).getBytes()));
                imageSrevice.create(image);
                images.add(image);
                goods.setImage(images);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping
    public String getGoods(Model model){
        model.addAttribute("goods", goodsServise.findAll());
        return "goods_list";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete")
    public String deleteGoods(@RequestParam Long id, HttpServletRequest request) {
        try {
            Goods goods = goodsServise.findById(id).orElseThrow( () -> new NotFoundExeption("Goods with id: " + id + "was not found"));
            goods.setImage(null);
            goodsServise.create(goods);
            if (goods.getGroup() != null){
            Groups group = goods.getGroup();
            List<Goods> goodsList = group.getGoods();
            for (int i = 0; i < group.getGoods().size(); i++){
                if (goodsList.get(i).getId() == id) {
                    goodsList.remove(i);
                    group.setGoods(goodsList);
                    groupService.update(group);
                }
            }
            }
            basketController.deleteGoodsInBasket(request, id);
            goodsServise.deleteById(id);

        } catch (Exception e) {
            return "goods-not-found";
        }
        return "redirect:/goods";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/one")
    public String getOne(@RequestParam Long id, Model model) {
        Optional<Goods> goodsOptional = goodsServise.findById(id);
        if (goodsOptional.isPresent()) {
            model.addAttribute("goods", goodsOptional.get());
            model.addAttribute("groups", groupService.findAll());
            return "goods-update";
        }
        return "goods-not-found";
    }


}
