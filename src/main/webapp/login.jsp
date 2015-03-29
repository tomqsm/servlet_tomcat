<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<%
    if (request.getParameter("failed") == null) {
        if (request.getHeader("referer") == null) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
        } else {
            if (request.getHeader("referer").contains("/en/")) {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/en/login"));
            } else if (request.getHeader("referer").contains("/de/")) {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/de/login"));
            } else {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
            }
        }

    } else {
        if (request.getHeader("referer") == null) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login-failed"));
        } else {
            if (request.getHeader("referer").contains("/en/")) {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/en/login-failed"));
            } else if (request.getHeader("referer").contains("/de/")) {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/de/login-failed"));
            } else {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login-failed"));
            }
        }

    }
%>