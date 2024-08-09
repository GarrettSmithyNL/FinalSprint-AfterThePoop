package product;

/**
 * Represents a Product with details such as product ID, name, description, and nutrient percentages.
 */
public class Product {
    private int product_id; // Unique identifier for the product
    private String product_name; // Name of the product
    private String product_description; // Description of the product
    private int k_percent; // Percentage of potassium in the product
    private int p_percent; // Percentage of phosphorus in the product
    private int n_percent; // Percentage of nitrogen in the product

    /**
     * Constructor with all fields.
     *
     * @param product_id the unique identifier for the product
     * @param product_name the name of the product
     * @param product_description the description of the product
     * @param k_percent the percentage of potassium in the product
     * @param p_percent the percentage of phosphorus in the product
     * @param n_percent the percentage of nitrogen in the product
     */
    public Product(int product_id, String product_name, String product_description, int k_percent, int p_percent, int n_percent) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.k_percent = k_percent;
        this.p_percent = p_percent;
        this.n_percent = n_percent;
    }

    /**
     * Default constructor for Product.
     */
    public Product() {
    }

    /**
     * Gets the unique identifier for the product.
     *
     * @return the product ID
     */
    public int getProduct_id() { return product_id; }

    /**
     * Sets the unique identifier for the product.
     *
     * @param product_id the product ID to set
     */
    public void setProduct_id(int product_id) { this.product_id = product_id; }

    /**
     * Gets the name of the product.
     *
     * @return the product name
     */
    public String getProduct_name() { return product_name; }

    /**
     * Sets the name of the product.
     *
     * @param product_name the product name to set
     */
    public void setProduct_name(String product_name) { this.product_name = product_name; }

    /**
     * Gets the description of the product.
     *
     * @return the product description
     */
    public String getProduct_description() { return product_description; }

    /**
     * Sets the description of the product.
     *
     * @param product_description the product description to set
     */
    public void setProduct_description(String product_description) { this.product_description = product_description; }

    /**
     * Gets the percentage of potassium in the product.
     *
     * @return the percentage of potassium
     */
    public int getK_percent() { return k_percent; }

    /**
     * Sets the percentage of potassium in the product.
     *
     * @param k_percent the percentage of potassium to set
     */
    public void setK_percent(int k_percent) { this.k_percent = k_percent; }

    /**
     * Gets the percentage of phosphorus in the product.
     *
     * @return the percentage of phosphorus
     */
    public int getP_percent() { return p_percent; }

    /**
     * Sets the percentage of phosphorus in the product.
     *
     * @param p_percent the percentage of phosphorus to set
     */
    public void setP_percent(int p_percent) { this.p_percent = p_percent; }

    /**
     * Gets the percentage of nitrogen in the product.
     *
     * @return the percentage of nitrogen
     */
    public int getN_percent() { return n_percent; }

    /**
     * Sets the percentage of nitrogen in the product.
     *
     * @param n_percent the percentage of nitrogen to set
     */
    public void setN_percent(int n_percent) { this.n_percent = n_percent; }
}