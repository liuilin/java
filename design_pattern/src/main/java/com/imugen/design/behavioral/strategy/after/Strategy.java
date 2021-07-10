package com.imugen.design.behavioral.strategy.after;

/**
 * @author Daniel Liu 2020/2/25 10:24
 */
public interface Strategy {
    double compute(long money);

    int getType();
}
