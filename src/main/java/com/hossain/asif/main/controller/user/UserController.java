package com.hossain.asif.main.controller.user;

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
import java.util.List;

/**
 * Created by asif.hossain on 10/1/14.
 */
@WebServlet(urlPatterns = {"/users/*"})
public class UserController extends HttpServlet{

    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        if(req.getPathInfo() == null ) {
            List<User> users = userService.getUsers();
            req.setAttribute("users",users);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/user/userList.jsp");
            requestDispatcher.forward(req,resp);
        }
        else {
            String[] tokens = req.getPathInfo().split("/");

            try {
                if(tokens!= null && tokens.length>=2) {
                    int userId = Integer.parseInt(tokens[1]);
                    System.out.println(userId);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
