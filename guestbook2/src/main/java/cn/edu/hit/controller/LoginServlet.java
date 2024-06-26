package cn.edu.hit.controller; // 定义包名

import cn.edu.hit.dao.UserDao; // 导入UserDao类
import jakarta.servlet.ServletException; // 导入ServletException类
import jakarta.servlet.annotation.WebServlet; // 导入WebServlet注解
import jakarta.servlet.http.HttpServlet; // 导入HttpServlet类
import jakarta.servlet.http.HttpServletRequest; // 导入HttpServletRequest类
import jakarta.servlet.http.HttpServletResponse; // 导入HttpServletResponse类
import jakarta.servlet.http.HttpSession; // 导入HttpSession类

import java.io.IOException; // 导入IOException类
import java.io.PrintWriter; // 导入PrintWriter类

/**
 * Servlet实现类LoginServlet，用于处理用户登录请求
 */
@WebServlet("/LoginServlet") // 指定Servlet的URL映射
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // 序列化ID，用于版本控制

    /**
     * 构造方法
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
        if(from.equals("login")) // 判断请求是否为普通用户登录
        {
            String username = request.getParameter("username"); // 获取请求参数"username"
            if(username == null || username.trim().equals("")) // 判断用户名是否为空
            {
                out.println("后端验证：用户名不能为空!返回<a href=\"add.jsp\">登录</a>"); // 输出错误信息并提供返回链接
                return; // 结束方法
            }
            String pwd = request.getParameter("pwd"); // 获取请求参数"pwd"
            if(pwd == null || pwd.trim().equals("")) // 判断密码是否为空
            {
                out.println("后端验证：密码不能为空!返回<a href=\"add.jsp\">登录</a>"); // 输出错误信息并提供返回链接
                return; // 结束方法
            }
            UserDao dao = new UserDao(); // 创建UserDao对象
            if(dao.checkUser(username, pwd)) // 检查用户凭证是否正确
            {
                HttpSession session = request.getSession(); // 获取当前用户的会话对象
                session.setAttribute("username", username); // 将用户名保存到会话中
                response.sendRedirect("index.jsp"); // 重定向到主页
            }
            else // 用户名或密码错误
            {
                out.println("用户名或密码错误，<a href=\"login.jsp\">返回重新登录</a>"); // 输出错误信息并提供返回链接
            }
        }
        else // 如果不是普通用户登录，则是管理员登录
        {
            String admin = request.getParameter("username"); // 获取请求参数"username"
            if(admin == null || admin.trim().equals("")) // 判断管理员名是否为空
            {
                out.println("后端验证：用户名不能为空!返回<a href=\"add.jsp\">登录</a>"); // 输出错误信息并提供返回链接
                return; // 结束方法
            }
            String pwd = request.getParameter("pwd"); // 获取请求参数"pwd"
            if(pwd == null || pwd.trim().equals("")) // 判断密码是否为空
            {
                out.println("后端验证：密码不能为空!返回<a href=\"add.jsp\">登录</a>"); // 输出错误信息并提供返回链接
                return; // 结束方法
            }
            UserDao dao = new UserDao(); // 创建UserDao对象
            if(dao.checkAdmin(admin, pwd)) // 检查管理员凭证是否正确
            {
                HttpSession session = request.getSession(); // 获取当前用户的会话对象
                session.setAttribute("admin", admin); // 将管理员名保存到会话中
                session.setAttribute("username", admin); // 将管理员名作为用户名保存到会话中
                response.sendRedirect("administrate.jsp"); // 重定向到管理员页面
            }
            else // 管理员名或密码错误
            {
                out.println("管理员名或密码错误，<a href=\"admin-login.jsp\">返回重新登录</a>"); // 输出错误信息并提供返回链接
            }
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
