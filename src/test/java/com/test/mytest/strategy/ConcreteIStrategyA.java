package com.test.mytest.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ycw on 2016/3/14.
 */
public class ConcreteIStrategyA implements IStrategy {
    private static final Logger logger = LoggerFactory.getLogger(ConcreteIStrategyA.class);

    @Override
    public double strategyInterface(double bookPrice) {
        logger.info("对于初级会员没有折扣");
        return bookPrice;
    }
}
