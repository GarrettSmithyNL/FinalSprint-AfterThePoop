package address;

import utility.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) for the Address entity.
 * Provides methods to perform CRUD operations on the Address table in the database.
 */
public class AddressDAO implements DAO<Address> {
  private Connection connection;

  /**
   * Constructor for AddressDAO.
   * Initializes the database connection.
   */
  public AddressDAO() {
    try {
      connection = DBConnection.getConnection();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Retrieves all addresses from the database.
   *
   * @return an ArrayList of Address objects
   */
  public final ArrayList<Address> getAll() {
    ArrayList<Address> addresses = new ArrayList<>();
    final String query = "SELECT * FROM address";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Address address = new Address();
        address.setAddressId(resultSet.getInt("address_id"));
        address.setStreet(resultSet.getString("street"));
        address.setCity(resultSet.getString("city"));
        address.setProvince(resultSet.getString("province"));
        address.setPostalCode(resultSet.getString("postal_code"));
        addresses.add(address);
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return addresses;
  }

  /**
   * Retrieves an address by its ID.
   *
   * @param id the ID of the address to retrieve
   * @return the Address object with the specified ID
   */
  public final Address getById(int id) {
    Address address = new Address();
    final String query = "SELECT * FROM address WHERE address_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        address.setAddressId(resultSet.getInt("address_id"));
        address.setStreet(resultSet.getString("street"));
        address.setCity(resultSet.getString("city"));
        address.setProvince(resultSet.getString("province"));
        address.setPostalCode(resultSet.getString("postal_code"));
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return address;
  }

  /**
   * Inserts a new address into the database.
   *
   * @param address the Address object to insert
   * @return the ID of the newly inserted address, or -1 if the insertion failed
   */
  public final int insert(Address address) {
    final String query = "INSERT INTO address (street, city, province, postal_code) VALUES (?, ?, ?, ?) RETURNING address_id";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setString(1, address.getStreet());
      statement.setString(2, address.getCity());
      statement.setString(3, address.getProvince());
      statement.setString(4, address.getPostalCode());
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return resultSet.getInt("address_id");
      }

    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return -1;
  }

  /**
   * Updates an existing address in the database.
   *
   * @param address the Address object with updated information
   */
  public final void update(Address address) {
    final String query = "UPDATE address SET street = ?, city = ?, province = ?, postal_code = ? WHERE address_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setString(1, address.getStreet());
      statement.setString(2, address.getCity());
      statement.setString(3, address.getProvince());
      statement.setString(4, address.getPostalCode());
      statement.setInt(5, address.getAddressId());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Deletes an address from the database.
   *
   * @param address the Address object to delete
   */
  public final void delete(Address address) {
    final String query = "DELETE FROM address WHERE address_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, address.getAddressId());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}