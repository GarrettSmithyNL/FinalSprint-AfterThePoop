package product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    public int addProduct(Product product) {
        return productDAO.insert(product);
    }

    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    public void deleteProduct(Product product) {
        productDAO.delete(product);
    }

    public Product getProductById(int product_id) {
        return productDAO.getById(product_id);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }


}
