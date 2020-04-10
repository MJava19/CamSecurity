package ua.lviv.lgs.CamSecurity.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MediaResponse {

    private String fileName;

    private String url;
}
