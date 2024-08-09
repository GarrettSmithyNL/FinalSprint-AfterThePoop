package users;

import org.mindrot.jbcrypt.BCrypt;
import product.*;
import posting.*;
import transaction.*;

import java.util.ArrayList;

/**
 * Service class for managing User entities.
 * Provides methods to perform various operations related to users, postings, products, and transactions.
 */
public class UserServices {
    private UserDAO userDAO;
    private PostingDAO postingDAO;
    private ProductDAO productDAO;
    private TransactionDAO transactionDAO;

    /**
     * Constructor for UserServices.
     * Initializes the DAO instances.
     */
    public UserServices() {
        this.userDAO = new UserDAO();
        this.postingDAO = new PostingDAO();
        this.productDAO = new ProductDAO();
        this.transactionDAO = new TransactionDAO();
    }

    /**
     * Retrieves all postings from the database.
     * This function is intended for buyer use only.
     *
     * @return an ArrayList of Posting objects
     */
    // BUYER
    public ArrayList<Posting> getAllPostings() {
        return postingDAO.getAll();
    }

    /**
     * Retrieves all postings by a specific seller.
     * This function is intended for buyer use only.
     *
     * @param sellerId the ID of the seller
     * @return an ArrayList of Posting objects by the specified seller
     */
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

    /**
     * Retrieves product details by product ID.
     * This function is intended for buyer use only.
     *
     * @param productId the ID of the product
     * @return the Product object with the specified ID
     */
    // BUYER
    public Product getProductDetails(int productId) {
        return productDAO.getById(productId);
    }

    /**
     * Adds a new posting to the database.
     * This function is intended for seller use only.
     *
     * @param posting the Posting object to add
     */
    // SELLER
    public void addPosting(Posting posting) {
        postingDAO.insert(posting);
    }

    /**
     * Updates an existing product in the database.
     * This function is intended for seller use only.
     *
     * @param product the Product object with updated information
     */
    // SELLER
    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    /**
     * Deletes a posting from the database.
     * This function is intended for seller use only.
     *
     * @param posting the Posting object to delete
     */
    // SELLER
    public void deletePosting(Posting posting) {
        postingDAO.delete(posting);
    }

    /**
     * Retrieves all users from the database.
     * This function is intended for admin use only.
     *
     * @return an ArrayList of User objects
     */
    // ADMIN
    public ArrayList<User> getAllUsers() {
        return userDAO.getAll();
    }

    /**
     * Deletes a user from the database.
     * This function is intended for admin use only.
     *
     * @param user the User object to delete
     */
    // ADMIN
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    /**
     * Retrieves all items with seller information from the database.
     * This function is intended for admin use only.
     *
     * @return an ArrayList of Product objects
     */
    // ADMIN
    public ArrayList<Product> getAllItems() {
        return productDAO.getAll();
    }

    /**
     * Retrieves all transactions from the database.
     * This function is intended for admin use only.
     *
     * @return an ArrayList of Transaction objects
     */
    // ADMIN
    public ArrayList<Transaction> getAllTransactions() {
        return transactionDAO.getAll();
    }

    /**
     * Retrieves all transactions by a specific user.
     * This function is intended for admin use only.
     *
     * @param userId the ID of the user
     * @return an ArrayList of Transaction objects by the specified user
     */
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

    /**
     * Handles authentication for user login.
     *
     * @param email the email of the user
     * @param password the password of the user
     * @return true if authentication is successful, false otherwise
     */
    public boolean authenticate(String email, String password) {
        User user = userDAO.getByEmail(email);
        return user != null && BCrypt.checkpw(password, user.getPassword());
    }

    /**
     * Registers a new user.
     *
     * @param user the User object to register
     * @return the ID of the newly registered user, or -1 if the registration failed
     */
    public int register(User user) {
        return userDAO.insert(user);
    }

    /**
     * Updates the profile of an existing user.
     *
     * @param user the User object with updated information
     */
    public void updateProfile(User user) {
        userDAO.update(user);
    }

    /**
     * Resets the password of a user.
     *
     * @param email the email of the user
     * @param newPassword the new password to set
     */
    public void resetPassword(String email, String newPassword) {
        User user = userDAO.getByEmail(email);
        if (user != null) {
            user.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(10)));
            userDAO.update(user);
        }
    }

    /**
     * Updates the email of a user.
     *
     * @param userId the ID of the user
     * @param newEmail the new email to set
     */
    public void updateEmail(int userId, String newEmail) {
        User user = userDAO.getById(userId);
        if (user != null) {
            user.setEmail(newEmail);
            userDAO.update(user);
        }
    }

    /**
     * Updates the phone number of a user.
     *
     * @param userId the ID of the user
     * @param newPhoneNumber the new phone number to set
     */
    public void updatePhoneNumber(int userId, String newPhoneNumber) {
        User user = userDAO.getById(userId);
        if (user != null) {
            user.setUserPhone(newPhoneNumber);
            userDAO.update(user);
        }
    }

    /**
     * Retrieves the user ID by email.
     *
     * @param email the email of the user
     * @return the user ID
     */
    public int getUserId(String email) {
        User user = userDAO.getByEmail(email);
        return user.getUserId();
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param userId the ID of the user
     * @return the User object with the specified ID
     */
    public User getUserById(int userId) {
        return userDAO.getById(userId);
    }
}