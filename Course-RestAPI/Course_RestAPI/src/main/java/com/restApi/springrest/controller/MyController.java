package com.restApi.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.springrest.entities.Course;
import com.restApi.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		
		return "This is home page";
	}
	
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId )
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	// creating courses
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);
	}
	
	//updating courses
	@PutMapping("/courses/{courseId}")
	public Course updateCourse(@PathVariable String courseId, @RequestBody Course course)
	{
		return this.courseService.updateCourse(Long.parseLong(courseId), course);
	}
	
	// deleting courses
	@DeleteMapping("/courses/{courseId}")
	public boolean deleteCourse(@PathVariable String courseId )
	{
		return this.courseService.deleteCourse(Long.parseLong(courseId));
	}
	

}
