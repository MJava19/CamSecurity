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
public class Media {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String type;

    @Lob
    private byte[] data;
}
