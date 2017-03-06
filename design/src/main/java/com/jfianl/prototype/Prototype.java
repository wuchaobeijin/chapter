package com.jfianl.prototype;

import java.io.*;

/**
 *  原型模型虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，该模式的思想就是一个对象
 *  作为原型，对其进行复制，克隆，产生一个和原型对象类似的新对象，复制对象用clone方法。
 * @author: wuchao
 * @date： 2017/2/27
 */
public class Prototype implements Cloneable, Serializable {


    private static final long serialVersionID = 1L;

    private String string;

    private SerializableObject obj;


    /**
     * 浅复制
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

    public Object deepClone() throws IOException,ClassNotFoundException {

        /**
         * 写入当前对象的二进制流
         */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /**
         * 读取二进制流中产生的新对象
         */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();

    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }


    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

    /**
     * 对象深浅复制
     *
     * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的
     *
     * 深复制：将一个对象复制后，不论是基本数据类型还是引用数据类型，都是重新创建的，简单的说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
     */


    class SerializableObject implements Serializable {
        private static final long serialVersionUID = 1L;
    }
}
