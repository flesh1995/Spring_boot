package ru.stiv.spring_boot_1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stiv.spring_boot_1.DAO.UserDao;
import ru.stiv.spring_boot_1.models.User;
import javax.validation.Valid;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ServiceUserImpl implements ServiceUser {

    private final UserDao userDao;

    public ServiceUserImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> userShow() {
        return userDao.userShow();
    }

    @Override
    @Transactional
    public void update(@Valid User user) {
        userDao.update(user);
    }

    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public User findUser(int id) {
        return userDao.findUser(id);
    }
}
