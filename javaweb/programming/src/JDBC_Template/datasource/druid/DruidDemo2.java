package JDBC_Template.datasource.druid;

import JDBC_Template.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Gakki
 * @date 2018/10/30 - 22:43
 */
public class DruidDemo2 {
    public static void main(String[] args) {

        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "insert into account values (null,?,?)";
            //3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4.设置值
            pstmt.setString(1,"嘿嘿嘿");
            pstmt.setDouble(2,200);
            //5.执行语句
            int i = pstmt.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }
    }
}
