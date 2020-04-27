package ua.lviv.lgs.CamSecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.lviv.lgs.CamSecurity.entity.FinishOrder;
import ua.lviv.lgs.CamSecurity.servise.FinishOrderService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FinishOrderController {
    private final FinishOrderService finishOrderService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/order/finish")
    public String getFinishOrder(Model model) {
        Long totalPrice = (long) 0;
        Long totalGoods = (long) 0;
        List<FinishOrder> finishOrderList = finishOrderService.findAll();
        for (long i = 0; i < finishOrderList.size(); i++) {
            FinishOrder finishOrder = finishOrderList.get((int) i);
            totalGoods += finishOrder.getTotalGoods();
            totalPrice += finishOrder.getTotalPrice();
        }
        model.addAttribute("totalGoods", totalGoods);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("orders", finishOrderService.findAll());
        return "finish-order-list";
    }
}
