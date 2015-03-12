package com.letsweb.tutorial.servlet_tomcat;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener()
public class ContextListener implements ServletContextListener {

    final Logger logger = LoggerFactory.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        logger.debug("Context initialised {}", context.getEffectiveMajorVersion());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.debug("Context destroyed.");
    }
}
