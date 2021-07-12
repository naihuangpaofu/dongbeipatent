package com.ljy.test;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LjyTest {
    static String URL= "jdbc:mysql://192.168.80.151:3306/shop?useUnicode=true&characterEncoding=utf8";
    static String USERNAME = "root";
    static String PASSWORD = "123456";
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            read();
        });
        service.execute(()->{
            write();
        });
    }
    public static void read() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            TimeUnit.SECONDS.sleep(1);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            pstmt = con.prepareStatement("select id,name,active from ums_role");
            rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null)
                    rs.close();
                if(pstmt != null)
                    pstmt.close();
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void write() {
        Connection con = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            con.setAutoCommit(false);
            pstmt = con.prepareStatement("update ums_role set name = ? where id=?");
            pstmt.setString(1, "董事长");
            pstmt.setInt(2, 1);
            int i = pstmt.executeUpdate();
            System.out.println(i);
            System.out.println("修改成功");
            TimeUnit.SECONDS.sleep(3);
            int j = 100 / 0;
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
