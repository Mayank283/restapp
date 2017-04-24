package org.mayank.restapp.simple.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{
	
//	@Autowired
//	Course course;
	//String[] course = {"Mayank Agarwal","Sita Ram Agarwal","Srachendra Agarwal","Rekha Agarwal"};
	Map<String,String> course = new HashMap<String,String>();
	
	//public Course listOfCourse(){
	public Map<String,String> listOfCourse(){
		//course.setCourseName("SpringBootWithAngular");
		course.put("Name", "Mayank");
		course.put("Player", "Sachin");
		course.put("Terror", "Afzal");
		course.put("super", "Virat");
		return course;
	}
	
	public String courseById(String id){
		return course.get(id);
	}
}
