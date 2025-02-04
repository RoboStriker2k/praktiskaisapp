package com.praktiskaisapp.praktiskaisapp.Rest.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "computers")
public class computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpu;
	private Integer ramammount;
	private String gpu;
	private String motherboard;
	private Integer storageammount;
	private String comments;
	private String operatingsystem;

    public computer() {
    }

    public computer(Long id, String cpu, Integer ramAmmount, String gpu, String motherboard, Integer storageammount, String comments, String operatingsystem) {
        this.id = id;
        this.cpu = cpu;
        this.ramammount = ramAmmount;
        this.gpu = gpu;
        this.motherboard = motherboard;
        this.storageammount = storageammount;
        this.comments = comments;
        this.operatingsystem = operatingsystem;   
    }

    public Long getId() {
        return id;
    }    
    public void setId(Long id) {
        this.id = id;
    }
    public String getCpu() {
        return cpu;
    }
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    public Integer getRamAmmount() {
        return ramammount;
    }
    public void setRamAmmount(Integer ramAmmount) {
        this.ramammount = ramAmmount;
    }
    public String getGpu() {
        return gpu;
    }
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }
    public String getMotherboard() {
        return motherboard;
    }
    public void setMotherboard(String Motherboard) {
        this.motherboard = Motherboard;
    }
    public Integer getStorageammount() {
        return storageammount;
    }
    public void setStorageammount(Integer Storageammount) {
        this.storageammount = Storageammount;
    }
    public String getComments() {
        return comments;
    }

    public void setComments(String Comments) {
        this.comments = Comments;
    }
    public String getOperatingsystem() {
        return operatingsystem;
    }
    public void setOperatingsystem(String Operatingsystem) {
        this.operatingsystem = Operatingsystem;
    }
    public computer getComputer() {
        return this;
    }
    public String computerToString()
    {
        return "Computer{" + this.id + "," + this.cpu + "," + this.ramammount + "," + this.gpu + "," + this.motherboard + "," + this.storageammount + "," + this.comments + "," + this.operatingsystem + "}";
    }
}
