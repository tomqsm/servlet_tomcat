package com.letsweb.tutorial.servlet_tomcat.rewriting;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toks
 */
public class URLLanguageSetter {

    private static final Logger logger = LoggerFactory.getLogger(URLLanguageSetter.class);
    private static final String SUPPORTED_LANGUAGES = "supportedLanguages";
    private String supportedLanguagesString = null;

    public void init(ServletConfig servletConfig) {
        final boolean needsInitialising = supportedLanguagesString == null;
        if (needsInitialising) {
            supportedLanguagesString = servletConfig.getServletContext().getInitParameter(SUPPORTED_LANGUAGES);
            assert supportedLanguagesString != null : "assert that web.xml has <context-param> named supportedLanguages";
        }
    }

    /**
     * This method is automatically called by means if urlrewrite.xml run tag.
     * @param request
     * @param response
     */
    public void run(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("servletPathWithoutLanguage", getServletPathWithQueryStringWithoutLanguage(request));
    }

    private String getServletPathWithQueryStringWithoutLanguage(HttpServletRequest request) {
        final HttpServletRequest originalRequest = (HttpServletRequest) (request.getAttribute("request"));
        assert originalRequest != null : "assertion: please set original request";
        final String contextPath = originalRequest.getContextPath();
        final StringBuffer requestURL = originalRequest.getRequestURL();
        final int indexOfContextStart = requestURL.indexOf(contextPath);
        final int indexOfContextEnd = indexOfContextStart + contextPath.length();
        String pathFromContext = requestURL.append(getQueryString(originalRequest)).replace(0, indexOfContextEnd, "").toString();
        final String[] langs = supportedLanguagesString.split(",");
        final String slash = "/";
        if (contextPath.length() == 1) {
            for (int i = 0; i < langs.length; i++) {
                String lang = langs[i];
                langs[i] = lang + slash;
            }
        } else {
            for (int i = 0; i < langs.length; i++) {
                String lang = langs[i];
                langs[i] = slash + lang + slash;
            }
        }
        for (String lang : langs) {
            if (pathFromContext.contains(lang)) {
                pathFromContext = pathFromContext.replaceAll(lang, "");
            }
        }
        return pathFromContext.startsWith(slash) ? pathFromContext : slash + pathFromContext;
    }

    private String getQueryString(HttpServletRequest request) {
        String queryString = request.getQueryString();
        queryString = queryString == null ? "" : queryString;
        StringBuilder queryStringBuilder = new StringBuilder(queryString);
        if (queryStringBuilder.length() != 0) {
            queryStringBuilder.insert(0, '?');
        }
        return queryStringBuilder.toString();
    }
}
