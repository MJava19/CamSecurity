package ua.lviv.lgs.CamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.CamSecurity.entity.Groups;

public interface GroupsRepository extends JpaRepository<Groups, Long> {
}
