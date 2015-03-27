package com.letsweb.tutorial.servlet_tomcat.rewriting;

import com.letsweb.tutorial.servlet_tomcat.Diagnostics;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RootController {
    private static final Logger logger = LoggerFactory.getLogger(RootController.class);
        final Diagnostics diagnostics = new Diagnostics();
    
    private boolean isDiagnostics = true;

    public void run(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        logger.debug("Started.");
        if(isDiagnostics){
            req.setAttribute("diagnostics_cookies", diagnostics.getCookies(req));
        }
        req.setAttribute("context", req.getContextPath());
        req.setAttribute("request", req);
    }
    
}
