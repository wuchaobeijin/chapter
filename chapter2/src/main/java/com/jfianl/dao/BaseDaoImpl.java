package com.jfianl.dao;


import com.jfianl.advice.JdbcDaoHelper;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * DAO层操作类
 * @author: wuchao
 * @date： 2017/2/14
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    /**
     * 操作常量
     **/

    private static final String SQL_INSERT = "insert";
    private static final String SQL_UPDATE = "update";
    private static final String SQL_DELETE = "delete";
    private static final String SQL_SELECT = "select";

    private Class<T> entityClass;

    private PreparedStatement statement;

    private String sql;

    private Object argType[];

    private ResultSet resultSet;


    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) getClass()
                .getGenericSuperclass();

        entityClass = (Class<T>) type.getActualTypeArguments()[0];

    }

    /**
     * 增加，删除，更新操作
     *
     * @param t    实体类
     * @param type 操作类型
     */
    public void operator(T t, String type) {
        sql = this.getSql(type);
        try {
            argType = this.setArgs(t, type);
            statement = JdbcDaoHelper.getPreparedStatement(sql);
            statement = JdbcDaoHelper.setPreparedStament(statement, argType);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcDaoHelper.close(statement, null);
        }
    }


    public T select(T t) {
        sql = getSql(SQL_SELECT);
        T obj = null;
        try {
            argType = setArgs(t, SQL_SELECT);
            statement = JdbcDaoHelper.getPreparedStatement(sql);
            statement = JdbcDaoHelper.setPreparedStament(statement, argType);
            resultSet = statement.executeQuery();
            Field fields[] = entityClass.getDeclaredFields();
            while (resultSet.next()) {
                obj = entityClass.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    fields[i].set(obj, resultSet.getObject(fields[i].getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


    private String getSql(String operator) {
        StringBuffer sql = new StringBuffer();
        Field fields[] = entityClass.getDeclaredFields();
        if (operator.equals(SQL_INSERT)) {
            sql.append("insert into " + entityClass.getSimpleName());
            sql.append("(");
            for (int i = 0; fields != null && i < fields.length; i++) {
                fields[i].setAccessible(true);
                sql.append(fields[i].getName()).append(",");
            }
            sql = sql.deleteCharAt(sql.length() - 1);
            sql.append(") values ( ");
            for (int i = 0; fields != null && i < fields.length; i++) {
                sql.append("?,");
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(")");
        } else if (operator.equals(SQL_UPDATE)) {
            sql.append("update " + entityClass.getSimpleName() + " set ");
            for (int i = 0; fields != null && i < fields.length; i++) {
                fields[i].setAccessible(true);
                String column = fields[i].getName();
                if (column.equals("id")) {
                    continue;
                }
                sql.append(column).append(" = ").append(" ?,");
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append("where id = ? ");
        } else if (operator.equals(SQL_DELETE)) {
            sql.append("delete from " + entityClass.getSimpleName()
                    + " where id=?");
        } else if (operator.equals(SQL_SELECT)) {
            sql.append("select * from " + entityClass.getSimpleName()
                    + " where id=?");
        }

        return sql.toString();
    }

    private Object[] setArgs(T entity, String operator) throws Exception {
        Field fields[] = entityClass.getDeclaredFields();
        if (operator.equals(SQL_INSERT)) {
            Object[] objects = new Object[fields.length];
            for (int i = 0; objects != null && i < fields.length; i++) {
                fields[i].setAccessible(true);
                objects[i] = fields[i].get(entity);
            }
            return objects;
        } else if (operator.equals(SQL_UPDATE)) {
            Object Tempobj[] = new Object[fields.length];
            for (int i = 0; Tempobj != null && i < fields.length; i++) {
                fields[i].setAccessible(true);
                Tempobj[i] = fields[i].get(entity);
            }
            Object object[] = new Object[fields.length];
            System.arraycopy(Tempobj, 1, object, 0, Tempobj.length - 1);
            object[object.length - 1] = Tempobj[0];
            return object;
        } else if (operator.equals(SQL_DELETE)) {
            Object obj[] = new Object[1];
            fields[0].setAccessible(true);
            obj[0] = fields[0].get(entity);
            return obj;
        } else if (operator.equals(SQL_SELECT)) {
            Object obj[] = new Object[1];
            fields[0].setAccessible(true);
            obj[0] = fields[0].get(entity);
            return obj;
        }
        return null;
    }
}
