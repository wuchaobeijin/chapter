package com.smart.adapter;

/**
 * 接口的适配，核心思想就是不要实现接口的所有方法，而是用一个抽象类去实现，然后其他类继承该抽象类，这样就不存在接口浪费的问题
 * @author: wuchao
 * @date： 2017/2/27
 */
public interface Sourceable {
    public void method1();
    public void method2();
}
