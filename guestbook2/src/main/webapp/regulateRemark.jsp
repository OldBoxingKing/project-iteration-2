<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,cn.edu.hit.entity.*,cn.edu.hit.dao.*"%>
<!-- 设置页面语言为Java，内容类型为text/html，字符集为UTF-8，并导入所需的Java包 -->
<%@ include file="admin-check.jsp"%> <!-- 包含用于管理员检查的 JSP 文件 -->
<!DOCTYPE html> <!-- 声明文档类型为 HTML5 -->
<html>
<head>
    <meta charset="UTF-8"> <!-- 设置页面字符集为UTF-8 -->
    <title>查看回帖</title> <!-- 设置页面标题为“查看回帖” -->
</head>
<body>
<%
    String str1 = request.getParameter("pageNum"); // 获取请求参数“pageNum”
    int pageNum = Integer.parseInt(str1); // 将“pageNum”转换为整数
    String str2 = request.getParameter("sid"); // 获取请求参数“sid”
    int sid = Integer.parseInt(str2); // 将“sid”转换为整数
%>
<p><a href="regulateMessage.jsp?pageNum=<%=pageNum%>&sid=<%=sid%>">《返回</a></p> <!-- 返回链接，指向 regulateMessage.jsp 并带有当前版块ID和页码参数 -->
<table width="508" border="1" align="center"> <!-- 创建一个宽度为508的表格，边框为1，居中显示 -->
    <%
        RemarkDao dao = new RemarkDao(); // 创建 RemarkDao 对象
        String str = request.getParameter("id"); // 获取请求参数“id”
        int id = Integer.parseInt(str); // 将“id”转换为整数
        List<Remark> rlist = dao.getRemark("select srcid, remark.id, remark.username, content, time from remark where remark.id = " + id + ""); // 查询符合条件的回帖列表
        int srcid;
        String username, content, time;
        for (Remark r : rlist) { // 遍历回帖列表
            srcid = r.getSrcid(); // 获取回帖ID
            username = r.getUsername(); // 获取用户名
            content = r.getContent(); // 获取回帖内容
            time = r.getTime(); // 获取回帖时间
    %>
    <tr>
        <td width="83"><%= username %></td> <!-- 显示用户名 -->
        <td width="409" rowspan="2"><%= content %></td> <!-- 显示回帖内容，跨两行 -->
    </tr>
    <tr>
        <td height="25"><%= time %></td> <!-- 显示回帖时间 -->
    </tr>
    <tr>
        <td height="25" colspan="2"><div align="center">
            <a href="RemarkServlet?from=remove&srcid=<%= srcid %>&id=<%= id %>&pageNum=<%= pageNum %>&sid=<%= sid %>" onClick="return confirm('确定删除吗？')">删除该回帖</a></div></td> <!-- 删除回帖链接，并弹出确认框 -->
    </tr>
    <%
        } // 结束 for 循环
    %>
</table>
<p align="center">&nbsp;</p> <!-- 占位符 -->
</body>
</html>
