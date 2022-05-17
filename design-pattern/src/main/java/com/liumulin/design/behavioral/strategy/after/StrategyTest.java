package com.liumulin.design.behavioral.strategy.after;

import com.liumulin.design.behavioral.strategy.before.UserType;

/**
 * @author Daniel Liu 2020/2/25 14:37
 */
public class StrategyTest {
    public static void main(String[] args) {
        // Strategy strategy = StrategyFactory.get(2);//用静态代码块方式，get方法也得是静态的.
        Strategy strategy = StrategyFactory.getInstance().get(UserType.PLATINUM_VIP.getType());//用的构造方法初始化，非静态不能访问静态方法，所以get方法改为非静态
        double price = 10000;
        // 折扣最低额
        if (price > 1000) {
            price = strategy.compute((long) price);
        }
        System.out.println("money = " + price);
        // double money = Money.getResult(1300, UserType.PLATINUM_VIP.getType());
    }
}