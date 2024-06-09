
<%
    String uname = (String)session.getAttribute("username");
    if(uname == null)
    {
        response.sendRedirect("login.jsp");
        return;
    }
%>
