package com.hossain.asif.main.service;

import com.hossain.asif.main.dao.UserDao;
import com.hossain.asif.main.dao.UserDaoImpl;
import com.hossain.asif.main.model.User;

import java.util.List;

/**
 * Created by asif.hossain on 9/18/14.
 */
public class UserServiceImpl implements UserService {
    UserDao userDao;
    public  UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public boolean verifyNewUser(User user) {
        if( this.userDao.getUserByEmail(user.getEmail()) == null) {
            return true;
        };
        return false;
    }


    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }


    @Override
    public User verifyUser(User user) {
        User verifiedUser = userDao.getUserByEmail(user.getEmail());
        if (verifiedUser != null
                && verifiedUser.getPassword().equals(user.getPassword())) {
            return verifiedUser;
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
