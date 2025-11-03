package test.basic;

import java.util.ArrayList;
import java.util.List;

import infra.ProductDAO;
import models.basic.Product;

public class GetProductsTest {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        List<Product> products = new ArrayList<>();

        dao.fetchAll().forEach(product -> {
            products.add(product);
        });

        System.out.println("# |   Nome   |    Preço    | Quantidade");
        products.forEach(product -> System.out
                .println(product.getId() + " - " + product.getName() + " | " + product.getPrice() + " | "
                        + product.getQuantity()));
    }
}
