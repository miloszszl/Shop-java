package POJO;

import javax.persistence.*;
import java.nio.BufferOverflowException;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_user",unique = true, nullable = false)
    private int idUser;

    private String firstName;

    private String lastName;

    private String login;

    private String password;

    private String email;

    private String phone;

    private String salt;

    private String city2;

    private String state;

    private String postalCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_city")
    private City city;

    private String streetName;

    private String houseNumber;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_account_type")
    private AccountType accountType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idComment.user",cascade=CascadeType.ALL)
    private List<Comment> comments=null;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idRate.user",cascade=CascadeType.ALL)
    private List<Rate> rates=null;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user",cascade=CascadeType.ALL)
    private List<UserOrder> userOrders =null;

    public User(){}

    public User(int idUser, String name, String lastName, String login, String password, String mail, String phone, String salt, String city2, String state, String postalCode, City city, String streetName, String houseNumber, AccountType accountType, List<Comment> comments, List<Rate> rates, List<UserOrder> userOrders) {
        this.idUser = idUser;
        this.firstName = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = mail;
        this.phone = phone;
        this.salt = salt;
        this.city2 = city2;
        this.state = state;
        this.postalCode = postalCode;
        this.city = city;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.accountType = accountType;
        this.comments = comments;
        this.rates = rates;
        this.userOrders = userOrders;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setState(String state) {
        this.state = state;
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

    //@JsonIgnore
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

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) throws BufferOverflowException{
        if(city2.length()>100)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.city2 = city2;
        }
    }

    public String getState() {
        return state;
    }

    public void setstate(String state) throws BufferOverflowException{
        if(state.length()>100)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.state = state;
        }
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) throws BufferOverflowException{
        if(postalCode.length()>100)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.postalCode = city2;
        }
    }

    //@JsonIgnore
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

    //@JsonIgnore
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    //@JsonIgnore
    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    //@JsonIgnore
    public List<UserOrder> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(List<UserOrder> userOrders) {
        this.userOrders = userOrders;
    }
}
