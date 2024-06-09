package cn.edu.hit.controller;  // 包声明

import cn.edu.hit.dao.UserDao;  // 导入UserDao类
import jakarta.servlet.ServletException;  // 导入ServletException类
import jakarta.servlet.annotation.WebServlet;  // 导入WebServlet注解
import jakarta.servlet.http.HttpServlet;  // 导入HttpServlet类
import jakarta.servlet.http.HttpServletRequest;  // 导入HttpServletRequest类
import jakarta.servlet.http.HttpServletResponse;  // 导入HttpServletResponse类
import jakarta.servlet.http.HttpSession;  // 导入HttpSession类

import java.io.IOException;  // 导入IOException类
import java.io.PrintWriter;  // 导入PrintWriter类

/**
 * Servlet 实现类 LoginServlet
 */
@WebServlet("/LoginServlet")  // 声明Servlet映射到/LoginServlet路径
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;  // 序列化ID

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO 自动生成的构造函数存根
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");  // 设置请求字符编码
        response.setContentType("text/html; charset=UTF-8");  // 设置响应内容类型和字符编码
        PrintWriter out = response.getWriter();  // 获取PrintWriter对象用于输出响应
        String from = request.getParameter("from");  // 获取请求参数from

        if(from.equals("login")) {  // 普通用户登录
            String username = request.getParameter("username");  // 获取用户名
            if(username == null || username.trim().equals("")) {  // 检查用户名是否为空
                out.println("后端验证：用户名不能为空!返回<a href=\"add.jsp\">登录</a>");
                return;
            }
            String pwd = request.getParameter("pwd");  // 获取密码
            if(pwd == null || pwd.trim().equals("")) {  // 检查密码是否为空
                out.println("后端验证：密码不能为空!返回<a href=\"add.jsp\">登录</a>");
                return;
            }
            UserDao dao = new UserDao();  // 创建UserDao对象
            if(dao.checkUser(username, pwd)) {  // 验证用户名和密码
                HttpSession session = request.getSession();  // 获取会话对象
                session.setAttribute("username", username);  // 在会话中存储用户名
                response.sendRedirect("index.jsp");  // 重定向到主页
            } else {
                out.println("用户名或密码错误，<a href=\"login.jsp\">返回重新登录</a>");
            }
        } else {  // 管理员登录
            String admin = request.getParameter("username");  // 获取管理员用户名
            if(admin == null || admin.trim().equals("")) {  // 检查管理员用户名是否为空
                out.println("后端验证：用户名不能为空!返回<a href=\"add.jsp\">登录</a>");
                return;
            }
            String pwd = request.getParameter("pwd");  // 获取密码
            if(pwd == null || pwd.trim().equals("")) {  // 检查密码是否为空
                out.println("后端验证：密码不能为空!返回<a href=\"add.jsp\">登录</a>");
                return;
            }
            UserDao dao = new UserDao();  // 创建UserDao对象
            if(dao.checkAdmin(admin, pwd)) {  // 验证管理员用户名和密码
                HttpSession session = request.getSession();  // 获取会话对象
                session.setAttribute("admin", admin);  // 在会话中存储管理员用户名
                session.setAttribute("username", admin);  // 在会话中存储用户名
                response.sendRedirect("administrate.jsp");  // 重定向到管理页面
            } else {
                out.println("管理员名或密码错误，<a href=\"admin-login.jsp\">返回重新登录</a>");
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO 自动生成的方法存根
        doGet(request, response);  // 调用doGet方法处理POST请求
    }
}
