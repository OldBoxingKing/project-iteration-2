package cn.edu.hit.dao; // 定义包名

import cn.edu.hit.DBUtils.DBUtils; // 导入DBUtils类
import cn.edu.hit.entity.User; // 导入User实体类

import java.sql.ResultSet; // 导入ResultSet类
import java.sql.SQLException; // 导入SQLException类
import java.util.ArrayList; // 导入ArrayList类
import java.util.List; // 导入List类

public class UserDao {
    // 获取所有用户信息
    public List<User> getAll(String sql) {
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        ResultSet rs = du.executeQuery(sql); // 执行查询语句
        List<User> uList = new ArrayList<>(); // 创建User列表
        String username, pwd, gender, face;
        try {
            while(rs.next()) // 遍历结果集
            {
                username = rs.getString("username"); // 获取用户名
                pwd = rs.getString("pwd"); // 获取密码
                gender = rs.getString("gender"); // 获取性别
                face = rs.getString("face"); // 获取头像
                uList.add(new User(username, pwd, gender, face)); // 创建User对象并添加到列表中
            }
        } catch (SQLException e) {
            // 捕捉并处理SQLException异常
            e.printStackTrace();
        }
        return uList; // 返回用户列表
    }

    // 添加新用户
    public int add(User u) {
        String username = u.getUsername(); // 获取用户名
        String pwd = u.getPwd(); // 获取密码
        String gender = u.getGender(); // 获取性别
        String face = u.getFace(); // 获取头像
        String sql = "insert into people values('" + username + "','" + pwd + "','" + gender + "','" + face + "')"; // 插入SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        return du.executeUpdate(sql); // 执行更新语句并返回结果
    }

    // 用户登录校验
    public boolean checkUser(String username, String pwd) {
        String sql = "select count(*) from people where username ='" + username + "' and pwd = '" + pwd +"'"; // 查询用户SQL语句
        System.out.println(sql); // 打印SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        ResultSet rs = du.executeQuery(sql); // 执行查询语句
        int count = -1;
        try {
            rs.next(); // 移动到结果集的第一行
            count = rs.getInt(1); // 获取查询结果
        } catch (SQLException e) {
            // 捕捉并处理SQLException异常
            e.printStackTrace();
        }
        return count == 1; // 返回校验结果
    }

    // 管理员登录校验
    public boolean checkAdmin(String username, String pwd) {
        String sql = "select count(*) from people where username ='admin' and pwd = '" + pwd +"'"; // 查询管理员SQL语句
        System.out.println(sql); // 打印SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        ResultSet rs = du.executeQuery(sql); // 执行查询语句
        int count = -1;
        try {
            if(rs.next()) {
                count = rs.getInt(1); // 获取查询结果
            }
        } catch (SQLException e) {
            // 捕捉并处理SQLException异常
            e.printStackTrace();
        }
        return count == 1; // 返回校验结果
    }

    // 修改用户密码
    public int modifyPwd(String username, String pwd) {
        String sql = "update people set pwd='" + pwd +"' where username='" + username + "'"; // 更新密码SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        return du.executeUpdate(sql); // 执行更新语句并返回结果
    }

    // 根据用户名查询用户是否存在
    public boolean getByUsername(String username) {
        String sql = "select count(*) from people where username ='" + username + "'"; // 查询用户SQL语句
        System.out.println(sql); // 打印SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        ResultSet rs = du.executeQuery(sql); // 执行查询语句
        int count = -1;
        try {
            rs.next(); // 移动到结果集的第一行
            count = rs.getInt(1); // 获取查询结果
        } catch (SQLException e) {
            // 捕捉并处理SQLException异常
            e.printStackTrace();
        }
        return count == 1; // 返回查询结果
    }

    // 删除用户
    public int remove(String username) {
        String sql = "delete from people where username='" + username + "'"; // 删除用户SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        return du.executeUpdate(sql); // 执行删除语句并返回结果
    }
}
