package company;

import java.util.ArrayList;

public class CompanyServices {
    private CompanyDAO companyDAO;

    public CompanyServices() {
        this.companyDAO = new CompanyDAO();
    }

    public ArrayList<Company> getAllCompanies() {
        return companyDAO.getAll();
    }

    public Company getCompanyById(int id) {
        return companyDAO.getById(id);
    }

    public void addCompany(Company company) {
        companyDAO.insert(company);
    }

    public void updateCompany(Company company) {
        companyDAO.update(company);
    }

    public void deleteCompany(Company company) {
        companyDAO.delete(company);
    }
}