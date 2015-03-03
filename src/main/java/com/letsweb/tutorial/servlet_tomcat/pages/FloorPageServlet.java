package com.letsweb.tutorial.servlet_tomcat.pages;

import java.io.IOException;
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
@WebServlet(name = "IndexPageServlet", urlPatterns = {"/floor"},
        initParams = {
            @WebInitParam(name = "message", value = "checks servlet")})
public class FloorPageServlet extends HttpServlet {

    private String listenerMessage = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        listenerMessage = (String) config.getServletContext().getAttribute("listenerMessage");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("serlet index page servlet");
        req.setAttribute("response", res); //for tuckey filter in ftl
        if(req.getParameter("lang") != null){
            req.setAttribute("locale", req.getParameter("lang"));
        }
        req.getRequestDispatcher(getServletContext().getInitParameter("template")).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("loginFailed"));
        req.getRequestDispatcher(getServletContext().getInitParameter("template")).forward(req, resp);
    }
    
}
