package com.forum.dao;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author: wuchao
 * @date： 2017/2/16
 */
@SuppressWarnings("unchecked")
public class DaoImpl<T> extends HibernateDaoSupport implements IDao {


    public Object find(Class clazz, int id) {
        return (T) getHibernateTemplate().get(clazz, id);
    }

    public void create(Object baseBean) {
        getHibernateTemplate().persist(baseBean);
    }

    public void save(Object baseBean) {
        getHibernateTemplate().save(baseBean);
    }

    public void delete(Object baseBean) {
        getHibernateTemplate().delete(baseBean);
    }

    public List list(String sql) {
        return getHibernateTemplate().find(sql);
    }

    public int getTotalCount(String hql, Object... params) {
        Query query = createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        Object object = query.uniqueResult();
        return ((Long)object).intValue();

    }

    public List list(String sql, int firstResult, int maxSize, Object... params){
        Query query = createQuery(sql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i+1, params[i]);
        }
        List<T> list = createQuery(sql).setFirstResult(firstResult).setMaxResults(maxSize).list();
        return list;
    }

    public Query createQuery(String hql) {
        return getSession().createQuery(hql);
    }
}
