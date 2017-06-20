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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private BrandDao brandDao;

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

    // {"name":"asd","price":null,"quantity":null,"category":"KLAPKI","brand":"KUBOT","description":"asdasd"}
    static class NewProductDTO {
        String name;
        BigDecimal price;
        int quantity;
        String category;
        String brand;
        String description;

        public String getName() { return this.name; }
        public BigDecimal getPrice() { return this.price; }
        public int getQuantity() { return this.quantity; }
        public String getCategory() { return this.category; }
        public String getBrand() { return this.brand; }
        public String getDescription() { return this.description; }

        public void setName(String name) { this.name = name; }
        public void setPrice(BigDecimal price) { this.price = price; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
        public void setCategory(String category) { this.category = category; }
        public void setBrand(String brand) { this.brand = brand; }
        public void setDescription(String description) { this.description = description; }
    }

    @RequestMapping(value = "/api/products/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProducts() {

        List<Product> allProducts = productDao.findAll();
        if(allProducts.isEmpty()){
            System.out.println("allProducts is empty");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/products/", method = RequestMethod.POST)
    public ResponseEntity<NewProductDTO> addProduct(@RequestBody NewProductDTO newProductDTO) {

        // public Product(int id, String name, String description, int amount, Category category, Brand brand, BigDecimal price, double totalRate, Set<ProductOrder> productOrder, Set<Comment> comments, Set<Rate> rates) {

        Category cat = categoryDao.findByCategoryNameIgnoreCase(newProductDTO.getCategory());
        Brand brand = brandDao.findByBrandName(newProductDTO.getBrand());
        Product product = new Product();

        product.setName(newProductDTO.getName());
        product.setPrice(newProductDTO.getPrice());
        product.setAmount(newProductDTO.getQuantity());
        product.setDescription((newProductDTO.getDescription()));
        product.setPhoto("eb6845e4-402c-40bf-93db-8efc70de3366");
        product.setCategory(cat);
        product.setBrand(brand);

        productDao.save(product);
        return new ResponseEntity<NewProductDTO>(newProductDTO, HttpStatus.OK);
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

    /*@RequestMapping(value = "/api/image/", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        modelMap.addAttribute("file", file);
        return "fileUploadView";
    } */

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

    @RequestMapping(value = "/api/orders/", method = RequestMethod.GET)
    public ResponseEntity<List<UserOrder>> listAllOrders() {

        List<UserOrder> allUserOrders = userOrderDao.findAll();

        if(allUserOrders.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UserOrder>>(allUserOrders, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/orders/{id}/orderStatus/", method = RequestMethod.PATCH)
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody Object obj) {

        OrderStatus orderStatus;
        List<UserOrder> allUserOrder = userOrderDao.findAll();    // Not redundant! Required for a workaround fix!
        UserOrder userOrder = userOrderDao.findByIdUserOrder(id); // Stack overflow here if line above is not used. SOlution that should but doesn't work -> https://stackoverflow.com/questions/17445657/hibernate-onetomany-java-lang-stackoverflowerror

        if (userOrder.getOrderStatus().getIdOrderStatus() == 1) {
            orderStatus = orderStatusDao.findOne(2);
        } else {
            orderStatus = orderStatusDao.findOne(1);
        }

        userOrder.setOrderStatus(orderStatus);
        userOrder.setOrderRealizationDatetime(new Timestamp(System.currentTimeMillis()));
        userOrderDao.save(userOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}