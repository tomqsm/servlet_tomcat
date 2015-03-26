<%@ page contentType="text/html"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<%
    if (request.getParameter("failed") == null) {
        if (request.getHeader("referer") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            if (request.getHeader("referer").contains("/en/")) {
                response.sendRedirect(request.getContextPath() + "/en/login");
            } else if (request.getHeader("referer").contains("/de/")) {
                response.sendRedirect(request.getContextPath() + "/de/login");
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        }

    } else {
        if (request.getHeader("referer") == null) {
            response.sendRedirect(request.getContextPath() + "/login-failed");
        } else {
            if (request.getHeader("referer").contains("/en/")) {
                response.sendRedirect(request.getContextPath() + "/en/login-failed");
            } else if (request.getHeader("referer").contains("/de/")) {
                response.sendRedirect(request.getContextPath() + "/de/login-failed");
            } else {
                response.sendRedirect(request.getContextPath() + "/login-failed");
            }
        }

    }
%>