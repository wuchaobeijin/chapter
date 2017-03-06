package com.jfianl.builder;

import java.util.List;

/**
 * @author: wuchao
 * @date： 2017/2/27
 */
public class Test {

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
        List<Sender> senders = builder.getList();
        System.out.println(senders.size());
    }
}
