package menu;

import users.User;
import users.UserServices;

import java.util.Scanner;

public class SubMenu {
    public void subMenu(int userId) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        User user = new UserServices().getUserById(userId);
        System.out.println("Welcome " + user.getUserName() + "!");
        while (running) {
            System.out.println("Please select an option:");
            System.out.println("1. Buyer Menu");
            System.out.println("2. Seller Menu");
            if (user.isAdmin()) {
                System.out.println("3. Admin Menu");
                System.out.println("4. Update Account");
                System.out.println("5. Logout");
            } else { // If user is not an admin, do not show admin menu options
                System.out.println("3. Update Account");
                System.out.println("4. Logout");
            }

            switch (scanner.nextInt()) {
                case 1:
                    BuyerSubMenu buyerSubMenu = new BuyerSubMenu(user);
                    buyerSubMenu.displayMenu();
                    break;
                case 2:
                    SellerSubMenu sellerSubMenu = new SellerSubMenu(user);
                    sellerSubMenu.displayMenu();
                    break;
                case 3:
                    if (user.isAdmin()) {
                        AdminMenu adminMenu = new AdminMenu();
                        adminMenu.adminMenu(user);
                    } else {
                        System.out.println("Update Account");
                    }
                    break;
                case 4:
                    if (user.isAdmin()) {
                        System.out.println("Update Account");
                    } else {
                        System.out.println("Logging out...");
                        running = false;
                    }
                    break;
                case 5:
                    if (user.isAdmin()) {
                        System.out.println("Logging out...");
                        running = false;
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        }

    }
}
