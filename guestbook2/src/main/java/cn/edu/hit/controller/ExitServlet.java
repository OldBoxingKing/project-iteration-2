package cn.edu.hit.controller;

// 导入相关的 Servlet 和 HTTP 类
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet 实现类 ExitServlet，用于处理用户退出登录的请求
 */
@WebServlet("/ExitServlet") // 指定 Servlet 的 URL 映射
public class ExitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // 序列化 ID，用于版本控制

    /**
     * 构造方法
     * @see HttpServlet#HttpServlet()
     */
    public ExitServlet() {
        super(); // 调用父类的构造方法
        // TODO Auto-generated constructor stub
    }

    /**
     * 处理 GET 请求的方法
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(); // 获取当前用户的会话对象
        session.invalidate(); // 使当前会话失效，注销用户
        response.sendRedirect("login.jsp"); // 重定向到登录页面
    }

    /**
     * 处理 POST 请求的方法
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response); // 调用 doGet 方法处理 POST 请求
    }

}
