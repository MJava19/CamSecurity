package ua.lviv.lgs.CamSecurity.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
public class FinishOrder {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    @OneToMany
    private List<Goods> goodsList;

    private Long totalGoods;

    private Long totalPrice;

    private String firstName;

    private String lastName;

    private String fatherName;

    private String email;

    private Integer phoneNumber;

    private String region;

    private String city;

    private Integer numberBranch;

    private Long totalPriceInFinishOrder;

    private Long totalGoodsInFinishOrder;

}
