package com.test.mytest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ycw on 2016/3/8.
 */
public class Singleton {
    private static final Logger logger = LoggerFactory.getLogger(Singleton.class);
    public Singleton(){}

    private static Singleton instance = null;

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args){
        Singleton instance =  Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        //System.out.println(instance);
        logger.info(""+instance);
        //System.out.println(""+instance1);
        logger.info(""+instance1);
        //System.out.println(instance == instance1);
        logger.info(String.valueOf(instance == instance1));

    }
}
