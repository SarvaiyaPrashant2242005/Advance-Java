package com.parkingManagement.model;

public class VehicleType {
    private String id;
    private String companyId;
    private String vehicleType;
    private String vehicleCharge;
    private String fine;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = String.valueOf(companyId);
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleCharge() {
        return vehicleCharge;
    }

    public void setVehicleCharge(double vehicleCharge) {
        this.vehicleCharge = String.valueOf(vehicleCharge);
    }

    public String getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = String.valueOf(fine);
    }
}
