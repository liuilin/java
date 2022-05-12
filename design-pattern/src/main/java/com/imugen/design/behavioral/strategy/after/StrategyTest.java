package com.imugen.design.behavioral.strategy.after;

/**
 * @author Daniel Liu 2020/2/25 14:37
 */
public class StrategyTest {
    public static void main(String[] args) {
//        Strategy strategy = StrategyFactory.get(2);//用静态代码块方式，get方法也得是静态的
        Strategy strategy = StrategyFactory.getInstance().get(2);//用的构造方法初始化，非静态不能访问静态方法，所以get方法改为非静态
        double money = strategy.compute(100);
        System.out.println("money = " + money);
    }
}