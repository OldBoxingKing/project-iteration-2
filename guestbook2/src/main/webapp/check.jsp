<%
    // 从 session 中获取用户名
    String uname = (String) session.getAttribute("username");
    // 如果用户名为空，则表示用户未登录，重定向到登录页面
    if (uname == null) {
        response.sendRedirect("login.jsp");
        return; // 结束代码执行
    }
%>
