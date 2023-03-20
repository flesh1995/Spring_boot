package ru.stiv.spring_boot_1.service;

import jakarta.validation.Valid;
import ru.stiv.spring_boot_1.models.User;


import java.util.List;

public interface ServiceUser {

    List<User> userShow();

    void update(User user);

    void add(@Valid User user);

    void delete(int id);

    User findUser(int id);

}
