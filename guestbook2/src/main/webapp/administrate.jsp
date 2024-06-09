
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,cn.edu.hit.entity.*,cn.edu.hit.dao.*"%> <!-- 设置JSP页面的语言为Java，内容类型为HTML，字符集为UTF-8，并导入java.util、cn.edu.hit.entity和cn.edu.hit.dao包 -->
<%@ include file="admin-check.jsp"%> <!-- 包含名为admin-check.jsp的文件 -->
<!DOCTYPE html> <!-- 定义文档类型为HTML5 -->
<html>
<head>
    <meta charset="UTF-8"> <!-- 设置页面字符编码为UTF-8 -->
    <title>管理</title> <!-- 设置页面标题为"管理" -->
    <style type="text/css"> <!-- 定义CSS样式 -->
    <!--
    .STYLE1 {
        font-size: xx-large; <!-- 定义STYLE1样式，字体大小为超大号 -->
        font-weight: bold; <!-- 字体加粗 -->
    }
    .STYLE2 {
        font-size: large; <!-- 定义STYLE2样式，字体大小为大号 -->
        font-weight: bold; <!-- 字体加粗 -->
    }
    -->
    </style>
</head>
<body>
<p align="center" class="STYLE1">欢迎使用管理系统</p> <!-- 定义一个居中的段落，内容为"欢迎使用管理系统"，样式为STYLE1 -->
<p align="center"><span class="STYLE2"><a href="modifyPwd2.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="user.jsp">用户管理</a>&nbsp;&nbsp;&nbsp;&nbsp;<a>帖子管理</a>&nbsp;&nbsp;&nbsp;&nbsp;<a>版块管理</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="ExitServlet">退出</a></span></p> <!-- 定义一个居中的段落，包含多个链接：修改密码、用户管理、帖子管理、版块管理、退出，样式为STYLE2 -->
<%--<p align="center"><span class="STYLE2"><a href="modifyPwd2.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="user.jsp">用户管理</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="regulateMessage.jsp">帖子管理</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="regulateSection.jsp">版块管理</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="ExitServlet">退出</a></span></p>--%> <!-- 注释掉的一段代码，包含了同样的链接，只是帖子管理和版块管理的链接有所不同 -->
</body>
</html> <!-- 结束HTML文档 -->
