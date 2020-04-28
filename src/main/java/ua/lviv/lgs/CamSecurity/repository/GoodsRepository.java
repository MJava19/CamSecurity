package ua.lviv.lgs.CamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.CamSecurity.entity.Goods;

import java.util.List;
import java.util.Set;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    @Query(value = "SELECT * FROM goods where manufacturer LIKE CONCAT('%',:name,'%') or code LIKE CONCAT('%',:name,'%') or name LIKE CONCAT('%',:name,'%')", nativeQuery = true)
    List<Goods> findByNameOrCodeOrManufacturer(@Param("name") String name);

}
