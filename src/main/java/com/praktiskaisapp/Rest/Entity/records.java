package com.praktiskaisapp.Rest.Entity;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity 
public class records {
    @Id
    private Long id;
    private  Date requestdate;
    private String[] requestedevices ;
    private String status = "Pending" ;

    public records(Long id, Date requestdate, String[] requestedevices) {
        this.id = id;
        this.requestdate = requestdate;
        this.requestedevices = requestedevices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(Date requestdate) {
        this.requestdate = requestdate;
    }

    public String[] getRequestedevices() {  
        return requestedevices;
    }

    public void setRequestedevices(String[] requestedevices) {
        this.requestedevices = requestedevices;
    }
    public String getStatus() {
        return status;
    }   
    public void setStatus(String status) {
        this.status = status;
    }
    public records getRecord() {
        return this;
    }

    public String recordToString()
    {
        String devices = "";
        for (String device : this.requestedevices) {
            devices += device + ",";
        }
        return "Record{" + this.id + "," + this.requestdate + "," + devices + "," + this.status + "}";
    }

}
