package com.forum.dao;


import org.hibernate.Query;

import java.util.List;

/**
 * @author: wuchao
 * @date： 2017/2/16
 */
public interface IDao<T> {

    public T find(Class<T> clazz, int id);

    public void create(T baseBean);
    public void save(T baseBean);
    public void delete(T baseBean);
    public List<T> list(String sql);
    public int getTotalCount(String hql, Object... params);
    public List<T> list(String sql, int firstResult, int maxSize,Object... params);
    public Query createQuery(String hql);
}
