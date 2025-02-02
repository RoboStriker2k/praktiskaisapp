package com.praktiskaisapp.Rest.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Cpu;
	private Integer RamAmmount;
	private String Gpu;
	private String Motherboard;
	private Integer Storage_ammount;
	private String Comments;
	private String Operating_system;
	
    public computer(Long id, String Cpu, Integer RamAmmount, String Gpu, String Motherboard, Integer Storage_ammount, String Comments, String Operating_system) {
        this.Id = id;
        this.Cpu = Cpu;
        this.RamAmmount = RamAmmount;
        this.Gpu = Gpu;
        this.Motherboard = Motherboard;
        this.Storage_ammount = Storage_ammount;
        this.Comments = Comments;
        this.Operating_system = Operating_system;
    }

    public Long getId() {
        return this.Id;
    }    
    public void setId(Long id) {
        this.Id = id;
    }
    public String getCpu() {
        return this.Cpu;
    }
    public void setCpu(String Cpu) {
        this.Cpu = Cpu;
    }
    public Integer getRamAmmount() {
        return this.RamAmmount;
    }
    public void setRamAmmount(Integer RamAmmount) {
        this.RamAmmount = RamAmmount;
    }
    public String getGpu() {
        return this.Gpu;
    }
    public void setGpu(String Gpu) {
        this.Gpu = Gpu;
    }
    public String getMotherboard() {
        return this.Motherboard;
    }
    public void setMotherboard(String Motherboard) {
        this.Motherboard = Motherboard;
    }
    public Integer getStorage_ammount() {
        return this.Storage_ammount;
    }
    public void setStorage_ammount(Integer Storage_ammount) {
        this.Storage_ammount = Storage_ammount;
    }
    public String getComments() {
        return this.Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }
    public String getOperating_system() {
        return this.Operating_system;
    }
    public void setOperating_system(String Operating_system) {
        this.Operating_system = Operating_system;
    }
    public computer getComputer() {
        return this;
    }
    public String computerToString()
    {
        return "Computer{" + this.Id + "," + this.Cpu + "," + this.RamAmmount + "," + this.Gpu + "," + this.Motherboard + "," + this.Storage_ammount + "," + this.Comments + "," + this.Operating_system + "}";
    }
}
