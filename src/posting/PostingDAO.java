package posting;

import utility.*;
import java.sql.*;
import java.util.ArrayList;

public class PostingDAO implements DAO<Posting> {
  private Connection connection;

  public PostingDAO() {
    try {
      connection = DBConnection.getConnection();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public final ArrayList<Posting> getAll() {
    ArrayList<Posting> postings = new ArrayList<>();
    final String query = "SELECT * FROM postings";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet resultSet = statement.executeQuery();
      while(resultSet.next()) {
        Posting posting = new Posting();
        posting.setPostingId(resultSet.getInt("posting_id"));
        posting.setSellerId(resultSet.getInt("seller_id"));
        posting.setProductId(resultSet.getInt("product_id"));
        posting.setQuantity(resultSet.getInt("quantity"));
        posting.setPrice(resultSet.getDouble("price"));
        postings.add(posting);
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return postings;
  }

  public final Posting getById(int id) {
    Posting posting = new Posting();
    final String query = "SELECT * FROM postings WHERE posting_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        posting.setPostingId(resultSet.getInt("posting_id"));
        posting.setSellerId(resultSet.getInt("seller_id"));
        posting.setProductId(resultSet.getInt("product_id"));
        posting.setQuantity(resultSet.getInt("quantity"));
        posting.setPrice(resultSet.getDouble("price"));
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return posting;
  }

  public final void insert(Posting posting) {
    final String query = "INSERT INTO postings (seller_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, posting.getSellerId());
      statement.setInt(2, posting.getProductId());
      statement.setInt(3, posting.getQuantity());
      statement.setDouble(4, posting.getPrice());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public final void update(Posting posting) {
    final String query = "UPDATE postings SET seller_id = ?, product_id = ?, quantity = ?, price = ? WHERE posting_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, posting.getSellerId());
      statement.setInt(2, posting.getProductId());
      statement.setInt(3, posting.getQuantity());
      statement.setDouble(4, posting.getPrice());
      statement.setInt(5, posting.getPostingId());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public final void delete(Posting posting) {
    final String query = "DELETE FROM postings WHERE posting_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, posting.getPostingId());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public final ArrayList<Posting> getBySellerId(int sellerId) {
    ArrayList<Posting> postings = new ArrayList<>();
    final String query = "SELECT * FROM postings WHERE seller_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, sellerId);
      ResultSet resultSet = statement.executeQuery();
      while(resultSet.next()) {
        Posting posting = new Posting();
        posting.setPostingId(resultSet.getInt("posting_id"));
        posting.setSellerId(resultSet.getInt("seller_id"));
        posting.setProductId(resultSet.getInt("product_id"));
        posting.setQuantity(resultSet.getInt("quantity"));
        posting.setPrice(resultSet.getDouble("price"));
        postings.add(posting);
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return postings;
  }
}
