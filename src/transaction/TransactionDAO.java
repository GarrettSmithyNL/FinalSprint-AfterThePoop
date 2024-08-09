package transaction;

import utility.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) for the Transaction entity.
 * Provides methods to perform CRUD operations on the Transaction table in the database.
 */
public class TransactionDAO implements DAO<Transaction> {
  // Connection to the database
  private Connection connection;

  /**
   * Constructor for TransactionDAO.
   * Initializes the database connection.
   */
  public TransactionDAO() {
    try {
      connection = DBConnection.getConnection();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Retrieves all transactions from the database.
   *
   * @return an ArrayList of Transaction objects
   */
  public final ArrayList<Transaction> getAll() {
    ArrayList<Transaction> transactions = new ArrayList<>();
    final String query = "SELECT * FROM transactions";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet resultSet = statement.executeQuery();
      while(resultSet.next()) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(resultSet.getInt("transaction_id"));
        transaction.setBuyerId(resultSet.getInt("buyer_id"));
        transaction.setSellerId(resultSet.getInt("seller_id"));
        transaction.setProductId(resultSet.getInt("product_id"));
        transaction.setQuantity(resultSet.getInt("quantity"));
        transaction.setPrice(resultSet.getDouble("price"));
        transactions.add(transaction);
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return transactions;
  }

  /**
   * Retrieves a transaction by its ID.
   *
   * @param id the ID of the transaction to retrieve
   * @return the Transaction object with the specified ID
   */
  public final Transaction getById(int id) {
    Transaction transaction = new Transaction();
    final String query = "SELECT * FROM transactions WHERE transaction_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        transaction.setTransactionId(resultSet.getInt("transaction_id"));
        transaction.setBuyerId(resultSet.getInt("buyer_id"));
        transaction.setSellerId(resultSet.getInt("seller_id"));
        transaction.setProductId(resultSet.getInt("product_id"));
        transaction.setQuantity(resultSet.getInt("quantity"));
        transaction.setPrice(resultSet.getDouble("price"));
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return transaction;
  }

  /**
   * Inserts a new transaction into the database.
   *
   * @param transaction the Transaction object to insert
   * @return the ID of the newly inserted transaction, or -1 if the insertion failed
   */
  public final int insert(Transaction transaction) {
    final String query = "INSERT INTO transactions (buyer_id, seller_id, product_id, quantity, price) VALUES (?, ?, ?, ?, ?) RETURNING transaction_id";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, transaction.getBuyerId());
      statement.setInt(2, transaction.getSellerId());
      statement.setInt(3, transaction.getProductId());
      statement.setInt(4, transaction.getQuantity());
      statement.setDouble(5, transaction.getPrice());
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return resultSet.getInt(1);
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return -1;
  }

  /**
   * Updates an existing transaction in the database.
   *
   * @param transaction the Transaction object with updated information
   */
  public final void update(Transaction transaction) {
    final String query = "UPDATE transactions SET buyer_id = ?, seller_id = ?, product_id = ?, quantity = ?, price = ? WHERE transaction_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, transaction.getBuyerId());
      statement.setInt(2, transaction.getSellerId());
      statement.setInt(3, transaction.getProductId());
      statement.setInt(4, transaction.getQuantity());
      statement.setDouble(5, transaction.getPrice());
      statement.setInt(6, transaction.getTransactionId());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Deletes a transaction from the database.
   *
   * @param transaction the Transaction object to delete
   */
  public final void delete(Transaction transaction) {
    final String query = "DELETE FROM transactions WHERE transaction_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, transaction.getTransactionId());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}