package cn.edu.hit.controller;  // 包声明

import cn.edu.hit.dao.MessageDao;  // 导入MessageDao类
import cn.edu.hit.dao.RemarkDao;   // 导入RemarkDao类
import cn.edu.hit.dao.UserDao;     // 导入UserDao类
import cn.edu.hit.entity.Message;  // 导入Message类
import cn.edu.hit.entity.User;     // 导入User类
import jakarta.servlet.ServletException;  // 导入ServletException类
import jakarta.servlet.annotation.WebServlet;  // 导入WebServlet注解
import jakarta.servlet.http.HttpServlet;  // 导入HttpServlet类
import jakarta.servlet.http.HttpServletRequest;  // 导入HttpServletRequest类
import jakarta.servlet.http.HttpServletResponse;  // 导入HttpServletResponse类
import jakarta.servlet.http.HttpSession;  // 导入HttpSession类

import java.io.IOException;  // 导入IOException类
import java.io.PrintWriter;  // 导入PrintWriter类
import java.util.List;  // 导入List类

/**
 * Servlet 实现类 RegServlet
 */
@WebServlet("/RegServlet")  // 声明Servlet映射到/RegServlet路径
public class RegServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;  // 序列化ID

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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

        if(from.equals("modify1")) {  // 用户修改密码
            HttpSession session = request.getSession();  // 获取会话对象
            String username = (String)session.getAttribute("username");  // 从会话中获取用户名
            String pwd1 = request.getParameter("pwd1");  // 获取新密码
            String pwd2 = request.getParameter("pwd2");  // 获取确认密码

            if(!pwd1.equals(pwd2)) {  // 检查两次密码是否一致
                out.println("后端验证：两次密码必需一致!返回<a href=\"modifyPwd.jsp\">重新修改</a>");
                return;
            }
            if(pwd1 == null || pwd1.trim().equals("")) {  // 检查密码是否为空
                out.println("后端验证：密码不能为空!返回<a href=\"modifyPwd.jsp\">重新修改</a>");
                return;
            }

            UserDao dao = new UserDao();  // 创建UserDao对象
            int count = dao.modifyPwd(username, pwd1);  // 修改密码

            if(count > 0) {
                out.println("修改成功，返回<a href=\"index.jsp\">主页</a>");
            } else {
                out.println("修改失败，<a href=\"modifyPwd.jsp\">重新修改</a>");
            }
        } else if(from.equals("modify2")) {  // 管理员修改密码
            HttpSession session = request.getSession();
            String username = (String)session.getAttribute("username");
            String pwd1 = request.getParameter("pwd1");
            String pwd2 = request.getParameter("pwd2");

            if(!pwd1.equals(pwd2)) {
                out.println("后端验证：两次密码必需一致!返回<a href=\"modifyPwd2.jsp\">重新修改</a>");
                return;
            }
            if(pwd1 == null || pwd1.trim().equals("")) {
                out.println("后端验证：密码不能为空!返回<a href=\"modifyPwd2.jsp\">重新修改</a>");
                return;
            }

            UserDao dao = new UserDao();
            int count = dao.modifyPwd(username, pwd1);

            if(count > 0) {
                out.println("修改成功，返回<a href=\"administrate.jsp\">管理页</a>");
            } else {
                out.println("修改失败，<a href=\"modifyPwd2.jsp\">重新修改</a>");
            }
        } else if(from.equals("remove")) {  // 删除用户
            String username = request.getParameter("username");
            UserDao dao = new UserDao();
            MessageDao dao1 = new MessageDao();
            RemarkDao dao2 = new RemarkDao();
            dao2.remove3(username);  // 删除与该用户相关的所有评论
            List<Message> mlist = dao1.getMessageId("select id from message where username='" + username + "'");
            for(Message m : mlist) {
                int id = m.getId();
                dao2.remove2(id);  // 删除与消息相关的评论
                dao1.remove(id);  // 删除消息
            }
            dao.remove(username);  // 删除用户
            response.sendRedirect("user.jsp");  // 重定向到用户管理页面
        } else {  // 用户注册
            String username = request.getParameter("username");
            String pwd = request.getParameter("pwd");
            String pwd2 = request.getParameter("pwd2");
            String gender = request.getParameter("gender");
            String face = request.getParameter("face");

            if(username == null || username.trim().equals("")) {  // 检查用户名是否为空
                out.println("后端验证：用户名不能为空!返回<a href=\"register.jsp\">注册</a>");
                return;
            }
            if(pwd == null || pwd.trim().equals("")) {  // 检查密码是否为空
                out.println("后端验证：密码不能为空!返回<a href=\"register.jsp\">注册</a>");
                return;
            }
            if(!pwd.equals(pwd2)) {  // 检查两次密码是否一致
                out.println("后端验证：两次密码必需一致!返回<a href=\"register.jsp\">重新注册</a>");
                return;
            }

            UserDao dao = new UserDao();
            if(dao.getByUsername(username)) {  // 检查用户名是否已存在
                out.println("后端验证：该用户名已存在!返回<a href=\"register.jsp\">重新注册</a>");
                return;
            }

            int count = dao.add(new User(username, pwd, gender, face));  // 添加新用户
            if(count > 0) {
                out.println("注册成功，返回<a href=\"login.jsp\">登录</a>");
            } else {
                out.println("注册失败，<a href=\"register.jsp\">重新注册</a>");
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
