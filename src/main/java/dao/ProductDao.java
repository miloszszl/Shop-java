package dao;

import POJO.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Miłosz on 09.06.2017.
 */
@Transactional
public interface ProductDao extends CrudRepository<Product, Integer> {

    Product findOne(int primaryKey);
    List<Product> findAll();
    List<Product> findByCategory_Id(Integer categoryPrimaryKey);
    List<Product> findByCategory_CategoryName(String categoryName);
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findByCategory_IdOrderByPriceAsc(Integer categoryPrimaryKey);
    List<Product> findByCategory_IdOrderByPriceDesc(Integer categoryPrimaryKey);
    Product save(Product p);
    boolean exists(Integer primaryKey);
    @Query("select p from Product p where p.price>:price")
    List<Product> findByPriceGT(@Param("price") Double price);
    @Query("select p from Product p where p.price<:price")
    List<Product> findByPriceLT(@Param("price") Double price);
    void delete(Product entity);

}
