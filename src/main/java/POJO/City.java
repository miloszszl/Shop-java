package POJO;

import javax.persistence.*;
import java.nio.BufferOverflowException;

/**
 * Created by Miłosz on 15.03.2017.
 */
@Entity
@Table(name = "miasta")
public class City {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idMiasta")
    private int idCity;
    @Column(name="nazwa")
    private String cityName;

    public City(){}

    public City(int idCity, String cityName) {
        this.idCity = idCity;
        this.cityName = cityName;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) throws BufferOverflowException{
        if(cityName.length()>30)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.cityName = cityName;
        }

    }
}
