package company;

import utility.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) for the Company entity.
 * Provides methods to perform CRUD operations on the Company table in the database.
 */
public class CompanyDAO implements DAO<Company> {
  private Connection connection;

  /**
   * Constructor for CompanyDAO.
   * Initializes the database connection.
   */
  public CompanyDAO() {
    try {
      connection = DBConnection.getConnection();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Retrieves all companies from the database.
   *
   * @return an ArrayList of Company objects
   */
  public final ArrayList<Company> getAll() {
    ArrayList<Company> companies = new ArrayList<>();
    final String query = "SELECT * FROM company";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Company company = new Company();
        company.setCompanyId(resultSet.getInt("company_id"));
        company.setAddressId(resultSet.getInt("address_id"));
        company.setCompanyName(resultSet.getString("company_name"));
        company.setCompanyPhone(resultSet.getString("company_phone"));
        companies.add(company);
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return companies;
  }

  /**
   * Retrieves a company by its ID.
   *
   * @param id the ID of the company to retrieve
   * @return the Company object with the specified ID
   */
  public final Company getById(int id) {
    Company company = new Company();
    final String query = "SELECT * FROM company WHERE company_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        company.setCompanyId(resultSet.getInt("company_id"));
        company.setAddressId(resultSet.getInt("address_id"));
        company.setCompanyName(resultSet.getString("company_name"));
        company.setCompanyPhone(resultSet.getString("company_phone"));
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return company;
  }

  /**
   * Inserts a new company into the database.
   *
   * @param company the Company object to insert
   * @return the ID of the newly inserted company, or -1 if the insertion failed
   */
  public final int insert(Company company) {
    final String query = "INSERT INTO company (address_id, company_name, company_phone) VALUES (?, ?, ?) RETURNING company_id";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, company.getAddressId());
      statement.setString(2, company.getCompanyName());
      statement.setString(3, company.getCompanyPhone());
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return resultSet.getInt("company_id");
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
    return -1;
  }

  /**
   * Updates an existing company in the database.
   *
   * @param company the Company object with updated information
   */
  public final void update(Company company) {
    final String query = "UPDATE company SET address_id = ?, company_name = ?, company_phone = ? WHERE company_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, company.getAddressId());
      statement.setString(2, company.getCompanyName());
      statement.setString(3, company.getCompanyPhone());
      statement.setInt(4, company.getCompanyId());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Deletes a company from the database.
   *
   * @param company the Company object to delete
   */
  public final void delete(Company company) {
    final String query = "DELETE FROM company WHERE company_id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, company.getCompanyId());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}