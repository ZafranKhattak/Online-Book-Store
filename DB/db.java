package DB;

import java.sql.*;


public class DB {
    
    static final String url = "jdbc:mysql://localhost:3306/ONLINE_STORE";
    static final String user = "root";
    static final String pass = "ZafranKhan@06";
    public static void main(String[] args) {
        
        try
        {   
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
      try {
        System.out.println("Database Connection start");
        Connection connection = DriverManager.getConnection(url , user, pass);
        System.out.println("Database Connection Successfuly");

        connection.close();
      } catch (Exception e) {
        e.getStackTrace();
      }

    }
}
