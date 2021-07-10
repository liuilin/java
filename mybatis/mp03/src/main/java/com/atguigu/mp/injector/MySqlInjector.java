package com.atguigu.mp.injector;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**自定义全局操作
 * @author Gakki
 * @date 2018/12/28 - 14:03
 */
public class MySqlInjector extends AutoSqlInjector {

    /**
     * 扩展inject方法，完成自定义全局操作
     * @param configuration
     * @param builderAssistant
     * @param mapperClass
     * @param modelClass
     * @param table
     */
    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        //将EmployeeMapper中定义的deleteAll， 处理成对应的MappedStatement对象，加入到configuration对象中。

        //注入SQL语句
        String sql = "delete from " + table.getTableName();
        //注入方法名 一定要与employeeMapper接口中的方法名一致
        String method = "deleteAll";

        //构造SQLsource对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);

        //构造一个删除的MapperStatement
        this.addDeleteMappedStatement(mapperClass, method, sqlSource);
    }
}
