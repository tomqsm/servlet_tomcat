package com.letsweb.tutorial.servlet_tomcat.pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LinksController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(req.getParameter("Servlet via urlrewirting GET"));
    }

    public void doGetPodlogi(HttpServletRequest req, HttpServletResponse res){
        System.out.println("doGetPodlogi " + req.getRequestURL().toString());
        System.out.println("doGetPodlogi " + req.getRequestURI().toString());
        req.setAttribute("servletPath", req.getRequestURI());
        req.setAttribute("queryString", req.getQueryString());
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("Servlet via urlrewirting POST"));
    }
    
}
