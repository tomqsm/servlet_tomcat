package com.letsweb.tutorial.servlet_tomcat.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * This filter is to obviate landing page. It forwards
 *
 * @author toks
 */
@WebFilter(filterName = "UrlFilter", urlPatterns = {"/en/*"}, initParams = {
    @WebInitParam(name = "mesg", value = "my filter")})
public class UrlFilter implements Filter {

    private List<String> supportedLocales;
    private Locale en;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        supportedLocales = Arrays.asList(filterConfig.getServletContext().getInitParameter("supportedLocales").split(","));
        en = Locale.ENGLISH;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
// make sure it runs on urls containing allowed languages
        if (req instanceof HttpServletRequest) {
            HttpServletRequest httpReq = (HttpServletRequest) req;
            final String servletPath = httpReq.getServletPath();
            final String lang = servletPath.substring(1, 3);
            String context = req.getServletContext().getContextPath();
            req.setAttribute("context", context + lang);
            
            System.out.println("Filter 3 before: request url: " + lang);
        }
        chain.doFilter(req, res);
            System.out.println("Filter 3 after: request url: ");
    }

    @Override
    public void destroy() {
    }

}
