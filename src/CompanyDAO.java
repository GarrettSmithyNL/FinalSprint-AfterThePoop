import utility.DAO;
import utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
public class CompanyDAO implements DAO<Company> {
  private Connection connection;

  public CompanyDAO() {
    try {
      connection = DBConnection.getConnection();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

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

  public final void insert(Company company) {
    final String query = "INSERT INTO company (address_id, company_name, company_phone) VALUES (?, ?, ?)";
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, company.getAddressId());
      statement.setString(2, company.getCompanyName());
      statement.setString(3, company.getCompanyPhone());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

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
