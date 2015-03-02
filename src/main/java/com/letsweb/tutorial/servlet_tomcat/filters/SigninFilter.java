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
import javax.servlet.http.HttpServletRequest;

/**
 * This filter is to obviate landing page. It forwards
 *
 * @author toks
 */
@WebFilter(filterName = "RootFilter", urlPatterns = {"/signin"}, initParams = {
    @WebInitParam(name = "mesg", value = "my filter")})
public class SigninFilter implements Filter {

    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        int counter = 1;
        if (req instanceof HttpServletRequest) {
            HttpServletRequest httpReq = (HttpServletRequest) req;
            System.out.println("Filter 1: " + counter++ + httpReq.getRequestURI());
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }
}
