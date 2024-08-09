package product;

import java.util.List;

/**
 * Service class for managing Product entities.
 * Provides methods to perform CRUD operations using ProductDAO.
 */
public class ProductService {
    private final ProductDAO productDAO;

    /**
     * Constructor for ProductService.
     * Initializes the ProductDAO instance.
     */
    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    /**
     * Adds a new product to the database.
     *
     * @param product the Product object to add
     * @return the ID of the newly inserted product, or -1 if the insertion failed
     */
    public int addProduct(Product product) {
        return productDAO.insert(product);
    }

    /**
     * Updates an existing product in the database.
     *
     * @param product the Product object with updated information
     */
    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    /**
     * Deletes a product from the database.
     *
     * @param product the Product object to delete
     */
    public void deleteProduct(Product product) {
        productDAO.delete(product);
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param product_id the ID of the product to retrieve
     * @return the Product object with the specified ID
     */
    public Product getProductById(int product_id) {
        return productDAO.getById(product_id);
    }

    /**
     * Retrieves all products from the database.
     *
     * @return a List of Product objects
     */
    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }
}