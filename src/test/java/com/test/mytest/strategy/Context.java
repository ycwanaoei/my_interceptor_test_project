package com.test.mytest.strategy;

/**
 * Created by ycw on 2016/3/14.
 */
public class Context {

    private IStrategy strategy;

    public Context(IStrategy strategy){
        this.strategy = strategy;
    }
    /**
     * 策略方法
     */
    public double contextInterface(double bookPrice){
        return this.strategy.strategyInterface(bookPrice);
    }
}
