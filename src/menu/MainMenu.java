package menu;

import java.util.Scanner;

/**
 * MainMenu class provides the main menu interface for the application.
 * It allows users to login, register, or exit the application.
 */
public class MainMenu {

  /**
   * Displays the main menu and handles user input for various operations.
   */
  public void mainMenu() {
    boolean running = true;
    System.out.println("Welcome to After The Poop!");
    System.out.println("Your Personal Fertilizer reseller!");
    Scanner scanner = new Scanner(System.in);
    while (running) {
      System.out.println("Please follow the menu options below:");
      System.out.println("1. Login");
      System.out.println("2. Register");
      System.out.println("3. Exit");
      switch (scanner.nextInt()) {
        case 1:
          LoginMenu loginMenu = new LoginMenu();
          int loggedInUserId = loginMenu.loginMenu();
          if (loggedInUserId != -1) {
            SubMenu subMenu = new SubMenu();
            subMenu.subMenu(loggedInUserId);
          }
          break;
        case 2:
          RegistrationMenu registrationMenu = new RegistrationMenu();
          registrationMenu.registrationMenu();
          break;
        case 3:
          System.out.println("Thank you for visiting After The Poop!");
          running = false;
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }
    }
    scanner.close();
  }

  /**
   * The main method to start the application.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    MainMenu mainMenu = new MainMenu();
    mainMenu.mainMenu();
  }
}