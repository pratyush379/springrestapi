package com.pratyush.springbootrestapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pratyush.springbootrestapi.entity.Course;


@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList();
		list.add(new Course(101,"java","core java"));
		list.add(new Course(102,"c++","good course on advance c++"));
	}
	
	@Override
	public List<Course> getCourses() {
		
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		Course c  = null;
		for(Course course : list) {
			if(course.getId()==courseId) {
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
	public Course updateCourse(Course course) {
		
		list.forEach(e->{
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});

		return course;
	}

	@Override
	public void deleteCourse(Long courseId) {
		
		list = this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
	}
	
	

}
