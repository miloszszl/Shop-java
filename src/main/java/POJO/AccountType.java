package POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.nio.BufferOverflowException;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name="TypyKont")
public class AccountType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idTypuKonta",unique = true, nullable = false)
    private int idAccountType;
    @Column(name = "typKonta")
    private String accountTypeName;
    @OneToMany(fetch = FetchType.EAGER ,mappedBy = "accountType")
    private List<User> users=null;


    public AccountType(){}

    public AccountType(int idAccountType, String accountTypeName) {
        this.idAccountType = idAccountType;
        this.accountTypeName = accountTypeName;
    }

    public AccountType(int idAccountType, String accountTypeName, List<User> users) {
        this.idAccountType = idAccountType;
        this.accountTypeName = accountTypeName;
        this.users = users;
    }

    public int getIdAccountType() {
        return idAccountType;
    }

    public void setIdAccountType(int idAccountType) {
        this.idAccountType = idAccountType;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) throws BufferOverflowException{

        if(accountTypeName.length()>20)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.accountTypeName = accountTypeName;
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
