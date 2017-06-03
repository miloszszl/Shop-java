package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import POJO.Category;
import POJO.Product;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import service.CategoryService;
import service.ProductService;
import service.UserService;
import POJO.User;

import javax.imageio.ImageIO;

@RestController
public class ProductController {

    private ProductService productService; // Service which will do all data retrieval/manipulation work.
    private CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) { // Constructor injection, field injection is not recommended.
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/api/products/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProducts() {

        List<Product> allProducts = productService.findAllProducts();
        if(allProducts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/image/{uuid}", method = RequestMethod.GET, produces = "image/jpg")
    public @ResponseBody byte[] getFile(@PathVariable("uuid") String uuid)  {
        try {
            // Retrieve image from the classpath.
            InputStream is = this.getClass().getResourceAsStream("/" + uuid + ".jpg");
            // Prepare buffered image.
            BufferedImage img = ImageIO.read(is);

            // Create a byte array output stream.
            ByteArrayOutputStream bao = new ByteArrayOutputStream();

            // Write to output stream
            ImageIO.write(img, "jpg", bao);

            return bao.toByteArray();
        } catch (IOException e) {
            //logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/api/products/categories/", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllCategories() {

        List<Category> allCategories = categoryService.findAllCategories();
        if(allCategories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

}