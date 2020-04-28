package ua.lviv.lgs.CamSecurity.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.CamSecurity.entity.Goods;
import ua.lviv.lgs.CamSecurity.entity.Groups;
import ua.lviv.lgs.CamSecurity.exeption.NotFoundExeption;
import ua.lviv.lgs.CamSecurity.repository.GoodsRepository;
import ua.lviv.lgs.CamSecurity.repository.GroupsRepository;
import ua.lviv.lgs.CamSecurity.servise.GoodsServise;
import ua.lviv.lgs.CamSecurity.servise.GroupService;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GoodsServiseImpl implements GoodsServise {
    private final GoodsRepository goodsRepository;

    private final GroupsRepository groupsRepository;

    @Override
    public Goods create(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    @Transactional
    public Goods update(Goods goods) {
        Goods persistedGoods = goodsRepository.findById(goods.getId()).orElseThrow(
                () -> new NotFoundExeption("id " + goods.getId()));
        Groups oldGroup = persistedGoods.getGroup();
        oldGroup.getGoods().remove(persistedGoods);
        groupsRepository.save(oldGroup);
        persistedGoods.setGroup(goods.getGroup());
        persistedGoods.setImage(goods.getImage());
        persistedGoods.setCode(goods.getCode());
        persistedGoods.setDescription(goods.getDescription());
        persistedGoods.setManufacturer(goods.getManufacturer());
        persistedGoods.setName(goods.getName());
        persistedGoods.setPrice(goods.getPrice());
        goodsRepository.save(persistedGoods);
        Groups groups = groupsRepository.findById(goods.getGroup().getId()).orElseThrow(() -> new NotFoundExeption("group was not found with this id: " + goods.getGroup().getId()));
        groups.getGoods().add(persistedGoods);
        groupsRepository.save(groups);

        return persistedGoods;
    }

    @Override
    public Optional<Goods> findById(Long id) {
        return goodsRepository.findById(id);
    }

    @Override
    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        goodsRepository.deleteById(id);
    }


    @Override
    public Set<Goods> findByName(String name) {

        return goodsRepository.findByName(name);
    }
}
