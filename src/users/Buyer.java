package users;

import java.util.ArrayList;

public class Buyer extends User {
    private ProductDAO productDAO;

    public Buyer() {
        this.productDAO = new ProductDAO();
    }

    // Function to see all available products
    public ArrayList<Product> seeAvailableProducts() {
        return productDAO.getAll();
    }

    // Function to search for specific products by name
    public ArrayList<Product> searchProducts(String productName) {
        ArrayList<Product> allProducts = productDAO.getAll();
        ArrayList<Product> filteredProducts = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getProductName().toLowerCase().contains(productName.toLowerCase())) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    // Function to expand product details by product ID
    public Product expandProductDetails(int productId) {
        return productDAO.getById(productId);
    }
}

