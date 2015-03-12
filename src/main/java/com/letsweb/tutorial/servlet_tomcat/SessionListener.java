package com.letsweb.tutorial.servlet_tomcat;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toks
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    final Logger logger = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.debug("{} session created, isNew: {}", se.getSession().getId(), se.getSession().isNew());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.debug("{} session destroyed", se.getSession().getId());
    }

}
