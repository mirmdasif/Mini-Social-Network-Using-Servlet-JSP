package com.hossain.asif.main.dao;

import com.hossain.asif.main.model.User;
import com.hossain.asif.main.util.DatabaseTemplate;
import com.hossain.asif.main.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by asif.hossain on 9/18/14.
 */
public class UserDaoImpl implements UserDao {
    private class UserRowMapper implements ObjectRowMapper<User> {

        @Override
        public User mapRowToObject(ResultSet resultSet) throws SQLException {
            User user = new User();
            user.setUserId(resultSet.getInt("user_id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            return user;
        }
    }

    final String insertUserStatement = "INSERT INTO user(first_name,last_name,email,password) VALUES (?,?,?,?)";
    final String getUserByEmailStatement = "SELECT * FROM user WHERE email = ?";
    @Override
    public User getUserByEmail(String email) {

        List<User> userList = DatabaseTemplate.executeQueryForObject(new UserRowMapper(), getUserByEmailStatement, email);

        if (userList.size()!=0) {
            return  userList.get(0);
        }
        else {
            return null;
        }

    }
    @Override
    public User getUserByUserId(int userId) {

        List<User> userList = DatabaseTemplate.executeQueryForObject(new UserRowMapper(), "Select * FROM user where user_id=?", userId);

        if (userList.size()!=0) {
            return  userList.get(0);
        }
        else {
            return null;
        }

    }

    @Override
    public void saveUser(User user) {

        DatabaseTemplate.executeInsertQuery(insertUserStatement, user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword());
    }

    @Override
    public List<User> getUserByName(String userName) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return  DatabaseTemplate.executeQueryForObject(new UserRowMapper(),"SELECT * FROM user");
    }

}
