package menu;

import users.UserServices;

import java.util.Scanner;
public class LoginMenu {
  public void loginMenu() {
    UserServices userServices = new UserServices();
    System.out.println("Enter your email:");
    Scanner scanner = new Scanner(System.in);
    String email = scanner.nextLine();
    System.out.println("Enter your password:");
    String password = scanner.nextLine();
    if (userServices.authenticate(email, password)) {
      System.out.println("Login successful!");
    } else {
      System.out.println("Login failed. Please try again.");
    }
  }
}
