package com.letsweb.tutorial.servlet_tomcat.rewriting;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserJsonController {

    private static final Logger logger = LoggerFactory.getLogger(UserJsonController.class);

    public void run(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
        logger.debug("Starts.");
        req.setAttribute("date", new Date());
        Thread.sleep(7000);
    }

}
