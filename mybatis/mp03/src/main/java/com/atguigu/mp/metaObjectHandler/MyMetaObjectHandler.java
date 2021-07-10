package com.atguigu.mp.metaObjectHandler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author Gakki
 * @date 2018/12/28 - 22:26
 */
public class MyMetaObjectHandler extends MetaObjectHandler {
    /**插入操作 自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //获取到需要被填充的字段的值
        Object fieldValByName = getFieldValByName("name", metaObject);
        if (fieldValByName == null) {
            System.out.println("--------------插入");
            setFieldValByName("name", "liuqiang", metaObject);
        }
    }

    /**修改操作 自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        //获取到需要被填充的字段的值
        Object fieldValByName = getFieldValByName("name", metaObject);
        if (fieldValByName == null) {
            System.out.println("--------------更新");
            setFieldValByName("name", "qiang", metaObject);
        }
    }
}
