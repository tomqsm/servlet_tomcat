package com.letsweb.tutorial.servlet_tomcat.rewriting;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LinksController {

    private static final Logger logger = LoggerFactory.getLogger(LinksController.class);
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(req.getParameter("Servlet via urlrewirting GET"));
    }
    
    public void doGetPodlogi(HttpServletRequest req, HttpServletResponse res) {
        logger.debug("Started.");
        req.setAttribute("request", req);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("Servlet via urlrewirting POST"));
    }
    
}
