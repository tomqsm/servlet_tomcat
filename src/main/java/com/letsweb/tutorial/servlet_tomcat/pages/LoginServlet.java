package com.letsweb.tutorial.servlet_tomcat.pages;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class illustrate WebServlet annotation
 *
 * @author Shing Wai Chan
 * @author Daniel Guo
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/en/login", "/logowanie"},
        initParams = {
            @WebInitParam(name = "message", value = "checks servlet")})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //prepares login page or redisplays it with login failed message
        if (req.getParameter("failed") != null) {
            req.setAttribute("loginResult", req.getParameter("failed"));
        }
        System.out.println("XXXXX");
        req.getRequestDispatcher("login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String referrer = req.getHeader("referer");
        UUID uuid = UUID.randomUUID();
        final Object username = req.getParameter("username");
        final Object password = req.getParameter("password");
        System.out.println("referrer: " + referrer + username + password + " failed: " + req.getParameter("failed"));
        req.getServletContext().getNamedDispatcher("IndexServlet").forward(req, resp);
    }
}
