package product;

public class Product {
    private int product_id;
    private String product_name;
    private String product_description;
    private double price;
    private int k_percent;
    private int p_percent;
    private int n_percent;

    // Constructor with all fields
    public Product(int product_id, String product_name, String product_description, double price, int k_percent, int p_percent, int n_percent) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.price = price;
        this.k_percent = k_percent;
        this.p_percent = p_percent;
        this.n_percent = n_percent;
    }

    // Default constructor
    public Product() {
    }

    // Getters and setters
    public int getProduct_id() { return product_id; }
    public void setProduct_id(int product_id) { this.product_id = product_id; }

    public String getProduct_name() { return product_name; }
    public void setProduct_name(String product_name) { this.product_name = product_name; }

    public String getProduct_description() { return product_description; }
    public void setProduct_description(String product_description) { this.product_description = product_description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getK_percent() { return k_percent; }
    public void setK_percent(int k_percent) { this.k_percent = k_percent; }

    public int getP_percent() { return p_percent; }
    public void setP_percent(int p_percent) { this.p_percent = p_percent; }

    public int getN_percent() { return n_percent; }
    public void setN_percent(int n_percent) { this.n_percent = n_percent; }
}
