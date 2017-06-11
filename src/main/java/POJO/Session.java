package POJO;

import javax.persistence.*;
import java.nio.BufferOverflowException;
import java.security.Timestamp;

/**
 * Created by Miłosz on 18.03.2017.
 */

//not used
@Entity
@Table(name = "sesja")
public class Session {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idSesji",unique = true, nullable = false)
    private int idSession;

    @Column(name = "idUzytkownika")
    private int idUser;
    private String id;
    private String ip;
    private String web;
    private Timestamp datetime;
    private String token;

    public Session(){}

    public Session(int idSession, int idUser, String id, String ip, String web, Timestamp datetime, String token) {
        this.idSession = idSession;
        this.idUser = idUser;
        this.id = id;
        this.ip = ip;
        this.web = web;
        this.datetime = datetime;
        this.token = token;
    }

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws BufferOverflowException{
        if(id.length()>200)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.id = id;
        }

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) throws BufferOverflowException{
        if(ip.length()>200)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.ip = ip;
        }
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) throws BufferOverflowException{
        if(web.length()>200)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.web = web;
        }

    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) throws BufferOverflowException{
        if(token.length()>20)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.token = token;
        }
    }
}
