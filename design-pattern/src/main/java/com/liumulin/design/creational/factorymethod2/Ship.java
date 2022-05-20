package com.liumulin.design.creational.factorymethod2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuqiang
 * @since 2022-05-20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("轮船海运");
    }
}
