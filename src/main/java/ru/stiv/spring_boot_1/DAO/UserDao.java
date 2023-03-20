package ru.stiv.spring_boot_1.DAO;



import ru.stiv.spring_boot_1.models.User;

import java.util.List;

public interface UserDao {
    List<User> userShow();

    void update(User user);

    void add(User user);

    void delete(int id);

    User findUser(int id);
}
