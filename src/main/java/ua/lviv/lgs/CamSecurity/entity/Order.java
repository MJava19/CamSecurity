package ua.lviv.lgs.CamSecurity.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/", message = "Не справжній email!")
    private String email;

    @NotNull
    @Pattern(regexp = "^[0-9]{1,10}$", message = "Введіть номер починаючи з 0XXX...")
    private Integer phoneNumber;

    @NotNull
    private String region;

    @NotNull
    private String city;

    @NotNull
    private Integer numberBranch;
}
