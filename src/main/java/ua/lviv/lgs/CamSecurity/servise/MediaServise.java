package ua.lviv.lgs.CamSecurity.servise;

import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.CamSecurity.entity.Media;
import ua.lviv.lgs.CamSecurity.entity.MediaResponse;

import java.util.List;
import java.util.Set;

public interface MediaServise {

    MediaResponse save(MultipartFile file);

    Media findByName(String name);

    List<Media> findAll();
}
