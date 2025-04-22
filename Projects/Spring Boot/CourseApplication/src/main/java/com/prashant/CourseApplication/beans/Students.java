package com.prashant.CourseApplication.beans;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Students {
    @Id
    private BigInteger stdid;
    private String stdname;
    private String stddepart;
    private BigInteger stdenroll;

    public BigInteger getStdid() {
        return stdid;
    }
    public void setStdid(BigInteger stdid) {
        this.stdid = stdid;
    }
    public String getStdname() {
        return stdname;
    }
    public void setStdname(String stdname) {
        this.stdname = stdname;
    }
    public String getStddepart() {
        return stddepart;
    }
    public void setStddepart(String stddepart) {
        this.stddepart = stddepart;
    }
    public BigInteger getStdenroll() {
        return stdenroll;
    }
    public void setStdenroll(BigInteger stdenroll) {
        this.stdenroll = stdenroll;
    }
    public void Student(){

    }

}
