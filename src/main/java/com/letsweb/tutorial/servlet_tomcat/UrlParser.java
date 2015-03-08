package com.letsweb.tutorial.servlet_tomcat;

import java.util.regex.Pattern;

public class UrlParser {

    /**
     * Expects http://localhost:8084/servlet_tomcat/en/indexservlet url splits
     * by en/ checks first split ends with the context then substrings the
     * language.
     *
     * @param context
     * @param url
     * @return
     */
    public String parseLanguageFromUrl(String context, String url) {
        String lang = "",
                regex = "/(en|pl)/";
        final String[] split = Pattern.compile(regex).split(url);
        if (split[0].endsWith(context)) {
            final int lengthToLang = split[0].length();
            lang = url.substring(lengthToLang + 1, lengthToLang + 3);
        }
        return lang;
    }
}
