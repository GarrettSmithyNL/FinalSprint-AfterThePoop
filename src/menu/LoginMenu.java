package menu;

import users.*;

import java.util.Scanner;
public class LoginMenu {
  public int loginMenu() {
    UserServices userServices = new UserServices();
    System.out.println("Enter your email:");
    Scanner scanner = new Scanner(System.in);
    String email = scanner.nextLine();
    System.out.println("Enter your password:");
    String password = scanner.nextLine();
    if (userServices.authenticate(email, password)) {
      System.out.println("Login successful!");
      return userServices.getUserId(email);
    } else {
      System.out.println("Login failed. Please try again.");
      return -1;
    }
  }
}
