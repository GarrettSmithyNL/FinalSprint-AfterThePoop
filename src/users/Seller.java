package users;

import java.util.ArrayList;
import product.*;

public class Seller extends User {
    private ProductDAO productDAO;

    public Seller() {
        this.productDAO = new ProductDAO();
    }

    // Function to add new products
    public void addProduct(Product product) {
        productDAO.add(product);
    }

    // Function to update current products
    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    // Function to delete their own products
    public void deleteProduct(int productId) {
        Product product = productDAO.getById(productId);
        if (product != null && product.getSellerId() == this.getUserId()) {
            productDAO.delete(productId);
        } else {
            throw new IllegalArgumentException("You can only delete your own products!.");
        }
    }

    // Function to view a list of products
    public ArrayList<Product> viewProducts() {
        return productDAO.getAll();
    }
}