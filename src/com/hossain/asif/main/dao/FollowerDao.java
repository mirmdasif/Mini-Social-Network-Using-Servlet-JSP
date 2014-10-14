package com.hossain.asif.main.dao;

/**
 * Created by sadasidha on 10/13/14.
 */
public interface FollowerDao {
    void follow(int userID, int followerId);
    void unFollow(int userId, int followerId);
}
