package com.letsweb.tutorial.servlet_tomcat.rest;

import freemarker.ext.dom.NodeModel;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

@WebServlet(name = "LayoutServlet", urlPatterns = {"/user"}, initParams = {
    @WebInitParam(name = "message", value = "layout servlet")})
public class LayoutServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(LayoutServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NodeModel parsed = null;
        try {
            parsed = NodeModel.parse(new File(req.getServletContext().getRealPath(
                    "WEB-INF/freemarker/header.xml")));
        } catch (SAXException ex) {
            LOG.error(ex.getMessage());
        } catch (ParserConfigurationException ex) {
            LOG.error(ex.getMessage());
        }

        req.setAttribute("xml", parsed);
        req.setAttribute("locale", req.getLocale().getLanguage());
        req.setAttribute("timestamp", System.currentTimeMillis());
        req.setAttribute("id", req.getParameter("id"));
        req.getRequestDispatcher("WEB-INF/freemarker/json/user.ftl").forward(req, resp);
    }

}
