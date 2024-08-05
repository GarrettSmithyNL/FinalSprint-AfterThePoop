// src/Admin.java
import java.util.ArrayList;

public class Admin extends User {
    private UserDAO userDAO;
    private ProductDAO productDAO;

    public Admin() {
        this.userDAO = new UserDAO();
        this.productDAO = new ProductDAO();
    }

    // Function to view list of all users
    public ArrayList<User> viewAllUsers() {
        return userDAO.getAll();
    }

    // Function to delete users by user ID
    public void deleteUser(int userId) {
        userDAO.delete(userId);
    }

    // Function to see list of all items with seller information
    public ArrayList<Product> seeAllItemsWithSellerInfo() {
        ArrayList<Product> allProducts = productDAO.getAll();
        for (Product product : allProducts) {
            User seller = userDAO.getById(product.getSellerId());
            product.setSellerInfo(seller);
        }
        return allProducts;
    }
}