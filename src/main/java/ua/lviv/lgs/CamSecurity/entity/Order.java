package ua.lviv.lgs.CamSecurity.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "order_castomer", schema = "PUBLIC")
public class Order {

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
}
