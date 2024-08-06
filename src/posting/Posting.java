package posting;

public class Posting {
  private int postingId;
  private int sellerId;
  private int productId;
  private int quantity;
  private double price;

  public Posting() {
  }

  public int getPostingId() {
    return postingId;
  }

  public void setPostingId(int postingId) {
    this.postingId = postingId;
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
