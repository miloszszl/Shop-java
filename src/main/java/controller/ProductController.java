package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

import POJO.Category;
import POJO.Order;
import POJO.Product;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import service.CategoryService;
import service.OrderService;
import service.ProductService;
import service.UserService;
import POJO.User;

import javax.imageio.ImageIO;

@RestController
public class ProductController {

    private ProductService productService; // Service which will do all data retrieval/manipulation work.
    private CategoryService categoryService;
    private OrderService orderService;
    private UserService userService;

    static class OrderDTO{
        int userId;
        String methodId;
        List<ProductTMP> products;

        public int getUserId() { return this.userId; }
        public String getMethodId() { return this.methodId; }
        public List<ProductTMP> getProducts() { return this.products; }

        public void setUserId(int userId) { this.userId = userId; }
        public void setMethodId(String methodId) { this.methodId = methodId; }
        public void setProducts(List<ProductTMP> products) { this.products = products; }
    }

    static class ProductTMP {
        int quantity;
        Product product;

        public int getQuantity() { return this.quantity; }
        public Product getProduct() { return this.product; }

        public void setQuantity(int quantity) { this.quantity = quantity; }
        public void setProduct(Product product) { this.product = product; }
    }

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, OrderService orderService, UserService userService) { // Constructor injection, field injection is not recommended.
        this.productService = productService;
        this.categoryService = categoryService;
        this.orderService = orderService;
        this.userService = userService;
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

    @RequestMapping(value = "/api/orders/", method = RequestMethod.POST)
    public ResponseEntity<Void> createOrder(@RequestBody OrderDTO orderDTO) {

        int x = orderDTO.getUserId();
        // public Order(int idOrder, User user, Timestamp orderDatetime, Timestamp orderRealizationDatetime, String note, Provider provider, OrderStatus orderStatus,List productOrder) {
        User user = userService.findById(x);
        Order order = new Order(1, user, new Timestamp(System.currentTimeMillis()), null,"note", null, null, null);
        // LINIJKA WYZEJ WYWALA, nie wiem czy ten obiekt "order" tak powinien wygladac,
        orderService.saveOrder(order);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}