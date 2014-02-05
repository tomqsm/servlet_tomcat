package com.letsweb.tutorial.servlet_tomcat.checks;

import com.letsweb.tutorial.servlet_tomcat.layout.*;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * This class illustrate WebFilter annotation
 *
 * @author Shing Wai Chan
 * @author Daniel Guo
 *
 */
@WebFilter(filterName = "ChecksFilter", urlPatterns = {"/checks"},
           initParams = {@WebInitParam(name = "mesg", value = "my filter")})
public class ChecksFilter implements Filter {

    String mesg = null;
    long time = System.currentTimeMillis();

    public void init(FilterConfig filterConfig) throws ServletException {
        mesg = filterConfig.getInitParameter("mesg");
    }

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        req.setAttribute("locale", req.getLocale().getLanguage());
        chain.doFilter(req, res);
    }

    public void destroy() {
    }
}
