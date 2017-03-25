package POJO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.BufferOverflowException;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name = "uzytkownicy")
public class Provider {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idDostawcy",unique = true, nullable = false)
    private int idProvider;

    @Column(name = "nazwa")
    private String providerName;

    @Column(name = "cena")
    private BigDecimal providerPrice;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "brand")
    private List<Order> orders;

    public Provider(){}

    public Provider(int idProvider,String providerName, BigDecimal providerPrice, List<Order> orders) {
        this.idProvider=idProvider;
        this.providerName = providerName;
        this.providerPrice = providerPrice;
        this.orders = orders;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
