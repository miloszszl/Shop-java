package POJO;

import javax.persistence.*;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name = "zdjecia")
public class Picture {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idZdjecia",unique = true, nullable = false)
    private int idPicture;

    @Column(name="link")
    private String picturePath;

    public Picture(){}

    public Picture(int idPicture, String picturePath) {
        this.idPicture = idPicture;
        this.picturePath = picturePath;
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
