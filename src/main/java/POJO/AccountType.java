package POJO;

import java.nio.Buffer;
import java.nio.BufferOverflowException;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class AccountType {

    private int idAccountType;
    private String accountTypeName;

    public AccountType(){}

    public AccountType(int idAccountType, String accountTypeName) {
        this.idAccountType = idAccountType;
        this.accountTypeName = accountTypeName;
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
}
