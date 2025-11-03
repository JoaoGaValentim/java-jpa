package infra;

import models.basic.Product;

public class ProductDAO extends DAO<Product> {
    public ProductDAO() {
        super(Product.class);
    }
}
