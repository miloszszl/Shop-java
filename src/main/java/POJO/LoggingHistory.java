package POJO;

import java.nio.BufferOverflowException;
import java.security.Timestamp;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class LoggingHistory {

    private String login;
    private Boolean loggedCorrectly;
    private Timestamp datetime;

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
