package org.mayank.restapp.simple.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component//(Tells spring to include it in bean container/alternate to @bean declaration)
@XmlRootElement
public class Course {
	
	private String courseName;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
