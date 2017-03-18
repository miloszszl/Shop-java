package POJO;

import java.nio.BufferOverflowException;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class Category {

    private int idCategory;
    private String categoryName;

    public Category(){}

    public Category(int idCategory, String categoryName) {
        this.idCategory = idCategory;
        this.categoryName = categoryName;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) throws BufferOverflowException{
        if(categoryName.length()>50)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.categoryName = categoryName;
        }
    }
}
