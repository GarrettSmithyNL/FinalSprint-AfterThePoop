package transaction;

public class Transaction {
  private int transactionId;
  private int buyerId;
  private int sellerId;
  private int productId;
  private int quantity;
  private double price;

  public Transaction() {}

  public Transaction(int buyerId, int sellerId, int productId, int quantity, double price) {
    this.buyerId = buyerId;
    this.sellerId = sellerId;
    this.productId = productId;
    this.quantity = quantity;
    this.price = price;
}

  public int getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(int transactionId) {
    this.transactionId = transactionId;
  }

  public int getBuyerId() {
    return buyerId;
  }

  public void setBuyerId(int buyerId) {
    this.buyerId = buyerId;
  }

  public int getSellerId() {
    return sellerId;
  }

  public void setSellerId(int sellerId) {
    this.sellerId = sellerId;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}