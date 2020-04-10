package ua.lviv.lgs.CamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.CamSecurity.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
