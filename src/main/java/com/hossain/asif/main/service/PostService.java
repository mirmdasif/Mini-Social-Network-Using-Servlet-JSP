package com.hossain.asif.main.service;

import com.hossain.asif.main.model.Post;
import com.hossain.asif.main.model.User;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sadasidha
 * Date: 9/21/14
 * Time: 1:31 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PostService {
   public void savePost(Post post);
   public List<Post> getPostOfUser(User user);
   public List<Post> getPostOfFriends(User user);
   public  Post getPostById(int postId);

}
