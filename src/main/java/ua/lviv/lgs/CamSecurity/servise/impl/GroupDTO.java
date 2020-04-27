package ua.lviv.lgs.CamSecurity.servise.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.CamSecurity.entity.Goods;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class GroupDTO {
    private Long id;

    private String name;

    private List<Goods> goods;

    private String description;

    private Integer totalGoods;

    private MultipartFile avatar;

    private String base64;
}
