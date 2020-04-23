package ua.lviv.lgs.CamSecurity.servise;

import ua.lviv.lgs.CamSecurity.entity.ShoppingBasket;

import java.util.List;

public interface ShoppingBasketServise {
    ShoppingBasket create(ShoppingBasket shoppingBasket);

    ShoppingBasket findById(Long id);

    ShoppingBasket findBySessionId(String sessionId);
}
