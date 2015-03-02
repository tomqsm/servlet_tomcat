package com.letsweb.tutorial.servlet_tomcat.filters;

import com.letsweb.tutorial.servlet_tomcat.pages.index.TemplateProvider;
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
import javax.servlet.http.HttpServletRequest;

/**
 * This filter is to obviate landing page. It forwards
 *
 * @author toks
 */
@WebFilter(filterName = "ApplicationScopeDataFilter", urlPatterns = {"/"}, initParams = {
    @WebInitParam(name = "mesg", value = "my filter")})
public class ApplicationScopeDataFilter implements Filter {

    private TemplateProvider templateProvider;
    private static String scripts;
    private static String csses;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        scripts = filterConfig.getServletContext().getInitParameter("scripts");
        csses = filterConfig.getServletContext().getInitParameter("csses");
        templateProvider = new TemplateProvider(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        req.setAttribute("xml", templateProvider.getTemplateModelWithXml((HttpServletRequest) req, "WEB-INF/freemarker/application.xml"));
        req.setAttribute("scripts", templateProvider.getTemplateModelWithXml((HttpServletRequest) req, scripts));
        req.setAttribute("csses", templateProvider.getTemplateModelWithXml((HttpServletRequest) req, csses));
        req.setAttribute("context", req.getServletContext().getContextPath());
        System.out.println("ApplicationScopeDataFilter 2 before: locale ");
        chain.doFilter(req, res);
        System.out.println("ApplicationScopeDataFilter 2 after: locale ");
    }

    @Override
    public void destroy() {
    }
}
