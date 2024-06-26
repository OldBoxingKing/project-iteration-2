<%--
  Created by IntelliJ IDEA.
  User: DeepMind2
  Date: 2023/5/3
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%
    String uname = (String)session.getAttribute("admin");
    if(uname == null)
    {
        response.sendRedirect("admin-login.jsp");
        return;
    }
%>
