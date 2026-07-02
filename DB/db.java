package DB;

import java.sql.*;


public class DB {
    
    static final String url = "jdbc:mysql://localhost:3306/ONLINE_STORE";
    static final String user = "root";
    static final String pass = "ZafranKhan@06";
    public static void main(String[] args) {
        
      try {
        System.out.print("Database Connection start");
        Connection connection = DriverManager.getConnection(url , user, pass);
        System.out.print("Database Connection Successfuly");
      } catch (Exception e) {
        e.getStackTrace();
      }

    }
}
