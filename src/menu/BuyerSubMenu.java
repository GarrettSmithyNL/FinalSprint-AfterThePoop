package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import company.*;
import posting.*;
import product.*;
import transaction.*;
import users.*;

public class BuyerSubMenu {
    private final User buyer;
    private final Scanner scanner;

    public BuyerSubMenu(User buyer) {
        this.buyer = buyer;
        this.scanner = new Scanner(System.in);
    }

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

    private void viewAllPostings() {
        PostingServices postingServices = new PostingServices();
        ProductService productService = new ProductService();
        UserServices userServices = new UserServices();
        CompanyServices companyServices = new CompanyServices();
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
    private void purchaseProduct() {
        PostingServices postingServices = new PostingServices();
        TransactionServices transactionService = new TransactionServices();
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