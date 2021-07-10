package com.imugen.design.behavioral.strategy.after;

import com.imugen.design.behavioral.strategy.before.UserType;

/**
 * @author Daniel Liu 2020/2/25 10:29
 */
public class Platinum implements Strategy {
    @Override
    public double compute(long money) {
        System.out.println("白金会员 优惠50元，再打7折");
        return (money - 50) * 0.7;
    }

    @Override
    public int getType() {
        return UserType.PLATINUM_VIP.getType();
    }
}