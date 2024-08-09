package menu;

import java.util.ArrayList;
import java.util.Scanner;

import company.*;
import posting.*;
import product.*;
import transaction.*;
import users.*;

/**
 * BuyerSubMenu class provides a menu interface for buyer users to view postings and purchase products.
 */
public class BuyerSubMenu {
    private final User buyer;
    private final Scanner scanner;
    private final PostingServices postingServices;
    private final ProductService productService;
    private final UserServices userServices;
    private final CompanyServices companyServices;
    private final TransactionServices transactionService;

    /**
     * Constructor for BuyerSubMenu.
     * Initializes the services and scanner.
     *
     * @param buyer the buyer user
     */
    public BuyerSubMenu(User buyer) {
        this.postingServices = new PostingServices();
        this.productService = new ProductService();
        this.userServices = new UserServices();
        this.companyServices = new CompanyServices();
        this.transactionService = new TransactionServices();
        this.buyer = buyer;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the buyer submenu and handles user input for various buyer operations.
     */
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nBuyer Submenu:");
            System.out.println("1. See All Postings");
            System.out.println("2. Purchase a Product");
            System.out.println("3. Exit to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAllPostings();
                    break;
                case 2:
                    purchaseProduct();
                    break;
                case 3:
                    System.out.println("Exiting to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 3);
    }

    /**
     * Displays all postings available for purchase.
     */
    private void viewAllPostings() {
        ArrayList<Posting> postings = postingServices.seeAvailablePostings();
        System.out.printf("--------------------------------------------------------------------------------%n");
        System.out.printf(" ID |             Name             |  Quantity  |  Price  |        Company      %n");
        System.out.printf("--------------------------------------------------------------------------------%n");
        for (Posting posting : postings) {
            Product product = productService.getProductById(posting.getProductId());
            Company company = companyServices.getCompanyById(userServices.getUserById(posting.getSellerId()).getCompanyId());
            System.out.printf("%4d|%30S|%8d LBS|$%8.2f|%21S%n", posting.getPostingId(), product.getProduct_name(), posting.getQuantity(), posting.getPrice(), company.getCompanyName());
        }
    }

    /**
     * Handles the purchase of a product by the buyer.
     */
    private void purchaseProduct() {
        System.out.print("Enter posting ID to purchase: ");
        int postingId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Posting posting = postingServices.seeSpecificPosting(postingId);
        if (posting == null) {
            System.out.println("Posting not found.");
            return;
        }

        System.out.print("Enter quantity to purchase: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (quantity > posting.getQuantity()) {
            System.out.println("Not enough quantity available.");
            return;
        }

        // Create a new transaction
        Transaction transaction = new Transaction(buyer.getUserId(), posting.getSellerId(), posting.getProductId(), quantity, posting.getPrice());
        transactionService.insert(transaction);

        // Update the posting quantity
        postingServices.updatePostingQuantity(postingId, posting.getQuantity() - quantity);
        System.out.println("Purchase successful.");
    }
}