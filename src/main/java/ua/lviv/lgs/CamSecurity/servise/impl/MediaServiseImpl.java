package ua.lviv.lgs.CamSecurity.servise.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ua.lviv.lgs.CamSecurity.entity.Media;
import ua.lviv.lgs.CamSecurity.entity.MediaResponse;
import ua.lviv.lgs.CamSecurity.repository.MediaRepository;
import ua.lviv.lgs.CamSecurity.servise.MediaServise;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class MediaServiseImpl implements MediaServise {
    private final MediaRepository mediaRepository;

    @Override
    public MediaResponse save(MultipartFile file) {
        Media media = new Media();
        media.setFileName(generateFileName(file));
        media.setType(file.getContentType());
        try {
            media.setData(file.getBytes());
        } catch (IOException e) {
            log.error("error while read data from file", e);
        }
        mediaRepository.save(media);
        MediaResponse response = new MediaResponse();
        response.setFileName(media.getFileName());
        response.setUrl(generateUrl(media.getFileName()));
        return response;
    }

    private String generateUrl(String fileName) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/files/")
                .path(fileName)
                .toUriString();
    }

    private String generateFileName(MultipartFile file) {
        return new Date().getTime() + ".jpg";
    }

    @Override
    public Media findByName(String name) {
        return mediaRepository.findByFileName(name);
    }

    @Override
    public List<Media> findAll() {
        return mediaRepository.findAll();
    }
}
