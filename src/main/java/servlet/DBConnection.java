package servlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;

    public static Connection getConnection(){

        try{

            Class.forName(
                "com.mysql.cj.jdbc.Driver"
            );

            con = DriverManager.getConnection(

                "jdbc:mysql://localhost:3306/collegefee",
                "root",
                "password"
            );

            System.out.println(
                "Database Connected Successfully"
            );

        } catch(Exception e){

            e.printStackTrace();
        }

        return con;
    }
}