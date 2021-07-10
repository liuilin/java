package JDBC_Template.jdbctemplate;

import JDBC_Template.domain.Emp;
import JDBC_Template.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Gakki
 * @date 2018/10/31 - 9:24
 */
public class JDBCTemplateDemo2 {

    // 1.创建JDBCTemplate对象

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 修改1号数据的salary为10000
     */
    @Test
    public void test01() {
        //2.定义sql
        String sql = "update emp set salary=10000 where ename=?";
        //3.执行SQL
        int i = template.update(sql, "孙悟空");
        System.out.println(i);
    }

    /**
     * 添加一条记录
     */
    @Test
    public void test02() {
        //1.定义sql
        String sql = "insert into emp(id,ename,salary) values(?,?,?)";
        //2.执行sql
        int i = template.update(sql, 1015, "Gakki", 1000);
        System.out.println(i);
    }

    /**
     * 删除上一条记录
     */
    @Test
    public void test03() {
        //1.定义SQL
        String sql = "delete from emp where ename = ?";
        int i = template.update(sql, "Gakki");
        System.out.println(i);
    }


    /**
     * 查询所有记录，将其封装为emp对象的list集合
     */
    @Test
    public void test06() {
        //1.定义sql
        String sql = "select * from emp";
        //2.执行sql
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 查询总记录数，用于查询聚合函数
     */
    @Test
    public void test07(){
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
