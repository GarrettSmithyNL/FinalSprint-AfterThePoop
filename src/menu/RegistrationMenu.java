package menu;

import address.*;
import users.*;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Scanner;

/**
 * RegistrationMenu class provides a menu interface for user registration.
 */
public class RegistrationMenu {

    /**
     * Displays the registration menu and handles user input for creating a new account.
     */
    public void registrationMenu() {
        Scanner scanner = new Scanner(System.in);
        User newUser = new User();
        Address newAddress = new Address();

        System.out.println("To create an account please have your company ID ready.");
        System.out.println("If you do not have a company ID, please contact your company's administrator.");

        System.out.println("Enter your name:");
        newUser.setUserName(scanner.nextLine());

        System.out.println("Enter your email:");
        newUser.setEmail(scanner.nextLine());

        System.out.println("Enter your phone number (XXXXXXXXXX):");
        newUser.setUserPhone(scanner.nextLine());

        System.out.println("Enter your street:");
        newAddress.setStreet(scanner.nextLine());

        System.out.println("Enter your city:");
        newAddress.setCity(scanner.nextLine());

        System.out.println("Enter your province (XX):");
        newAddress.setProvince(scanner.nextLine());

        System.out.println("Enter your postal code (XXXXXX):");
        newAddress.setPostalCode(scanner.nextLine());

        newUser.setAddressId(new AddressServices().addAddress(newAddress));

        System.out.println("Enter your company ID:");
        newUser.setCompanyId(scanner.nextInt());

        System.out.println("Enter your password:");
        newUser.setPassword(BCrypt.hashpw(scanner.next(), BCrypt.gensalt()));

        System.out.println("Your user ID is: " + new UserServices().register(newUser));
    }
}