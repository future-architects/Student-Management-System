package com.cy.student.modules.utils;

import java.sql.*;

public class SqlToMap {

   public static Integer count(String sql) throws SQLException {

       int count = 0;
       Connection conn = JDBCUtil.getConn();
       Statement stmt = null;
       try {
           stmt = conn.createStatement();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       ResultSet rs = null;
//       String sql = "SELECT COUNT(bid) FROM book";
       try {
           stmt = conn.createStatement();
           rs = stmt.executeQuery(sql);
           if (rs.next()) {
               count = rs.getInt(1);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           conn.close();
           stmt.close();
           rs.close();
       }
       return count;
   }





}
