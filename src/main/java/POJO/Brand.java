package POJO;

import java.nio.BufferOverflowException;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class Brand {

    private int idBrand;
    private String brandName;

    public Brand(){}

    public Brand(int idBrand, String brandName) {
        this.idBrand = idBrand;
        this.brandName = brandName;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) throws BufferOverflowException{

        if(brandName.length()>50)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.brandName = brandName;
        }
    }
}
