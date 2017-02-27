package com.smart.abstractFarctory;

/**
 * @author: wuchao
 * @date： 2017/2/27
 */
public class SendMailFactory implements Provider {
    public Sender produce() {
        return new MailSender();
    }
}
