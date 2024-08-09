package transaction;

/**
 * Represents a Transaction with details such as transaction ID, buyer ID, seller ID, product ID, quantity, and price.
 */
public class Transaction {
  private int transactionId; // Unique identifier for the transaction
  private int buyerId; // ID of the buyer involved in the transaction
  private int sellerId; // ID of the seller involved in the transaction
  private int productId; // ID of the product involved in the transaction
  private int quantity; // Quantity of the product involved in the transaction
  private double price; // Price of the product involved in the transaction

  /**
   * Default constructor for Transaction.
   */
  public Transaction() {}

  /**
   * Constructor with all fields.
   *
   * @param buyerId the ID of the buyer involved in the transaction
   * @param sellerId the ID of the seller involved in the transaction
   * @param productId the ID of the product involved in the transaction
   * @param quantity the quantity of the product involved in the transaction
   * @param price the price of the product involved in the transaction
   */
  public Transaction(int buyerId, int sellerId, int productId, int quantity, double price) {
    this.buyerId = buyerId;
    this.sellerId = sellerId;
    this.productId = productId;
    this.quantity = quantity;
    this.price = price;
  }

  /**
   * Gets the unique identifier for the transaction.
   *
   * @return the transaction ID
   */
  public int getTransactionId() {
    return transactionId;
  }

  /**
   * Sets the unique identifier for the transaction.
   *
   * @param transactionId the transaction ID to set
   */
  public void setTransactionId(int transactionId) {
    this.transactionId = transactionId;
  }

  /**
   * Gets the ID of the buyer involved in the transaction.
   *
   * @return the buyer ID
   */
  public int getBuyerId() {
    return buyerId;
  }

  /**
   * Sets the ID of the buyer involved in the transaction.
   *
   * @param buyerId the buyer ID to set
   */
  public void setBuyerId(int buyerId) {
    this.buyerId = buyerId;
  }

  /**
   * Gets the ID of the seller involved in the transaction.
   *
   * @return the seller ID
   */
  public int getSellerId() {
    return sellerId;
  }

  /**
   * Sets the ID of the seller involved in the transaction.
   *
   * @param sellerId the seller ID to set
   */
  public void setSellerId(int sellerId) {
    this.sellerId = sellerId;
  }

  /**
   * Gets the ID of the product involved in the transaction.
   *
   * @return the product ID
   */
  public int getProductId() {
    return productId;
  }

  /**
   * Sets the ID of the product involved in the transaction.
   *
   * @param productId the product ID to set
   */
  public void setProductId(int productId) {
    this.productId = productId;
  }

  /**
   * Gets the quantity of the product involved in the transaction.
   *
   * @return the quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Sets the quantity of the product involved in the transaction.
   *
   * @param quantity the quantity to set
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Gets the price of the product involved in the transaction.
   *
   * @return the price
   */
  public double getPrice() {
    return price;
  }

  /**
   * Sets the price of the product involved in the transaction.
   *
   * @param price the price to set
   */
  public void setPrice(double price) {
    this.price = price;
  }
}