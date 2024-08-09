package utility;

import java.sql.*;

/**
 * Utility class for managing database connections.
 * Provides a method to establish a connection to a PostgreSQL database.
 */
public class DBConnection {
  // Database URL
  private static final String URL = "jdbc:postgresql://localhost:5432/AfterThePoop";
  // Database user
  private static final String USER = "postgres";
  // Database password
  private static final String PASSWORD = ""; // Your Password here!

  /**
   * Establishes a connection to the PostgreSQL database.
   *
   * @return a Connection object to the database, or null if the connection failed
   */
  public static Connection getConnection() {
    Connection connection = null;
    try {
      // Load the PostgreSQL JDBC driver
      Class.forName("org.postgresql.Driver");
      // Establish the connection
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException e) {
      // Print the stack trace for the exception
      e.printStackTrace();
    }
    return connection;
  }
}