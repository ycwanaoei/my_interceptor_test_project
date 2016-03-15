package com.test.mytest.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ycw on 2016/3/14.
 */
public class Client {
    private static final Logger logger = LoggerFactory.getLogger(Client.class);
    public static void main(String[] args){
        Context context;

//        context = new Context(new ConcreteIStrategyA());
//        double quote1 = context.contextInterface(300);
//        logger.info("最终价格为："+quote1);

        context = new Context(new ConcreteIStrategyB());
        double quote2 = context.contextInterface(300);
        logger.info("最终价格为："+quote2);

//        context = new Context(new ConcreteIStrategyC());
//        double quote3 = context.contextInterface(300);
//        logger.info("最终价格为："+quote3);

//        context = new Context(new ConcreteIStrategyD());
//        double quote4 = context.contextInterface(300);
//        logger.info("最终价格为："+quote4);
    }
}
