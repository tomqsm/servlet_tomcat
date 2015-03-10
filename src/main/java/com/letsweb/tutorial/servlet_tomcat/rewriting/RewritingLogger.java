package com.letsweb.tutorial.servlet_tomcat.rewriting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toks
 */
public class RewritingLogger {

    final Logger logger = LoggerFactory.getLogger(RewritingLogger.class);

    public void run(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("{}");
    }

    public void log(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("{}", request.getAttribute("log.info"));
        request.removeAttribute("log.info");
    }
}
