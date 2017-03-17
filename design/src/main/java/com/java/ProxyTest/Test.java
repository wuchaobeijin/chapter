package com.java.ProxyTest;

/**
 * @author: wuchao
 * @date： 2017/3/17
 */
public class Test {
    public static void main(String[] args) {
        Dog target = new GunDog();
        Dog dog = (Dog) MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }
}
