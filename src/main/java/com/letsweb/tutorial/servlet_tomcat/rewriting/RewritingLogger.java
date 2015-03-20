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

    private static final Logger logger = LoggerFactory.getLogger(RewritingLogger.class);

    /**
     * This method is automatically called by means if urlrewrite.xml run tag.
     * @param request
     * @param response 
     */
    public void run(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("{}");
    }

    /**
     * Input to this method is provided via urlrewrite.xml setting.
     * @param request
     * @param response
     */
    public void log(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("{}", request.getAttribute("log.info"));
        request.removeAttribute("log.info");
    }
}
