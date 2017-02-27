package com.smart.adapter;

/**
 * 对象的适配
 * @author: wuchao
 * @date： 2017/2/27
 */
public class Wrapper implements Targetable {

    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    public void method2() {
        System.out.println("this is targetable method");
    }

    public void method1() {
        source.method1();
    }
}
