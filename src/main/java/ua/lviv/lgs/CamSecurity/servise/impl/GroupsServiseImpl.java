package ua.lviv.lgs.CamSecurity.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.CamSecurity.entity.Goods;
import ua.lviv.lgs.CamSecurity.entity.Groups;
import ua.lviv.lgs.CamSecurity.exeption.NotFoundExeption;
import ua.lviv.lgs.CamSecurity.repository.GoodsRepository;
import ua.lviv.lgs.CamSecurity.repository.GroupsRepository;
import ua.lviv.lgs.CamSecurity.servise.GroupsServise;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GroupsServiseImpl implements GroupsServise {

    private final GroupsRepository groupsRepository;
    private final GoodsRepository goodsRepository;

    @Override
    public Groups create(Groups group) {
        return groupsRepository.save(group);
    }

    @Override
    public Groups update(Groups group) {
        return groupsRepository.save(group);
    }

    @Override
    public Optional<Groups> findById(Long id) {
        return groupsRepository.findById(id);
    }

    @Override
    public List<Groups> findAll() {
        return groupsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        groupsRepository.deleteById(id);
    }

    @Override
    public void addGoodsToGroup(Long goodsId, Long groupId) {
        Groups groups = groupsRepository.findById(groupId).orElseThrow(() -> new NotFoundExeption("group was not found with this id: " + groupId));
        Goods goods = goodsRepository.findById(goodsId).orElseThrow(() -> new NotFoundExeption("goods was not found with this id: " + groupId));

        groups.getGoods().add(goods);
        groupsRepository.save(groups);
    }

    @Override
    public List<Goods> findGoodsInGroup(Long groupId) {
        return  groupsRepository.findById(groupId).orElseThrow(() -> new NotFoundExeption("goods was not found with this id: " + groupId)).getGoods();
    }
}
