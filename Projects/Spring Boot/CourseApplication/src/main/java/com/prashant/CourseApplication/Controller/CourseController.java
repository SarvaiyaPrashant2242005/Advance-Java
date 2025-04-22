package com.prashant.CourseApplication.Controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.CourseApplication.beans.Course;
import com.prashant.CourseApplication.repository.CourseRepository;

@RestController
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping("/courses")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @RequestMapping(value = "/course", method=RequestMethod.POST)
    public void saveCourse(@RequestBody Course course){
        courseRepository.save(course);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Optional<Course> getCourseById(@PathVariable BigInteger id){
        return courseRepository.findById(id);
    }

    @RequestMapping(value ="/delete/{id}", method=RequestMethod.DELETE)
    public void deletecourse(@PathVariable BigInteger id){
        courseRepository.deleteById(id);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.PUT)
    public void updatecourse(@PathVariable BigInteger id){
        
    }

}
