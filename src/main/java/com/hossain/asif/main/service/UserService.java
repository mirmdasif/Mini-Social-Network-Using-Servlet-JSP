package com.hossain.asif.main.service;

import com.hossain.asif.main.model.User;

import java.util.List;

/**
 * Created by asif.hossain on 9/18/14.
 */
public interface UserService {
    public void saveUser(User user);
    public boolean verifyNewUser(User user);
    public User verifyUser(User user);
    public List<User> getUsers();
}
