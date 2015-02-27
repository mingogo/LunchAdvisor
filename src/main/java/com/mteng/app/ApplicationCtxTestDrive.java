package com.mteng.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mingogo on 2/26/15.
 */
public class ApplicationCtxTestDrive {
    public static void main(String argv[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(ctx.getBeanDefinitionCount() + " beans defined. ");
    }
}
