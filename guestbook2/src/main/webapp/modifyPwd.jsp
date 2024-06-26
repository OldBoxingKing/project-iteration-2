<%--
  Created by IntelliJ IDEA. // 由 IntelliJ IDEA 创建
  User: DeepMind2 // 用户名
  Date: 2023/5/3 // 创建日期
  Time: 14:35 // 创建时间
  To change this template use File | Settings | File Templates. // 更改此模板请使用 文件 | 设置 | 文件模板。
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <!-- 设置页面语言为Java，内容类型为text/html，字符集为UTF-8 -->
<%@ include file="check.jsp"%> <!-- 包含用于用户登录状态检查的 JSP 文件 -->
<!DOCTYPE html> <!-- 声明文档类型为 HTML5 -->
<html>
<head>
    <meta charset="UTF-8"> <!-- 设置页面字符集为UTF-8 -->
    <title>修改密码</title> <!-- 设置页面标题为“修改密码” -->
    <script type="text/javascript">
        function verify() {
            var pwd1 = f.pwd1.value; // 获取新密码的值
            var pwd = f.pwd.value; // 获取确认密码的值
            if (pwd1 === "") { // 如果新密码为空
                alert("密码不能为空"); // 提示错误信息
                f.pwd1.focus(); // 将焦点设置到新密码输入框
                return false; // 阻止表单提交
            }
        }
    </script>
</head>
<body>
<form name="f" method="post" action="RegServlet" onSubmit="return verify()"> <!-- 表单，提交到 RegServlet，提交前进行验证 -->
    <input type="hidden" name="from" value="modify1"/> <!-- 隐藏字段，表示来自修改密码页面 -->
    <a href="index.jsp">《返回</a> <!-- 返回链接，指向 index.jsp -->
    <table width="264" border="1" align="center"> <!-- 创建一个宽度为264的表格，边框为1，居中显示 -->
        <tr>
            <td width="72">新密码</td>
            <td width="184"><label>
                <input type="password" name="pwd1"> <!-- 新密码输入框 -->
            </label></td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td><label>
                <input type="password" name="pwd2"> <!-- 确认密码输入框 -->
            </label></td>
        </tr>
        <tr>
            <td>&nbsp;</td> <!-- 空单元格 -->
            <td><label>
                <input type="submit" name="Submit" value="修改"> <!-- 提交按钮 -->
            </label></td>
        </tr>
    </table>
</form>
</body>
</html>
