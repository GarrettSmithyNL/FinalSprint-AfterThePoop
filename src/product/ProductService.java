package product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int product_id);
    Product getProductById(int product_id);
    List<Product> getAllProducts();
}
