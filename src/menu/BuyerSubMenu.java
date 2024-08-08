package menu;

import java.util.List;
import java.util.Scanner;
import posting.Posting;
import posting.PostingServices;
import transaction.Transaction;
import transaction.TransactionServices;
import users.*;

public class BuyerSubMenu {
    private final PostingServices postingServices;
    private final TransactionServices transactionService;
    private final User buyer;
    private final Scanner scanner;

    public BuyerSubMenu(PostingServices postingServices, TransactionServices transactionService, User buyer) {
        this.postingServices = postingServices;
        this.transactionService = transactionService;
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
                    seeAllPostings();
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

    private void seeAllPostings() {
        List<Posting> postings = postingServices.seeAvailablePostings();
        System.out.println("Postings:");
        for (Posting posting : postings) {
            System.out.println("ID: " + posting.getPostingId() + ", Product ID: " + posting.getProductId() +
                    ", Quantity: " + posting.getQuantity() + ", Price: " + posting.getPrice());
        }
    }
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