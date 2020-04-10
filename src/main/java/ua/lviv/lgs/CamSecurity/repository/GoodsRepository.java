package ua.lviv.lgs.CamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.CamSecurity.entity.Goods;

import java.util.Set;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Set<Goods> findByName(String name);
}
