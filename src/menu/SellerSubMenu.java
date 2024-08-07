package menu;

import product.Product;
import product.ProductService;
import java.util.List;
import java.util.Scanner;

public class SellerSubMenu {
    private final ProductService productService;
    private final Scanner scanner;

    public SellerSubMenu(ProductService productService) {
        this.productService = productService;
        this.scanner = new Scanner(System.in);
    }

//    public void displayMenu() {
//        int choice;
//        do {
//            System.out.println("\nSeller Submenu:");
//            System.out.println("1. List All Products");
//            System.out.println("2. Add New Product");
//            System.out.println("3. Update Product");
//            System.out.println("4. Delete Product");
//            System.out.println("5. Exit to Main Menu");
//            System.out.print("Enter your choice: ");
//            choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    listAllProducts();
//                    break;
//                case 2:
//                    addNewProduct();
//                    break;
//                case 3:
//                    updateProduct();
//                    break;
//                case 4:
//                    deleteProduct();
//                    break;
//                case 5:
//                    System.out.println("Exiting to Main Menu...");
//                    break;
//                default:
//                    System.out.println("Invalid choice, please try again.");
//            }
//        } while (choice != 5);
//    }

//    private void listAllProducts() {
//        List<Product> products = productService.getAllProducts();
//        System.out.println("Products:");
//        for (Product product : products) {
//            System.out.println("ID: " + product.getProduct_id() + ", Name: " + product.getProduct_name() +
//                    ", Description: " + product.getProduct_description() + ", Price: " + product.getPrice() +
//                    ", K%: " + product.getK_percent() + ", P%: " + product.getP_percent() + ", N%: " + product.getN_percent());
//        }
//    }

//    private void addNewProduct() {
//        System.out.print("Enter product name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter product description: ");
//        String description = scanner.nextLine();
//        System.out.print("Enter price: ");
//        double price = scanner.nextDouble();
//        System.out.print("Enter K%: ");
//        int kPercent = scanner.nextInt();
//        System.out.print("Enter P%: ");
//        int pPercent = scanner.nextInt();
//        System.out.print("Enter N%: ");
//        int nPercent = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        Product product = new Product(0, name, description, price, kPercent, pPercent, nPercent);
//        productService.addProduct(product);
//        System.out.println("Product added successfully.");
//    }

    private void updateProduct() {
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

//        System.out.print("Enter new price (or -1 to keep current): ");
//        double price = scanner.nextDouble();
//        if (price != -1) {
//            product.setPrice(price);
//        }

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

//    private void deleteProduct() {
//        System.out.print("Enter product ID to delete: ");
//        int id = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        productService.deleteProduct(id);
//        System.out.println("Product deleted successfully.");
//    }
}
