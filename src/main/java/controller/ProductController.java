package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import POJO.*;
import dao.*;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;

@RestController
public class ProductController {

//    private ProductService productService; // Service which will do all data retrieval/manipulation work.
//    private CategoryService categoryService;
//    private OrderService orderService;
//    private UserService userService;

    @Autowired
    private UserOrderDao userOrderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProviderDao providerDao;

    @Autowired
    private OrderStatusDao orderStatusDao;

    @Autowired
    private ProductOrderDao productOrderDao;

    static class OrderDTO{
        int userId;
        int methodId;
        List<ProductDTO> products;

        public int getUserId() { return this.userId; }
        public int getMethodId() { return this.methodId; }
        public List<ProductDTO> getProducts() { return this.products; }

        public void setUserId(int userId) { this.userId = userId; }
        public void setMethodId(int methodId) { this.methodId = methodId; }
        public void setProducts(List<ProductDTO> products) { this.products = products; }
    }

    static class ProductDTO {
        int quantity;
        Product product;

        public int getQuantity() { return this.quantity; }
        public Product getProduct() { return this.product; }

        public void setQuantity(int quantity) { this.quantity = quantity; }
        public void setProduct(Product product) { this.product = product; }
    }

//    @Autowired
//    public ProductController(ProductService productService, CategoryService categoryService, OrderService orderService, UserService userService) { // Constructor injection, field injection is not recommended.
//        this.productService = productService;
//        this.categoryService = categoryService;
//        this.orderService = orderService;
//        this.userService = userService;
//    }

    @RequestMapping(value = "/api/products/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProducts() {

        List<Product> allProducts = productDao.findAll();
        if(allProducts.isEmpty()){
            System.out.println("allProducts is empty");
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

        List<Category> allCategories = categoryDao.findAll();
        if(allCategories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/orders/", method = RequestMethod.POST)
    public ResponseEntity<User> createOrder(@RequestBody OrderDTO orderDTO) {

        int x = orderDTO.getUserId();
        int z = orderDTO.getMethodId();
        List<ProductDTO> products = orderDTO.getProducts();

        //lpeij nie uzywac find one
//        User user = userDao.findOne(x);
        User user = userDao.findByIdUser(x);
        Provider provider = providerDao.findOne(z);
        OrderStatus orderStatus = orderStatusDao.findOne(1);
        UserOrder userOrder = new UserOrder(user, new Timestamp(System.currentTimeMillis()), null,"", provider, orderStatus, null);
        UserOrder freshUserOrder = userOrderDao.save(userOrder);

        for (ProductDTO productDTO : products) {
            ProductOrder productOrder = new ProductOrder();
            productOrder.setAmount(productDTO.getQuantity());
            productOrder.setActualPrice(productDTO.getProduct().getPrice().multiply(BigDecimal.valueOf(productDTO.getQuantity())));

            Product product = productDao.findOne(productDTO.getProduct().getId());
            ProductOrderId productOrderId = new ProductOrderId(freshUserOrder, product);
            productOrder.setIdProductOrder(productOrderId);
            productOrderDao.save(productOrder);
        }


        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}