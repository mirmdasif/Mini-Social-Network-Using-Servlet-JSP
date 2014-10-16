package com.hossain.asif.main.dao;

import com.hossain.asif.main.model.Post;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sadasidha
 * Date: 9/21/14
 * Time: 1:12 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PostDao {
    public void savePost(Post post);
    public List<Post> getPostByUserID(int userId);
    List<Post> getPostsOfFriends(int userId);
    Post  getPostByPostId(int postId);
}
