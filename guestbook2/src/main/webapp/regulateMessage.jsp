<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,cn.edu.hit.entity.*,cn.edu.hit.dao.*"%>
<!-- 设置页面语言为Java，内容类型为text/html，字符集为UTF-8，并导入所需的Java包 -->
<%@ include file="admin-check.jsp"%> <!-- 包含用于管理员检查的 JSP 文件 -->
<!DOCTYPE html> <!-- 声明文档类型为 HTML5 -->
<html>
<head>
    <meta charset="UTF-8"> <!-- 设置页面字符集为UTF-8 -->
    <title>帖子管理</title> <!-- 设置页面标题为“帖子管理” -->
    <style type="text/css">
        <!--
        .STYLE1 { background-color: #FFFFFF; } <!-- 设置背景颜色 -->
        .STYLE3 { font-size: x-large; } <!-- 设置字体大小 -->
        .STYLE4 {
            font-size: xx-large;
            font-family: "宋体";
            color: #3300FF;
            font-weight: bold;
        }
        .STYLE9 { color: #3366FF; }
        .STYLE10 { font-size: large; }
        -->
    </style>
</head>
<%
    String str = "9"; // 设置默认的版块ID为9
    int Sid = 9; // 设置默认的版块ID为9
    if (request.getParameter("sid") != null) { // 如果请求参数包含版块ID
        str = request.getParameter("sid"); // 获取请求参数中的版块ID
        Sid = Integer.parseInt(str); // 将版块ID转换为整数
    }
%>
<body class="STYLE1"> <!-- 设置页面样式 -->
<p><a href="administrate.jsp">《返回</a></p> <!-- 返回链接，指向 administrate.jsp -->
<div align="center" class="STYLE1"></div> <!-- 居中对齐的空div -->
<div align="center" class="STYLE10">
    <%
        SectionDao dao1 = new SectionDao(); // 创建 SectionDao 对象
        List<Section> slist = dao1.getSection("select * from section"); // 查询所有版块
        String section;
        int sid;
        for (Section s : slist) { // 遍历版块列表
            sid = s.getSid(); // 获取版块ID
            section = s.getSection(); // 获取版块名称
    %>
    <a href="regulateMessage.jsp?sid=<%= sid %>"><%= section %></a>&nbsp;&nbsp;&nbsp; <!-- 显示版块链接 -->
    <%
        } // 结束 for 循环
    %>
</div>
<table width="451" border="1" align="center"> <!-- 创建一个宽度为451的表格，边框为1，居中显示 -->
    <%
        final int PAGE_SIZE = 5; // 每页显示的帖子数
        MessageDao dao = new MessageDao(); // 创建 MessageDao 对象
        str = request.getParameter("sid"); // 获取请求参数中的版块ID
        if (str == null) { // 如果版块ID为空
            out.println("<tr><td class=\"STYLE1\"><div align=\"center\">请选择一个版块！</div></td></tr>");
            return;
        }
        Sid = Integer.parseInt(str); // 将版块ID转换为整数
    %>
    <%
        if (Sid == 0) { // 如果版块ID为0，提示选择一个版块
            out.println("<tr><td class=\"STYLE1\"><div align=\"center\">请选择一个版块！</div></td></tr>");
        } else if (Sid != 0) { // 如果版块ID不为0
            int rowCount = dao.getCount2(Sid); // 获取该版块的总帖子数
            int pageCount = (rowCount + PAGE_SIZE - 1) / PAGE_SIZE; // 计算总页数
            String pageNum = request.getParameter("pageNum"); // 获取用户想看的页码
            if (pageNum == null) pageNum = "1";
            int p = Integer.parseInt(pageNum); // 将页码转换为整数
            String Section = dao1.gainSection(Sid); // 获取版块名称
            List<Message> mlist = dao.getMessage("select id, message.username, title, gender, content, face, time, good, section from message,people where message.username = people.username and section='" + Section + "' limit " + PAGE_SIZE + " offset " + ((p - 1) * PAGE_SIZE) + ""); // 查询符合条件的帖子列表
            int id = 0, good = 0;
            String username = null, gender = null, face = null, title = null, content = null, time = null;
            for (Message m : mlist) { // 遍历帖子列表
                id = m.getId(); // 获取帖子ID
                username = m.getUsername(); // 获取用户名
                gender = m.getGender(); // 获取性别
                face = m.getFace(); // 获取头像
                title = m.getTitle(); // 获取标题
                content = m.getContent(); // 获取内容
                time = m.getTime(); // 获取时间
    %>
    <tr>
        <td class="STYLE1"><div align="center"><img src="face/<%= face %>.jpg"/></div></td> <!-- 显示用户头像 -->
        <td class="STYLE1"><%= title %></td> <!-- 显示帖子标题 -->
    </tr>
    <tr>
        <td width="92" class="STYLE1"><div align="center"><%= username %></div></td> <!-- 显示用户名 -->
        <td width="343" rowspan="3" class="STYLE1"><%= content %></td> <!-- 显示帖子内容，跨三行 -->
    </tr>
    <tr>
        <td class="STYLE1"><div align="center">
            <%
                if (gender.equals("m")) out.print("男"); // 显示性别，男
                else out.print("女"); // 显示性别，女
            %></div></td>
    </tr>
    <tr>
        <td class="STYLE1"><div align="center"><%= time %></div></td> <!-- 显示帖子时间 -->
    </tr>
    <tr>
        <td colspan="2" class="STYLE1"><div align="center"><a href="MessageServlet?from=remove&id=<%= id %>&pageNum=<%= p %>&sid=<%= Sid %>" onClick="return confirm('确定删除吗？')">删除该帖</a></div></td> <!-- 删除帖子链接，并弹出确认框 -->
    </tr>
    <tr>
        <td colspan="2" class="STYLE1"><div align="center"><a href="regulateRemark.jsp?id=<%= id %>&pageNum=<%= p %>&sid=<%= Sid %>">管理回帖</a></div></td> <!-- 管理回帖链接 -->
    </tr>
    <%
        } // 结束 for 循环
    %>
</table>
<div align="center" class="STYLE1">
    <%
            if (p <= 1) out.println("首页"); // 显示首页链接
            else out.println("<a href=\"regulateMessage.jsp?sid=" + Sid + "\">首页</a>");

            if (p <= 1) out.println("上一页"); // 显示上一页链接
            else out.println("<a href=\"regulateMessage.jsp?sid=" + Sid + "&pageNum=" + (p - 1) + "\">上一页</a>");

            if (p >= pageCount) out.println("下一页"); // 显示下一页链接
            else out.println("<a href=\"regulateMessage.jsp?sid=" + Sid + "&pageNum=" + (p + 1) + "\">下一页</a>");

            if (p >= pageCount) out.println("尾页"); // 显示尾页链接
            else out.println("<a href=\"regulateMessage.jsp?sid=" + Sid + "&pageNum=" + pageCount + "\">尾页</a>");
        } // 结束 if 语句
    %>
</div>

<p>&nbsp;</p> <!-- 占位符 -->
</body>
</html>
