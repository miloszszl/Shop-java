package POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.BufferOverflowException;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_provider",unique = true, nullable = false)
    private int idProvider;

    private String providerName;

    private BigDecimal providerPrice;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "provider",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UserOrder> userOrders;

    public Provider(){}

    public Provider(int idProvider,String providerName, BigDecimal providerPrice, List<UserOrder> userOrders) {
        this.idProvider=idProvider;
        this.providerName = providerName;
        this.providerPrice = providerPrice;
        this.userOrders = userOrders;
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

    public List<UserOrder> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(List<UserOrder> userOrders) {
        this.userOrders = userOrders;
    }

    @Override
    public String toString(){
        return "toString";
    }
}
