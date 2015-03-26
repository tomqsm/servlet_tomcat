package com.letsweb.tutorial.servlet_tomcat.rewriting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    public void run(HttpServletRequest req, HttpServletResponse res) {
        logger.debug("Starts.");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        logger.debug("Starts.");
    }

}
