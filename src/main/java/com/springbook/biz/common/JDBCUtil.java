package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class JDBCUtil {

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql//localhost/test",
                    "dev","dev");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


}
