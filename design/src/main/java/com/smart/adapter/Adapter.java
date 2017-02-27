package com.smart.adapter;

/**
 * 类的适配
 * @author: wuchao
 * @date： 2017/2/27
 */
public class Adapter extends Source implements Targetable {

    public void method2() {
        System.out.println("this is targetable method");
    }
}
