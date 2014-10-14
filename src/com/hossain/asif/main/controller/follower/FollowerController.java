package com.hossain.asif.main.controller.follower;

import com.hossain.asif.main.dao.FollowerDao;
import com.hossain.asif.main.dao.FollowerDaoImplementation;
import com.hossain.asif.main.model.Post;
import com.hossain.asif.main.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sadasidha on 10/13/14.
 */
@WebServlet(name = "followerController" ,
        urlPatterns = {"/follow/*"})
public class FollowerController extends HttpServlet {
    FollowerDao followerDao = new FollowerDaoImplementation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getRequestURI().matches("/follow/\\d+")){
            int followerId = getFollowerId(req);
            followerDao.follow(((User)req.getSession().getAttribute("authenticatedUser")).getUserId(),followerId);
        }
        resp.sendRedirect("/posts");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().matches("/follow/\\d+")) {
            int followerId = getFollowerId(req);
            followerDao.unFollow(((User)req.getSession().getAttribute("authenticatedUser")).getUserId(),followerId);
        }
        resp.sendRedirect("/posts");
    }

    private int getFollowerId(HttpServletRequest req) {
        String[] urlTokens = req.getPathInfo().split("/");
        if (urlTokens != null && urlTokens.length>=2) {
            try {
                int followerId = Integer.parseInt(urlTokens[1]);

                return followerId;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}
