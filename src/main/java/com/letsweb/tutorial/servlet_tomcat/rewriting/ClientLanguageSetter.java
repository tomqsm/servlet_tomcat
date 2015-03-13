package com.letsweb.tutorial.servlet_tomcat.rewriting;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toks
 */
public class ClientLanguageSetter {

    private static final Set<String> languages = new HashSet<>();
    private static final String DEFAULT_LANGUAGE = "pl";

    static {
        languages.add("pl");
        languages.add("en");
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
    
    public boolean isLanguageSupported(String lang){
        boolean isSupported = false;
        isSupported = languages.contains(lang);
        return isSupported;
    }
}
