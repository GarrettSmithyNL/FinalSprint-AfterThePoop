package product;

import product.Product;
import utility.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) for the Product entity.
 * Provides methods to perform CRUD operations on the Product table in the database.
 */
public class ProductDAO implements DAO<Product> {
  // Connection to the database
  private Connection connection;

  /**
   * Constructor for ProductDAO.
   * Initializes the database connection.
   */
  public ProductDAO() {
    try {
      connection = DBConnection.getConnection();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Retrieves all products from the database.
   *
   * @return an ArrayList of Product objects
   */
  public final ArrayList<Product> getAll() {
    // List to store products
    ArrayList<Product> products = new ArrayList<>();
    // SQL query to get all products from the database
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

  /**
   * Retrieves a product by its ID.
   *
   * @param id the ID of the product to retrieve
   * @return the Product object with the specified ID
   */
  public final Product getById(int id) {
    // Product object to store the result
    Product product = new Product();
    // SQL query to get a product by id
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

  /**
   * Inserts a new product into the database.
   *
   * @param product the Product object to insert
   * @return the ID of the newly inserted product, or -1 if the insertion failed
   */
  public final int insert(Product product) {
    // SQL query to insert a product into the database
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

  /**
   * Updates an existing product in the database.
   *
   * @param product the Product object with updated information
   */
  public final void update(Product product) {
    // SQL query to update a product in the database
    final String query = "UPDATE products SET product_name = ?, product_description = ?, k_percent = ?, p_percent = ?, n_percent = ? WHERE product_id = ?";
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

  /**
   * Deletes a product from the database.
   *
   * @param product the Product object to delete
   */
  public final void delete(Product product) {
    // SQL query to delete a product from the database
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