package com.letsweb.tutorial.servlet_tomcat.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.fest.assertions.Assertions.assertThat;

/**
 *
 * @author toks
 */
public class IndexServletTest {

    public IndexServletTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void patternWorks() {
        String url = "http://localhost:8084/servlet_tomcat/indexservlet";
        String pattern = "^.*/[a-z]{2}/.*$";
        boolean matches = url.toString().matches(pattern);
        assertFalse(matches);
        boolean found = Pattern.compile(pattern).matcher(url).find();
        assertFalse(found);
        url = "http://localhost:8084/servlet_tomcat/en/indexservlet";
        found = Pattern.compile(pattern).matcher(url).find();
        assertTrue(found);
        matches = url.toString().matches(pattern);
        assertTrue(matches);
    }

    @Test
    public void returnsFoundPattern() {
        String[] found = new String[1];
        String regex = "/(en|pl)/";
        String context = "/";
        String url = "http://localhost:8084"+context+"/en/indexservlet";
        final Pattern pattern = Pattern.compile(regex);
        final String[] split = pattern.split(url);
        System.out.println(split.length);
//        assertThat(split).isSameAs(new String [] {"/en/"});
        assertThat(split[0].endsWith(context)).isTrue();
        if (split[0].endsWith(context)) {
//            final int index = url.indexOf(split[0]) + split[0].length() + 1;
            
            System.out.println(url.substring(split[0].length()+1, split[0].length() + 3));
        }

        final Matcher matcher = pattern.matcher(url);
        int counter = 0;
        while (matcher.find()) {
            found[counter++] = matcher.group();
        }
//        assertThat(found[0]).isEqualTo("/en/");
    }

    public String parseLanguageInUrl(String context, String url) {
        String lang = "",
                regex = "[a-z]{2}/";
        final String[] split = Pattern.compile(regex).split(url);
        if (split[0].endsWith(context)) {
            final int endOfContext = split[0].lastIndexOf(context);
            lang = url.substring(endOfContext + 1, endOfContext + 3);
        }
        return lang;
    }

}
