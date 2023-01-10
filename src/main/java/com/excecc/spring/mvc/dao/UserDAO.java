package com.excecc.spring.mvc.dao;

import com.excecc.spring.mvc.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public void saveUser(User user);

    User getUser(int id);
    public void updateUser(User user);

    public void removeUser(User user);
}
