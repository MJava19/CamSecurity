package ua.lviv.lgs.CamSecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lviv.lgs.CamSecurity.entity.Goods;
import ua.lviv.lgs.CamSecurity.entity.Order;
import ua.lviv.lgs.CamSecurity.entity.User;
import ua.lviv.lgs.CamSecurity.servise.OrderService;
import ua.lviv.lgs.CamSecurity.servise.UserServise;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final UserServise userServise;

    @GetMapping("/order")
    public String getOrderPage(Model model) {
        model.addAttribute("orderForm", new Order());
        return "buy";
    }

    @PostMapping("/order")
    public String createOrder(HttpServletRequest request, @ModelAttribute("orderForm") Order order){
        Principal principal = request.getUserPrincipal();
        User user = userServise.findByUsername(principal.getName());
        List<Goods> goodsList = new ArrayList<>();
        goodsList.addAll(user.getShoppingBasket().getGoods());
        Long totalGoods = user.getShoppingBasket().getTotalGoods();
        Long totalPrise = user.getShoppingBasket().getTotalPrice();
        String userName = principal.getName();

        order.setGoodsList(goodsList);
        order.setTotalGoods(totalGoods);
        order.setTotalPrice(totalPrise);
        order.setUserName(userName);
        orderService.create(order);
        return "successful";
    }



    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/orders")
    public String getOrders(Model model){
        model.addAttribute("orders", orderService.findAll());
        return "order-list";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/orders/delete")
    public String deleteOrder(Long id){
        orderService.deleteById(id);
        return "redirect:/admin/orders";
    }
}
