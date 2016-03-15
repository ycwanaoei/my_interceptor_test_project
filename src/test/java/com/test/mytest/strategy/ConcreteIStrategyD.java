package com.test.mytest.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ycw on 2016/3/14.
 */
public class ConcreteIStrategyD implements IStrategy {
    private static final Logger logger = LoggerFactory.getLogger(ConcreteIStrategyD.class);

    @Override
    public double strategyInterface(double bookPrice) {
        logger.info("对于VVVIP会员的折扣是40%");
        return bookPrice * 0.6;
    }
}
