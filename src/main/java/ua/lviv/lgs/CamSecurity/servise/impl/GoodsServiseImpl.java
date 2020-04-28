package ua.lviv.lgs.CamSecurity.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.CamSecurity.entity.Goods;
import ua.lviv.lgs.CamSecurity.repository.GoodsRepository;
import ua.lviv.lgs.CamSecurity.servise.GoodsServise;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GoodsServiseImpl implements GoodsServise {
    private final GoodsRepository goodsRepository;

    @Override
    public Goods create(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public Goods update(Goods goods) {
        return goodsRepository.save(goods);
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
    public List<Goods> findByNameOrCodeOrManufacturer(String name) {

        return goodsRepository.findByNameOrCodeOrManufacturer(name);
    }
}
