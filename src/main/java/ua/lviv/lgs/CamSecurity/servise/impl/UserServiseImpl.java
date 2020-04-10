package ua.lviv.lgs.CamSecurity.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.CamSecurity.entity.User;
import ua.lviv.lgs.CamSecurity.exeption.NotFoundExeption;
import ua.lviv.lgs.CamSecurity.repository.UserRepository;
import ua.lviv.lgs.CamSecurity.servise.UserServise;

@Service
@RequiredArgsConstructor
public class UserServiseImpl implements UserServise {
    private final UserRepository userRepository;


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name).orElseThrow(() -> new NotFoundExeption("User with name: " + name + "was not found"));
    }
}
