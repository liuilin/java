package com.liumulin.design.behavioral.strategy.after;

/**
 * @author Daniel Liu 2020/2/25 10:24
 */
public interface Strategy {
    long compute(long money);

    int getType();
}
