package cn.edu.hit.dao; // 定义包名

import java.sql.ResultSet; // 导入ResultSet类
import java.sql.SQLException; // 导入SQLException类
import java.util.ArrayList; // 导入ArrayList类
import java.util.List; // 导入List类

import cn.edu.hit.DBUtils.DBUtils; // 导入DBUtils类
import cn.edu.hit.entity.Message; // 导入Message实体类

public class MessageDao {
    // 添加新帖子
    public void add(Message m) {
        String username = m.getUsername(); // 获取用户名
        String title = m.getTitle(); // 获取标题
        String content = m.getContent(); // 获取内容
        String time = m.getTime(); // 获取时间
        String section = m.getSection(); // 获取版块
        int good = 0; // 初始化点赞数为0
        String sql = "insert into message(username,title,content,time,good,section) values('" + username + "','" + title + "','" + content + "','" + time + "'," + good + ",'" + section + "')"; // 插入SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        du.executeUpdate(sql); // 执行更新语句
    }

    // 从数据库中获取帖子
    public List<Message> getMessage(String sql) {
        List<Message> mlist = new ArrayList<>(); // 创建Message列表
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        ResultSet rs = du.executeQuery(sql); // 执行查询语句
        int id, good;
        String username, gender, face, title, content, time, section;
        try {
            while(rs.next()) // 遍历结果集
            {
                id = rs.getInt("id"); // 获取帖子ID
                username = rs.getString("username"); // 获取用户名
                gender = rs.getString("gender"); // 获取性别
                face = rs.getString("face"); // 获取头像
                title = rs.getString("title"); // 获取标题
                content = rs.getString("content"); // 获取内容
                time = rs.getString("time"); // 获取时间
                good = rs.getInt("good"); // 获取点赞数
                section = rs.getString("section"); // 获取版块
                mlist.add(new Message(id, username, gender, face, title, content, time, good, section)); // 创建Message对象并添加到列表中
            }
            return mlist; // 返回帖子列表
        } catch (SQLException e) {
            // 捕捉并处理SQLException异常
            e.printStackTrace();
            return null; // 返回空列表
        }
    }

    // 获取总帖子数
    public int getCount() {
        int count = 0; // 初始化帖子数为0
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        ResultSet rs = du.executeQuery("select count(*) from message"); // 执行查询语句
        try {
            rs.next(); // 移动到结果集的第一行
            count = rs.getInt(1); // 获取查询结果
        } catch (SQLException e) {
            // 捕捉并处理SQLException异常
            e.printStackTrace();
            count = 0; // 出错时返回0
        }
        return count; // 返回总帖子数
    }

    // 获取当前版块的总帖子数
    public int getCount2(int sid) {
        int count = 0; // 初始化帖子数为0
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        ResultSet rs1 = du.executeQuery("select section from section where sid=" + sid + ""); // 执行查询语句，获取版块名称
        String section = null;
        try {
            rs1.next(); // 移动到结果集的第一行
            section = rs1.getString("section"); // 获取版块名称
        } catch (SQLException e1) {
            // 捕捉并处理SQLException异常
            e1.printStackTrace();
        }
        ResultSet rs = du.executeQuery("select count(*) from message where section='" + section + "'"); // 执行查询语句，获取版块中的帖子数
        try {
            rs.next(); // 移动到结果集的第一行
            count = rs.getInt(1); // 获取查询结果
        } catch (SQLException e) {
            // 捕捉并处理SQLException异常
            e.printStackTrace();
            count = 0; // 出错时返回0
        }
        return count; // 返回当前版块的总帖子数
    }

    // 根据ID获取帖子
    public Message getById(int id) {
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        ResultSet rs = du.executeQuery("select id, message.username, title, gender, content, face, time, good from message,people where id = " + id + ""); // 执行查询语句
        int good;
        String username, gender, face, title, content, time;
        Message m = null;
        try {
            if(rs.next()) // 如果有查询结果
            {
                id = rs.getInt("id"); // 获取帖子ID
                username = rs.getString("username"); // 获取用户名
                gender = rs.getString("gender"); // 获取性别
                face = rs.getString("face"); // 获取头像
                title = rs.getString("title"); // 获取标题
                content = rs.getString("content"); // 获取内容
                time = rs.getString("time"); // 获取时间
                good = rs.getInt("good"); // 获取点赞数
                m = new Message(id, username, gender, face, title, content, time, good); // 创建Message对象
            }
        } catch (SQLException e) {
            // 捕捉并处理SQLException异常
            e.printStackTrace();
        }
        return m; // 返回Message对象
    }

    // 为帖子添加点赞
    public int addGood(Message m) {
        int id = m.getId(); // 获取帖子ID
        int good = m.getGood() + 1; // 增加点赞数
        String sql = "update message set good = " + good + " where id = " + id + ""; // 更新SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        return du.executeUpdate(sql); // 执行更新语句并返回结果
    }

    // 根据ID删除帖子
    public int remove(int id) {
        String sql = "delete from message where id=" + id + ""; // 删除SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        return du.executeUpdate(sql); // 执行删除语句并返回结果
    }

    // 根据用户名删除帖子
    public int remove2(String username) {
        String sql = "delete from message where username='" + username + "'"; // 删除SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        return du.executeUpdate(sql); // 执行删除语句并返回结果
    }

    // 从数据库中获取帖子的ID
    public List<Message> getMessageId(String sql) {
        List<Message> mlist = new ArrayList<>(); // 创建Message列表
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        ResultSet rs = du.executeQuery(sql); // 执行查询语句
        int id;
        try {
            while(rs.next()) // 遍历结果集
            {
                id = rs.getInt("id"); // 获取帖子ID
                mlist.add(new Message(id)); // 创建Message对象并添加到列表中
            }
            return mlist; // 返回帖子ID列表
        } catch (SQLException e) {
            // 捕捉并处理SQLException异常
            e.printStackTrace();
            return null; // 返回空列表
        }
    }
}
