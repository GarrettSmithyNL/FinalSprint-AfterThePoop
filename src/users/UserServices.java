package users;

import org.mindrot.jbcrypt.BCrypt;
import product.*;
import posting.*;
import transaction.*;

import java.util.ArrayList;

public class UserServices {
    private UserDAO userDAO;
    private PostingDAO postingDAO;
    private ProductDAO productDAO;
    private TransactionDAO transactionDAO;

    public UserServices() {
        this.userDAO = new UserDAO();
        this.postingDAO = new PostingDAO();
        this.productDAO = new ProductDAO();
        this.transactionDAO = new TransactionDAO();
    }

    // See all Postings
    // BUYER
    public ArrayList<Posting> getAllPostings() {
        return postingDAO.getAll();
    }

    // See all Postings by Seller
    // BUYER
    public ArrayList<Posting> getPostingsBySeller(int sellerId) {
        ArrayList<Posting> postings = postingDAO.getAll();
        ArrayList<Posting> sellerPostings = new ArrayList<>();
        for (Posting posting : postings) {
            if (posting.getSellerId() == sellerId) {
                sellerPostings.add(posting);
            }
        }
        return sellerPostings;
    }

    // Expand Product Details
    // BUYER
    public Product getProductDetails(int productId) {
        return productDAO.getById(productId);
    }

    // Add Posting
    // SELLER
    public void addPosting(Posting posting) {
        postingDAO.insert(posting);
    }

    // Update Product
    // SELLER
    public void updateProduct(Product product) {
        productDAO.update(product);
    }


    // Delete Posting
    // SELLER
    public void deletePosting(Posting posting) {
        postingDAO.delete(posting);
    }

    // View all Users
    // ADMIN
    public ArrayList<User> getAllUsers() {
        return userDAO.getAll();
    }

    // Delete User
    // ADMIN
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    // View all Items with Seller Information
    // ADMIN
    public ArrayList<Product> getAllItems() {
        return productDAO.getAll();
    }

    // View all Transactions
    // ADMIN
    public ArrayList<Transaction> getAllTransactions() {
        return transactionDAO.getAll();
    }

    // View all Transactions by User
    // ADMIN
    public ArrayList<Transaction> getTransactionsByUser(int userId) {
        ArrayList<Transaction> transactions = transactionDAO.getAll();
        ArrayList<Transaction> userTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getBuyerId() == userId || transaction.getSellerId() == userId) {
                userTransactions.add(transaction);
            }
        }
        return userTransactions;
    }

    // Handles authentication (READ) for user login
    public boolean authenticate(String email, String password) {
        User user = userDAO.getByEmail(email);
        return user != null && BCrypt.checkpw(password, user.getPassword());
    }
    // Registration (CREATE)
    public int register(User user) {
        return userDAO.insert(user);
    }

    // Profile modification (UPDATE)
    public void updateProfile(User user) {
        userDAO.update(user);
    }

    // Password reset (UPDATE)
    public void resetPassword(String email, String newPassword) {
        User user = userDAO.getByEmail(email);
        if (user != null) {
            user.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(10)));
            userDAO.update(user);
        }
    }

    // Enter email, phone number (UPDATE)
    public void updateEmail(int userId, String newEmail) {
        User user = userDAO.getById(userId);
        if (user != null) {
            user.setEmail(newEmail);
            userDAO.update(user);
        }
    }

    public void updatePhoneNumber(int userId, String newPhoneNumber) {
        User user = userDAO.getById(userId);
        if (user != null) {
            user.setUserPhone(newPhoneNumber);
            userDAO.update(user);
        }
    }

    public int getUserId(String email) {
        User user = userDAO.getByEmail(email);
        return user.getUserId();
    }

    public User getUserById(int userId) {
        return userDAO.getById(userId);
    }
}