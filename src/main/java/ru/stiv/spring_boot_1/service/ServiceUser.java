package myappweb.service;

import jakarta.validation.Valid;
import myappweb.models.User;
import java.util.List;

public interface ServiceUser {

    List<User> userShow();

    void update(User user);

    void add(@Valid User user);

    void delete(int id);

    User findUser(int id);

}
