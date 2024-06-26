<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,cn.edu.hit.entity.*,cn.edu.hit.dao.*"%>
<!-- 设置页面语言为Java，内容类型为text/html，字符集为UTF-8，并导入所需的Java包 -->
<%@ include file="admin-check.jsp"%> <!-- 包含用于管理员检查的 JSP 文件 -->
<!DOCTYPE html> <!-- 声明文档类型为 HTML5 -->
<html>
<head>
  <meta charset="UTF-8"> <!-- 设置页面字符集为UTF-8 -->
  <title>用户管理</title> <!-- 设置页面标题为“用户管理” -->
</head>
<body>
<a href="administrate.jsp">《返回</a> <!-- 返回链接，指向 administrate.jsp -->
<form method="post"> <!-- 表单，使用POST方法提交 -->
  <div align="center">请输入用户名: <!-- 提示用户输入用户名 -->
    <input type="text" name="username"/> <!-- 文本输入框，用于输入用户名 -->
    <input type="submit" value="查询"/> <!-- 提交按钮，点击后提交表单 -->
  </div>
</form>
<table width="316" border="1" align="center"> <!-- 创建一个宽度为316的表格，边框为1，居中显示 -->
  <tr>
    <td width="72">头像</td> <!-- 表头，显示“头像” -->
    <td width="72">用户名</td> <!-- 表头，显示“用户名” -->
    <td width="72">性别</td> <!-- 表头，显示“性别” -->
    <td width="72">密码</td> <!-- 表头，显示“密码” -->
    <td width="72">删除</td> <!-- 表头，显示“删除” -->
  </tr>
  <%
    String face, username, gender, pwd; // 定义变量，分别表示头像、用户名、性别和密码
    int age; // 定义变量，表示年龄（但未使用）
    request.setCharacterEncoding("UTF-8"); // 设置请求的字符编码为UTF-8
    username = request.getParameter("username"); // 获取请求参数“username”
    if (username == null) { // 如果用户名为空
      username = ""; // 将用户名设置为空字符串
    } else {
      username = username.trim(); // 去掉用户名两端的空格
    }
    UserDao dao = new UserDao(); // 创建 UserDao 对象
    List<User> uList = dao.getAll("select * from people where username like '%" + username + "%'"); // 查询符合条件的用户列表
    for (User u : uList) { // 遍历用户列表
      face = u.getFace(); // 获取用户头像
      username = u.getUsername(); // 获取用户名
      gender = u.getGender(); // 获取性别
      pwd = u.getPwd(); // 获取密码
  %>
  <tr>
    <td><img src="face/<%= face %>.jpg" alt="头像"/></td> <!-- 显示用户头像 -->
    <td><%= username %></td> <!-- 显示用户名 -->
    <td><%= gender %></td> <!-- 显示性别 -->
    <td><%= pwd %></td> <!-- 显示密码 -->
    <td><% if (!username.equals("admin")) out.println("<a href=\"RegServlet?from=remove&username=" + username + "\" onClick=\"return confirm('确定删除吗？')\">删除</a>"); %></td> <!-- 如果用户名不是“admin”，则显示删除链接，点击后弹出确认框 -->
  </tr>
  <%
    } // 结束 for 循环
  %>
</table>
</body>
</html>
