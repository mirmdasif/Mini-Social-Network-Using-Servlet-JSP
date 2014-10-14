package com.hossain.asif.main.controller;


import com.hossain.asif.main.model.User;
import com.hossain.asif.main.service.UserService;
import com.hossain.asif.main.service.UserServiceImpl;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by asif.hossain on 9/30/14.
 */
@WebServlet(
        name = "LoginController",
        urlPatterns = {"/login"}
)
public class LoginController extends HttpServlet {
    UserService userService;

    @Override
    public void init() {
        userService = new UserServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        rd.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));

        user = userService.verifyUser(user);
        if (user != null) {
            System.out.println("Login Successful");
            HttpSession session =  req.getSession();
            session.setAttribute("authenticatedUser",user);
            resp.sendRedirect("/home");
        }
        else {
            System.out.println("Login Failed");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}
