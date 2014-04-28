package com.letsweb.tutorial.servlet_tomcat.filters;

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
 * This filter is to obviate landing page. It forwards
 *
 * @author toks
 */
@WebFilter(filterName = "RootFilter", urlPatterns = {"/"}, initParams = {
    @WebInitParam(name = "mesg", value = "my filter")})
public class RootFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }
}
