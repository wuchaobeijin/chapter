package org.jfinal.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * @author: wuchao
 * @date： 2017/3/8
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    public static final User dao = new User();

    public User checkLogin(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        return dao.findFirst(sql, username, password);
    }


}
