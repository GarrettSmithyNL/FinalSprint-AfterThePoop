package posting;

import utility.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) for the Posting entity.
 * Provides methods to perform CRUD operations on the Posting table in the database.
 */
public class PostingDAO implements DAO<Posting> {
  private Connection connection;

  /**
   * Constructor for PostingDAO.
   * Initializes the database connection.
   */
  public PostingDAO() {
    try {
      connection = DBConnection.getConnection();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Retrieves all postings from the database.
   *
   * @return an ArrayList of Posting objects
   */
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

  /**
   * Retrieves a posting by its ID.
   *
   * @param id the ID of the posting to retrieve
   * @return the Posting object with the specified ID
   */
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

  /**
   * Inserts a new posting into the database.
   *
   * @param posting the Posting object to insert
   * @return the ID of the newly inserted posting, or -1 if the insertion failed
   */
  public final int insert(Posting posting) {
    final String query = "INSERT INTO postings (seller_id, product_id, quantity, price) VALUES (?, ?, ?, ?) RETURNING posting_id";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, posting.getSellerId());
      statement.setInt(2, posting.getProductId());
      statement.setInt(3, posting.getQuantity());
      statement.setDouble(4, posting.getPrice());
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return resultSet.getInt("posting_id");
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return -1;
  }

  /**
   * Updates an existing posting in the database.
   *
   * @param posting the Posting object with updated information
   */
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

  /**
   * Deletes a posting from the database.
   *
   * @param posting the Posting object to delete
   */
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

  /**
   * Retrieves postings by seller ID.
   *
   * @param sellerId the ID of the seller whose postings to retrieve
   * @return an ArrayList of Posting objects
   */
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

  /**
   * Deletes all postings by a specific seller.
   *
   * @param sellerId the ID of the seller whose postings to delete
   */
  public final void deleteAllBySeller(int sellerId) {
    final String query = "DELETE FROM postings WHERE seller_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, sellerId);
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}