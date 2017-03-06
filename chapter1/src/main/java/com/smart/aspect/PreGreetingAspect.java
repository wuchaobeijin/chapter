package com.smart.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author: wuchao
 * @date： 2017/3/3
 */
@Aspect
public class PreGreetingAspect {

    @Before("execution(* greetTo(..))")
    public void beforeGreeing() {
        System.out.println("How are you");
    }
}
