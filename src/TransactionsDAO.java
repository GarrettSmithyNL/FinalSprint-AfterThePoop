import java.sql.*;
import java.util.ArrayList;
public class TransactionsDAO implements DAO<Transaction>{
  private Connection connection;

  public TransactionsDAO() {
    try {
      connection = DBConnection.getConnection();
    } catch (Exception e) {
      System.out.println(STR."Error: \{e.getMessage()}");
    }
  }

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
      System.out.println(STR."Error: \{e.getMessage()}");
    }
    return transactions;
  }

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
      System.out.println(STR."Error: \{e.getMessage()}");
    }
    return transaction;
  }

  public final void insert(Transaction transaction) {
    final String query = "INSERT INTO transactions (buyer_id, seller_id, product_id, quantity, price) VALUES (?, ?, ?, ?, ?)";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, transaction.getBuyerId());
      statement.setInt(2, transaction.getSellerId());
      statement.setInt(3, transaction.getProductId());
      statement.setInt(4, transaction.getQuantity());
      statement.setDouble(5, transaction.getPrice());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println(STR."Error: \{e.getMessage()}");
    }
  }

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
      System.out.println(STR."Error: \{e.getMessage()}");
    }
  }

  public final void delete(Transaction transaction) {
    final String query = "DELETE FROM transactions WHERE transaction_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, transaction.getTransactionId());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println(STR."Error: \{e.getMessage()}");
    }
  }
}
