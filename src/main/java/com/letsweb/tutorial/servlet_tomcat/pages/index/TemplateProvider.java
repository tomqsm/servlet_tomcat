package com.letsweb.tutorial.servlet_tomcat.pages.index;

import freemarker.ext.dom.NodeModel;
import java.io.File;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author toks
 */
public class TemplateProvider {

    private final FilterConfig filterConfig;
    private static final String RELOAD_PARAM_NAME = "reloadTemplate";
    private NodeModel model;

    public TemplateProvider(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    private boolean isReloadingOnRequest() {
        return (Boolean.parseBoolean(filterConfig.getServletContext().getInitParameter(RELOAD_PARAM_NAME)));
    }

    private void loadTemplateModelWithXml(HttpServletRequest req, String path) {
        try {
            model = NodeModel.parse(new File(req.getServletContext().getRealPath(path)));
        } catch (Exception ex) {
            throw new RuntimeException("Parsing template problem.");
        }
    }

    public NodeModel getTemplateModelWithXml(HttpServletRequest req, String path) {
        if (model == null || isReloadingOnRequest()) {
            loadTemplateModelWithXml(req, path);
        }
        return model;
    }
}
