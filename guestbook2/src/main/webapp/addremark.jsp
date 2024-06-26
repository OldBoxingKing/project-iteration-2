<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,cn.edu.hit.entity.*,cn.edu.hit.dao.*"%> <!-- 设置页面语言为Java，内容类型为text/html，字符集为UTF-8，并导入所需的Java包 -->
<%@ include file="check.jsp"%> <!-- 包含用于用户登录状态检查的 JSP 文件 -->
<!DOCTYPE html> <!-- 声明文档类型为 HTML5 -->
<html>
<head>
    <meta charset="UTF-8"> <!-- 设置页面字符集为UTF-8 -->
    <title>我要回帖</title> <!-- 设置页面标题为“我要回帖” -->
    <script type="text/javascript">
        function verify() {
            var content = f.content.value; // 获取留言内容输入框的值
            if (content === "") { // 如果留言内容为空
                alert("留言内容不能为空"); // 提示错误信息
                f.content.focus(); // 将焦点设置到留言内容输入框
                return false; // 阻止表单提交
            }
        }
    </script>
    <%
        // 获取请求参数中的留言ID、页码和版块ID，并将其转换为整数
        RemarkDao dao = new RemarkDao();
        String str = request.getParameter("id");
        int id = Integer.parseInt(str);
        String str1 = request.getParameter("pageNum");
        int pageNum = Integer.parseInt(str1);
        String str2 = request.getParameter("sid");
        int sid = Integer.parseInt(str2);
    %>
</head>
<body>
<form name="f" action="RemarkServlet" method="post" onSubmit="return verify()"> <!-- 表单，提交到 RemarkServlet，提交前进行验证 -->
    <input name="id" type="hidden" value="<%=id%>"> <!-- 隐藏字段，留言ID -->
    <input name="sid" type="hidden" value="<%=sid%>"> <!-- 隐藏字段，版块ID -->
    <input name="page" type="hidden" value="<%=pageNum%>"> <!-- 隐藏字段，页码 -->
    <input name="from" type="hidden" value="add"> <!-- 隐藏字段，表示来自添加回帖页面 -->
    <table width="270" border="1" align="center"> <!-- 创建一个宽度为270的表格，边框为1，居中显示 -->
        <tr>
            <td width="69" height="141">输入内容:</td>
            <td width="185"><textarea name="content" rows="10" cols="100"></textarea></td> <!-- 留言内容输入框 -->
        </tr>
        <tr>
            <td>&nbsp;</td> <!-- 空单元格 -->
            <td><label>
                <input type="submit" name="Submit" value="发布回帖"> <!-- 提交按钮 -->
            </label></td>
        </tr>
    </table>
</form>
</body>
</html>
