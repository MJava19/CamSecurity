package ua.lviv.lgs.CamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.CamSecurity.entity.ShoppingBasket;

public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasket, Long> {
}
