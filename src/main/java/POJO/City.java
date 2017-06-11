package POJO;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.nio.BufferOverflowException;
import java.util.List;

/**
 * Created by Miłosz on 15.03.2017.
 */
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_city",unique = true, nullable = false)
    private int idCity;

    private String cityName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city",cascade = CascadeType.ALL)
    private List<User> users;

    public City(){}
    public City(int idCity, String cityName)
    {
        this.idCity = idCity;
        this.cityName = cityName;
    }
    public City(int idCity, String cityName,List<User> users) {
        this.idCity = idCity;
        this.cityName = cityName;
        this.users=users;
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

    @JsonIgnore
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
