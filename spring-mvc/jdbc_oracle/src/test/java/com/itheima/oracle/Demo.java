import oracle.jdbc.OracleTypes;
import org.junit.Test;

import java.sql.*;

/**
 * @author Gakki
 * @date 2018/12/30 - 15:55
 */
public class Demo {

    @Test
    public void javaCallOracle() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.25.134:1521:orcl", "scott", "tiger");
        PreparedStatement pstmt = conn.prepareStatement("select * from emp where empno = ?");
        pstmt.setObject(1,7900);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("ename"));
        }
        rs.close();
        pstmt.close();
        conn.close();
    }

    @Test
    public void javaCallProcedure() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.25.134:1521:orcl", "itheima", "root");
        CallableStatement call = conn.prepareCall("{call p_yearsal(?,?)}");
        call.setObject(1,7788);
        call.registerOutParameter(2,OracleTypes.NUMBER);
        call.execute();
        System.out.println(call.getObject(2));

        call.close();
        conn.close();
    }
}
