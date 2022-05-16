package com.imugen.design.behavioral.strategy.after;

import com.imugen.design.behavioral.strategy.before.UserType;

/**
 * @author Daniel Liu 2020/2/25 10:26
 */
public class Silver implements Strategy {
    @Override
    public long compute(long money) {
        System.out.println("白银会员优惠 50 元");
        return money - 50;
    }

    @Override
    public int getType() {
        return UserType.SILVER_VIP.getType();
    }
}