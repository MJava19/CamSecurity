package ua.lviv.lgs.CamSecurity.servise.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.CamSecurity.entity.Groups;

import java.util.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class GoodsDTO {

    private Long id;

    private Integer code;

    private String name;

    private String description;

    private Long price;

    private List<MultipartFile> image = new LinkedList<>();

    private Groups group;

}
