package com.letsweb.tutorial.servlet_tomcat.rewriting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toks
 */
public class RewritingLogger {

    public void run(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("LOGGER XXX");
    }
}
