package com.pratyush.springbootrestapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratyush.springbootrestapi.dao.CourseDao;
import com.pratyush.springbootrestapi.entity.Course;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	
	
	@Autowired
	private CourseDao courseDao;
	
	
	@Override
	public List<Course> getCourses() {
		
		
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		
		return courseDao.findById(courseId).get();
	}

	@Override
	public Course addCourse(Course course) {
		
	
		return courseDao.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		
		
		return courseDao.save(course);
	}

	@Override
	public void deleteCourse(Long courseId) {
		
		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
		}
	
	

}
