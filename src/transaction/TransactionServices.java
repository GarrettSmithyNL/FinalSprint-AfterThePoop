package transaction;

import transaction.Transaction;
import transaction.TransactionDAO;

import java.util.ArrayList;
public class TransactionServices {
  private TransactionDAO transactionDAO;

  public TransactionServices() {
    transactionDAO = new TransactionDAO();
  }

  // Function to get all transactions
  // ADMIN ONLY
  public final ArrayList<Transaction> getAll() {
    return transactionDAO.getAll();
  }

  // Function to get a transaction by id
  // ADMIN ONLY
  public final Transaction getById(int id) {
    return transactionDAO.getById(id);
  }

  // Function to insert a transaction
  public final int insert(Transaction transaction) {
    return transactionDAO.insert(transaction);
  }
}
