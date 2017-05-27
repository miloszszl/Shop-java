package service;

import DBUtils.DBUtil;
import DBUtils.HibernateUtil;
import POJO.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    private DBUtil dbUtil = new HibernateUtil();

    @Override
    public Product findById(long id) {
        return null;
    }

    @Override
    public List<Product> findAllProducts() {
        return dbUtil.readAll(Product.class);
    }
}
