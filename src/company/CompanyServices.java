package company;

import java.util.ArrayList;

/**
 * Service class for managing Company entities.
 * Provides methods to perform CRUD operations using CompanyDAO.
 */
public class CompanyServices {
    private CompanyDAO companyDAO;

    /**
     * Constructor for CompanyServices.
     * Initializes the CompanyDAO instance.
     */
    public CompanyServices() {
        this.companyDAO = new CompanyDAO();
    }

    /**
     * Retrieves all companies from the database.
     *
     * @return an ArrayList of Company objects
     */
    public ArrayList<Company> getAllCompanies() {
        return companyDAO.getAll();
    }

    /**
     * Retrieves a company by its ID.
     *
     * @param id the ID of the company to retrieve
     * @return the Company object with the specified ID
     */
    public Company getCompanyById(int id) {
        return companyDAO.getById(id);
    }

    /**
     * Adds a new company to the database.
     *
     * @param company the Company object to add
     * @return the ID of the newly inserted company, or -1 if the insertion failed
     */
    public int addCompany(Company company) {
        return companyDAO.insert(company);
    }

    /**
     * Updates an existing company in the database.
     *
     * @param company the Company object with updated information
     */
    public void updateCompany(Company company) {
        companyDAO.update(company);
    }

    /**
     * Deletes a company from the database.
     *
     * @param company the Company object to delete
     */
    public void deleteCompany(Company company) {
        companyDAO.delete(company);
    }
}