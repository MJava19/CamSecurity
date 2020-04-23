package ua.lviv.lgs.CamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.CamSecurity.entity.ShoppingBasket;

@Repository
public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasket, Long> {

    ShoppingBasket findBySessionId(String sessionId);
}
