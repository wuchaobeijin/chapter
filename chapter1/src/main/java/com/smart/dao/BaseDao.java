package com.smart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author: wuchao
 * @date： 2017/2/20
 */
public class BaseDao<T> {

    private Class<T> entityClass;

    @Autowired
    private HibernateTemplate hibernateTemplate;


    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    /**
     * 通过反射确定子类的泛型类
     */
    public BaseDao() {
        Type genType = getClass().getGenericSuperclass();
        Type [] params = ((ParameterizedType)genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    /**
     * 根据id加载PO实例
     * @param id
     * @return 返回相应的持久化PO实例
     */
    public T load(Serializable id) {
        return (T) getHibernateTemplate().load(entityClass, id);
    }

    /**
     * 根据ID获取PO实例
     * @param id
     * @return 返回相应的持久化PO实例
     */
    public T get(Serializable id) {
        return (T) getHibernateTemplate().get(entityClass, id);
    }

    /**
     *
     * 查询所有对象
     */
    public List<T> loadAll() {
        return getHibernateTemplate().loadAll(entityClass);
    }

    /**
     * 保存
     */
    public void save(T entity) {
        getHibernateTemplate().save(entity);
    }

    /**
     * 删除
     * @param entity
     */
    public void remove(T entity) {
        getHibernateTemplate().delete(entity);
    }

    /**
     * 更新
     * @param entity
     */
    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    public List find(String hql) {
        return this.getHibernateTemplate().find(hql);
    }

    public List find(String hql, Object... params) {
        return this.getHibernateTemplate().find(hql, params);
    }

    public void initialize(Object entity) {
        getHibernateTemplate().initialize(entity);
    }
}
