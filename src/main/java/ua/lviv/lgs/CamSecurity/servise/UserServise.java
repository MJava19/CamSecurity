package ua.lviv.lgs.CamSecurity.servise;

import ua.lviv.lgs.CamSecurity.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserServise {

    User save(User user);

    User findByUsername(String name);

    User findByEmail(String email);


}
