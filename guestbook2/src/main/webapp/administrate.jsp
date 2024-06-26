<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,cn.edu.hit.entity.*,cn.edu.hit.dao.*"%> <!-- 设置页面语言为Java，内容类型为text/html，字符集为UTF-8，并导入所需的Java包 -->
<%@ include file="admin-check.jsp"%> <!-- 包含用于管理员检查的 JSP 文件 -->
<!DOCTYPE html> <!-- 声明文档类型为 HTML5 -->
<html>
<head>
    <meta charset="UTF-8"> <!-- 设置页面字符集为UTF-8 -->
    <title>管理</title> <!-- 设置页面标题为“管理” -->
    <style type="text/css">
        <!--
        .STYLE1 {
            font-size: xx-large;
            font-weight: bold;
        }
        .STYLE2 {
            font-size: large;
            font-weight: bold;
        }
        -->
    </style>
</head>
<body>
<p align="center" class="STYLE1">欢迎使用管理系统</p> <!-- 显示欢迎信息 -->
<%-- 注释掉的行，原本用于显示管理选项 -->
<%--<p align="center"><span class="STYLE2"><a href="modifyPwd2.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="user.jsp">用户管理</a>&nbsp;&nbsp;&nbsp;&nbsp;<a>帖子管理</a>&nbsp;&nbsp;&nbsp;&nbsp;<a>版块管理</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="ExitServlet">退出</a></span></p>--%>
<p align="center"><span class="STYLE2"><a href="modifyPwd2.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="user.jsp">用户管理</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="regulateMessage.jsp">帖子管理</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="regulateSection.jsp">版块管理</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="ExitServlet">退出</a></span></p> <!-- 显示管理选项，提供修改密码、用户管理、帖子管理、版块管理和退出的链接 -->
</body>
</html>
