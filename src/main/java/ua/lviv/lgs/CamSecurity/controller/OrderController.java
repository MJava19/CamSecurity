package ua.lviv.lgs.CamSecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.lgs.CamSecurity.entity.*;
import ua.lviv.lgs.CamSecurity.servise.FinishOrderService;
import ua.lviv.lgs.CamSecurity.servise.OrderService;
import ua.lviv.lgs.CamSecurity.servise.ShoppingBasketServise;
import ua.lviv.lgs.CamSecurity.servise.UserServise;
import ua.lviv.lgs.CamSecurity.validator.OrderValidator;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final UserServise userServise;
    private final FinishOrderService finishOrderService;
    private final ShoppingBasketServise basketServise;
    private final OrderValidator orderValidator;

    @GetMapping("/order")
    public String getOrderPage(Model model) {
        model.addAttribute("orderForm", new Order());
        return "buy";
    }

    @PostMapping("/order")
    public String createOrder(HttpServletRequest request, @ModelAttribute("orderForm") Order order, BindingResult bindingResult){
        if (request.isUserInRole("ROLE_USER")) {
            Principal principal = request.getUserPrincipal();
            User user = userServise.findByUsername(principal.getName());
            if (user.getShoppingBasket().getTotalGoods() == 0) {
                return "redirect:/myBasket";
            }
            List<Goods> goodsList = new ArrayList<>();
            goodsList.addAll(user.getShoppingBasket().getGoods());
            Long totalGoods = user.getShoppingBasket().getTotalGoods();
            Long totalPrise = user.getShoppingBasket().getTotalPrice();
            String userName = principal.getName();

            order.setGoodsList(goodsList);
            order.setTotalGoods(totalGoods);
            order.setTotalPrice(totalPrise);
            order.setUserName(userName);
            orderValidator.validate(order, bindingResult);
            if (bindingResult.hasErrors()) {
                return "buy";
            }

            orderService.create(order);
        } else {
            String sessionId = request.getSession().getId();
            ShoppingBasket shoppingBasket = basketServise.findBySessionId(sessionId);
            if (shoppingBasket.getTotalGoods() == null) {
                return "redirect:/myBasket";
            }
            List<Goods> goodsList = new ArrayList<>();
            goodsList.addAll(shoppingBasket.getGoods());
            Long totalGoods = shoppingBasket.getTotalGoods();
            Long totalPrise = shoppingBasket.getTotalPrice();

            order.setGoodsList(goodsList);
            order.setTotalGoods(totalGoods);
            order.setTotalPrice(totalPrise);
            orderValidator.validate(order, bindingResult);
            if (bindingResult.hasErrors()) {
                return "buy";
            }

            orderService.create(order);
        }
        return "successful";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/orders")
    public String getOrders(Model model){
        model.addAttribute("orders", orderService.findAll());
        return "order-list";
    }

    public void castToFinishOrder(Order order, FinishOrder finishOrder) {
        finishOrder.setId(order.getId());
        List<Goods> goodsList = new ArrayList<>();
        for (int i = 0; i < order.getGoodsList().size(); i++) {
            Goods goods = order.getGoodsList().get(i);
            goodsList.add(goods);
        }
        finishOrder.setGoodsList(goodsList);
        finishOrder.setTotalGoods(order.getTotalGoods());
        finishOrder.setTotalPrice(order.getTotalPrice());
        finishOrder.setFirstName(order.getFirstName());
        finishOrder.setLastName(order.getLastName());
        finishOrder.setFatherName(order.getFatherName());
        finishOrder.setEmail(order.getEmail());
        finishOrder.setPhoneNumber(order.getPhoneNumber());
        finishOrder.setRegion(order.getRegion());
        finishOrder.setCity(order.getCity());
        finishOrder.setNumberBranch(order.getNumberBranch());
        finishOrderService.create(finishOrder);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/orders/delete")
    public String deleteOrder(Long id){
        Order order = orderService.findById(id);
        FinishOrder finishOrder = new FinishOrder();
        castToFinishOrder(order, finishOrder);
        orderService.deleteById(id);
        return "redirect:/admin/orders";
    }
}
