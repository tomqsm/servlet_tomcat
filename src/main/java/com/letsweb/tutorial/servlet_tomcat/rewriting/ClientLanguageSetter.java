package com.letsweb.tutorial.servlet_tomcat.rewriting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.servlet.ServletConfig;
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
    private static final String SUPPORTED_LANGUAGES = "supportedLanguages";
    private String supportedLanguagesString = null;
    final Logger logger = LoggerFactory.getLogger(ClientLanguageSetter.class);

    public void init(ServletConfig servletConfig) {
        final boolean needsInitialising = supportedLanguagesString == null;
        if (needsInitialising) {
            supportedLanguagesString = servletConfig.getServletContext().getInitParameter(SUPPORTED_LANGUAGES);
            assert supportedLanguagesString != null : "assert that web.xml has <context-param> named supportedLanguages";
            final String[] langs = supportedLanguagesString.split(",");
            languages.addAll(Arrays.asList(langs));
        }
    }

    public void run(HttpServletRequest request, HttpServletResponse response) {
        final Locale locale = request.getLocale();
        String browserLang = locale.getLanguage();
        if (languages.contains(browserLang) && !browserLang.equals(DEFAULT_LANGUAGE)) {
            request.setAttribute("browserLanguage", browserLang);
        } else {
            request.setAttribute("browserLanguage", "/");
        }
    }

    public boolean isLanguageSupported(String lang) {
        boolean isSupported = false;
        isSupported = languages.contains(lang);
        return isSupported;
    }
}
