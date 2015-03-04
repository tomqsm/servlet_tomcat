package com.letsweb.tutorial.servlet_tomcat.pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toks
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/indexservlet"})
public class IndexServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param req servlet request
     * @param res servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("serlet index page servlet");
        req.setAttribute("response", res); //for tuckey filter in ftl
        String i18RootUrl = "";
        final String requestURI = req.getRequestURI();
        final StringBuffer requestURL = req.getRequestURL();
        final StringBuffer requestURLWithQuery = req.getRequestURL().append('?').append(req.getQueryString());
        final String contextPath = req.getContextPath();
        final int indexOfContextPathInURL = requestURL.indexOf(contextPath);
        final StringBuffer modifiedRequestURL = req.getRequestURL().append('?').append(req.getQueryString()).replace(0, indexOfContextPathInURL + contextPath.length(), "/en");

        System.out.println("requestURI: " + requestURI);
        System.out.println("requestURL: " + requestURL);
        System.out.println("requestURLWithQuery: " + requestURLWithQuery);
        System.out.println("indexOfContextPath: " + indexOfContextPathInURL);
        System.out.println("modifiedRequestURL: " + modifiedRequestURL);
        System.out.println("contextPath: " + contextPath);
        final String languageURL = res.encodeURL(contextPath + modifiedRequestURL.toString());
        req.setAttribute("languageURLen", languageURL);
        req.setAttribute("languageURLpl", res.encodeURL(requestURLWithQuery.toString()));
        

        if (req.getParameter("lang") != null) {
            req.setAttribute("locale", req.getParameter("lang"));
        }
        req.getRequestDispatcher(getServletContext().getInitParameter("template")).forward(req, res);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
