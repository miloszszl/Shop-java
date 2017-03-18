package POJO;

import java.nio.BufferOverflowException;
import java.security.Timestamp;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class Rate {

    private RateId idRate;
    private Timestamp datetime;
    private double value;

    public Rate(){}

    public Rate(RateId idRate, Timestamp datetime, double value) {
        this.idRate = idRate;
        this.datetime = datetime;
        this.value = value;
    }

    public RateId getIdRate() {
        return idRate;
    }

    public void setIdRate(RateId idRate) {
        this.idRate = idRate;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) throws BufferOverflowException{
        if(value>10 || value<0)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.value = value;
        }
    }
}
