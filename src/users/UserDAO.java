package users;

import utility.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) for the User entity.
 * Provides methods to perform CRUD operations on the User table in the database.
 */
public class UserDAO implements DAO<User> {
  // Connection to the database
  private Connection connection;

  /**
   * Constructor for UserDAO.
   * Initializes the database connection.
   */
  public UserDAO() {
    try {
      // Get the connection to the database
      connection = DBConnection.getConnection();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Retrieves all users from the database.
   *
   * @return an ArrayList of User objects
   */
  public final ArrayList<User> getAll() {
    // List to store users
    ArrayList<User> users = new ArrayList<>();
    // SQL query to get all users from the database
    final String query = "SELECT * FROM users";
    // Try to execute the query
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet resultSet = statement.executeQuery();
      // Loop through the result set
      while(resultSet.next()) {
        User user = new User();
        user.setUserId(resultSet.getInt("user_id"));
        user.setAddressId(resultSet.getInt("address_id"));
        user.setCompanyId(resultSet.getInt("company_id"));
        user.setUserName(resultSet.getString("user_name"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setUserPhone(resultSet.getString("user_phone"));
        user.setAdmin(resultSet.getBoolean("is_admin"));
        users.add(user);
      }
    } catch (SQLException e) {
      // Print the error message
      System.out.println("Error: " + e.getMessage());
    }
    return users;
  }

  /**
   * Retrieves a user by its ID.
   *
   * @param id the ID of the user to retrieve
   * @return the User object with the specified ID
   */
  public final User getById(int id) {
    // User object to store the result
    User user = new User();
    // SQL query to get a user by id
    final String query = "SELECT * FROM users WHERE user_id = ?";
    // Try to execute the query
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      // If there is a result
      if (resultSet.next()) {
        user.setUserId(resultSet.getInt("user_id"));
        user.setAddressId(resultSet.getInt("address_id"));
        user.setCompanyId(resultSet.getInt("company_id"));
        user.setUserName(resultSet.getString("user_name"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setUserPhone(resultSet.getString("user_phone"));
        user.setAdmin(resultSet.getBoolean("is_admin"));
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return user;
  }

  /**
   * Inserts a new user into the database.
   *
   * @param user the User object to insert
   * @return the ID of the newly inserted user, or -1 if the insertion failed
   */
  public final int insert(User user) {
    // SQL query to insert a user into the database
    final String query = "INSERT INTO users (address_id, company_id, user_name, email, password, user_phone, is_admin) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING user_id";
    // Try to execute the query
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, user.getAddressId());
      statement.setInt(2, user.getCompanyId());
      statement.setString(3, user.getUserName());
      statement.setString(4, user.getEmail());
      statement.setString(5, user.getPassword());
      statement.setString(6, user.getUserPhone());
      statement.setBoolean(7, user.isAdmin());
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return resultSet.getInt("user_id");
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return -1;
  }

  /**
   * Updates an existing user in the database.
   *
   * @param user the User object with updated information
   */
  public final void update(User user) {
    // SQL query to update a user in the database
    final String query = "UPDATE users SET address_id = ?, company_id = ?, user_name = ?, email = ?, password = ?, user_phone = ?, is_admin = ? WHERE user_id = ?";
    // Try to execute the query
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, user.getAddressId());
      statement.setInt(2, user.getCompanyId());
      statement.setString(3, user.getUserName());
      statement.setString(4, user.getEmail());
      statement.setString(5, user.getPassword());
      statement.setString(6, user.getUserPhone());
      statement.setBoolean(7, user.isAdmin());
      statement.setInt(8, user.getUserId());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Deletes a user from the database.
   *
   * @param user the User object to delete
   */
  public final void delete(User user) {
    // SQL query to delete a user from the database
    final String query = "DELETE FROM users WHERE user_id = ?";
    // Try to execute the query
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, user.getUserId());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Retrieves a user by its email.
   *
   * @param email the email of the user to retrieve
   * @return the User object with the specified email
   */
  public User getByEmail(String email) {
    User user = null;
    final String query = "SELECT * FROM users WHERE email = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            user = new User();
            user.setUserId(resultSet.getInt("user_id"));
            user.setAddressId(resultSet.getInt("address_id"));
            user.setCompanyId(resultSet.getInt("company_id"));
            user.setUserName(resultSet.getString("user_name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setUserPhone(resultSet.getString("user_phone"));
            user.setAdmin(resultSet.getBoolean("is_admin"));
        }
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
    return user;
  }
}