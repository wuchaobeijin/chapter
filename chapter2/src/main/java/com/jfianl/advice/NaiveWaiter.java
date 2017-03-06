package com.jfianl.advice;

/**
 * @author: wuchao
 * @date： 2017/2/14
 */
public class NaiveWaiter implements Waiter {

    public void greetTo(String name) {
        System.out.println("greet to " +  name + ".....");
    }

    public void serveTo(String name) {
        System.out.println("serving " +  name + ".....");
    }
}
