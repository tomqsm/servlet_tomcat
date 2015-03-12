<%@ page contentType="text/html"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<%
    if (request.getParameter("failed") == null) {
        response.sendRedirect(request.getContextPath() + "/login");
    }else {
        response.sendRedirect(request.getContextPath() + "/login/failed");
    }
%>