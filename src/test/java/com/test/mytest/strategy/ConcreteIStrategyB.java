package com.test.mytest.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ycw on 2016/3/14.
 */
public class ConcreteIStrategyB implements IStrategy {
    private static final Logger logger = LoggerFactory.getLogger(ConcreteIStrategyB.class);

    @Override
    public double strategyInterface(double bookPrice) {
        logger.info("对于中级会员的折扣是10%");
        return bookPrice * 0.9;
    }
}
