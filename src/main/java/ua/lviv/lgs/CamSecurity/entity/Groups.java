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
public class Groups {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long totalGoods;

    @OneToMany
    private List<Goods> goods;
}
