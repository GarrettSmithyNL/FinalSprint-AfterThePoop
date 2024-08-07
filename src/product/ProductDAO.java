package product;

import product.Product;
import utility.*;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO implements DAO<Product> {
  // Connection to the database
  private Connection connection;

  // Constructor
  public ProductDAO() {
    try {
      connection = DBConnection.getConnection();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
  public final ArrayList<Product> getAll() {
    // List to store users
    ArrayList<Product> products = new ArrayList<>();
    // SQL query to get all users from the database
    final String query = "SELECT * FROM products";
    // Try to execute the query
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet resultSet = statement.executeQuery();
      // Loop through the result set
      while(resultSet.next()) {
        Product product = new Product();
        product.setProduct_id(resultSet.getInt("product_id"));
        product.setProduct_name(resultSet.getString("product_name"));
        product.setProduct_description(resultSet.getString("product_description"));
        product.setK_percent(resultSet.getInt("k_percent"));
        product.setP_percent(resultSet.getInt("p_percent"));
        product.setN_percent(resultSet.getInt("n_percent"));
        products.add(product);
      }
    } catch (SQLException e) {
      // Print the error message
      System.out.println("Error: " + e.getMessage());
    }
    return products;
  }

  public final Product getById(int id) {
    // users.User object to store the result
    Product product = new Product();
    // SQL query to get a user by id
    final String query = "SELECT * FROM products WHERE product_id = ?";
    // Try to execute the query
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      // If there is a result
      if (resultSet.next()) {
        product.setProduct_id(resultSet.getInt("product_id"));
        product.setProduct_name(resultSet.getString("product_name"));
        product.setProduct_description(resultSet.getString("product_description"));
        product.setK_percent(resultSet.getInt("k_percent"));
        product.setP_percent(resultSet.getInt("p_percent"));
        product.setN_percent(resultSet.getInt("n_percent"));
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return product;
  }

  public final int insert(Product product) {
    // SQL query to insert a user into the database
    final String query = "INSERT INTO products (product_name, product_description, k_percent, p_percent, n_percent) VALUES (?, ?, ?, ?, ?) RETURNING product_id";
    // Try to execute the query
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setString(1, product.getProduct_name());
      statement.setString(2, product.getProduct_description());
      statement.setInt(3, product.getK_percent());
      statement.setInt(4, product.getP_percent());
      statement.setInt(5, product.getN_percent());
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return resultSet.getInt("product_id");
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return -1;
  }

  public final void update(Product product) {
    // SQL query to update a user in the database
    final String query = "UPDATE products SET product_name = ?, product_description = ?, k_percent = ?, p_percent = ?, n_percent = ? WHERE user_id = ?";
    // Try to execute the query
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setString(1, product.getProduct_name());
      statement.setString(2, product.getProduct_description());
      statement.setInt(3, product.getK_percent());
      statement.setInt(4, product.getP_percent());
      statement.setInt(5, product.getN_percent());
      statement.setInt(6, product.getProduct_id());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public final void delete(Product product) {
    // SQL query to delete a user from the database
    final String query = "DELETE FROM products WHERE product_id = ?";
    // Try to execute the query
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, product.getProduct_id());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

}
