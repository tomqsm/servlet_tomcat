package com.letsweb.tutorial.servlet_tomcat.filters;

import freemarker.ext.dom.NodeModel;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author toks
 */
public class TemplateLoaderFilter implements Filter {

    private static final boolean debug = false;

    private FilterConfig filterConfig;
    private File appStaticData;
    private File scriptsFile;
    private File cssesFile;

    public TemplateLoaderFilter() {
    }

    private void doBeforeProcessing(ServletRequest req, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("DecoratorFilter:DoBeforeProcessing");
        }
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("DECOR before ok.");
        req.setAttribute("context", req.getServletContext().getContextPath());
        try {
            req.setAttribute("xml", NodeModel.parse(appStaticData));
            req.setAttribute("scripts", NodeModel.parse(scriptsFile));
            req.setAttribute("csses", NodeModel.parse(cssesFile));
            req.setAttribute("locale", req.getAttribute("locale") == null ? req.getLocale().getLanguage() : req.getAttribute("locale"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("DecoratorFilter:DoAfterProcessing");
        }
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("DecoratorFilter:doFilter()");
        }

        doBeforeProcessing(request, response);

        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }

        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("DecoratorFilter:Initializing filter");
            }
        }
        initialiseFreemarker();
    }
    private void initialiseFreemarker() {
        appStaticData = new File(filterConfig.getServletContext().getRealPath("/WEB-INF/freemarker/application.xml"));
        scriptsFile = new File(filterConfig.getServletContext().getRealPath(filterConfig.getServletContext().getInitParameter("scripts")));
        cssesFile = new File(filterConfig.getServletContext().getRealPath(filterConfig.getServletContext().getInitParameter("csses")));
    }
    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("DecoratorFilter()");
        }
        StringBuffer sb = new StringBuffer("DecoratorFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
