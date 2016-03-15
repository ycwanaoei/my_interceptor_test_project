package com.test.mytest;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static org.apache.commons.lang.StringUtils.*;

/**
  * Created by ycw on 2016/3/2.
  */
public class MD5Test {
    private static final Logger logger = LoggerFactory.getLogger(MD5Test.class);
    private static final String USER_NAME = "ycw";

    private static final String PASSWORD = "changeme";

    private static final String PASSWORD_MD5_STR = "16d3f928165f4aaf899b0f3fdd9d020a";

    private static int count = 0;

    private static String clusterNodes = "sz.ut1o.com:9100,sz.ut2o.com:9200,sz.ut3o.com:9300,sz.ut4o.com:9400,sz.ut5o.com:9500";

    static final String COLON = ":";
    static final String COMMA = ",";


    public static void main(String[] args){
        for(String clusterNode:split(clusterNodes,COMMA)){
            String str1 = substringBefore(clusterNode,COLON);
            String str2 = substringAfter(clusterNode,COLON);
            logger.info(str1+"\t\t\'"+str2+"\'");
            //System.out.println(str1+"\t\t\'"+str2+"\'");

        }
//        int record = 0;
//        shuru();
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-application.xml");
//        System.out.println(ctx.getBeanDefinitionCount());
//        ctx.getAutowireCapableBeanFactory();
//        ctx.getDisplayName();

//        while(true){
//            Long key = System.currentTimeMillis();
//            String timeToMD5 = DigestUtils.md5Hex(key.toString());
//            System.out.println("timeToMD5  " + record + "-->" + timeToMD5);
//            record++;
//        }
        System.out.println(Runtime.getRuntime().getClass());
    }

    public static void shuru() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.next();
        System.out.println("请输入密码：");
        String pwd = sc.next();
        System.err.println(pwd.replaceAll(".","*"));
        String pwdmd5 = DigestUtils.md5Hex(username+pwd);
        System.out.println("pwd-->" + pwd +"\n"+"pwdmd5-->" + pwdmd5);
        if(PASSWORD_MD5_STR.equals(pwdmd5)){
            System.out.println("密码正确！");
            if(count > 0){
                count--;
            }
            System.out.println("count-->"+count);
        }else{
            System.out.println("密码错误！！");
            count++;
            //
            System.out.println("count-->"+count);
            if(count < 3){
                shuru();
            }else{
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("你已经连续三次输入错误！账户已锁定！！");
            }
        }
    }
}
