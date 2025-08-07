package com.example.bt1_ss5.model;

import java.util.Date;

public class Ticket {
    private int id;
    private int customerId;
    private int scheduleId;
    private String seatName;
    private Double totalMoney;
    private Date createdAt;

    public Ticket() {
    }

    public Ticket(int id, int customerId, int scheduleId, String seatName, Double totalMoney, Date createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.scheduleId = scheduleId;
        this.seatName = seatName;
        this.totalMoney = totalMoney;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
