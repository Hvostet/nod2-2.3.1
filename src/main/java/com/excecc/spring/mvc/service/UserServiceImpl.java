package com.excecc.spring.mvc.service;

import com.excecc.spring.mvc.dao.UserDAO;
import com.excecc.spring.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created in Intellij
 * User: Davidenko
 * Date: 05.11.2022
 * Time: 20:57
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        user.setId(id);
        userDAO.updateUser(user);
    }


    @Override
    @Transactional
    public void removeUser(User user) {
        userDAO.removeUser(user);
    }


}
