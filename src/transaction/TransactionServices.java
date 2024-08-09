package transaction;

import java.util.ArrayList;

/**
 * Service class for managing Transaction entities.
 * Provides methods to perform CRUD operations using TransactionDAO.
 */
public class TransactionServices {
  private TransactionDAO transactionDAO;

  /**
   * Constructor for TransactionServices.
   * Initializes the TransactionDAO instance.
   */
  public TransactionServices() {
    transactionDAO = new TransactionDAO();
  }

  /**
   * Retrieves all transactions from the database.
   * This function is intended for admin use only.
   *
   * @return an ArrayList of Transaction objects
   */
  // ADMIN ONLY
  public final ArrayList<Transaction> getAll() {
    return transactionDAO.getAll();
  }

  /**
   * Retrieves a transaction by its ID.
   * This function is intended for admin use only.
   *
   * @param id the ID of the transaction to retrieve
   * @return the Transaction object with the specified ID
   */
  // ADMIN ONLY
  public final Transaction getById(int id) {
    return transactionDAO.getById(id);
  }

  /**
   * Inserts a new transaction into the database.
   *
   * @param transaction the Transaction object to insert
   * @return the ID of the newly inserted transaction, or -1 if the insertion failed
   */
  public final int insert(Transaction transaction) {
    return transactionDAO.insert(transaction);
  }
}