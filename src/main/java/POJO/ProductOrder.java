package POJO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name = "ProdutkyZamowienia")
@AssociationOverrides({
        @AssociationOverride(name = "idProductOrder.order",
                joinColumns = @JoinColumn(name = "idZamowienia")),
        @AssociationOverride(name = "idProductOrder.product",
                joinColumns = @JoinColumn(name = "idProduktu")) })
public class ProductOrder {

    @EmbeddedId
    private ProductOrderId idProductOrder;

    @Column(name="ilosc")
    private int amount;

    @Column(name="cenaZamowieniowa")
    private BigDecimal actualPrice;

    public ProductOrder() {}

    public ProductOrder(ProductOrderId idProductOrder, int amount, BigDecimal actualPrice) {
        this.idProductOrder = idProductOrder;
        this.amount = amount;
        this.actualPrice = actualPrice;
    }

    public ProductOrderId getIdProductOrder() {
        return idProductOrder;
    }

    public void setIdProductOrder(ProductOrderId idProductOrder) {
        this.idProductOrder = idProductOrder;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }
}
