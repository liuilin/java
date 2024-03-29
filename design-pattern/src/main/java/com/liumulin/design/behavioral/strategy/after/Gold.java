package com.liumulin.design.behavioral.strategy.after;

import com.liumulin.design.behavioral.strategy.before.UserType;

/**
 * @author Daniel Liu 2020/2/25 10:28
 */
public class Gold implements Strategy {
    @Override
    public long compute(long money) {
        System.out.println("黄金会员 8折");
        return money * 80 / 100;
    }

    @Override
    public int getType() {
        return UserType.GOLD_VIP.getType();
    }
}