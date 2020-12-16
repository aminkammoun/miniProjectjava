package dao;

import java.sql.*;

public class SingletonConnection {
    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
           System.out.println("connexion etablie");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }

}
