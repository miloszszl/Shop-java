package POJO;

import javax.persistence.*;
import java.nio.BufferOverflowException;
import java.security.Timestamp;

/**
 * Created by Miłosz on 18.03.2017.
 */

@Entity
@Table(name = "Blokady")
public class Lock {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idBlokady",unique = true, nullable = false)
    private int idLock;

    @Column(name = "login")
    private String login;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataBlokady")
    private Timestamp datetime;

    public Lock(){}

    public Lock(int idLock, String login, Timestamp datetime) {
        this.idLock = idLock;
        this.login = login;
        this.datetime = datetime;
    }

    public int getIdLock() {
        return idLock;
    }

    public void setIdLock(int idLock) {
        this.idLock = idLock;
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

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}
