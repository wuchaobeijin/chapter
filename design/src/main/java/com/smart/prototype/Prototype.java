package com.smart.prototype;

/**
 *  原型模型虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，该模式的思想就是一个对象
 *  作为原型，对其进行复制，克隆，产生一个和原型对象类似的新对象，复制对象用clone方法。
 * @author: wuchao
 * @date： 2017/2/27
 */
public class Prototype implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

    /**
     * 对象深浅复制
     *
     * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的
     *
     * 深复制：将一个对象复制后，不论是基本数据类型还是引用数据类型，都是重新创建的，简单的说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
     */
}
