package ua.lviv.lgs.CamSecurity.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private Long id;


    private String userName;

    @ManyToMany
    @NotNull
    private List<Goods> goodsList;

    @NotNull
    private Long totalGoods;

    @NotNull
    private Long totalPrice;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String fatherName;

    @NotNull
    private String email;

    @NotNull
    private Integer phoneNumber;

    @NotNull
    private String region;

    @NotNull
    private String city;

    @NotNull
    private Integer numberBranch;
}
