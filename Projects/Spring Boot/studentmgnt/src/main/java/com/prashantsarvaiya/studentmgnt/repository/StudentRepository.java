package com.prashantsarvaiya.studentmgnt.repository;

import org.springframework.data.repository.CrudRepository;

import com.prashantsarvaiya.studentmgnt.beans.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
    
}
