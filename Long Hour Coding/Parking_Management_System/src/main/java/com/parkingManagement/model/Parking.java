package com.parkingManagement.model;

import java.sql.Timestamp;

public class Parking {
    private int id;
    private String vehicleNumber;
    private int duration;
    private String companyName;
    private Timestamp entryTime;
    private Timestamp exitTime;
    private double fine;

    public Parking() {}

    public Parking(String vehicleNumber, int duration, String companyName, Timestamp entryTime) {
        this.vehicleNumber = vehicleNumber;
        this.duration = duration;
        this.companyName = companyName;
        this.entryTime = entryTime;
        this.exitTime = null; // Not set at booking
        this.fine = 0.0;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public Timestamp getEntryTime() { return entryTime; }
    public void setEntryTime(Timestamp entryTime) { this.entryTime = entryTime; }

    public Timestamp getExitTime() { return exitTime; }
    public void setExitTime(Timestamp exitTime) { this.exitTime = exitTime; }

    public double getFine() { return fine; }
    public void setFine(double fine) { this.fine = fine; }
}
