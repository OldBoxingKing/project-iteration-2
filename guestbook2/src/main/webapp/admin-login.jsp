
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <!-- 设置JSP页面的语言为Java，内容类型为HTML，字符集为UTF-8 -->
<!DOCTYPE html> <!-- 定义文档类型为HTML5 -->
<html>
<head>
    <meta charset="UTF-8"> <!-- 设置页面字符编码为UTF-8 -->
    <title>管理员登录</title> <!-- 设置页面标题为"管理员登录" -->
    <script type="text/javascript"> <!-- 定义JavaScript脚本 -->
    function verify()
    {
        var username = f.username.value

        if(username === "")
        {
            alert("管理员名不能为空") <!-- 如果用户名为空，弹出提示 -->
            f.username.focus() <!-- 将焦点设置到用户名输入框 -->
            return false <!-- 返回false，阻止表单提交 -->
        }
        var pwd = f.pwd.value
        if(pwd === "")
        {
            alert("密码不能为空") <!-- 如果密码为空，弹出提示 -->
            f.pwd.focus() <!-- 将焦点设置到密码输入框 -->
            return false <!-- 返回false，阻止表单提交 -->
        }
    }
    </script>
    <style type="text/css"> <!-- 定义CSS样式 -->
    <!--
    .STYLE1 {
        font-family: "新宋体"; <!-- 定义STYLE1样式，字体为新宋体 -->
        font-size: medium; <!-- 字体大小为中等 -->
    }
    -->
    </style>
</head>
<body>
<form name="f" action="LoginServlet" method="post" onSubmit="return verify()"> <!-- 定义表单，名称为f，提交到LoginServlet，使用post方法，提交时调用verify函数 -->
    <input type="hidden" name="from" value="admin"/> <!-- 隐藏输入框，名称为from，值为admin -->
    <table height="138" border="1" align="center"> <!-- 定义一个高度为138，带边框，居中的表格 -->
        <tr>
            <td width="48">用户名</td> <!-- 定义一个单元格，内容为"用户名"，宽度为48 -->
            <td width="235"><input type="text" name="username"/></td> <!-- 定义一个单元格，包含一个文本输入框，名称为username，宽度为235 -->
        </tr>
        <tr>
            <td>密码</td> <!-- 定义一个单元格，内容为"密码" -->
            <td><input type="password" name="pwd"/></td> <!-- 定义一个单元格，包含一个密码输入框，名称为pwd -->
        </tr>
        <tr>
            <td>&nbsp</td> <!-- 定义一个空单元格 -->
            <td><input type="submit" value="登录"/></td> <!-- 定义一个单元格，包含一个提交按钮，文本为"登录" -->
        </tr>
    </table>
    <p align="center"><a href="login.jsp">普通用户登录</a></p> <!-- 定义一个居中的段落，包含一个链接，指向login.jsp，文本为"普通用户登录" -->
</form>
</body>
</html> <!-- 结束HTML文档 -->
