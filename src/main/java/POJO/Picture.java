package POJO;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_picture",unique = true, nullable = false)
    private int idPicture;

    @Type(type="text")
    private String picturePath;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;

    public Picture(){}

    public Picture(String picturePath, Product product) {
        this.picturePath = picturePath;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(int idPicture) {
        this.idPicture = idPicture;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}
