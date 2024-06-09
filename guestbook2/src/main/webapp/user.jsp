<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,cn.edu.hit.entity.*,cn.edu.hit.dao.*"%> <!-- 设置JSP页面的语言为Java，内容类型为HTML，字符集为UTF-8，并导入java.util、cn.edu.hit.entity和cn.edu.hit.dao包 -->
<%@ include file="admin-check.jsp"%> <!-- 包含名为admin-check.jsp的文件 -->
<!DOCTYPE html> <!-- 定义文档类型为HTML5 -->
<html>
<head>
  <meta charset="UTF-8"> <!-- 设置页面字符编码为UTF-8 -->
  <title>用户管理</title> <!-- 设置页面标题为"用户管理" -->
</head>
<body>
<a href="administrate.jsp">《返回</a> <!-- 定义一个链接，指向administrate.jsp，文本为"《返回" -->
<form method="post"> <!-- 定义一个表单，使用POST方法提交，action未指定，因此会提交到当前页面 -->
<%--  表单提交后页面会重新加载，并执行表单提交的处理逻辑。这就是通过重新加载页面，执行页面上的Java代码来处理查询请求。--%>
  <div align="center">请输入用户名:
    <input type="text" name="username"/> <!-- 定义一个文本输入框，名称为username -->
    <input type="submit" value="查询"/> <!-- 定义一个提交按钮，文本为"查询" -->
  </div>
</form>
<table width="316" border="1" align="center"> <!-- 定义一个宽度为316，带边框，居中的表格 -->
  <tr>
    <td width="72">头像</td> <!-- 定义一个单元格，内容为"头像"，宽度为72 -->
    <td width="72">用户名</td> <!-- 定义一个单元格，内容为"用户名"，宽度为72 -->
    <td width="72">性别</td> <!-- 定义一个单元格，内容为"性别"，宽度为72 -->
    <td width="72">密码</td> <!-- 定义一个单元格，内容为"密码"，宽度为72 -->
    <td width="72">删除</td> <!-- 定义一个单元格，内容为"删除"，宽度为72 -->
  </tr>
  <%
    String face, username, gender, pwd;
    int age;
    request.setCharacterEncoding("UTF-8"); //<!-- 设置请求的字符编码为UTF-8 -->
    username = request.getParameter("username"); //<!-- 获取请求参数username的值 -->
    if(username == null)
    {
    username = ""; //<!-- 如果username为null，将其设为空字符串 -->
    }
    else
    {
    username = username.trim(); //<!-- 否则，将username去掉首尾空格 -->
    }
    UserDao dao = new UserDao(); //<!-- 创建UserDao对象 -->
    List<User> uList = dao.getAll("select * from people where username like '%" + username + "%'"); //<!-- 调用getAll方法，查询符合条件的用户列表 -->
    for(User u : uList) { //<!-- 遍历用户列表 -->
    face = u.getFace(); //<!-- 获取用户的头像 -->
    username = u.getUsername(); //<!-- 获取用户的用户名 -->
    gender = u.getGender(); //<!-- 获取用户的性别 -->
    pwd = u.getPwd(); //<!-- 获取用户的密码 -->
  %>
  <tr>
    <td><img src="face/<%=face%>.jpg"/></td> <!-- 显示用户头像 -->
    <td><%=username%></td> <!-- 显示用户名 -->
    <td><%=gender%></td> <!-- 显示性别 -->
    <td><%=pwd%></td> <!-- 显示密码 -->
    <td><%if(!username.equals("admin")) out.println("<a href=\"RegServlet?from=remove&username=" + username + "\" onClick=\"return confirm('确定删除吗？')\">删除</a>");%></td> <!-- 如果用户名不是admin，显示删除链接，点击时弹出确认提示 -->
  </tr>
  <%
    }
  %>
</table>
</body>
</html>
