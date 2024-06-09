package cn.edu.hit.DBUtils;
import java.sql.*;

public class DBUtils {
    private Connection con;//static
    private Statement stmt;//static
    public DBUtils()
    {
        try {
            Class.forName("org.postgresql.Driver");//com.mysql.jdbc.Driver
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/guestbook2", "postgres", "abc392307");//"jdbc:mysql://localhost:3306/guestbook2","root","510133"
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public ResultSet executeQuery(String sql)//static
    {
        try {
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);//return null;
        }
    }
    public int executeUpdate(String sql)//static
    {
        try {
            Statement stmt = con.createStatement();
            return stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1;
        }
    }
    public void close()//static
    {
        try {
            stmt.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
