package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static Connection con;

    private ConnectionUtil() {
        con=null;
    }

    public static Connection getConnection(){
        try {
            if(con != null && !con.isClosed()){
                return con;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String url, user, pass;

        url = System.getenv("url");
        user = System.getenv("user");
        pass = System.getenv("pass");

        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Your password or url is wrong.");
        }
        return con;
    }
}