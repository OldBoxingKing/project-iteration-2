package cn.edu.hit.dao;  // 包声明

import cn.edu.hit.DBUtils.DBUtils;  // 导入DBUtils类
import cn.edu.hit.entity.User;  // 导入User类

import java.sql.ResultSet;  // 导入ResultSet类
import java.sql.SQLException;  // 导入SQLException类
import java.util.ArrayList;  // 导入ArrayList类
import java.util.List;  // 导入List类

public class UserDao {
    // 获取所有用户信息
    public List<User> getAll(String sql) {
        DBUtils du = new DBUtils();  // 创建DBUtils对象
        ResultSet rs = du.executeQuery(sql);  // 执行查询
        List<User> uList = new ArrayList<>();  // 创建用户列表
        String username, pwd, gender, face;
        try {
            while (rs.next()) {
                username = rs.getString("username");  // 获取用户名
                pwd = rs.getString("pwd");  // 获取密码
                gender = rs.getString("gender");  // 获取性别
                face = rs.getString("face");  // 获取头像
                uList.add(new User(username, pwd, gender, face));  // 添加用户到列表
            }
        } catch (SQLException e) {
            // TODO 自动生成的捕获块
            e.printStackTrace();
        }
        return uList;  // 返回用户列表
    }

    // 添加新用户
    public int add(User u) {
        String username = u.getUsername();
        String pwd = u.getPwd();
        String gender = u.getGender();
        String face = u.getFace();
        String sql = "insert into people values('" + username + "','" + pwd + "','" + gender + "','" + face + "')";
        DBUtils du = new DBUtils();
        return du.executeUpdate(sql);  // 执行更新操作
    }

    // 用户登录校验
    public boolean checkUser(String username, String pwd) {
        String sql = "select count(*) from people where username ='" + username + "' and pwd = '" + pwd + "'";
        System.out.println(sql);
        DBUtils du = new DBUtils();
        ResultSet rs = du.executeQuery(sql);
        int count = -1;
        try {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            // TODO 自动生成的捕获块
            e.printStackTrace();
        }
        return count == 1;  // 返回校验结果
    }

    // 管理员登录校验
    public boolean checkAdmin(String username, String pwd) {
        String sql = "select count(*) from people where username ='admin' and pwd = '" + pwd + "'";
        System.out.println(sql);
        DBUtils du = new DBUtils();
        ResultSet rs = du.executeQuery(sql);
        int count = -1;
        try {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO 自动生成的捕获块
            e.printStackTrace();
        }
        return count == 1;  // 返回校验结果
    }

    // 修改密码
    public int modifyPwd(String username, String pwd) {
        String sql = "update people set pwd='" + pwd + "' where username='" + username + "'";
        DBUtils du = new DBUtils();
        return du.executeUpdate(sql);  // 执行更新操作
    }

    // 根据用户名获取用户信息
    public boolean getByUsername(String username) {
        String sql = "select count(*) from people where username ='" + username + "'";
        System.out.println(sql);
        DBUtils du = new DBUtils();
        ResultSet rs = du.executeQuery(sql);

        int count = -1;  // 声明一个int变量count并初始化为-1，用于存储查询结果的计数
        try {
            rs.next();  // 移动ResultSet的光标到下一行
            count = rs.getInt(1);  // 获取ResultSet当前行的第一列值，并赋值给count
        } catch (SQLException e) {
            // TODO 自动生成的捕获块
            e.printStackTrace();  // 打印捕获的SQL异常的堆栈跟踪
        }
        return count == 1 ? true : false;  // 返回一个布尔值，判断count是否等于1，如果等于1则返回true，否则返回false

    }

    // 删除用户
    public int remove(String username) {
        String sql = "delete from people where username='" + username + "'";
        DBUtils du = new DBUtils();
        return du.executeUpdate(sql);  // 执行删除操作
    }
}
