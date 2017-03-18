package POJO;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class Picture {

    private int idPicture;
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
