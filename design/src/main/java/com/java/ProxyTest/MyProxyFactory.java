package com.java.ProxyTest;

import java.lang.reflect.Proxy;

/**
 * @author: wuchao
 * @date： 2017/3/17
 */
public class MyProxyFactory {


        public static Object getProxy(Object target) {
            MyHandler handler = new MyHandler();
            handler.setTarget(target);
            return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
        }

}
