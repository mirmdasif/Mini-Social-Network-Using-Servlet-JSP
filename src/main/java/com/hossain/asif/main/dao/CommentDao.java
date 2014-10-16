package com.hossain.asif.main.dao;

import com.hossain.asif.main.model.Comment;

import java.util.List;

/**
 * Created by asif.hossain on 9/21/14.
 */
public interface CommentDao {
    public void saveComment(Comment comment);
    public List<Comment> getCommentByPostId(int postId);
}
