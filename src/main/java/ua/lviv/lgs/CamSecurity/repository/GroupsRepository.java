package ua.lviv.lgs.CamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.CamSecurity.entity.Groups;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, Long> {
}
