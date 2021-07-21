package com.imugen.design.behavioral.strategy.after;

import com.imugen.design.behavioral.strategy.before.UserType;

/**
 * @author Daniel Liu 2020/2/25 10:28
 */
public class Gold implements Strategy {
    @Override
    public double compute(long money) {
        System.out.println("黄金会员 8折");
        return money * 0.8;
    }

    @Override
    public int getType() {
        return UserType.GOLD_VIP.getType();
    }
}