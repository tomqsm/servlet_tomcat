package com.letsweb.tutorial.servlet_tomcat.rewriting;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toks
 */
public class PageLanguageUrlResolver {

    final Logger logger = LoggerFactory.getLogger(PageLanguageUrlResolver.class);

    public void run(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("{}");
    }

    public void test(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {
        logger.debug("{} pathFrom: {}, \n pathToLang {} \n pathFromLang: {}", request.getAttribute("log.info"), getPathFrom(request), getPathToLang(request), getPathFromLang(request));
        request.removeAttribute("log.info");
    }

    public String getPathFrom(HttpServletRequest request) {
        String pathFrom = "";
        pathFrom = request.getHeader("referer");
        return pathFrom == null ? "" : pathFrom;
    }

    public String getPathTo(HttpServletRequest request) {
        String pathTo = "";
        pathTo = request.getRequestURL().toString();
        return pathTo == null ? "" : pathTo;
    }

    public String getPathFromLang(HttpServletRequest request) {
        final String[] langs = new String[]{"en", "pl"};
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

    public String getPathToLang(HttpServletRequest request) {
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
}
