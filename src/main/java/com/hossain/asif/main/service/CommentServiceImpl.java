package com.hossain.asif.main.service;

import com.hossain.asif.main.dao.CommentDao;
import com.hossain.asif.main.dao.CommentDaoImpl;
import com.hossain.asif.main.model.Comment;
import com.hossain.asif.main.model.Post;

import java.util.List;

/**
 * Created by asif.hossain on 9/21/14.
 */
public class CommentServiceImpl implements CommentService {
    CommentDao commentDao = new CommentDaoImpl();
    @Override
    public void saveComment(Comment comment) {
        commentDao.saveComment(comment);
    }

    @Override
    public List<Comment> getCommentOfPost(Post post) {
        return commentDao.getCommentByPostId(post.getPostId());
    }

}
