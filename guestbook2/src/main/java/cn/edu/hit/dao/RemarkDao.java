package cn.edu.hit.dao;

import cn.edu.hit.DBUtils.DBUtils;
import cn.edu.hit.entity.Remark;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RemarkDao {
    public void add(Remark r)
    {
        int id = r.getId();
        String username = r.getUsername();
        String content = r.getContent();
        String time = r.getTime();
        String sql = "insert into remark(id,username,content,time) values('" + id + "','" + username + "','" + content + "','" + time + "')";
        DBUtils du = new DBUtils();
        du.executeUpdate(sql);
    }
    public List<Remark> getRemark(String sql)//从数据库中获得回帖
    {
        List<Remark> rlist = new ArrayList<>();
        DBUtils du = new DBUtils();
        ResultSet rs = du.executeQuery(sql);
        int srcid,id;
        String username,content,time;
        try {
            while(rs.next())
            {
                srcid = rs.getInt("srcid");
                id = rs.getInt("id");
                username = rs.getString("username");
                content = rs.getString("content");
                time = rs.getString("time");
                rlist.add(new Remark(srcid,id,username,content,time));
            }
            return rlist;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    public int remove(int srcid)//删除单个回帖
    {
        String sql = "delete from remark where srcid=" + srcid + "";
        DBUtils du = new DBUtils();
        return du.executeUpdate(sql);
    }
    public int remove2(int id)//删除一个帖子的所有回帖
    {
        String sql = "delete from remark where id=" + id + "";
        DBUtils du = new DBUtils();
        return du.executeUpdate(sql);
    }
    public int remove3(String username)//删除一个用户的所有回帖
    {
        String sql = "delete from remark where username='" + username + "'";
        DBUtils du = new DBUtils();
        return du.executeUpdate(sql);
    }

}
