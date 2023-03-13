package myappweb.DAO;

import myappweb.models.User;

import java.util.List;

public interface UserDao {
    List<User> userShow();

    void update(User user);

    void add(User user);

    void delete(int id);

    User findUser(int id);
}
