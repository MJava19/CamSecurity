package ua.lviv.lgs.CamSecurity.servise;

import ua.lviv.lgs.CamSecurity.entity.Goods;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GoodsServise {

    Goods create(Goods goods);

    Goods update(Goods goods);

    Optional<Goods> findById(Long id);

    List<Goods> findAll();

    void deleteById(Long id);

    void addPictureToGoods(Long mediaId, Long goodsId);

    Set<Goods> findByName(String name);
}
