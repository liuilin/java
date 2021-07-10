package JDBC_Template.jdbctemplate;

import JDBC_Template.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Gakki
 * @date 2018/10/31 - 9:02
 */
public class JDBCTemplateDemo {
    public static void main(String[] args){
        //1.导入jar包
        //2.创建jdbctemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.执行方法
        String sql = "update account set balance = 5000 where id = ?";
        int i = template.update(sql,3);
        System.out.println(i);
    }
}
