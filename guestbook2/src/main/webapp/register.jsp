<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">  <!-- 设置页面的字符编码为UTF-8 -->
    <title>注册</title>  <!-- 设置页面标题为“注册” -->
    <script type="text/javascript">
        // 定义selectFace函数，用于根据选择的头像显示对应的图片
        function selectFace(f)
        {
            f.showface.src="face/" + f.face.value + ".jpg";  // 设置showface图片的src属性为选择的头像路径
        }
    </script>
    <script type="text/javascript">
        // 定义verify函数，用于验证表单输入
        function verify()
        {
            var username = f.username.value;  // 获取用户名输入框的值

            if(username === "")
            {
                alert("用户名不能为空");  // 弹出提示框告知用户名不能为空
                f.username.focus();  // 聚焦到用户名输入框
                return false;  // 阻止表单提交
            }
            var pwd = f.pwd.value;  // 获取密码输入框的值
            if(pwd === "")
            {
                alert("密码不能为空");  // 弹出提示框告知密码不能为空
                f.pwd.focus();  // 聚焦到密码输入框
                return false;  // 阻止表单提交
            }
        }
    </script>
</head>
<body>
<form name="f" action="RegServlet" method="post" onsubmit="return verify()">
    <input type="hidden" name="from" value="register"/>  <!-- 隐藏字段，用于传递表单来源信息 -->
    <table border="1" align="center">  <!-- 创建一个居中的边框为1的表格 -->
        <tr>
            <td>用户名</td>  <!-- 表格行中的单元格，显示“用户名” -->
            <td><input type="text" name="username"/></td>  <!-- 输入框，用于输入用户名 -->
        </tr>
        <tr>
            <td>密码</td>  <!-- 表格行中的单元格，显示“密码” -->
            <td><input type="password" name="pwd"/></td>  <!-- 输入框，用于输入密码 -->
        </tr>
        <tr>
            <td>确认密码</td>  <!-- 表格行中的单元格，显示“确认密码” -->
            <td><input type="password" name="pwd2"/></td>  <!-- 输入框，用于输入确认密码 -->
        </tr>
        <tr>
            <td>性别</td>  <!-- 表格行中的单元格，显示“性别” -->
            <td>
                <!-- 单选按钮，用于选择性别，默认选择“男” -->
                <input type="radio" name="gender" value="m" checked="checked"/>男
                <input type="radio" name="gender" value="f"/>女
            </td>
        </tr>
        <tr>
            <td>头像</td>  <!-- 表格行中的单元格，显示“头像” -->
            <td>
                <select name="face" id="face" onChange="selectFace(this.form)">  <!-- 下拉选择框，用于选择头像 -->
                    <option value="1" select="selected">头像1</option>  <!-- 下拉选项，值为1，默认选择 -->
                    <option value="2">头像2</option>  <!-- 下拉选项，值为2 -->
                    <option value="3">头像3</option>  <!-- 下拉选项，值为3 -->
                    <option value="4">头像4</option>  <!-- 下拉选项，值为4 -->
                    <option value="5">头像5</option>  <!-- 下拉选项，值为5 -->
                    <option value="6">头像6</option>  <!-- 下拉选项，值为6 -->
                    <option value="7">头像7</option>  <!-- 下拉选项，值为7 -->
                    <option value="8">头像8</option>  <!-- 下拉选项，值为8 -->
                    <option value="9">头像9</option>  <!-- 下拉选项，值为9 -->
                    <option value="10">头像10</option>  <!-- 下拉选项，值为10 -->
                    <option value="11">头像11</option>  <!-- 下拉选项，值为11 -->
                    <option value="12">头像12</option>  <!-- 下拉选项，值为12 -->
                    <option value="13">头像13</option>  <!-- 下拉选项，值为13 -->
                    <option value="14">头像14</option>  <!-- 下拉选项，值为14 -->
                    <option value="15">头像15</option>  <!-- 下拉选项，值为15 -->
                    <option value="16">头像16</option>  <!-- 下拉选项，值为16 -->
                    <option value="17">头像17</option>  <!-- 下拉选项，值为17 -->
                    <option value="18">头像18</option>  <!-- 下拉选项，值为18 -->
                    <option value="19">头像19</option>  <!-- 下拉选项，值为19 -->
                    <option value="20">头像20</option>  <!-- 下拉选项，值为20 -->
                </select>
                <!-- 显示选择的头像图片，默认显示头像1 -->
                <img name="showface" src="face/1.jpg" width="40" height="40"/>
            </td>
        </tr>
        <tr>
            <td>&nbsp</td>  <!-- 空单元格，用于占位 -->
            <td><input type="submit" value="注册"/></td>  <!-- 提交按钮，显示“注册” -->
        </tr>
    </table>
    <p align="center">已有帐号？<a href="login.jsp">点击登录</a></p>  <!-- 中心对齐的段落，包含登录链接 -->
</form>
</body>
</html>
