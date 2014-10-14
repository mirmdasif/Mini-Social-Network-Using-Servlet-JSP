package com.hossain.asif.main.controller;


import com.hossain.asif.main.model.User;
import com.hossain.asif.main.service.UserService;
import com.hossain.asif.main.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asif.hossain on 9/30/14.
 */
@WebServlet(
        name = "RegistrationController",
        urlPatterns = {"/registration"}
)
public class RegistrationController extends HttpServlet {

    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setPassword(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));

        boolean isNewUser = userService.verifyNewUser(user);
        if (isNewUser) {
            userService.saveUser(user);
            resp.sendRedirect("/login");
        }
        else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("//WEB-INF/jsp/registration.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}
