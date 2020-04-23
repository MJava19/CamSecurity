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
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100000)
    private String base64image;

}
