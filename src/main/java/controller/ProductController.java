package controller;

import java.util.List;

import POJO.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import service.ProductService;
import service.UserService;
import POJO.User;

@RestController
public class ProductController {

    private ProductService productService; // Service which will do all data retrieval/manipulation work.

    @Autowired
    public ProductController(ProductService productService) { // Constructor injection, field injection is not recommended.
        this.productService = productService;
    }

    @RequestMapping(value = "/api/products/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProducts() {

        List<Product> allProducts = productService.findAllProducts();
        if(allProducts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
}