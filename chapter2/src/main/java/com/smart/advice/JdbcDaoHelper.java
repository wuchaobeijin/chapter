package com.smart.advice;

import java.sql.*;

/**
 * @author: wuchao
 * @date： 2017/2/14
 */
public class JdbcDaoHelper {

    private static final String USER = "root";

    private static final String PASSWORD = "";

    private static final String URL = "jdbc:mysql://localhost:3306/?数据库名";

    private static Connection connection;


    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            return connection;
        }
        return connection;
    }


    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }


    public static PreparedStatement setPreparedStament(PreparedStatement statement, Object[] args) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }
        return statement;
    }

    public static void close(PreparedStatement ps, ResultSet rs) {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
            if (ps != null) {
                ps.close();
                ps = null;
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
