package com.smart.aspect;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @author: wuchao
 * @date： 2017/3/3
 */
public class Test {

    public static void main(String[] args) {
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(PreGreetingAspect.class);
        Waiter proxy = factory.getProxy();
        proxy.greetTo("wuchao");
        proxy.saveTo("wuchao");
    }



}
