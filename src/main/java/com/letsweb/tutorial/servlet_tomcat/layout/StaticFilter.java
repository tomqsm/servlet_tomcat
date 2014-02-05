package com.letsweb.tutorial.servlet_tomcat.layout;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "filter2", urlPatterns = {"/"}, initParams = {@WebInitParam(name = "mesg", value = "my filter")})
public class StaticFilter implements Filter {

  private RequestDispatcher defaultRequestDispatcher;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    defaultRequestDispatcher = filterConfig.getServletContext().getNamedDispatcher("LayoutServlet");
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    defaultRequestDispatcher.forward(req, res);
  }

  @Override
  public void destroy() {}
}
