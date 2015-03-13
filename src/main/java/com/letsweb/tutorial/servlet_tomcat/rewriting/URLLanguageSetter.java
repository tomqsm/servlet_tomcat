package com.letsweb.tutorial.servlet_tomcat.rewriting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toks
 */
public class URLLanguageSetter {

    final Logger logger = LoggerFactory.getLogger(URLLanguageSetter.class);

    public void run(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("{}");
    }

    public void log(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("log.info: {}", request.getAttribute("log.info"));
        request.removeAttribute("log.info");
    }

    public void setPathFromLang(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("pathFromLang", getPathFromLang(request));
    }

    public void setPathToLang(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("pathToLang", getPathToLang(request));
    }

    public void setServletPathWithoutLanguage(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("servletPathWithoutLanguage", getServletPathWithoutLanguage(request));
    }

    public String rewritePathForLanguage(String lang, HttpServletRequest request) {
        String rewritenPath = "";
        String pathFrom = this.getPathFrom(request);
        

        return rewritenPath;
    }

    private String getPathFrom(HttpServletRequest request) {
        String pathFrom = "";
        pathFrom = request.getHeader("referer");
        return pathFrom == null ? "" : pathFrom;
    }

    private String getPathTo(HttpServletRequest request) {
        String pathTo = "";
        pathTo = request.getRequestURL().toString();
        return pathTo == null ? "" : pathTo;
    }

    private String getPathFromLang(HttpServletRequest request) {
        final String[] langs = new String[]{"en", "pl", "de"};
        final String slash = "/";
        String pathLang = "";
        final String pathFrom = getPathFrom(request);
        final String context = request.getContextPath();
        if (context.length() == 1) {
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
            if (pathFrom.contains(lang)) {
                pathLang = lang.replaceAll(slash, "");
            }
        }
        return pathLang;
    }

    private String getPathToLang(HttpServletRequest request) {
        final String[] langs = new String[]{"en", "pl"};
        final String slash = "/";
        String pathLang = "";
        final String pathTo = getPathTo(request);
        final String context = request.getContextPath();
        if (context.length() == 1) {
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
            if (pathTo.contains(lang)) {
                pathLang = lang.replaceAll(slash, "");
            }
        }
        return pathLang;
    }

    private String getServletPathWithoutLanguage(HttpServletRequest request) {
        final HttpServletRequest originalRequest = (HttpServletRequest)(request.getAttribute("request"));
        assert originalRequest != null : "assertion: please set original request";
        final String contextPath = originalRequest.getContextPath();
        final StringBuffer requestURL = originalRequest.getRequestURL();
        final int indexOfContextStart = requestURL.indexOf(contextPath);
        final int indexOfContextEnd = indexOfContextStart + contextPath.length();
        String pathFromContext = requestURL.append(getQueryString(originalRequest)).replace(0, indexOfContextEnd, "").toString();
        final String[] langs = new String[]{"en", "pl", "de"}; //TODO get these from some init params
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
        return pathFromContext.startsWith(slash) ? pathFromContext : slash+pathFromContext;
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
