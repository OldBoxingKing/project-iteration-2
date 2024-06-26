package cn.edu.hit.controller; // 定义包名

import cn.edu.hit.dao.RemarkDao; // 导入RemarkDao类
import cn.edu.hit.entity.Remark; // 导入Remark实体类
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
 * Servlet实现类RemarkServlet，用于处理评论相关的请求
 */
@WebServlet("/RemarkServlet") // 指定Servlet的URL映射
public class RemarkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // 序列化ID，用于版本控制

    /**
     * 构造方法
     * @see HttpServlet#HttpServlet()
     */
    public RemarkServlet() {
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
        if (from.equals("add")) { // 判断请求是否为添加评论
            String str = request.getParameter("id"); // 获取请求参数"id"
            int id = Integer.parseInt(str); // 将"id"转换为整数
            String str1 = request.getParameter("sid"); // 获取请求参数"sid"
            int sid = Integer.parseInt(str1); // 将"sid"转换为整数
            String str2 = request.getParameter("page"); // 获取请求参数"page"
            int pageNum = Integer.parseInt(str2); // 将"page"转换为整数
            String content = request.getParameter("content"); // 获取请求参数"content"
            if (content == null || content.trim().equals("")) { // 判断评论内容是否为空
                out.println("后端验证：回帖内容不能为空!返回<a href=\"addremark.jsp?id=" + id + "&pageNum=" + pageNum + "&sid=" + sid + "\">发布回帖</a>"); // 输出错误信息并提供返回链接
                return; // 结束方法
            }
            LocalDate time = LocalDate.now(); // 获取当前日期
            HttpSession session = request.getSession(); // 获取当前用户的会话对象
            String username = (String) session.getAttribute("username"); // 获取会话中的用户名
            RemarkDao dao = new RemarkDao(); // 创建RemarkDao对象
            dao.add(new Remark(id, username, content, time.toString())); // 添加新评论
            response.sendRedirect("remark.jsp?id=" + id + "&pageNum=" + pageNum + "&sid=" + sid + ""); // 重定向到评论页面
        } else { // 如果不是添加评论，则是删除评论
            String str = request.getParameter("srcid"); // 获取请求参数"srcid"
            int srcid = Integer.valueOf(str).intValue(); // 将"srcid"转换为整数
            String str2 = request.getParameter("id"); // 获取请求参数"id"
            int id = Integer.valueOf(str2).intValue(); // 将"id"转换为整数
            String str3 = request.getParameter("pageNum"); // 获取请求参数"pageNum"
            int pageNum = Integer.valueOf(str3).intValue(); // 将"pageNum"转换为整数
            String str4 = request.getParameter("sid"); // 获取请求参数"sid"
            int sid = Integer.valueOf(str4).intValue(); // 将"sid"转换为整数
            RemarkDao dao = new RemarkDao(); // 创建RemarkDao对象
            dao.remove(srcid); // 删除评论
            response.sendRedirect("regulateRemark.jsp?id=" + id + "&pageNum=" + pageNum + "&sid=" + sid + ""); // 重定向到评论管理页面
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
