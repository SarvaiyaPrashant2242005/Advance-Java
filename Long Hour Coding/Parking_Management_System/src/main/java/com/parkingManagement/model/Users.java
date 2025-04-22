package com.parkingManagement.model;

public class Users {
    private int id;
    private int company_id;  // Added company_id
    private String company_name;
    private String company_email;
    private String company_phone;
    private String company_address;
    private int parking_slots;
    private String password;

    // Updated constructor to include company_id
    public Users(String company_name, String company_email, String company_phone, String company_address, Integer parking_slots, String password) {
        this.company_id = company_id;
        this.company_name = company_name;
        this.company_email = company_email;
        this.company_phone = company_phone;
        this.company_address = company_address;
        this.parking_slots = Integer.parseInt(String.valueOf(parking_slots));
        this.password = password;
    }

    // Default constructor
    public Users() {

    }
    // Getter for companyName
    public String getCompanyName() {
        return company_name;
    }

    // Getter and setter methods for company_id
    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    // Getter and setter for id
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Getter and setter for company_name
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    // Getter and setter for company_email
    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }

    public String getCompany_email() {
        return company_email;
    }

    // Getter and setter for company_phone
    public void setCompany_phone(String company_phone) {
        this.company_phone = company_phone;
    }

    public String getCompany_phone() {
        return company_phone;
    }

    // Getter and setter for company_address
    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    // Getter and setter for parking_slots
    public int getParking_slots() {
        return parking_slots;
    }

    public void setParking_slots(int parking_slots) {
        this.parking_slots = parking_slots;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
