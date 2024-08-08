package utility;

import java.sql.*;
public class DBConnection {
  private static final String URL = "jdbc:postgresql://localhost:5432/AfterThePoop";
  private static final String USER = "postgres";
  private static final String PASSWORD = ""; // Your Password here!

  public static Connection getConnection() {
    Connection connection = null;
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }
}
