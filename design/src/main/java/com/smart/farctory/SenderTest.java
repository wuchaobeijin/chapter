package com.smart.farctory;

/**
 * @author: wuchao
 * @date： 2017/2/26
 */
public class SenderTest {

    public static void main(String[] args) {
        Sender sender = SenderFactory.produceMail();
        sender.sender();
    }
}
