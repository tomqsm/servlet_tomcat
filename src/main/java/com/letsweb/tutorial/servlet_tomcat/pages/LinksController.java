package com.letsweb.tutorial.servlet_tomcat.pages;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LinksController extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(req.getParameter("Servlet via urlrewirting GET"));
//        req.getRequestDispatcher(getServletContext().getInitParameter("template")).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("Servlet via urlrewirting POST"));
//        req.getRequestDispatcher(getServletContext().getInitParameter("template")).forward(req, resp);
    }
    
}
