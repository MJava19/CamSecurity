package ua.lviv.lgs.CamSecurity.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.CamSecurity.entity.FinishOrder;
import ua.lviv.lgs.CamSecurity.repository.FinishOrderRepository;
import ua.lviv.lgs.CamSecurity.servise.FinishOrderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinishOrderServiceImpl implements FinishOrderService {
    private final FinishOrderRepository finishOrderRepository;

    @Override
    public List<FinishOrder> findAll() {
        return finishOrderRepository.findAll();
    }

    @Override
    public List<FinishOrder> findByUserName(String userName) {
        return finishOrderRepository.findByUserName(userName);
    }

    @Override
    public FinishOrder create(FinishOrder finishOrder) {
        return finishOrderRepository.save(finishOrder);
    }
}
