<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <!-- 设置页面语言为Java，内容类型为text/html，字符集为UTF-8 -->
<!DOCTYPE html> <!-- 声明文档类型为 HTML5 -->
<html>
<head>
    <meta charset="UTF-8"> <!-- 设置页面字符集为UTF-8 -->
    <title>用户登录</title> <!-- 设置页面标题为“用户登录” -->
    <script type="text/javascript">
        function verify() {
            var username = f.username.value; // 获取用户名输入框的值
            if (username === "") { // 如果用户名为空
                alert("用户名不能为空"); // 提示错误信息
                f.username.focus(); // 将焦点设置到用户名输入框
                return false; // 阻止表单提交
            }
            var pwd = f.pwd.value; // 获取密码输入框的值
            if (pwd === "") { // 如果密码为空
                alert("密码不能为空"); // 提示错误信息
                f.pwd.focus(); // 将焦点设置到密码输入框
                return false; // 阻止表单提交
            }
        }
    </script>
    <style type="text/css">
        <!--
        .STYLE1 {
            font-family: "新宋体"; // 设置字体
        font-size: medium; // 设置字体大小
        }
        -->
    </style>
</head>
<body>
<form name="f" action="LoginServlet" method="post" onSubmit="return verify()"> <!-- 表单，提交到 LoginServlet，提交前进行验证 -->
    <input type="hidden" name="from" value="login"/> <!-- 隐藏字段，表示来自登录页面 -->
    <table height="138" border="1" align="center"> <!-- 创建一个有边框的表格，居中显示 -->
        <tr>
            <td width="48">用户名</td>
            <td width="235"><input type="text" name="username"/></td> <!-- 用户名输入框 -->
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="pwd"/></td> <!-- 密码输入框 -->
        </tr>
        <tr>
            <td>&nbsp;</td> <!-- 空单元格 -->
            <td><input type="submit" value="登录"/></td> <!-- 提交按钮 -->
        </tr>
    </table>
    <p align="center"><span class="STYLE1">新用户？<a href="register.jsp">点击注册</a></span></p> <!-- 链接到注册页面 -->
    <p align="center"><a href="admin-login.jsp">管理员登录</a></p> <!-- 链接到管理员登录页面 -->
</form>
</body>
</html>
