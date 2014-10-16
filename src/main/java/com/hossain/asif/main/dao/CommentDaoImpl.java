package com.hossain.asif.main.dao;

import com.hossain.asif.main.model.Comment;
import com.hossain.asif.main.util.DatabaseTemplate;
import com.hossain.asif.main.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by asif.hossain on 9/21/14.
 */
public class CommentDaoImpl implements CommentDao {

    private final String commentInsertStmt = "INSERT INTO post_comment(post_id,user_id,body) values(?,?,?)";
    private class CommentRowMapper implements ObjectRowMapper<Comment> {

        @Override
        public Comment mapRowToObject(ResultSet resultSet) throws SQLException {

            Comment comment = new Comment();
            comment.setCommentId(resultSet.getInt("comment_id"));
            comment.setPostId(resultSet.getInt("post_id"));
            comment.setUserId(resultSet.getInt("user_id"));
            comment.setCommentBody(resultSet.getString("body"));
            comment.setTime(resultSet.getTimestamp("comment_time"));
            return comment;
        }
    }
    @Override
    public void saveComment(Comment comment) {

        DatabaseTemplate.executeInsertQuery(commentInsertStmt,
                comment.getPostId(),
                comment.getUserId(),
                comment.getCommentBody());

    }

    @Override
    public List<Comment> getCommentByPostId(int postId) {
        return DatabaseTemplate.executeQueryForObject(new CommentRowMapper(), "SELECT * FROM post_comment WHERE post_id = ?", postId);
    }
}
