package com.prashant.CourseApplication.repository;

import java.math.BigInteger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prashant.CourseApplication.beans.Students;


public interface  StudentRepository extends JpaRepository<Students, BigInteger>{

}
