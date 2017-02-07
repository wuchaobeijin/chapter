package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : 吴超
 * @date : 2017-02-07
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 获得匹配的数量
     *
     * @param userName 用户名
     * @param password 密码
     * @return 数量
     */
    public int getMatchCount(String userName, String password) {
        String sql = "select count(*) from t_user where user_name = ? and password = ? ";
        return jdbcTemplate.queryForInt(sql, new Object[]{userName, password});
    }

    /**
     * 根据名称查询用户信息
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    public User findUserByUserName(final String userName) {
        String sql = "select user_id, user_name from t_user where user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sql, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
            }
        });
        return user;
    }

    /**
     * 更新登录信息
     *
     * @param user 用户信息
     */
    public void updateLoginInfo(User user) {
        String sql = "update t_user set last_visit=?, last_ip=?  where user_id = ?";
        jdbcTemplate.update(sql, new Object[]{user.getLastVisit(), user.getLastIp(), user.getUserId()});
    }
}
