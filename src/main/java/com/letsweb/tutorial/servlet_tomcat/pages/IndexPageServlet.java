package com.letsweb.tutorial.servlet_tomcat.pages;

import freemarker.ext.dom.NodeModel;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.FileUtils;
import org.xml.sax.SAXException;

/**
 * This class illustrate WebServlet annotation
 *
 * @author Shing Wai Chan
 * @author Daniel Guo
 */
@WebServlet(name = "IndexPageServlet", urlPatterns = {"/index"},
        initParams = {
            @WebInitParam(name = "message", value = "checks servlet")})
public class IndexPageServlet extends HttpServlet {

    private String listenerMessage = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        listenerMessage = (String) config.getServletContext().getAttribute("listenerMessage");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        NodeModel parsed = null;
        try {
            parsed = NodeModel.parse(new File(req.getServletContext().getRealPath("WEB-INF/freemarker/header.xml")));
        } catch (SAXException ex) {
            Logger.getLogger(IndexPageServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(IndexPageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        req.setAttribute("xml", parsed);
        req.getRequestDispatcher("WEB-INF/freemarker/index.ftl").forward(req, res);
    }
}