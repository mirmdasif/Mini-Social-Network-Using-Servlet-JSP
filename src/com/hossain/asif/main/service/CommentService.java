package com.hossain.asif.main.service;

import com.hossain.asif.main.model.Comment;
import com.hossain.asif.main.model.Post;

import java.util.List;

/**
 * Created by asif.hossain on 9/21/14.
 */
public interface CommentService {
    public void saveComment(Comment comment);
    public List<Comment> getCommentOfPost(Post post);
}
