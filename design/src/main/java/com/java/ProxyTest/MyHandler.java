package com.java.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: wuchao
 * @date： 2017/3/17
 */
public class MyHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil dogUtil = new DogUtil();
        dogUtil.method1();
        Object result = method.invoke(target,args);
        dogUtil.method2();
        return result;
    }
}
