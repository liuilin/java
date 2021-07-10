package JDBC_Template.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Gakki
 * @date 2018/10/30 - 18:41
 */
public class c3p0Demo1 {
    public static void main(String[] args) throws SQLException {
        //创建连接池对象
        DataSource ds= new ComboPooledDataSource();
        //获取连接对象
        Connection conn = ds.getConnection();

        System.out.println(conn);
    }
}
