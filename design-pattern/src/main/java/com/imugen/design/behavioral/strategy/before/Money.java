package com.imugen.design.behavioral.strategy.before;

/**
 * 假设有这么一个需求：
 * <p>
 * 一个电商系统，当用户消费满1000 金额，可以根据用户VIP等级，享受打折优惠。根据用户VIP等级，计算出用户最终的费用。
 * <p>
 * 普通会员 不打折
 * 白银会员 优惠50元
 * 黄金会员 8折
 * 白金会员 优惠50元，再打7折
 *
 * @author Daniel Liu 2020/2/25 9:38
 */
public class Money {
    public static double getResult(long money, int type) {
        if (money > 1000) {
            if (type == UserType.SILVER_VIP.getType()) {
                System.out.println("白银会员 优惠50元");
                return money - 50;
            } else if (type == UserType.GOLD_VIP.getType()) {
                System.out.println("黄金会员 8折");
                return (double) money * 0.8;
            } else if (type == UserType.PLATINUM_VIP.getType()) {
                System.out.println("白金会员 优惠50元，再打7折");
                return ((double) money - 50) * 0.7;
            } else {
                System.out.println("普通会员 不打折");
                return money;
            }
        }
        return (double) money;
    }
}