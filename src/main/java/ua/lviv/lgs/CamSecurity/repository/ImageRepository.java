package ua.lviv.lgs.CamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.CamSecurity.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
