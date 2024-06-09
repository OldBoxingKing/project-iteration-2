<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,cn.edu.hit.entity.*,cn.edu.hit.dao.*"%> <!-- 设置JSP页面的语言为Java，内容类型为HTML，字符集为UTF-8，并导入java.util、cn.edu.hit.entity和cn.edu.hit.dao包 -->
<%@ include file="check.jsp"%> <!-- 包含名为check.jsp的文件 -->
<!DOCTYPE html> <!-- 定义文档类型为HTML5 -->
<html>
<head>
    <meta charset="UTF-8"> <!-- 设置页面字符编码为UTF-8 -->
    <title>留言</title> <!-- 设置页面标题为"留言" -->
    <style type="text/css"> <!-- 定义CSS样式 -->
    <!--
    .STYLE1 { backgroundcolor:#CC99FF} <!-- 定义STYLE1样式，背景颜色为#CC99FF -->
    .STYLE3 {font-size: x-large; } <!-- 定义STYLE3样式，字体大小为特大号 -->
    .STYLE4 {
        font-size: xx-large; <!-- 定义STYLE4样式，字体大小为超大号 -->
        font-family: "宋体"; <!-- 设置字体为宋体 -->
        color: #3300FF; <!-- 字体颜色为#3300FF -->
        font-weight: bold; <!-- 字体加粗 -->
    }
    .STYLE9 {color: #3366FF} <!-- 定义STYLE9样式，字体颜色为#3366FF -->
    .STYLE10 {font-size: large} <!-- 定义STYLE10样式，字体大小为大号 -->
    -->
    </style>
</head>

<body class="STYLE1"> <!-- 将body的样式设置为STYLE1 -->
<div align="center" class="STYLE1"> <!-- 定义一个居中的div，样式为STYLE1 -->
    <blockquote>
        <p><span class="STYLE4">紫 丁 香 论 坛</span></p> <!-- 定义一个段落，内容为"紫丁香论坛"，样式为STYLE4 -->
        <p align="center"><span class="STYLE9"><a href="modifyPwd.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a>我要留言</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="ExitServlet">退出</a></span></p> <!-- 定义一个居中的段落，包含三个链接：修改密码、我要留言、退出，样式为STYLE9 -->
    </blockquote>
</div>

<p>&nbsp;</p> <!-- 定义一个空段落，用于增加间距 -->
</body>
</html> <!-- 结束HTML文档 -->
