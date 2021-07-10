package com.atguigu.mp.beans;

import lombok.Data;

/**
 * @author Gakki
 * @date 2018/12/27 - 9:28
 * 定义JavaBean
 * 建议使用包装类型：
 *  因为每个基本类型都有个默认值
 */
@Data
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    public void setSalary(double v) {

    }
}
