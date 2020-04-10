package ua.lviv.lgs.CamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.CamSecurity.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);
}
