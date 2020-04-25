package ua.lviv.lgs.CamSecurity.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity(name = "groups_g")
public class Groups {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @OneToMany
    private List<Goods> goods;

    @NotNull
    private String description;

    private Integer totalGoods;

}
