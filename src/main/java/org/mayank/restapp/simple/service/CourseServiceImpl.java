package org.mayank.restapp.simple.service;

import java.util.ArrayList;

import org.mayank.restapp.simple.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	Course course;
	
	ArrayList<Course> a = new ArrayList<Course>();
	
	public Course listOfCourse(){
		course.setCourseName("SpringBoot");
		return course;
	}
}
