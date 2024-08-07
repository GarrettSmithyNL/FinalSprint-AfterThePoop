package menu;

import company.*;
import posting.*;
import users.*;

import java.util.Scanner;
import java.util.ArrayList;

public class AdminMenu {
    public void adminMenu(User user) {
      boolean running = true;
      Scanner scanner = new Scanner(System.in);
      while (running) {
        System.out.println("Admin Menu");
        System.out.println("Select an option:");
        System.out.println("1. View All Users");
        System.out.println("2. Delete User");
        System.out.println("3. View All Companies");
        System.out.println("4. View All Postings");
        System.out.println("5. View All Transactions");
        System.out.println("6. Create Company");
        System.out.println("7. Update Company");
        System.out.println("8. Delete Company");
        switch (scanner.nextInt()) {
          case 1:
            viewAllUsers();
            break;
          case 2:
            deleteUser();
            break;
          case 3:
            System.out.println("View All Companies");
            break;
          case 4:
            System.out.println("View All Postings");
            break;
          case 5:
            System.out.println("View All Transactions");
            break;
          case 6:
            System.out.println("Create Company");
            break;
          case 7:
            System.out.println("Update Company");
            break;
          case 8:
            System.out.println("Delete Company");
            break;
          default:
            System.out.println("Invalid option. Please try again.");
            break;
        }
      }
    }

    private void viewAllUsers() {
        UserServices userServices = new UserServices();
        ArrayList<User> users = userServices.getAllUsers();
        System.out.printf("-----------------------------------------------------------------------------%n");
        System.out.printf(" ID |        Name        |             Email            |      Company       %n");
        System.out.printf("-----------------------------------------------------------------------------%n");
        for (User user : users) {
          Company company = new CompanyServices().getCompanyById(user.getCompanyId());

            System.out.printf("%4d|%20S|%30S|%20S%n", user.getUserId(), user.getUserName(), user.getEmail(), company.getCompanyName());
        }
    }

    private void deleteUser() {
        UserServices userServices = new UserServices();
        PostingServices postingService = new PostingServices();
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

  private void viewAllCompanies() {
    UserServices userServices = new UserServices();
    ArrayList<User> users = userServices.getAllUsers();
    System.out.printf("-----------------------------------------------------------------------------%n");
    System.out.printf(" ID |        Name        |             Email            |      Company       %n");
    System.out.printf("-----------------------------------------------------------------------------%n");
    for (User user : users) {
      Company company = new CompanyServices().getCompanyById(user.getCompanyId());

      System.out.printf("-%4d|-%19S |-%29S |-%19S %n", user.getUserId(), user.getUserName(), user.getEmail(), company.getCompanyName());
    }
  }
}
