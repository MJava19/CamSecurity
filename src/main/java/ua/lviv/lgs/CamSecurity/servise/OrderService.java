package ua.lviv.lgs.CamSecurity.servise;

import ua.lviv.lgs.CamSecurity.entity.Order;

import java.util.List;

public interface OrderService {

    Order findById(Long id);

    Order create(Order order);

    List<Order> findAll();

    void deleteById(Long id);


}
