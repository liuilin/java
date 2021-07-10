package JDBC_Template.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池工具类
 *
 * @author Gakki
 * @date 2018/10/30 - 20:20
 */
public class JDBCUtils {
    //提供静态代码块加载配置文件，初始化连接池对象
    private static DataSource ds = null;

    static {
        try {
            //1.静态代码块加载配置文件
            Properties pro = new Properties();
            /*Class c = JDBCUtils.class;
            ClassLoader classLoader = c.getClassLoader();
            URL url = classLoader.getResource("druid.properties");
            String path = url.getPath();
            pro.load(new FileInputStream(path));*/
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.获取连接对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提供方法
     * 1. 获取连接方法：通过数据库连接池获取连接
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 2. 释放资源
     */
    public static void close(Statement stmt, Connection conn) {
        /*if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/

        close(null,stmt,conn);
    }

    public static void close(ResultSet rs,Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    //3. 获取连接池的方法
    public static DataSource getDataSource(){
        return ds;
    }
}
