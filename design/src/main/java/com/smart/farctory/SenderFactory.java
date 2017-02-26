package com.smart.farctory;

/**
 * 工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建
 * @author: wuchao
 * @date： 2017/2/26
 */
public class SenderFactory {

//    /**
//     * 单个工厂方法和模式。
//     * @param type 传递的参数
//     * @return 发送
//     */
//    public Sender produce(String type) {
//
//        if (type.equals("mail")) {
//            return new MailSender();
//        } else if (type.equals("sms")) {
//            return new SMSSender();
//        } else {
//            System.out.println("输入参数错误");
//            return null;
//        }
//    }
//
//    /**多个工厂方法，避免参数传递错误**/
//    public Sender produceMail() {
//        return new MailSender();
//    }
//
//    public Sender produceSMS() {
//        return new SMSSender();
//    }

    /**
     * 静态方法
     */

    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SMSSender();
    }

}
