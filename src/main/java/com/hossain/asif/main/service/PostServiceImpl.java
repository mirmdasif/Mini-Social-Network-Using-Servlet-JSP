package com.hossain.asif.main.service;

import com.hossain.asif.main.dao.*;
import com.hossain.asif.main.model.Post;
import com.hossain.asif.main.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sadasidha
 * Date: 9/21/14
 * Time: 2:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class PostServiceImpl implements PostService {
    PostDao postDao = new PostDaoImpl();
    UserDao userDao = new UserDaoImpl();
    CommentDao commentDao = new CommentDaoImpl();
    @Override
    public void savePost(Post post) {
          postDao.savePost(post);
    }

    @Override
    public List<Post> getPostOfUser(User user) {
        List<Post> posts = postDao.getPostByUserID(user.getUserId());
        for (Post post : posts) {

            post.setUser(userDao.getUserByUserId(post.getUserID()));
            post.setComments(commentDao.getCommentByPostId(post.getPostId()));

        }
        return posts;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Post> getPostOfFriends(User user) {

        List<Post>posts = postDao.getPostsOfFriends(user.getUserId());
        for (Post post : posts) {
            post.setUser(userDao.getUserByUserId(post.getUserID()));
        }
        return posts;
          //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Post getPostById(int postId) {
        Post post = postDao.getPostByPostId(postId);
        post.setComments(commentDao.getCommentByPostId(postId));
        post.setUser(userDao.getUserByUserId(post.getUserID()));
        return post;
    }
}
