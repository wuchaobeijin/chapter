package com.smart.aspect;

/**
 * @author: wuchao
 * @date： 2017/3/3
 */
public class NaiveWaiter implements Waiter {

    public void greetTo(String name) {
        System.out.println("NaiveWaiter: greet to " + name + ".....");
    }

    public void saveTo(String name) {
        System.out.println("NaiveWaiter: serving " + name + ".....");
    }
}
