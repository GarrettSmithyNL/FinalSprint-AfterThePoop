package product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public void addProduct(Product product) {
        productDAO.insert(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    @Override
    public void deleteProduct(int product_id) {
        productDAO.delete(product_id);
    }

    @Override
    public Product getProductById(int product_id) {
        return productDAO.getById(product_id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }
}
