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
        name = "HomeController",
        urlPatterns = {"/home"}
)
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req,resp);
    }
}
