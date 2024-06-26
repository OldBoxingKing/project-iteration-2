package cn.edu.hit.dao; // 定义包名

import cn.edu.hit.DBUtils.DBUtils; // 导入DBUtils类
import cn.edu.hit.entity.Section; // 导入Section实体类

import java.sql.ResultSet; // 导入ResultSet类
import java.sql.SQLException; // 导入SQLException类
import java.util.ArrayList; // 导入ArrayList类
import java.util.List; // 导入List类

public class SectionDao {
    // 从数据库中获取全部版块
    public List<Section> getSection(String sql) {
        List<Section> slist = new ArrayList<>(); // 创建Section列表
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        ResultSet rs = du.executeQuery(sql); // 执行查询语句
        String section;
        int sid;
        try {
            while(rs.next()) // 遍历结果集
            {
                section = rs.getString("section"); // 获取版块名称
                sid = rs.getInt("sid"); // 获取版块ID
                slist.add(new Section(sid, section)); // 创建Section对象并添加到列表中
            }
            return slist; // 返回版块列表
        } catch (SQLException e) {
            // 捕捉并处理SQLException异常
            e.printStackTrace();
            return null; // 返回空列表
        }
    }

    // 根据版块ID获取版块名称
    public String gainSection(int sid) {
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        String section = null;
        ResultSet rs = du.executeQuery("select section from section where sid=" + sid + ""); // 执行查询语句
        try {
            while(rs.next()) // 遍历结果集
            {
                section = rs.getString("section"); // 获取版块名称
            }
        } catch (SQLException e) {
            // 捕捉并处理SQLException异常
            e.printStackTrace();
        }
        return section; // 返回版块名称
    }

    // 添加新版块
    public void add(String section) {
        String sql = "insert into section(section) values('" + section + "')"; // 插入SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        du.executeUpdate(sql); // 执行更新语句
    }

    // 版块重名校验
    public boolean checkSection(String section) {
        String sql = "select count(*) from section where section ='" + section + "'"; // 查询版块是否存在SQL语句
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

    // 删除版块
    public int remove(String section) {
        String sql = "delete from section where section='" + section + "'"; // 删除SQL语句
        DBUtils du = new DBUtils(); // 创建DBUtils对象
        return du.executeUpdate(sql); // 执行删除语句并返回结果
    }
}
