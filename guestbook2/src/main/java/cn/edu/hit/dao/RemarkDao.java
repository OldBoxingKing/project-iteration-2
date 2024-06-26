package cn.edu.hit.dao; // 定义包名

import cn.edu.hit.DBUtils.DBUtils; // 导入DBUtils类
import cn.edu.hit.entity.Remark; // 导入Remark实体类

import java.sql.ResultSet; // 导入ResultSet类
import java.sql.SQLException; // 导入SQLException类
import java.util.ArrayList; // 导入ArrayList类
import java.util.List; // 导入List类

public class RemarkDao {
    // 添加新回帖
    public void add(Remark r) {
        int id = r.getId(); // 获取帖子ID
        String username = r.getUsername(); // 获取用户名
        String content = r.getContent(); // 获取内容
        String time = r.getTime(); // 获取时间
        String sql = "insert into remark(id,username,content,time) values('" + id + "','" + username + "','" + content + "','" + time + "')"; // 插入SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        du.executeUpdate(sql); // 执行更新语句
    }

    // 从数据库中获取回帖
    public List<Remark> getRemark(String sql) {
        List<Remark> rlist = new ArrayList<>(); // 创建Remark列表
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        ResultSet rs = du.executeQuery(sql); // 执行查询语句
        int srcid, id;
        String username, content, time;
        try {
            while(rs.next()) // 遍历结果集
            {
                srcid = rs.getInt("srcid"); // 获取回帖ID
                id = rs.getInt("id"); // 获取帖子ID
                username = rs.getString("username"); // 获取用户名
                content = rs.getString("content"); // 获取内容
                time = rs.getString("time"); // 获取时间
                rlist.add(new Remark(srcid, id, username, content, time)); // 创建Remark对象并添加到列表中
            }
            return rlist; // 返回回帖列表
        } catch (SQLException e) {
            // 捕捉并处理SQLException异常
            e.printStackTrace();
            return null; // 返回空列表
        }
    }

    // 删除单个回帖
    public int remove(int srcid) {
        String sql = "delete from remark where srcid=" + srcid + ""; // 删除SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        return du.executeUpdate(sql); // 执行删除语句并返回结果
    }

    // 删除一个帖子的所有回帖
    public int remove2(int id) {
        String sql = "delete from remark where id=" + id + ""; // 删除SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        return du.executeUpdate(sql); // 执行删除语句并返回结果
    }

    // 删除一个用户的所有回帖
    public int remove3(String username) {
        String sql = "delete from remark where username='" + username + "'"; // 删除SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        return du.executeUpdate(sql); // 执行删除语句并返回结果
    }
}
