package ua.lviv.lgs.CamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.CamSecurity.entity.Media;

public interface MediaRepository extends JpaRepository<Media, Long> {
    Media findByFileName(String name);
}
