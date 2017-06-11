package dao;

import POJO.Category;
import POJO.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Miłosz on 09.06.2017.
 */
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer> {

    Product findOne(int primaryKey);
    List<Category> findAll();
    Category findByCategoryNameIgnoreCase(String categoryName);
    Category save(Category p);
    boolean exists(Integer primaryKey);
    void delete(Category entity);

}
