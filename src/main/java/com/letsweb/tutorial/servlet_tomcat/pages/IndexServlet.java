package com.letsweb.tutorial.servlet_tomcat.pages;

import com.letsweb.tutorial.servlet_tomcat.UrlParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toks
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/index", "/en/index", "/de/index"}) 
public class IndexServlet extends HttpServlet {

    private UrlParser parser = new UrlParser();

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
        System.out.println("IndexServlet :)");
        final int indexOfContextStart = req.getRequestURL().indexOf(req.getContextPath());
        final int indexOfContextEnd = indexOfContextStart + req.getContextPath().length();
        req.setAttribute("context", req.getContextPath());
        req.setAttribute("fromServlet", req.getRequestURL().append(getQueryString(req)).replace(0, indexOfContextEnd, "").toString());
        System.out.println("fromServlet: " + req.getRequestURI());
        final String langUrl = parser.parseLanguageFromUrl(req.getContextPath(), req.getRequestURL().toString());
        String i18nContext = req.getContextPath();
        if (!langUrl.isEmpty()) {
            req.setAttribute("locale", langUrl);
//            req.setAttribute("tk", "true");
        } else {
            req.setAttribute("locale", "pl");

            // remove
        }
    }

    public String getLanguageLink(HttpServletRequest req, String lang) {
        String defaultLang = "pl";
        if (lang.isEmpty() || lang.equals(defaultLang)) {
            lang = "";
        } else {
            lang = "/" + lang;
        }
        String link = "";

        final int indexOfContextStart = req.getRequestURL().indexOf(req.getContextPath());
        final int indexOfContextEnd = indexOfContextStart + req.getContextPath().length();

        final String currentPathFromDomain = req.getRequestURL().append(getQueryString(req)).replace(0, indexOfContextStart, "").toString(); // /servlet_tomcat/indexservlet?p=test
        final String currentPathFromContext = req.getRequestURL().append(getQueryString(req)).replace(0, indexOfContextEnd, "").toString(); // /indexservlet?p=test
        final StringBuffer currentPathToParams = req.getRequestURL(); // http://localhost:8084/servlet_tomcat/indexservlet
        StringBuffer currentPath = req.getRequestURL().append(getQueryString(req)); // http://localhost:8084/servlet_tomcat/en/indexservlet?p=test
        final String contextPath = req.getContextPath(); // /servlet_tomcat
        final String currentPathI18ToServletPath = currentPath.replace(indexOfContextEnd, currentPath.length(), "/" + lang + "/").toString(); // http://localhost:8084/servlet_tomcat/en/
        final StringBuffer currentPathI18FromContext = req.getRequestURL().append(getQueryString(req)).replace(0, indexOfContextEnd, "/en"); // /en/indexservlet?p=test
        final String contextPathI18 = req.getContextPath(); // /servlet_tomcat/en
        link = contextPathI18 + currentPathFromContext;
        return link;
    }

    public String getQueryString(HttpServletRequest request) {
        String queryString = request.getQueryString();
        queryString = queryString == null ? "" : queryString;
        StringBuilder queryStringBuilder = new StringBuilder(queryString);
        if (queryStringBuilder.length() != 0) {
            queryStringBuilder.insert(0, '?');
        }
        return queryStringBuilder.toString();
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
        request.getRequestDispatcher("template.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
