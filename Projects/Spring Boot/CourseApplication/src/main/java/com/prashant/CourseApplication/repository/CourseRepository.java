package com.prashant.CourseApplication.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashant.CourseApplication.beans.Course;

public interface  CourseRepository extends JpaRepository<Course, BigInteger> {
    
    
}
