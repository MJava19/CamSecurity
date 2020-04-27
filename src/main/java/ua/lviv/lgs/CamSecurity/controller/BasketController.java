package ua.lviv.lgs.CamSecurity.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import ua.lviv.lgs.CamSecurity.entity.Goods;
import ua.lviv.lgs.CamSecurity.entity.ShoppingBasket;
import ua.lviv.lgs.CamSecurity.entity.User;
import ua.lviv.lgs.CamSecurity.exeption.NotFoundExeption;
import ua.lviv.lgs.CamSecurity.servise.GoodsServise;
import ua.lviv.lgs.CamSecurity.servise.ShoppingBasketServise;
import ua.lviv.lgs.CamSecurity.servise.UserServise;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BasketController {
    private final ShoppingBasketServise basketServise;
    private final GoodsServise goodsServise;
    private final UserServise userServise;

    @GetMapping("/basket")
    public String addGoodsToBasket(HttpServletRequest request, @RequestParam Long id) {
        if (request.isUserInRole("ROLE_USER")) {
            Principal principal = request.getUserPrincipal();
            User user = userServise.findByUsername(principal.getName());
            ShoppingBasket shoppingBasket = user.getShoppingBasket();
            createBasket(id, shoppingBasket);
        } else {
            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
            ShoppingBasket isBasket;
            isBasket = basketServise.findBySessionId(sessionId);
            if (isBasket != null) {
                createBasket(id, isBasket);
            } else {
                ShoppingBasket shoppingBasket = new ShoppingBasket();
                basketServise.create(shoppingBasket);
                shoppingBasket.setSessionId(sessionId);
                createBasket(id, shoppingBasket);
            }
        }
        return "redirect:/goods";
    }

    public void createBasket(@RequestParam Long id, ShoppingBasket shoppingBasket) {
        Goods goods = goodsServise.findById(id).orElseThrow(() -> new NotFoundExeption("Goods with id: " + id + "was not found"));
        List<Goods> rezult = new ArrayList<>();
        if (shoppingBasket.getGoods() != null){
            rezult.addAll(shoppingBasket.getGoods());
        }
        rezult.add(goods);
        shoppingBasket.setGoods(rezult);
        basketServise.create(shoppingBasket);
        shoppingBasket.setTotalGoods((long) shoppingBasket.getGoods().size());
        Long price = (long) 0;
        for (int i = 0; i < shoppingBasket.getGoods().size(); i++) {
            price = price + rezult.get(i).getPrice();
        }
        shoppingBasket.setTotalPrice(price);
        basketServise.create(shoppingBasket);
    }


    @GetMapping("/myBasket")
    public String getBasket(Model model, HttpServletRequest request) {
        if (!request.isUserInRole("ROLE_USER")) {
            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
            if (basketServise.findBySessionId(sessionId) != null) {
                ShoppingBasket shoppingBasket = basketServise.findBySessionId(sessionId);
                if (shoppingBasket.getTotalGoods() == null || shoppingBasket.getTotalGoods() == 0) {
                    return "empty-basket";
                }
                model.addAttribute("basket", shoppingBasket);
            } else {
                ShoppingBasket shoppingBasket = new ShoppingBasket();
                basketServise.create(shoppingBasket);
                shoppingBasket.setSessionId(sessionId);
                basketServise.create(shoppingBasket);
                if (shoppingBasket.getTotalGoods() == null || shoppingBasket.getTotalGoods() == 0) {
                    return "empty-basket";
                }
                model.addAttribute("basket", shoppingBasket);
            }
        } else {
            Principal principal = request.getUserPrincipal();
            User user = userServise.findByUsername(principal.getName());
            ShoppingBasket shoppingBasket = user.getShoppingBasket();
            if (shoppingBasket.getTotalGoods() == null || shoppingBasket.getTotalGoods() == 0) {
                return "empty-basket";
            }
            model.addAttribute("basket", shoppingBasket);
        }
        return "basket";
    }

    @GetMapping("/myBasket/delete")
    public String deleteGoods(@RequestParam Long id, HttpServletRequest request) {
        deleteGoodsInBasket(request, id);
        return "redirect:/myBasket";
    }

    public void deleteGoodsInBasket(HttpServletRequest request, @RequestParam Long id) {
        try {
            if (!request.isUserInRole("ROLE_USER")) {
                String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
                ShoppingBasket shoppingBasket = basketServise.findBySessionId(sessionId);
                deleteGoods(shoppingBasket, id);
            } else {
                Principal principal = request.getUserPrincipal();
                User user = userServise.findByUsername(principal.getName());
                ShoppingBasket shoppingBasket = user.getShoppingBasket();
                deleteGoods(shoppingBasket, id);
            }
        } catch (Exception e) {
        }
    }

    public void deleteGoods(ShoppingBasket shoppingBasket, @RequestParam Long id) {
        List<Goods> basketGoods = shoppingBasket.getGoods();
        for (int i = 0; i < basketGoods.size(); i++) {
            if (basketGoods.get(i).getId() == id) {
                basketGoods.remove(i);
            }
        }
        shoppingBasket.setGoods(basketGoods);
        basketServise.create(shoppingBasket);
        shoppingBasket.setTotalGoods((long) shoppingBasket.getGoods().size());
        Long price = (long) 0;
        for (int i = 0; i < shoppingBasket.getGoods().size(); i++) {
            price = price + basketGoods.get(i).getPrice();
        }
        shoppingBasket.setTotalPrice(price);
        basketServise.create(shoppingBasket);
    }
}
