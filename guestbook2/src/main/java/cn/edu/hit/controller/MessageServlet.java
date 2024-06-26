package cn.edu.hit.controller; // 定义包名

import cn.edu.hit.dao.MessageDao; // 导入MessageDao类
import cn.edu.hit.dao.RemarkDao; // 导入RemarkDao类
import cn.edu.hit.dao.SectionDao; // 导入SectionDao类
import cn.edu.hit.entity.Message; // 导入Message实体类
import jakarta.servlet.ServletException; // 导入ServletException类
import jakarta.servlet.annotation.WebServlet; // 导入WebServlet注解
import jakarta.servlet.http.HttpServlet; // 导入HttpServlet类
import jakarta.servlet.http.HttpServletRequest; // 导入HttpServletRequest类
import jakarta.servlet.http.HttpServletResponse; // 导入HttpServletResponse类
import jakarta.servlet.http.HttpSession; // 导入HttpSession类

import java.io.IOException; // 导入IOException类
import java.io.PrintWriter; // 导入PrintWriter类
import java.time.LocalDate; // 导入LocalDate类

/**
 * Servlet实现类MessageServlet，用于处理留言相关的请求
 */
@WebServlet("/MessageServlet") // 指定Servlet的URL映射
public class MessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // 序列化ID，用于版本控制

    /**
     * 构造方法
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super(); // 调用父类的构造方法
        // TODO Auto-generated constructor stub
    }

    /**
     * 处理GET请求的方法
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // 设置请求的字符编码为UTF-8
        response.setContentType("text/html; charset=UTF-8"); // 设置响应的内容类型和字符编码
        PrintWriter out = response.getWriter(); // 获取PrintWriter对象，用于向客户端输出响应内容
        String from = request.getParameter("from"); // 获取请求参数"from"
        if(from.equals("add")) // 判断请求是否为添加留言
        {
            String str = request.getParameter("sid"); // 获取请求参数"sid"
            int sid = Integer.parseInt(str); // 将"sid"转换为整数
            SectionDao dao1 = new SectionDao(); // 创建SectionDao对象
            String section = dao1.gainSection(sid); // 获取版块名称
            String title = request.getParameter("title"); // 获取请求参数"title"
            if(title == null || title.trim().equals("")) // 判断留言主题是否为空
            {
                out.println("后端验证：留言主题不能为空!返回<a href=\"add.jsp\">发布留言</a>"); // 输出错误信息并提供返回链接
                return; // 结束方法
            }
            String content = request.getParameter("content"); // 获取请求参数"content"
            if(content == null || content.trim().equals("")) // 判断留言内容是否为空
            {
                out.println("后端验证：留言内容不能为空!返回<a href=\"add.jsp\">发布留言</a>"); // 输出错误信息并提供返回链接
                return; // 结束方法
            }
            LocalDate time = LocalDate.now(); // 获取当前日期
            HttpSession session = request.getSession(); // 获取当前用户的会话对象
            String username = (String)session.getAttribute("username"); // 获取会话中的用户名
            MessageDao dao = new MessageDao(); // 创建MessageDao对象
            dao.add(new Message(username, title, content, time.toString(), section)); // 添加新留言
            response.sendRedirect("index.jsp?sid=" + sid + ""); // 重定向到主页
        }
        else if(from.equals("like")) // 判断请求是否为点赞操作
        {
            String str = request.getParameter("id"); // 获取请求参数"id"
            int id = Integer.parseInt(str); // 将"id"转换为整数
            String str2 = request.getParameter("pageNum"); // 获取请求参数"pageNum"
            int page = Integer.parseInt(str2); // 将"pageNum"转换为整数
            String str3 = request.getParameter("sid"); // 获取请求参数"sid"
            int sid = Integer.parseInt(str3); // 将"sid"转换为整数
            MessageDao dao = new MessageDao(); // 创建MessageDao对象
            Message m = dao.getById(id); // 根据ID获取留言
            dao.addGood(m); // 为留言添加点赞
            response.sendRedirect("index.jsp?sid=" + sid + "&pageNum=" + page + ""); // 重定向到主页并保留当前页面和版块
            return; // 结束方法
        }
        else if(from.equals("remove")) // 判断请求是否为删除操作
        {
            String str = request.getParameter("id"); // 获取请求参数"id"
            int id = Integer.valueOf(str).intValue(); // 将"id"转换为整数
            String str2 = request.getParameter("pageNum"); // 获取请求参数"pageNum"
            int pageNum = Integer.valueOf(str2).intValue(); // 将"pageNum"转换为整数
            String str3 = request.getParameter("sid"); // 获取请求参数"sid"
            int sid = Integer.parseInt(str3); // 将"sid"转换为整数
            MessageDao dao = new MessageDao(); // 创建MessageDao对象
            RemarkDao dao2 = new RemarkDao(); // 创建RemarkDao对象
            dao2.remove2(id); // 删除留言的所有评论
            dao.remove(id); // 删除留言
            response.sendRedirect("regulateMessage.jsp?pageNum=" + pageNum + "&sid=" + sid + ""); // 重定向到留言管理页面
        }
    }

    /**
     * 处理POST请求的方法
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response); // 调用doGet方法处理POST请求
    }
}
