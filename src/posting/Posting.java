package posting;

/**
 * Represents a Posting with details such as posting ID, seller ID, product ID, quantity, and price.
 */
public class Posting {
  private int postingId; // Unique identifier for the posting
  private int sellerId; // Identifier for the associated seller
  private int productId; // Identifier for the associated product
  private int quantity; // Quantity of the product in the posting
  private double price; // Price of the product in the posting

  /**
   * Default constructor for Posting.
   */
  public Posting() {
  }

  /**
   * Gets the unique identifier for the posting.
   *
   * @return the posting ID
   */
  public int getPostingId() {
    return postingId;
  }

  /**
   * Sets the unique identifier for the posting.
   *
   * @param postingId the posting ID to set
   */
  public void setPostingId(int postingId) {
    this.postingId = postingId;
  }

  /**
   * Gets the identifier for the associated seller.
   *
   * @return the seller ID
   */
  public int getSellerId() {
    return sellerId;
  }

  /**
   * Sets the identifier for the associated seller.
   *
   * @param sellerId the seller ID to set
   */
  public void setSellerId(int sellerId) {
    this.sellerId = sellerId;
  }

  /**
   * Gets the identifier for the associated product.
   *
   * @return the product ID
   */
  public int getProductId() {
    return productId;
  }

  /**
   * Sets the identifier for the associated product.
   *
   * @param productId the product ID to set
   */
  public void setProductId(int productId) {
    this.productId = productId;
  }

  /**
   * Gets the quantity of the product in the posting.
   *
   * @return the quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Sets the quantity of the product in the posting.
   *
   * @param quantity the quantity to set
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Gets the price of the product in the posting.
   *
   * @return the price
   */
  public double getPrice() {
    return price;
  }

  /**
   * Sets the price of the product in the posting.
   *
   * @param price the price to set
   */
  public void setPrice(double price) {
    this.price = price;
  }
}