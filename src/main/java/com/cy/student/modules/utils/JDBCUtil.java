package com.cy.student.modules.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static String url = "jdbc:mysql://rm-bp1i63m5pjswk8c64so.mysql.rds.aliyuncs.com:3306/studentmanagements?useSSL=true";
    private static String username = "root";
    private static String password = "Yuanshuai0925";
    public static Connection getConn() throws SQLException{
        return DriverManager.getConnection(url,username,password);
    }
    public static void close(Connection conn){
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        System.out.println(getConn());
    }

}
