<%--
  Created by IntelliJ IDEA. // 由 IntelliJ IDEA 创建
  User: DeepMind2 // 用户名
  Date: 2023/5/3 // 创建日期
  Time: 14:34 // 创建时间
  To change this template use File | Settings | File Templates. // 更改此模板请使用 文件 | 设置 | 文件模板。
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,cn.edu.hit.entity.*,cn.edu.hit.dao.*"%> <!-- 设置页面语言为Java，内容类型为text/html，字符集为UTF-8，并导入所需的Java包 -->
<%@ include file="check.jsp"%> <!-- 包含用于用户登录状态检查的 JSP 文件 -->
<!DOCTYPE html> <!-- 声明文档类型为 HTML5 -->
<html>
<head>
    <meta charset="UTF-8"> <!-- 设置页面字符集为UTF-8 -->
    <title>留言</title> <!-- 设置页面标题为“留言” -->
    <style type="text/css">
        <!--
        .STYLE1 { background-color:#FFFFFF } <!-- 背景颜色 -->
        .STYLE3 { font-size: x-large; } <!-- 字体大小 -->
        .STYLE4 { font-size: xx-large; font-family: "宋体"; color: #3300FF; font-weight: bold; } <!-- 字体大小，字体，颜色，加粗 -->
        .STYLE9 { color: #3366FF; } <!-- 字体颜色 -->
        .STYLE10 { font-size: large; } <!-- 字体大小 -->
        -->
    </style>
</head>
<%
    String str = "9"; // 设置默认版块ID
    int Sid = 9; // 设置默认版块ID
    if (request.getParameter("sid") != null) { // 如果请求参数包含版块ID
        str = request.getParameter("sid"); // 获取请求参数中的版块ID
        Sid = Integer.parseInt(str); // 将版块ID转换为整数
    }
%>
<body class="STYLE1">
<div align="center" class="STYLE1">
    <blockquote>
        <p><span class="STYLE4">紫 丁 香 论 坛</span></p> <!-- 网站标题 -->
        <p align="center"><span class="STYLE9">
            <a href="modifyPwd.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="add.jsp?sid=<%=Sid%>" class="STYLE3">我要留言</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="ExitServlet">退出</a></span></p> <!-- 修改密码和退出链接 -->
    </blockquote>
</div>
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
    <a href="index.jsp?sid=<%=sid%>"><%=section%></a>&nbsp;&nbsp;&nbsp; <!-- 显示版块链接 -->
    <%
        } // 结束 for 循环
    %>
</div>
<table width="451" border="1" align="center"> <!-- 创建一个宽度为451的表格，边框为1，居中显示 -->
    <%
        final int PAGE_SIZE = 5; // 每页显示的留言数
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
            int rowCount = dao.getCount2(Sid); // 获取该版块的总留言数
            int pageCount = (rowCount + PAGE_SIZE - 1) / PAGE_SIZE; // 计算总页数
            String pageNum = request.getParameter("pageNum"); // 获取用户想看的页码
            if (pageNum == null) pageNum = "1";
            int p = Integer.parseInt(pageNum); // 将页码转换为整数
            String Section = dao1.gainSection(Sid); // 获取版块名称
            List<Message> mlist = dao.getMessage("select id, message.username, title, gender, content, face, time, good, section from message,people where message.username = people.username and section='" + Section + "' limit " + PAGE_SIZE + " offset " + ((p - 1) * PAGE_SIZE) + ""); // 查询符合条件的留言列表
            int id = 0, good = 0;
            String username = null, gender = null, face = null, title = null, content = null, time = null;
            for (Message m : mlist) { // 遍历留言列表
                id = m.getId(); // 获取留言ID
                username = m.getUsername(); // 获取用户名
                gender = m.getGender(); // 获取性别
                face = m.getFace(); // 获取头像
                title = m.getTitle(); // 获取标题
                content = m.getContent(); // 获取内容
                time = m.getTime(); // 获取时间
                good = m.getGood(); // 获取点赞数
    %>
    <tr>
        <td class="STYLE1"><div align="center"><img src="face/<%=face%>.jpg"/></div></td> <!-- 显示用户头像 -->
        <td class="STYLE1"><%=title%></td> <!-- 显示留言标题 -->
    </tr>
    <tr>
        <td width="92" class="STYLE1"><div align="center"><%=username%></div></td> <!-- 显示用户名 -->
        <td width="343" rowspan="3" class="STYLE1"><%=content%></td> <!-- 显示留言内容，跨三行 -->
    </tr>
    <tr>
        <td class="STYLE1"><div align="center">
            <%
                if (gender.equals("m")) out.print("男"); // 显示性别，男
                else out.print("女"); // 显示性别，女
            %></div></td>
    </tr>
    <tr>
        <td class="STYLE1"><div align="center"><%=time%></div></td> <!-- 显示留言时间 -->
    </tr>
    <tr>
        <td colspan="2" class="STYLE1"><div align="right">
            <label>
                <div align="left"><a href="MessageServlet?from=like&id=<%=id%>&pageNum=<%=p%>&sid=<%=Sid%>">
                    <input type="image" name="imageField" src="face/like.jpg"> <!-- 点赞按钮 -->
                </a>：<%=good%></div> <!-- 显示点赞数 -->
            </label>
        </div></td>
    </tr>
    <tr>
        <td colspan="2" class="STYLE1"><div align="center"><a href="remark.jsp?id=<%=id%>&pageNum=<%=p%>&sid=<%=Sid%>">查看回帖</a></div></td> <!-- 查看回帖链接 -->
    </tr>
    <%
        } // 结束 for 循环
    %>
</table>
<div align="center" class="STYLE1">
    <%
            if (p <= 1) out.println("首页"); // 显示首页链接
            else out.println("<a href=\"index.jsp?sid=" + Sid + "\">首页</a>");

            if (p <= 1) out.println("上一页"); // 显示上一页链接
            else out.println("<a href=\"index.jsp?sid=" + Sid + "&pageNum=" + (p - 1) + "\">上一页</a>");

            if (p >= pageCount) out.println("下一页"); // 显示下一页链接
            else out.println("<a href=\"index.jsp?sid=" + Sid + "&pageNum=" + (p + 1) + "\">下一页</a>");

            if (p >= pageCount) out.println("尾页"); // 显示尾页链接
            else out.println("<a href=\"index.jsp?sid=" + Sid + "&pageNum=" + pageCount + "\">尾页</a>");
        } // 结束 if 语句
    %>
</div>

<p>&nbsp;</p> <!-- 占位符 -->
</body>
</html>
