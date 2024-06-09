package cn.edu.hit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hit.DBUtils.DBUtils;
import cn.edu.hit.entity.Message;


public class MessageDao {
    public void add(Message m)
    {
        String username = m.getUsername();
        String title = m.getTitle();
        String content = m.getContent();
        String time = m.getTime();
        String section = m.getSection();
        int good = 0;
        String sql = "insert into message(username,title,content,time,good,section) values('" + username + "','" + title + "','" + content + "','" + time + "'," + good + ",'" + section + "')";
        DBUtils du = new DBUtils();
        du.executeUpdate(sql);
    }
    public List<Message> getMessage(String sql)//从数据库中获得帖子
    {
        List<Message> mlist = new ArrayList<>();
        DBUtils du = new DBUtils();
        ResultSet rs = du.executeQuery(sql);
        int id,good;
        String username,gender,face,title,content,time,section;
        try {
            while(rs.next())
            {
                id = rs.getInt("id");
                username = rs.getString("username");
                gender = rs.getString("gender");
                face = rs.getString("face");
                title = rs.getString("title");
                content = rs.getString("content");
                time = rs.getString("time");
                good = rs.getInt("good");
                section = rs.getString("section");
                mlist.add(new Message(id,username,gender,face,title,content,time,good,section));
            }
            return mlist;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    public int getCount()//获取总帖子数
    {
        int count = 0;
        DBUtils du = new DBUtils();
        ResultSet rs = du.executeQuery("select count(*) from message");
        try {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            count = 0;
        }
        return count;
    }
    public int getCount2(int sid)//获取当前版块总帖子数
    {
        int count = 0;
        DBUtils du = new DBUtils();
        ResultSet rs1 = du.executeQuery("select section from section where sid=" + sid + "");
        String section = null;
        try {
            rs1.next();
            section = rs1.getString("section");
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ResultSet rs = du.executeQuery("select count(*) from message where section='" + section + "'");
        try {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            count = 0;
        }
        return count;
    }
    public Message getById(int id) {
        DBUtils du = new DBUtils();
        ResultSet rs = du.executeQuery("select id, message.username, title, gender, content, face, time, good from message,people where id = " + id + "");
        int good;
        String username,gender,face,title,content,time;
        Message m = null;
        try {
            if(rs.next())
            {
                id = rs.getInt("id");
                username = rs.getString("username");
                gender = rs.getString("gender");
                face = rs.getString("face");
                title = rs.getString("title");
                content = rs.getString("content");
                time = rs.getString("time");
                good = rs.getInt("good");
                m = new Message(id,username,gender,face,title,content,time,good);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return m;
    }
    public int addGood(Message m) {
        int id = m.getId();
        int good = m.getGood() + 1;
        String sql = "update message set good = " + good + " where id = " + id + "";
        DBUtils du = new DBUtils();
        return du.executeUpdate(sql);
    }
    public int remove(int id)//根据id删除帖子
    {
        String sql = "delete from message where id=" + id + "";
        DBUtils du = new DBUtils();
        return du.executeUpdate(sql);
    }
    public int remove2(String username)//根据用户名删除帖子
    {
        String sql = "delete from message where username='" + username + "'";
        DBUtils du = new DBUtils();
        return du.executeUpdate(sql);
    }
    public List<Message> getMessageId(String sql)//从数据库中获得帖子的id
    {
        List<Message> mlist = new ArrayList<>();
        DBUtils du = new DBUtils();
        ResultSet rs = du.executeQuery(sql);
        int id;
        try {
            while(rs.next())
            {
                id = rs.getInt("id");
                mlist.add(new Message(id));
            }
            return mlist;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
