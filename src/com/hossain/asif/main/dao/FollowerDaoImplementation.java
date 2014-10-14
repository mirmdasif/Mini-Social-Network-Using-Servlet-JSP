package com.hossain.asif.main.dao;

import com.hossain.asif.main.util.DatabaseTemplate;

/**
 * Created by asif.hossain on 9/21/14.
 */
public class FollowerDaoImplementation implements FollowerDao {

    @Override
    public void follow(int userID, int followerId) {

        DatabaseTemplate.executeInsertQuery("INSERT INTO follower (user_id, follower_id) VALUES (?, ?)",userID,followerId);
    }

    @Override
    public void unFollow(int userId, int followerId) {
        DatabaseTemplate.executeInsertQuery("DELETE FROM follower " +
                "Where user_id=? AND follower_id = ?",userId,followerId);
    }
}
