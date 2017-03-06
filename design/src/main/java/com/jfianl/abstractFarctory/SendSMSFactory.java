package com.jfianl.abstractFarctory;

/**
 * @author: wuchao
 * @date： 2017/2/27
 */
public class SendSMSFactory implements Provider {
    public Sender produce() {
        return new SMSSender();
    }
}
