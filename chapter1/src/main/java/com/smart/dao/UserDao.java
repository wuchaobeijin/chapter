package com.smart.dao;

import com.smart.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: wuchao
 * @date： 2017/2/20
 */
@Repository
public class UserDao extends BaseDao<User> {

    private final String GET_USER_BY_USERNAME = "from user u where u.userName = ?";

    private final String QUERT_USER_BY_USERNAME = "from user u where u.user like ?";

    public User getUserByUserName(String userName) {
        List<User> userList = (List<User>) find(GET_USER_BY_USERNAME, userName);
        if (null == userList || userList.size() == 0) {
            return null;
        }
        return userList.get(0);
    }

    public List<User> queryUserByUserName(String name) {
        return (List<User>)find(QUERT_USER_BY_USERNAME,name);
    }
}
