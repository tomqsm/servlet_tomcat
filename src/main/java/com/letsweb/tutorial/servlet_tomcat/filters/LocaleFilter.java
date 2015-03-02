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

/**
 * This filter is to obviate landing page. It forwards
 *
 * @author toks
 */
@WebFilter(filterName = "LocaleFilter", urlPatterns = {"/"}, initParams = {
    @WebInitParam(name = "mesg", value = "my filter")})
public class LocaleFilter implements Filter {

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
        final String reqLocale = req.getLocale().getLanguage();
        if (supportedLocales.contains(reqLocale)) {
            req.setAttribute("locale", reqLocale);
        } else {
            req.setAttribute("locale", en);
        }
        System.out.println("Filter 2 before: locale " + reqLocale);
        chain.doFilter(req, res);
        System.out.println("Filter 2 after: locale ");
    }

    @Override
    public void destroy() {
    }
}
