package POJO;

import javax.persistence.*;
import java.nio.BufferOverflowException;
import java.sql.Timestamp;

/**
 * Created by Miłosz on 18.03.2017.
 */
//@Entity
@Embeddable
@Table(name = "HistoriaLogowan")
public class LoggingHistory {


    @Column(name = "login",unique = true, nullable = false)
    private String login;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name ="dataZCzasem")
    private Timestamp datetime;

    @Column(name ="czyZalogowanoPomyslnie")
    private Boolean loggedCorrectly;

    public LoggingHistory(){}

    public LoggingHistory(String login, Boolean loggedCorrectly, Timestamp datetime) {
        this.login = login;
        this.loggedCorrectly = loggedCorrectly;
        this.datetime = datetime;
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

    public Boolean getLoggedCorrectly() {
        return loggedCorrectly;
    }

    public void setLoggedCorrectly(Boolean loggedCorrectly) {
        this.loggedCorrectly = loggedCorrectly;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}
