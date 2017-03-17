package com.java.ProxyTest;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author: wuchao
 * @date： 2017/3/17
 */
public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("我是一只大傻狗");
    }

    @Override
    public void run() {
        System.out.println("我奔跑迅速");
    }

}
