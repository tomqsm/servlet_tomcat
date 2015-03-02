package com.letsweb.tutorial.servlet_tomcat.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 *
 */
@WebFilter(filterName = "IndexPageFilter", urlPatterns = {"/"},
        initParams = {
            @WebInitParam(name = "mesg", value = "my filter")})
public class IndexPageFilter implements Filter {

    private RequestDispatcher defaultRequestDispatcher;

    public void init(FilterConfig filterConfig) throws ServletException {
        defaultRequestDispatcher = defaultRequestDispatcher == null ? filterConfig.getServletContext().getNamedDispatcher("IndexPageServlet") : defaultRequestDispatcher;
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        defaultRequestDispatcher.forward(req, res);
    }

    public void destroy() {
    }
}
