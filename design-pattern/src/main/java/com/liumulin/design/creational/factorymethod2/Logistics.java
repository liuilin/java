package com.liumulin.design.creational.factorymethod2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工厂方法实现方式二：https://refactoringguru.cn/design-patterns/factory-method
 *
 *
 * @author liuqiang
 * @since 2022-05-20
 */
public abstract class Logistics {
    public abstract Transport createTransport();
}
