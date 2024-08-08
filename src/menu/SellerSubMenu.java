package menu;

import posting.*;
import product.*;
import users.User;

import java.util.ArrayList;
import java.util.Scanner;

public class SellerSubMenu {
    private final Scanner scanner;
    private final User user;

    public SellerSubMenu(User user) {
        this.scanner = new Scanner(System.in);
        this.user = user;
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("1. List All Products");
            System.out.println("2. Add New Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Create new Posting");
            System.out.println("6. Edit Posting");
            System.out.println("7. Delete Posting");
            System.out.println("8. Exit to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    listAllProducts(user);
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    createPosting(user);
                    break;
                case 6:
                    updatePosting();
                    break;
                case 7:
                    deletePosting();
                    break;
                case 8:
                    System.out.println("Exiting to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 8);
    }

    private void listAllProducts(User user) {
        PostingServices postingServices = new PostingServices();
        ProductService productService = new ProductService();
        ArrayList<Posting> postings = postingServices.seeAvailablePostings();
        ArrayList<Posting> userPostings = new ArrayList<>();
        for (Posting posting : postings) {
            if (posting.getSellerId() == user.getUserId()) {
                userPostings.add(posting);
            }
        }
        System.out.printf("------------------------------------------------------------------------------------------------------%n");
        System.out.printf(" ID |             Name             |  K Per  |  P Per  |  N Per  |  Quantity  |  Price  |  Seller ID  %n");
        System.out.printf("------------------------------------------------------------------------------------------------------%n");
        for (Posting posting : userPostings) {
            Product product = productService.getProductById(posting.getProductId());
            System.out.printf("%4d|%30S|%9d|%9d|%9d|%8d LBS|$%8.2f|%13d%n", posting.getPostingId(), product.getProduct_name(), product.getK_percent(), product.getP_percent(), product.getN_percent(), posting.getQuantity(), posting.getPrice(), posting.getSellerId());
        }
    }

    private void addNewProduct() {
        ProductService productServices = new ProductService();
        Product product = new Product();
        System.out.print("Enter product name: ");
        product.setProduct_name(scanner.nextLine());
        System.out.print("Enter product description: ");
        product.setProduct_description(scanner.nextLine());
        System.out.print("Enter K%: ");
        product.setK_percent(scanner.nextInt());
        System.out.print("Enter P%: ");
        product.setP_percent(scanner.nextInt());
        System.out.print("Enter N%: ");
        product.setN_percent(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        int productID = productServices.addProduct(product);
        System.out.println("Product added successfully.");
        System.out.println("Product ID: " + productID);
    }

    private void updateProduct() {
        ProductService productService = new ProductService();
        System.out.print("Enter product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = productService.getProductById(id);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter new product name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            product.setProduct_name(name);
        }

        System.out.print("Enter new product description (leave blank to keep current): ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            product.setProduct_description(description);
        }

        System.out.print("Enter new K% (or -1 to keep current): ");
        int kPercent = scanner.nextInt();
        if (kPercent != -1) {
            product.setK_percent(kPercent);
        }

        System.out.print("Enter new P% (or -1 to keep current): ");
        int pPercent = scanner.nextInt();
        if (pPercent != -1) {
            product.setP_percent(pPercent);
        }

        System.out.print("Enter new N% (or -1 to keep current): ");
        int nPercent = scanner.nextInt();
        if (nPercent != -1) {
            product.setN_percent(nPercent);
        }
        scanner.nextLine(); // Consume newline

        productService.updateProduct(product);
        System.out.println("Product updated successfully.");
    }

    private void deleteProduct() {
        ProductService productService = new ProductService();
        System.out.print("Enter product ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        productService.deleteProduct(productService.getProductById(id));
        System.out.println("Product deleted successfully.");
    }

    private void createPosting(User user) {
        PostingServices postingServices = new PostingServices();
        Posting posting = new Posting();
        System.out.print("Enter product ID: ");
        posting.setProductId(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        System.out.print("Enter quantity: ");
        posting.setQuantity(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        System.out.print("Enter price: ");
        posting.setPrice(scanner.nextDouble());
        scanner.nextLine(); // Consume newline
        posting.setSellerId(user.getUserId());
        postingServices.createPosting(posting);
        System.out.println("Posting created successfully.");
    }

    private void updatePosting() {
        PostingServices postingServices = new PostingServices();
        System.out.print("Enter posting ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Posting posting = postingServices.seeSpecificPosting(id);
        if (posting == null) {
            System.out.println("Posting not found.");
            return;
        }

        System.out.print("Enter new product ID (or -1 to keep current): ");
        int productId = scanner.nextInt();
        if (productId != -1) {
            posting.setProductId(productId);
        }

        System.out.print("Enter new quantity (or -1 to keep current): ");
        int quantity = scanner.nextInt();
        if (quantity != -1) {
            posting.setQuantity(quantity);
        }

        System.out.print("Enter new price (or -1 to keep current): ");
        double price = scanner.nextDouble();
        if (price != -1) {
            posting.setPrice(price);
        }
        scanner.nextLine(); // Consume newline

        postingServices.updatePosting(posting);
        System.out.println("Posting updated successfully.");
    }

    private void deletePosting() {
        PostingServices postingServices = new PostingServices();
        System.out.print("Enter posting ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        postingServices.deletePosting(postingServices.seeSpecificPosting(id));
        System.out.println("Posting deleted successfully.");
    }
}
