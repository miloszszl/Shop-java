package POJO;

import java.nio.BufferOverflowException;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class User {
    private int idUser;
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String mail;
    private String phone;
    private String salt;
    private City city;
    private String streetName;
    private String houseNumber;
    private AccountType accountType;
    private Comment comment;
    private Rate rate;

    public User(){}

    public User(int idUser, String name, String lastName, String login, String password, String mail, String phone, String salt, City city, String streetName, String houseNumber, AccountType accountType, Comment comment, Rate rate) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
        this.salt = salt;
        this.city = city;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.accountType = accountType;
        this.comment = comment;
        this.rate = rate;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws BufferOverflowException{
        if(name.length()>30)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.name = name;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) throws BufferOverflowException{
        if(mail.length()>50)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.mail = mail;
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }
}
