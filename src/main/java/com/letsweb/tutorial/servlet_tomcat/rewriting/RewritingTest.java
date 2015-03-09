package com.letsweb.tutorial.servlet_tomcat.rewriting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.tuckey.web.filters.urlrewrite.extend.RewriteMatch;
import org.tuckey.web.filters.urlrewrite.extend.RewriteRule;

/**
 *
 * @author toks
 */
public class RewritingTest extends RewriteRule{

    @Override
    public RewriteMatch matches(HttpServletRequest request, HttpServletResponse response) {
        final RewriteMatch rewriteMatch = new RewriteMatch();
        return super.matches(request, response); //To change body of generated methods, choose Tools | Templates.
    }
    
}
