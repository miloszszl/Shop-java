package service;

import DBUtils.DBUtil;
import DBUtils.HibernateUtil;
import POJO.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    private DBUtil dbUtil = new HibernateUtil();

    @Override
    public List<Category> findAllCategories() {
        {
            return dbUtil.readAll(Category.class);
        }
    }
}
