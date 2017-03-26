package org.mayank.restapp.simple.service;

import java.util.Map;

import org.mayank.restapp.simple.model.Course;

public interface CourseService {
	
	public Map<String, String> listOfCourse();

	public String courseById(String id);
	
}