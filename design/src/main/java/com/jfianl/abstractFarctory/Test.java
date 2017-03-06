package com.jfianl.abstractFarctory;

/**
 * 工厂类实现业务接口。
 * 如果想新增一个功能，比如发送及时消息，做一个实现类，实现sende接口，同时做一个工厂类。实现provider接口。
 * 无需去改动现成的代码，扩展性很好。
 * @author: wuchao
 * @date： 2017/2/27
 */
public class Test {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        provider.produce().sender();
    }
}
