package POJO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.BufferOverflowException;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class Provider {

    private int idProvider;
    private String providerName;
    private BigDecimal providerPrice;

    public Provider(){}

    public Provider(int idProvider, String providerName, BigDecimal providerPrice) {
        this.idProvider = idProvider;
        this.providerName = providerName;
        this.providerPrice = providerPrice;
    }

    public int getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) throws BufferOverflowException{

        if(providerName.length()>50)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.providerName = providerName;
        }
    }

    public BigDecimal getProviderPrice() {
        return providerPrice;
    }

    public void setProviderPrice(BigDecimal providerPrice) throws BufferOverflowException{
        if(providerPrice.compareTo(new BigDecimal(999.99))==1 || providerPrice.compareTo(BigDecimal.ZERO)==-1)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.providerPrice = providerPrice.setScale(2, RoundingMode.FLOOR);
        }

    }


}
