package com.letsweb.tutorial.servlet_tomcat.rewriting
import com.letsweb.tutorial.servlet_tomcat.Diagnostics;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author toks
 */
class RootColtroller {
    private static final Logger logger = LoggerFactory.getLogger(RootController.class);

    public void run(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        logger.debug("Started.");
        req.setAttribute("context", req.getContextPath());
        req.setAttribute("request", req);
    } 
	
}

