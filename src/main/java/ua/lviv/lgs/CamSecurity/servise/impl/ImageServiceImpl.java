package ua.lviv.lgs.CamSecurity.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.CamSecurity.entity.Image;
import ua.lviv.lgs.CamSecurity.repository.ImageRepository;
import ua.lviv.lgs.CamSecurity.servise.ImageService;
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public Image create(Image image) {
        return imageRepository.save(image);
    }
}
