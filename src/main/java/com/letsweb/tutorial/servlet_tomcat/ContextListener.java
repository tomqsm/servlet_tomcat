package com.letsweb.tutorial.servlet_tomcat;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Shing Wai Chan
 * @author Daniel Guo
 *
 */
@WebListener()
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        System.out.println("Context initialised. Servlet API " + context.getEffectiveMajorVersion());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context destroyed.");
    }
}
