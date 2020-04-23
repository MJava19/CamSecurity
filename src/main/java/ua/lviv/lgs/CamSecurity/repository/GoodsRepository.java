package ua.lviv.lgs.CamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.CamSecurity.entity.Goods;

import java.util.Set;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Set<Goods> findByName(String name);
}
