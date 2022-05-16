package com.imugen.design.behavioral.strategy.after;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class StrategyFactory {

    private static Map<Integer, Strategy> map;

    // 也可以用 static 静态方法
    public StrategyFactory() {
        List<Strategy> strategies = new ArrayList<>();
        strategies.add(new Ordinary());
        strategies.add(new Silver());
        strategies.add(new Gold());
        strategies.add(new Platinum());
        map = strategies.stream().collect(Collectors.toMap(Strategy::getType, strategy -> strategy));
    }

//    public static double getResult(long money, int type) {
//        if (money <= 1000) {
//            return (double) money;
//        }
//        Strategy strategy;
//        if (type == UserType.SILVER_VIP.getType()) {
//            strategy = new Silver();
//        } else if (type == UserType.GOLD_VIP.getType()) {
//            strategy = new Gold();
//        } else if (type == UserType.PLATINUM_VIP.getType()) {
//            strategy = new Platinum();
//        } else {
//            strategy = new Ordinary();
//        }
//        return strategy.compute(money);
//    }

    public static StrategyFactory getInstance() {
        return Holder.instance;
    }

    public Strategy get(int type) {
        return map.get(type);
    }

    public static class Holder {
        public static StrategyFactory instance = new StrategyFactory();
    }
}