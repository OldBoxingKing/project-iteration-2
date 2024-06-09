package cn.edu.hit.controller;  // 包声明

import jakarta.servlet.ServletException;  // 导入ServletException类
import jakarta.servlet.annotation.WebServlet;  // 导入WebServlet注解
import jakarta.servlet.http.HttpServlet;  // 导入HttpServlet类
import jakarta.servlet.http.HttpServletRequest;  // 导入HttpServletRequest类
import jakarta.servlet.http.HttpServletResponse;  // 导入HttpServletResponse类
import jakarta.servlet.http.HttpSession;  // 导入HttpSession类

import java.io.IOException;  // 导入IOException类

/**
 * Servlet 实现类 ExitServlet
 */
@WebServlet("/ExitServlet")  // 声明Servlet映射到/ExitServlet路径
public class ExitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;  // 序列化ID

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExitServlet() {
        super();
        // TODO 自动生成的构造函数存根
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();  // 获取会话对象
        session.invalidate();  // 使会话无效，清除所有会话数据
        response.sendRedirect("login.jsp");  // 重定向到登录页面
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO 自动生成的方法存根
        doGet(request, response);  // 调用doGet方法处理POST请求
    }

}
