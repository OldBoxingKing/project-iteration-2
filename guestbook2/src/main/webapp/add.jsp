<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <!-- 设置页面语言为Java，内容类型为text/html，字符集为UTF-8 -->
<%@ include file="check.jsp"%> <!-- 包含用于用户登录状态检查的 JSP 文件 -->
<!DOCTYPE html> <!-- 声明文档类型为 HTML5 -->
<html>
<head>
  <meta charset="UTF-8"> <!-- 设置页面字符集为UTF-8 -->
  <title>留言</title> <!-- 设置页面标题为“留言” -->
  <script type="text/javascript">
    function verify() {
      var title = f.title.value; // 获取主题输入框的值
      if (title === "") { // 如果主题为空
        alert("留言主题不能为空"); // 提示错误信息
        f.title.focus(); // 将焦点设置到主题输入框
        return false; // 阻止表单提交
      }
      var content = f.content.value; // 获取内容输入框的值
      if (content === "") { // 如果内容为空
        alert("留言内容不能为空"); // 提示错误信息
        f.content.focus(); // 将焦点设置到内容输入框
        return false; // 阻止表单提交
      }
    }
  </script>
</head>
<body>
<%
  // 获取请求参数中的版块ID，并将其转换为整数
  String str = request.getParameter("sid");
  int sid = Integer.parseInt(str);
%>
<form name="f" action="MessageServlet" method="post" onsubmit="return verify()"> <!-- 表单，提交到 MessageServlet，提交前进行验证 -->
  <input type="hidden" name="from" value="add"/> <!-- 隐藏字段，表示来自添加留言页面 -->
  <input type="hidden" name="sid" value="<%=sid%>"/> <!-- 隐藏字段，版块ID -->
  <table border="1" align="center"> <!-- 创建一个有边框的表格，居中显示 -->
    <tr>
      <td>主题</td>
      <td><input type="text" name="title"/></td> <!-- 主题输入框 -->
    </tr>
    <tr>
      <td>内容</td>
      <td><textarea name="content" rows="10" cols="100"></textarea></td> <!-- 内容输入框 -->
    </tr>
    <tr>
      <td>&nbsp;</td> <!-- 空单元格 -->
      <td><input type="submit" value="留言"/></td> <!-- 提交按钮 -->
    </tr>
  </table>
</form>
</body>
</html>
