package com.praktiskaisapp.Rest.Entity;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;




@Entity 
public class records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "requestdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private  Date requestdate;
@OneToMany 
@JoinColumn(name = "computer_id")
    private List<computer> requestedevices ;
    @Column(name = "status", columnDefinition = "VARCHAR(255) DEFAULT 'Pending'")
    private String status ;
  
    public records(Long id, Date requestdate, List<computer> requestedevices, String status) {
        this.id = id;
        this.requestdate = requestdate;
        this.requestedevices = requestedevices;
        this.status = status;
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

    public  List<computer> getRequestedevices() {  
        return requestedevices;
    }

    public void setRequestedevices(List<computer> requestedevices) {
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
        for (computer device : this.requestedevices) {
            devices += device.computerToString() + ",";
        }
        return "Record{" + this.id + "," + this.requestdate + "," + devices + "," + this.status + "}";
    }

}
