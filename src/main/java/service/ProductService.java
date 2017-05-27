package service;

import POJO.Product;

import java.util.List;

public interface ProductService {

    Product findById(long id);
    List<Product> findAllProducts();
}
