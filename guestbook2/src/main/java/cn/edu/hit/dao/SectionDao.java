package cn.edu.hit.dao;

import cn.edu.hit.DBUtils.DBUtils;
import cn.edu.hit.entity.Section;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SectionDao {
    public List<Section> getSection(String sql)//从数据库中获得全部版块
    {
        List<Section> slist = new ArrayList<>();
        DBUtils du = new DBUtils();
        ResultSet rs = du.executeQuery(sql);
        String section;
        int sid;
        try {
            while(rs.next())
            {
                section = rs.getString("section");
                sid = rs.getInt("sid");
                slist.add(new Section(sid,section));
            }
            return slist;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    public String gainSection(int sid)
    {
        DBUtils du = new DBUtils();
        String section = null;
        ResultSet rs = du.executeQuery("select section from section where sid=" + sid + "");
        try {
            while(rs.next())
            {
                section = rs.getString("section");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return section;
    }
    public void add(String section)
    {
        String sql = "insert into section(section) values('" + section + "')";//String sql = "insert into section(`section`) values('" + section + "')";
        DBUtils du = new DBUtils();
        du.executeUpdate(sql);
    }
    public boolean checkSection(String section)//版块重名校验
    {
        String sql = "select count(*) from section where section ='" + section + "'";
        DBUtils du = new DBUtils();
        ResultSet rs = du.executeQuery(sql);
        int count = -1;
        try {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return count == 1?true:false;
    }
    public int remove(String section)
    {
        String sql = "delete from section where section='" + section + "'";
        DBUtils du = new DBUtils();
        return du.executeUpdate(sql);
    }
}
