package com.restApi.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.restApi.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Course(125, " java ", "this course contains basics of java"));
		list.add(new Course(126, " spring boot ", "this course contains creating rest api"));
	}

	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c=null;
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public boolean deleteCourse(long courseId) {
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				list.remove(course);
				return true;
			}
		}
		return false;
	}

	@Override
	public Course updateCourse(long courseId, Course course) {
		for(Course c:list)
		{
			if(c.getId()==courseId)
			{
				c.setId(course.getId());
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
				return c;
			}
		}
		return null;
	}

}
