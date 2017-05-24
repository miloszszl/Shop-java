package POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.nio.BufferOverflowException;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name = "uzytkownicy")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idUzytkownika",unique = true, nullable = false)
    private int idUser;

    @Column(name="imie")
    private String firstName;

    @Column(name="nazwisko")
    private String lastName;

    @Column(name="login")
    private String login;

    @Column(name="haslo")
    private String password;

    @Column(name="mail")
    private String email;

    @Column(name="telefon")
    private String phone;

    @Column(name="sol")
    private String salt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMiasta")
    private City city;

    @Column(name="nazwaUlicy")
    private String streetName;

    @Column(name="numerDomu")
    private String houseNumber;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTypuKonta")
    private AccountType accountType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idComment.user")
    private List<Comment> comments=null;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idRate.user")
    private List<Rate> rates=null;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orders=null;

    public User(){}

    public User(int idUser,String name, String lastName, String login, String password, String mail, String phone, String salt, City city, String streetName, String houseNumber, AccountType accountType, List<Comment> comments, List<Rate> rates, List<Order> orders) {
        this.idUser=idUser;
        this.firstName = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = mail;
        this.phone = phone;
        this.salt = salt;
        this.city = city;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.accountType = accountType;
        this.comments = comments;
        this.rates = rates;
        this.orders = orders;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setName(String name) throws BufferOverflowException{
        if(name.length()>30)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.firstName = name;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws BufferOverflowException {
        if(lastName.length()>30)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.lastName = lastName;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws BufferOverflowException{
        if(login.length()>20)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.login = login;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        //haszowanie
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) throws BufferOverflowException{
        if (mail.length() > 50) {
            throw new BufferOverflowException();
        } else {
            this.email = mail;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws BufferOverflowException{
        if(phone.length()>12)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.phone = phone;
        }
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) throws BufferOverflowException{
        if(salt.length()>10)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.salt = salt;
        }
    }

    @JsonIgnore
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) throws BufferOverflowException{
        if(streetName.length()>30)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.streetName = streetName;
        }
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) throws BufferOverflowException{
        if(houseNumber.length()>10)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.houseNumber = houseNumber;
        }
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @JsonIgnore
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @JsonIgnore
    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    @JsonIgnore
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
