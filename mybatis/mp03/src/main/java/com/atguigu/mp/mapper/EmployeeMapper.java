package com.atguigu.mp.mapper;

import com.atguigu.mp.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Mugen
 * @since 2018-12-27
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    int deleteAll();
}
