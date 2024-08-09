package menu;

import address.*;
import company.*;
import posting.*;
import product.*;
import transaction.*;
import users.*;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * AdminMenu class provides a menu interface for admin users to manage users, companies, postings, and transactions.
 */
public class AdminMenu {
    private UserServices userServices;
    private PostingServices postingService;
    private CompanyServices companyServices;
    private AddressServices addressServices;
    private ProductService productService;
    private TransactionServices transactionServices;

    /**
     * Displays the admin menu and handles user input for various admin operations.
     *
     * @param user the admin user
     */
    public void adminMenu(User user) {
        this.userServices = new UserServices();
        this.postingService = new PostingServices();
        this.companyServices = new CompanyServices();
        this.addressServices = new AddressServices();
        this.productService = new ProductService();
        this.transactionServices = new TransactionServices();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.println("Select an option:");
            System.out.println("1. View All Users");
            System.out.println("2. Delete User");
            System.out.println("3. Update User Admin Status");
            System.out.println("4. View All Companies");
            System.out.println("5. View All Postings");
            System.out.println("6. View All Transactions");
            System.out.println("7. Create Company");
            System.out.println("8. Update Company");
            System.out.println("9. Delete Company");
            System.out.println("10. Exit to Main Menu");
            switch (scanner.nextInt()) {
                case 1:
                    viewAllUsers();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    updateUserAdminStatus();
                    break;
                case 4:
                    viewAllCompanies();
                    break;
                case 5:
                    viewAllPostings();
                    break;
                case 6:
                    viewAllTransactions();
                    break;
                case 7:
                    createCompany();
                    break;
                case 8:
                    updateCompany();
                    break;
                case 9:
                    deleteCompany();
                    break;
                case 10:
                    System.out.println("Exiting to Main Menu...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    /**
     * Displays all users in the system.
     */
    private void viewAllUsers() {
        ArrayList<User> users = userServices.getAllUsers();
        System.out.printf("-----------------------------------------------------------------------------%n");
        System.out.printf(" ID |        Name        |             Email            |      Company       %n");
        System.out.printf("-----------------------------------------------------------------------------%n");
        for (User user : users) {
            Company company = new CompanyServices().getCompanyById(user.getCompanyId());
            System.out.printf("%4d|%20S|%30S|%20S%n", user.getUserId(), user.getUserName(), user.getEmail(), company.getCompanyName());
        }
    }

    /**
     * Deletes a user from the system.
     */
    private void deleteUser() {
        System.out.println("Enter the ID of the user you would like to delete:");
        Scanner scanner = new Scanner(System.in);
        User user = userServices.getUserById(scanner.nextInt());
        if (user != null) {
            postingService.deleteAllPostingsBySeller(user.getUserId());
            userServices.deleteUser(user);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    /**
     * Updates the admin status of a user.
     */
    private void updateUserAdminStatus() {
        System.out.println("Enter the ID of the user you would like to update:");
        Scanner scanner = new Scanner(System.in);
        User user = userServices.getUserById(scanner.nextInt());
        if (user != null) {
            user.setAdmin(!user.isAdmin());
            userServices.updateProfile(user);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    /**
     * Displays all companies in the system.
     */
    private void viewAllCompanies() {
        ArrayList<Company> companies = companyServices.getAllCompanies();
        System.out.printf("-------------------------------------------------------------------------------------------%n");
        System.out.printf(" ID |        Name        |                     Address                      |    Phone     %n");
        System.out.printf("-------------------------------------------------------------------------------------------%n");
        for (Company company : companies) {
            Address address = addressServices.getAddressById(company.getAddressId());
            String companyAddress = address.getStreet() + ", " + address.getCity() + ", " + address.getProvince() + " " + address.getPostalCode();
            System.out.printf("%3d|%19S|%49S|%13S%n", company.getCompanyId(), company.getCompanyName(), companyAddress, company.getCompanyPhone());
        }
    }

    /**
     * Displays all postings in the system.
     */
    private void viewAllPostings() {
        ArrayList<Posting> postings = postingService.seeAvailablePostings();
        System.out.printf("------------------------------------------------------------------------%n");
        System.out.printf(" ID |             Name             |  Quantity  |  Price  |  Seller ID  %n");
        System.out.printf("------------------------------------------------------------------------%n");
        for (Posting posting : postings) {
            Product product = productService.getProductById(posting.getProductId());
            System.out.printf("%4d|%30S|%8d LBS|$%8.2f|%13d%n", posting.getPostingId(), product.getProduct_name(), posting.getQuantity(), posting.getPrice(), posting.getSellerId());
        }
    }

    /**
     * Displays all transactions in the system.
     */
    private void viewAllTransactions() {
        ArrayList<Transaction> transactions = transactionServices.getAll();
        System.out.printf("------------------------------------------------------------------%n");
        System.out.printf(" ID |  Buyer ID  |  Seller ID  |  Prod ID  |  Quantity  |  Price  %n");
        System.out.printf("------------------------------------------------------------------%n");
        for (Transaction transaction : transactions) {
            System.out.printf("%4d|%12d|%13d|%11d|%8d LBS|$%8.2f%n", transaction.getTransactionId(), transaction.getBuyerId(), transaction.getSellerId(), transaction.getProductId(), transaction.getQuantity(), transaction.getPrice());
        }
    }

    /**
     * Creates a new company in the system.
     */
    private void createCompany() {
        Company company = new Company();
        Address address = new Address();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the company:");
        company.setCompanyName(scanner.nextLine());
        System.out.println("Enter the street address:");
        address.setStreet(scanner.nextLine());
        System.out.println("Enter the city:");
        address.setCity(scanner.nextLine());
        System.out.println("Enter the province (XX):");
        address.setProvince(scanner.nextLine());
        System.out.println("Enter the postal code (XXXXXX):");
        address.setPostalCode(scanner.nextLine());
        System.out.println("Enter the phone number (XXXXXXXXXX):");
        company.setCompanyPhone(scanner.nextLine());
        company.setAddressId(new AddressServices().addAddress(address));
        int companyID = companyServices.addCompany(company);
        System.out.println("Company created successfully.");
        System.out.println("Company ID: " + companyID);
    }

    /**
     * Updates an existing company in the system.
     */
    private void updateCompany() {
        System.out.println("Enter the company ID you would like to update:");
        Scanner scanner = new Scanner(System.in);
        Company company = companyServices.getCompanyById(scanner.nextInt());
        Address address = addressServices.getAddressById(company.getAddressId());
        if (company != null) {
            scanner.nextLine();
            System.out.println("Would like to update the company address? (Y/N)");
            if (scanner.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("Current address: " + address.getStreet() + ", " + address.getCity() + ", " + address.getProvince() + " " + address.getPostalCode());
                System.out.println("Enter the street address:");
                address.setStreet(scanner.nextLine());
                System.out.println("Enter the city:");
                address.setCity(scanner.nextLine());
                System.out.println("Enter the province (XX):");
                address.setProvince(scanner.nextLine());
                System.out.println("Enter the postal code (XXXXXX):");
                address.setPostalCode(scanner.nextLine());
                new AddressServices().updateAddress(address);
            }
            System.out.println("Would like to update the company information? (Y/N)");
            if (scanner.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("Enter the name of the company:");
                company.setCompanyName(scanner.nextLine());
                System.out.println("Enter the phone number (XXXXXXXXXX):");
                company.setCompanyPhone(scanner.nextLine());
                companyServices.updateCompany(company);
            }
        } else {
            System.out.println("Company not found.");
        }
        System.out.println("Company updated successfully.");
    }

    /**
     * Deletes a company from the system.
     */
    private void deleteCompany() {
        System.out.println("Enter the company ID you would like to delete:");
        Scanner scanner = new Scanner(System.in);
        Company company = companyServices.getCompanyById(scanner.nextInt());
        if (company != null) {
            new CompanyServices().deleteCompany(company);
            System.out.println("Company deleted successfully.");
        } else {
            System.out.println("Company not found.");
        }
    }
}