package com.letsweb.tutorial.servlet_tomcat.rewriting;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogoutController {

    private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);

    public void run(HttpServletRequest req, HttpServletResponse res) {
        logger.debug("Starts.");
        removePrincipal(req, res);
    }

    public void removePrincipal(HttpServletRequest req, HttpServletResponse res) {
        final Principal userPrincipal = req.getUserPrincipal();
        if (userPrincipal == null) {
            // user has not been authenticated - do nothing
            logger.debug("No Princial found. User has not been authenticated.");
        } else {
            final HttpSession session = req.getSession(false);
            session.invalidate();
        }
    }

}
