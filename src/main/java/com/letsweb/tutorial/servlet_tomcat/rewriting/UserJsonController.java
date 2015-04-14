package com.letsweb.tutorial.servlet_tomcat.rewriting;

import com.letsweb.tutorial.servlet_tomcat.dataaccess.dao.PropertyLineDao;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserJsonController {

    private static final Logger logger = LoggerFactory.getLogger(UserJsonController.class);

    public void run(HttpServletRequest req, HttpServletResponse res) {
        logger.debug("Starts.");
        req.setAttribute("date", new Date());
        PropertyLineDao dao = new PropertyLineDao();
        logger.debug("XXX {}", dao.findRecordByName("esgo4"));
    }
    
    public void getDelayedJson(HttpServletRequest req, HttpServletResponse res) throws InterruptedException{
        final String delayString = req.getAttribute("delay").toString();
        logger.debug("delay string: {}", delayString);
        int delayTime = Integer.parseInt(delayString);
        logger.debug("delay int: {}", delayTime);
        req.setAttribute("date", new Date());
        Thread.sleep(delayTime*1000);
    }

}
