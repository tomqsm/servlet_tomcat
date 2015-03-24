package com.letsweb.tutorial.servlet_tomcat.pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinksController extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(LinksController.class);
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(req.getParameter("Servlet via urlrewirting GET"));
    }
    
    public void doGetPodlogi(HttpServletRequest req, HttpServletResponse res) {
        logger.debug("podłogi");
        req.setAttribute("request", req);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("Servlet via urlrewirting POST"));
    }
    
}
