package users;

import users.User;
import utility.*;

import static java.lang.StringTemplate.STR;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements DAO<User> {
  // Connection to the database
  private Connection connection;

  // Constructor
  public UserDAO() {
    try {
      // Get the connection to the database
      connection = DBConnection.getConnection();
    } catch (Exception e) {
      System.out.println(STR."Error: \{e.getMessage()}");
    }
  }
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
      System.out.println(STR."Error: \{e.getMessage()}");
    }
    return users;
  }

  public final User getById(int id) {
    // users.User object to store the result
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
      System.out.println(STR."Error: \{e.getMessage()}");
    }
    return user;
  }

  public final void insert(User user) {
    // SQL query to insert a user into the database
    final String query = "INSERT INTO users (address_id, company_id, user_name, email, password, user_phone, is_admin) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println(STR."Error: \{e.getMessage()}");
    }
  }

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
      System.out.println(STR."Error: \{e.getMessage()}");
    }
  }

  public final void delete(User user) {
    // SQL query to delete a user from the database
    final String query = "DELETE FROM users WHERE user_id = ?";
    // Try to execute the query
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, user.getUserId());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println(STR."Error: \{e.getMessage()}");
    }
  }

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
