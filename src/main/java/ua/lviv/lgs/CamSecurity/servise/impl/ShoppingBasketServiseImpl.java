package ua.lviv.lgs.CamSecurity.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.lgs.CamSecurity.entity.Goods;
import ua.lviv.lgs.CamSecurity.entity.ShoppingBasket;
import ua.lviv.lgs.CamSecurity.entity.User;
import ua.lviv.lgs.CamSecurity.repository.ShoppingBasketRepository;
import ua.lviv.lgs.CamSecurity.servise.ShoppingBasketServise;
import ua.lviv.lgs.CamSecurity.servise.UserServise;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingBasketServiseImpl implements ShoppingBasketServise {
    private final ShoppingBasketRepository basketRepository;

    @Override
    public ShoppingBasket create(ShoppingBasket shoppingBasket) {
        return basketRepository.save(shoppingBasket);
    }

    @Override
    public ShoppingBasket findById(Long id) {
        return basketRepository.getOne(id);
    }

    @Override
    public ShoppingBasket findBySessionId(String sessionId) {
        return basketRepository.findBySessionId(sessionId);
    }


}
