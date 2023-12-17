package service;

import entity.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository;


    public Product getProduct(int id) {
        productRepository = new ProductRepository();
        Product product = productRepository.findById(id);

        return product;
    }

    public List<Product> getList() {
        productRepository = new ProductRepository();
        List<Product> products = productRepository.findAll();

        return products;
    }

    public List<Product> getListByCategory(int value) {
        productRepository = new ProductRepository();
        List<Product> products = productRepository.findAllByCategory(value);

        return products;
    }

    public void save(String productName, int price, int category) {
        productRepository = new ProductRepository();
        Product product = new Product(productName, price, category);

        productRepository.save(product);
    }
}
