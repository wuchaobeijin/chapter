package com.smart.dao;

/**
 * @author: wuchao
 * @date： 2017/2/14
 */
public interface BaseDao<T> {
    void operator(T t, String type);
    T select(T t);
}
