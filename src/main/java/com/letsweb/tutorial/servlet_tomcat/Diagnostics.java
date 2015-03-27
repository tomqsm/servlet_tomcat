package com.letsweb.tutorial.servlet_tomcat;

import com.letsweb.tutorial.servlet_tomcat.rewriting.RootController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toks
 */
public class Diagnostics {

    private static final Logger logger = LoggerFactory.getLogger(RootController.class);
    
    public Diagnostics() {
    }
    
    public Cookie[] getCookies(final HttpServletRequest request) {
        return request.getCookies();
    }
    
    public class NameValuePair {
        
        private String name, value;
        
        public NameValuePair(String name, String value) {
            this.name = name;
            this.value = value;
        }
        
        public NameValuePair() {
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getValue() {
            return value;
        }
        
        public void setValue(String value) {
            this.value = value;
        }
        
    }
}
