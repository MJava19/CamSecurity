package ua.lviv.lgs.CamSecurity.servise;

import ua.lviv.lgs.CamSecurity.entity.Goods;
import ua.lviv.lgs.CamSecurity.entity.Groups;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    Groups create(Groups group);

    Groups update(Groups group);

    Optional<Groups> findById(Long id);

    List<Groups> findAll();

    void deleteById(Long id);

    void addGoodsToGroup(Long goodsId, Long groupId);

    List<Goods> findGoodsInGroup(Long groupId);
}
