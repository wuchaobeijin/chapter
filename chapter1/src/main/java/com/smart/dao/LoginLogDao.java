package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author : 吴超
 * @date : 2017-02-07
 */
@Repository
public class LoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 插入一条登录记录
     *
     * @param loginLog 登录记录
     */
    public void insertLoginLog(LoginLog loginLog) {
        String sql = "insert into t_login_log (user_id,ip,login_datetime) values (?,?,?)";
        Object[] args = new Object[]{loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(sql, args);
    }
}
