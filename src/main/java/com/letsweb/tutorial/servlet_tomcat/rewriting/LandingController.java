package com.letsweb.tutorial.servlet_tomcat.rewriting;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LandingController {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(req.getParameter("Servlet via urlrewirting GET"));
        System.out.println("IndexServlet :)");
        req.setAttribute("context", req.getContextPath());
        req.setAttribute("request", req);
    }

    public void doGetPodlogi(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("doGetPodlogi " + req.getRequestURL().toString());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("Servlet via urlrewirting POST"));
    }

}
