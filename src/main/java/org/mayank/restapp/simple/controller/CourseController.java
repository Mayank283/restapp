package org.mayank.restapp.simple.controller;

import java.util.Map;

import org.mayank.restapp.simple.error.ErrorResponse;
import org.mayank.restapp.simple.exception.CourseNotFoundException;
import org.mayank.restapp.simple.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,String>> listOfCourse(){
	//public Course listOfCourse(){
		Map<String,String> course = courseService.listOfCourse(); 
		return new ResponseEntity<Map<String,String>>(course,HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String courseById(@PathVariable("id") String id) throws CourseNotFoundException{
	//public Course listOfCourse(){
		String course = courseService.courseById(id); 
		if (course == null) {
//            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			throw new CourseNotFoundException("Course is not available");
        }
		return course;
//		return new ResponseEntity<String>(course,HttpStatus.OK);
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}