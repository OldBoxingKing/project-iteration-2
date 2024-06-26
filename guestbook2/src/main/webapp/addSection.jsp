<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,cn.edu.hit.entity.*,cn.edu.hit.dao.*"%> <!-- 设置页面语言为Java，内容类型为text/html，字符集为UTF-8，并导入所需的Java包 -->
<%@ include file="admin-check.jsp"%> <!-- 包含用于管理员检查的 JSP 文件 -->
<!DOCTYPE html> <!-- 声明文档类型为 HTML5 -->
<html>
<head>
    <meta charset="UTF-8"> <!-- 设置页面字符集为UTF-8 -->
    <title>增加版块</title> <!-- 设置页面标题为“增加版块” -->
    <script type="text/javascript">
        function verify() {
            var section = f.section.value; // 获取版块名称输入框的值
            if (section === "") { // 如果版块名称为空
                alert("板块名不能为空"); // 提示错误信息
                f.section.focus(); // 将焦点设置到版块名称输入框
                return false; // 阻止表单提交
            }
        }
    </script>
</head>
<body>
<form name="f" method="post" action="SectionServlet" onSubmit="return verify()"> <!-- 表单，提交到 SectionServlet，提交前进行验证 -->
    <input type="hidden" name="from" value="add"/> <!-- 隐藏字段，表示来自增加版块页面 -->
    <a href="regulateSection.jsp">《返回</a> <!-- 返回链接，指向 regulateSection.jsp -->
    <table width="269" border="1" align="center"> <!-- 创建一个宽度为269的表格，边框为1，居中显示 -->
        <tr>
            <td width="75">版块名称</td>
            <td width="178"><label>
                <input name="section" type="text" id="section"> <!-- 版块名称输入框 -->
            </label></td>
        </tr>
        <tr>
            <td colspan="2"><label>
                <div align="center">
                    <input type="submit" name="Submit" value="增加"> <!-- 提交按钮 -->
                </div>
            </label></td>
        </tr>
    </table>
</form>
</body>
</html>
