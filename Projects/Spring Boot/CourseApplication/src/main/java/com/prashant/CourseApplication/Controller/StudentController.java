package com.prashant.CourseApplication.Controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.CourseApplication.beans.Students;

import com.prashant.CourseApplication.repository.StudentRepository;

@RestController
public class StudentController{
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/students")
    public List<Students> getStudents(){
        return studentRepository.findAll();
    }

    @RequestMapping(value="/students",method=RequestMethod.POST)
    public void saveStudent(@RequestBody Students student){
        studentRepository.save(student);
    }

    @RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
    public void deleteStudent(@PathVariable BigInteger id){
        studentRepository.deleteById(id);
    }

    @RequestMapping(value="/students/{id}", method=RequestMethod.GET)
    public void getStudentByID(@PathVariable BigInteger id){
        studentRepository.findById(id);
    }
}