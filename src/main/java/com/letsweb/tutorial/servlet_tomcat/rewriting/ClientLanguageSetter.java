package com.letsweb.tutorial.servlet_tomcat.rewriting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toks
 */
public class ClientLanguageSetter {

    private static final Set<String> languages = new HashSet<>();
    private static final String DEFAULT_LANGUAGE = "pl";
    private static final String SUPPORTED_LANGUAGES_PARAM_NAME = "supportedLanguages";
    private static final String CLIENT_LANGUAGE_ATTRIBUTE_NAME = "browserLanguage";
    private String supportedLanguagesString = null;
    private static final Logger logger = LoggerFactory.getLogger(ClientLanguageSetter.class);

    /**
     * This method is authomatically called when urlrewite.xml uses this class.
     *
     * @param servletConfig
     */
    public void init(ServletConfig servletConfig) {
        final boolean needsInitialising = supportedLanguagesString == null;
        if (needsInitialising) {
            final ServletContext servletContext = servletConfig.getServletContext();
            supportedLanguagesString = getContextParameter(servletContext, SUPPORTED_LANGUAGES_PARAM_NAME);
            assert supportedLanguagesString != null : "assert that web.xml has <context-param> named supportedLanguages";
            final String[] langs = supportedLanguagesString.split(",");
            languages.addAll(Arrays.asList(langs));
        }
    }

    /**
     * This method is automatically called by means if urlrewrite.xml run tag.
     *
     * @param request
     * @param response
     */
    public void run(HttpServletRequest request, HttpServletResponse response) {
        final Locale locale = request.getLocale();
        String browserLang = locale.getLanguage();
        if (isLanguageSupported(browserLang) && !isLanguageDefault(browserLang)) {
            request.setAttribute(CLIENT_LANGUAGE_ATTRIBUTE_NAME, browserLang);
            logger.debug("Set attribute: {}:{} default language is {}", CLIENT_LANGUAGE_ATTRIBUTE_NAME, browserLang, DEFAULT_LANGUAGE);
        } else {
            request.setAttribute(CLIENT_LANGUAGE_ATTRIBUTE_NAME, "/");
        }
    }

    private boolean isLanguageSupported(String lang) {
        return languages.contains(lang);
    }

    private boolean isLanguageDefault(String lang) {
        return lang.equals(DEFAULT_LANGUAGE);
    }

    private String getContextParameter(ServletContext servletContext, String paramName) {
        final String param = servletContext.getInitParameter(SUPPORTED_LANGUAGES_PARAM_NAME);
        return param == null ? "" : param;
    }
}
