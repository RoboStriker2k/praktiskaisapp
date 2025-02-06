package com.praktiskaisapp.praktiskaisapp.Rest.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "records")
public class records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "requestdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date requestdate;

    private List<Number> requestedevices;

    @Column(name = "status", columnDefinition = "VARCHAR(255) DEFAULT 'Pending'")
    private String status;
    private String reason;
    private String requestor;

    public records() {
    }

    public records(Long id, Date requestdate, List<Number> requestedevices, String reason, String status, String requestor) {
        this.id = id;
        this.requestdate = requestdate;
        this.requestedevices = requestedevices;
        this.reason = reason;
        this.status = status;
        this.requestor = requestor;
    }
    public String getRequestor() {
        return requestor;
    }
    public void setRequestor(String requestor) {
        this.requestor = requestor;
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

    public List<Number> getRequestedevices() {
        return requestedevices;
    }

    public void setRequestedevices(List<Number> requestedevices) {
        this.requestedevices = requestedevices;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRecord(records record) {
        this.id = record.getId();
        this.requestdate = record.getRequestdate();
        this.requestedevices = record.getRequestedevices();
        this.reason = record.getReason();
        this.status = record.getStatus();
    }

    public String recordToString() {
        String devices = "";
        for (Number device : this.requestedevices) {
            devices += device.toString() + ",";
        }
        return "Record{" + this.id + "," + this.requestdate + "," + devices + "," + this.reason + "," + this.status
                + "}";
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
