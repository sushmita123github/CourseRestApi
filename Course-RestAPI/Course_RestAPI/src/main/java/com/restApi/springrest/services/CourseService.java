package com.restApi.springrest.services;

import java.util.List;

import com.restApi.springrest.entities.Course;

public interface CourseService {

	public List<Course> getCourses();

	public Course getCourse(long courseId);

	public Course addCourse(Course course);

	public boolean deleteCourse(long courseId);

	public Course updateCourse(long courseId, Course course);
}
