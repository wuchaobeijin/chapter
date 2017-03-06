package com.jfianl.builder;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: wuchao
 * @date： 2017/2/27
 */
public class Builder {

    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count) {
        for (int i = 0; i <count; i++) {
            list.add(new SMSSender());
        }
    }

    public List<Sender> getList() {
        return list;
    }
}
