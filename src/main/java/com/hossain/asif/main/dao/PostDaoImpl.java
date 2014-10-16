package com.hossain.asif.main.dao;

import com.hossain.asif.main.model.Post;
import com.hossain.asif.main.util.DatabaseTemplate;
import com.hossain.asif.main.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sadasidha
 * Date: 9/21/14
 * Time: 1:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class PostDaoImpl implements PostDao {


    private class PostRowMapper implements ObjectRowMapper<Post> {

        @Override
        public Post mapRowToObject(ResultSet resultSet) throws SQLException {

            Post post = new Post();
            post.setPostId(resultSet.getInt("post_id"));
            post.setBody(resultSet.getString("body"));
            post.setDate(resultSet.getTimestamp("post_time"));
            post.setUserID(resultSet.getInt("user_id"));
            return post;

           //To change body of implemented methods use File | Settings | File Templates.
        }
    }
    private final String postInsertStmt = "INSERT INTO post(user_id,body) VALUES(?,?)";
    @Override
    public void savePost(Post post) {

        DatabaseTemplate.executeInsertQuery(postInsertStmt,
                post.getUser().getUserId(), post.getBody());
    }

    @Override
    public List<Post> getPostByUserID(int userId) {

        return DatabaseTemplate.executeQueryForObject(new PostRowMapper(), "SELECT * FROM post WHERE user_id=?", userId);
    }

    @Override
    public Post getPostByPostId(int postId) {

        List<Post> posts = DatabaseTemplate.executeQueryForObject(new PostRowMapper(),"SELECT * FROM post WHERE post_id=?",postId);
        if (posts !=null) {
            return posts.get(0);
        }
        else {
            return null;
        }
    }
    @Override
    public List<Post> getPostsOfFriends(int userId) {
        String query=" SELECT * from post"
                +" WHERE user_id IN (SELECT follower_id from follower"
                +" WHERE user_id=?)";
       return DatabaseTemplate.executeQueryForObject(new PostRowMapper(),query,userId);
    }

}
