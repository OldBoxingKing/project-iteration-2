<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <!-- 设置JSP页面的语言为Java，内容类型为HTML，字符集为UTF-8 -->
<%@ include file="check.jsp"%> <!-- 包含名为check.jsp的文件 -->
<!DOCTYPE html> <!-- 定义文档类型为HTML5 -->
<html>
<head>
    <meta charset="UTF-8"> <!-- 设置页面字符编码为UTF-8 -->
    <title>修改密码</title> <!-- 设置页面标题为"修改密码" -->
    <script type="text/javascript"> <!-- 定义JavaScript脚本 -->
    function verify()
    {
        var pwd1 = f.pwd1.value; <!-- 获取新密码的值 -->
        var pwd = f.pwd.value; <!-- 获取确认密码的值 -->
        if(pwd1 === "")
        {
            alert("密码不能为空"); <!-- 如果新密码为空，弹出提示 -->
            f.pwd1.focus(); <!-- 将焦点设置到新密码输入框 -->
            return false; <!-- 返回false，阻止表单提交 -->
        }
    }
    </script>
</head>
<body>
<form name="f" method="post" action="RegServlet" onSubmit="return verify()"> <!-- 定义表单，名称为f，提交到RegServlet，使用post方法，提交时调用verify函数 -->
    <input type="hidden" name="from" value="modify1"/> <!-- 隐藏输入框，名称为from，值为modify1 -->
    <a href="index.jsp">《返回</a> <!-- 定义一个链接，指向index.jsp，文本为"《返回" -->
    <table width="264" border="1" align="center"> <!-- 定义一个宽度为264，带边框，居中的表格 -->
        <tr>
            <td width="72">新密码</td> <!-- 定义一个单元格，内容为"新密码"，宽度为72 -->
            <td width="184"><label>
                <input type="text" name="pwd1"> <!-- 定义一个文本输入框，名称为pwd1 -->
            </label></td>
        </tr>
        <tr>
            <td>确认密码</td> <!-- 定义一个单元格，内容为"确认密码" -->
            <td><label>
                <input type="text" name="pwd2"> <!-- 定义一个文本输入框，名称为pwd2 -->
            </label></td>
        </tr>
        <tr>
            <td>&nbsp;</td> <!-- 定义一个空单元格 -->
            <td><label>
                <input type="submit" name="Submit" value="修改"> <!-- 定义一个提交按钮，文本为"修改" -->
            </label></td>
        </tr>
    </table>
</form>
</body>
</html>
