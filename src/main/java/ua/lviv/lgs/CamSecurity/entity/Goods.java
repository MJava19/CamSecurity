package ua.lviv.lgs.CamSecurity.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
public class Goods {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @OneToOne
    private Media media;


}
