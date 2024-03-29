package com.liumulin.design.behavioral.strategy.after;

import com.liumulin.design.behavioral.strategy.before.UserType;

/**
 * @author Daniel Liu 2020/2/25 11:14
 */
public class Ordinary implements Strategy {
    @Override
    public long compute(long money) {
        System.out.println("普通会员 不打折");
        return money;
    }

    @Override
    public int getType() {
        return UserType.ORDINARY.getType();
    }
}