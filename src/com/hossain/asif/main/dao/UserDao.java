package com.hossain.asif.main.dao;

import com.hossain.asif.main.model.Post;
import com.hossain.asif.main.model.User;

import java.util.List;

/**
 * Created by asif.hossain on 9/18/14.
 */
public interface UserDao {
    User getUserByEmail(String email);
    void saveUser(User user);
    List<User> getUserByName(String userName);
    List<User> getUsers();
    User getUserByUserId(int userId);

}
