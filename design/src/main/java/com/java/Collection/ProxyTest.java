package com.java.Collection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: wuchao
 * @date： 2017/3/17
 */
interface Preson
{
    void walk();
    void sayHello(String name);
}

class MyInvokationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------正在执行的方法" + method);
        System.out.println("下面是执行该方法时传入的实参为");
        if (args != null) {
            for (Object val : args) {
                System.out.println(val);
            }
        } else {
            System.out.println("调用该方法没有实参");
        }
        return null;
    }
}

public class ProxyTest {

    public static void main(String[] args) {
        InvocationHandler handler = new MyInvokationHandler();
        Preson p = (Preson) Proxy.newProxyInstance(Preson.class.getClassLoader(),new Class[]{Preson.class}, handler);
        p.walk();
        p.sayHello("孙悟空");
    }
}
