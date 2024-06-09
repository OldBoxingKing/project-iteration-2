
<%
    String uname = (String)session.getAttribute("admin");
    if(uname == null)
    {
        response.sendRedirect("admin-login.jsp");
        return;
    }
%>
