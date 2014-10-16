package com.hossain.asif.main.controller.post;

import com.hossain.asif.main.model.Comment;
import com.hossain.asif.main.model.Post;
import com.hossain.asif.main.model.User;
import com.hossain.asif.main.service.CommentService;
import com.hossain.asif.main.service.CommentServiceImpl;
import com.hossain.asif.main.service.PostService;
import com.hossain.asif.main.service.PostServiceImpl;


import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by asif.hossain on 10/2/14.
 */
@WebServlet(
        name = "PostController",
        urlPatterns = {"/posts/*","/post"}
)
public class PostController extends HttpServlet{
    PostService postService = new PostServiceImpl();
    CommentService commentService  = new CommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getRequestURI().equals("/posts")) {
            showFollowersPost(req,resp);
        }
        else if (req.getRequestURI().matches("/posts/\\d+")){
            int postId = getPostId(req);
            Post post = postService.getPostById(postId);
            if (post != null) {
                req.setAttribute("post",post);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/post/singlePost.jsp");
                requestDispatcher.forward(req,resp);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getRequestURI().matches("posts/\\d+/comment")){
            saveComment(req);
            resp.sendRedirect("/posts/"+getPostId(req));
        }
        else if (req.getRequestURI().matches("/posts/newPost")) {
            savePost(req);
            resp.sendRedirect("/home");
        }
    }

    private void savePost(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("authenticatedUser");
        Post post = new Post();
        post.setBody(req.getParameter("post-text"));
        post.setUser(user);
        postService.savePost(post);
    }

    private void saveComment(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("authenticatedUser");
        int postId = getPostId(req);
        Comment comment = new Comment();
        comment.setCommentBody(req.getParameter("comment-text"));
        comment.setUserId(user.getUserId());
        comment.setPostId(postId);
        commentService.saveComment(comment);
    }

    private int getPostId(HttpServletRequest req) {
        String[] urlTokens = req.getPathInfo().split("/");
        if (urlTokens != null && urlTokens.length>=2) {

            int postId = Integer.parseInt(urlTokens[1]);
            return postId;
        }
        else {
            return -1;
        }
    }

    private void showFollowersPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("authenticatedUser");
        List<Post> posts = postService.getPostOfFriends(user);
        req.setAttribute("posts",posts);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/post/posts.jsp");
        requestDispatcher.forward(req,resp);
    }
}
