package ua.lviv.lgs.CamSecurity.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
public class ShoppingBasket {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    List<Goods> goods;

    private Long totalPrice;

    private Long totalGoods;

    private String sessionId;
}
