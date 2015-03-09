<%@ page contentType="text/html"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<%
    if (request.getParameter("failed") == null) {
        response.sendRedirect(request.getContextPath() + "/login");
    } else if(request.getLocale().getLanguage().toString().equals("pl")){
        response.sendRedirect(request.getContextPath() + "/logowanie/nieudane");
    }else {
        response.sendRedirect(request.getContextPath() + "/login/failed");
    }
%>