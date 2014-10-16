package com.hossain.asif.main.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by asif.hossain on 10/1/14.
 */
@WebFilter("/*")
public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest)servletRequest).getSession(false);
        String requestedUri = ((HttpServletRequest) servletRequest).getRequestURI();

        if (session == null || session.getAttribute("authenticatedUser")==null) {
            if (requestedUri.contains("login") || requestedUri.contains("registration")) {
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                ((HttpServletResponse)servletResponse).sendRedirect("/login");
            }
        }
        else if (requestedUri.contains("login") || requestedUri.contains("registration")) {
            ((HttpServletResponse)servletResponse).sendRedirect("/home");
        }
        else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
