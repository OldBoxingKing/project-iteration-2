<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,cn.edu.hit.entity.*,cn.edu.hit.dao.*"%>
<!-- 设置页面语言为Java，内容类型为text/html，字符集为UTF-8，并导入所需的Java包 -->
<%@ include file="admin-check.jsp"%> <!-- 包含用于管理员检查的 JSP 文件 -->
<!DOCTYPE html> <!-- 声明文档类型为 HTML5 -->
<html>
<head>
  <meta charset="UTF-8"> <!-- 设置页面字符集为UTF-8 -->
  <title>版块管理</title> <!-- 设置页面标题为“版块管理” -->
</head>
<body>
<p><a href="administrate.jsp">《返回</a></p> <!-- 返回链接，指向 administrate.jsp -->
<table width="258" border="1" align="center"> <!-- 创建一个宽度为258的表格，边框为1，居中显示 -->
  <tr>
    <td><div align="center">版块名称</div></td> <!-- 表头，显示“版块名称” -->
    <td><div align="center">删除</div></td> <!-- 表头，显示“删除” -->
  </tr>
  <%
    SectionDao dao = new SectionDao(); // 创建 SectionDao 对象
    List<Section> sList = dao.getSection("select * from section"); // 查询所有版块
    String section;
    int sid;
    for (Section s : sList) { // 遍历版块列表
      section = s.getSection(); // 获取版块名称
      sid = s.getSid(); // 获取版块ID
  %>
  <tr>
    <td width="122"><div align="center"><%= section %></div></td> <!-- 显示版块名称，并居中对齐 -->
    <td width="120"><div align="center"><% if (!section.equals("学习")) out.print("<a href=\"SectionServlet?from=remove&sid=" + sid + "\" onClick=\"return confirm('确定删除吗？')\">删除</a>"); %></div></td> <!-- 如果版块名称不是“学习”，则显示删除链接，并弹出确认框 -->
  </tr>
  <%
    } // 结束 for 循环
  %>
</table>
<p align="center"><a href="addSection.jsp">增加版块</a></p> <!-- 链接到添加版块页面 -->
</body>
</html>
