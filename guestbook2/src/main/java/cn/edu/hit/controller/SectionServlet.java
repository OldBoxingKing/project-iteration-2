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

import java.io.IOException; // 导入IOException类
import java.io.PrintWriter; // 导入PrintWriter类
import java.util.List; // 导入List类

/**
 * Servlet实现类SectionServlet，用于处理版块相关的请求
 */
@WebServlet("/SectionServlet") // 指定Servlet的URL映射
public class SectionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // 序列化ID，用于版本控制

    /**
     * 构造方法
     * @see HttpServlet#HttpServlet()
     */
    public SectionServlet() {
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
        if(from.equals("add")) // 判断请求是否为添加版块
        {
            String section = request.getParameter("section"); // 获取请求参数"section"
            if(section == null || section.trim().equals("")) // 判断版块名称是否为空
            {
                out.println("后端验证：版块名称不能为空!返回<a href=\"addSection.jsp\">重新增加</a>"); // 输出错误信息并提供返回链接
                return; // 结束方法
            }
            SectionDao dao = new SectionDao(); // 创建SectionDao对象
            if(dao.checkSection(section)) // 检查版块是否已存在
            {
                out.println("后端验证：该版块已存在!返回<a href=\"addSection.jsp\">重新增加</a>"); // 输出错误信息并提供返回链接
                return; // 结束方法
            }
            dao.add(section); // 添加新版块
        }
        else // 如果不是添加版块，则是删除版块
        {
            String str = request.getParameter("sid"); // 获取请求参数"sid"
            int sid = Integer.parseInt(str); // 将"sid"转换为整数
            MessageDao dao = new MessageDao(); // 创建MessageDao对象
            RemarkDao dao1 = new RemarkDao(); // 创建RemarkDao对象
            SectionDao dao2 = new SectionDao(); // 创建SectionDao对象
            String section = dao2.gainSection(sid); // 获取版块名称
            List<Message> mlist = dao.getMessageId("select id from message where section='" + section + "'"); // 获取属于该版块的所有留言
            for(Message m: mlist) // 遍历所有留言
            {
                int id = m.getId(); // 获取留言ID
                dao1.remove2(id); // 删除留言的所有评论
                dao.remove(id); // 删除留言
            }
            dao2.remove(section); // 删除版块
        }
        response.sendRedirect("regulateSection.jsp"); // 重定向到版块管理页面
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
