package com.test.mytest.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ycw on 2016/3/14.
 */
public class ConcreteIStrategyC implements IStrategy {
    private static final Logger logger = LoggerFactory.getLogger(ConcreteIStrategyC.class);

    @Override
    public double strategyInterface(double bookPrice) {
        logger.info("对于高级会员的折扣是20%");
        return bookPrice * 0.8;
    }
}
