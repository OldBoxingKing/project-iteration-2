<%--
  Created by IntelliJ IDEA. // 由 IntelliJ IDEA 创建
  User: DeepMind2 // 用户名
  Date: 2023/5/3 // 创建日期
  Time: 14:36 // 创建时间
  To change this template use File | Settings | File Templates. // 更改此模板请使用 文件 | 设置 | 文件模板。
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <!-- 设置页面语言为Java，内容类型为text/html，字符集为UTF-8 -->
<!DOCTYPE html> <!-- 声明文档类型为 HTML5 -->
<html>
<head>
    <meta charset="UTF-8"> <!-- 设置页面字符集为UTF-8 -->
    <title>注册</title> <!-- 设置页面标题为“注册” -->
    <script type="text/javascript">
        function selectFace(f) {
            f.showface.src = "face/" + f.face.value + ".jpg"; // 根据选中的头像更新显示的图片
        }
    </script>
    <script type="text/javascript">
        function verify() {
            var username = f.username.value;
            if (username === "") {
                alert("用户名不能为空"); // 如果用户名为空，提示错误信息
                f.username.focus(); // 将焦点设置到用户名输入框
                return false;
            }
            var pwd = f.pwd.value;
            if (pwd === "") {
                alert("密码不能为空"); // 如果密码为空，提示错误信息
                f.pwd.focus(); // 将焦点设置到密码输入框
                return false;
            }
        }
    </script>
</head>
<body>
<form name="f" action="RegServlet" method="post" onsubmit="return verify()"> <!-- 表单，提交到 RegServlet，提交前进行验证 -->
    <input type="hidden" name="from" value="register"/> <!-- 隐藏字段，表示来自注册页面 -->
    <table border="1" align="center"> <!-- 创建一个有边框的表格，居中显示 -->
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"/></td> <!-- 用户名输入框 -->
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="pwd"/></td> <!-- 密码输入框 -->
        </tr>
        <tr>
            <td>确认密码</td>
            <td><input type="password" name="pwd2"/></td> <!-- 确认密码输入框 -->
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="gender" value="m" checked="checked"/>男<input type="radio" name="gender" value="f"/>女</td> <!-- 性别选择框，默认选中男 -->
        </tr>
        <tr>
            <td>头像</td>
            <td>
                <select name="face" id="face" onChange="selectFace(this.form)"> <!-- 头像选择框，改变时调用 selectFace 函数 -->
                    <option value="1" selected="selected">头像1</option> <!-- 默认选中头像1 -->
                    <option value="2">头像2</option>
                    <option value="3">头像3</option>
                    <option value="4">头像4</option>
                    <option value="5">头像5</option>
                    <option value="6">头像6</option>
                    <option value="7">头像7</option>
                    <option value="8">头像8</option>
                    <option value="9">头像9</option>
                    <option value="10">头像10</option>
                    <option value="11">头像11</option>
                    <option value="12">头像12</option>
                    <option value="13">头像13</option>
                    <option value="14">头像14</option>
                    <option value="15">头像15</option>
                    <option value="16">头像16</option>
                    <option value="17">头像17</option>
                    <option value="18">头像18</option>
                    <option value="19">头像19</option>
                    <option value="20">头像20</option>
                </select>
                <img name="showface" src="face/1.jpg" width="40" height="40"/> <!-- 显示选中的头像图片 -->
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="注册"/></td> <!-- 提交按钮 -->
        </tr>
    </table>
    <p align="center">已有帐号？<a href="login.jsp">点击登录</a></p> <!-- 链接到登录页面 -->
</form>
</body>
</html>
