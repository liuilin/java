package com.liumulin.design.behavioral.strategy.after;

import com.liumulin.design.behavioral.strategy.before.UserType;

/**
 * @author Daniel Liu 2020/2/25 10:29
 */
public class Platinum implements Strategy {
    @Override
    public long compute(long money) {
        System.out.println("白金会员 优惠50元，再打7折");
        return (money - 50) * 70/100;
    }

    @Override
    public int getType() {
        return UserType.PLATINUM_VIP.getType();
    }
}