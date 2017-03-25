package POJO;

import javax.persistence.*;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miłosz on 15.03.2017.
 */
@Entity
@Table(name = "Miasta")
public class City {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idMiasta",unique = true, nullable = false)
    private int idCity;
    @Column(name="nazwa")
    private String cityName;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "city")
    private List<User> users=new ArrayList<User>();


    public City(){}

    public City(int idCity, String cityName,List<User> users) {
        this.idCity = idCity;
        this.cityName = cityName;
        //this.users=users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
