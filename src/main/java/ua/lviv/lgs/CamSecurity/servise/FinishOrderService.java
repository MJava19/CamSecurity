package ua.lviv.lgs.CamSecurity.servise;

import ua.lviv.lgs.CamSecurity.entity.FinishOrder;

import java.util.List;

public interface FinishOrderService {
    List<FinishOrder> findAll();

    List<FinishOrder> findByUserName(String userName);

    FinishOrder create(FinishOrder finishOrder);
}
