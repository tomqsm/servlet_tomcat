package com.letsweb.tutorial.servlet_tomcat;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toks
 */
public class LocaleSetter {

    private static Set<String> languages = new HashSet<String>();
    private static final String DEFAULT_LANGUAGE = "pl";

    static {
        languages.add("pl");
        languages.add("en");
    }

    public void run(HttpServletRequest request, HttpServletResponse response) {
        final Locale locale = request.getLocale();
        String browserLang = locale.getLanguage();
        String urlLang = null; // parse url for en / pl
        if (languages.contains(browserLang) && urlLang == null && !browserLang.equals(DEFAULT_LANGUAGE)) {
            request.setAttribute("selectedLanguage", "/" + browserLang + "/");
        } else {
            request.setAttribute("selectedLanguage", "/");
        }
        request.setAttribute("tk", true);
        System.out.println("LocaleSetter OK: " + "Browser language: " + browserLang + ", set selectedLanguage: [" + request.getAttribute("selectedLanguage") + "]");
    }
}
