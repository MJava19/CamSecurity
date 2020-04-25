package ua.lviv.lgs.CamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.CamSecurity.entity.FinishOrder;

import java.util.List;

@Repository
public interface FinishOrderRepository extends JpaRepository<FinishOrder, Long> {
    List<FinishOrder> findByUserName(String userName);
}
