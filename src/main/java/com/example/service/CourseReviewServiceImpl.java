package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Course;
import com.example.entity.ReviewV1;
import com.example.entity.ReviewV2;
import com.example.repository.CourseRepository;
import com.example.repository.ReviewRepositoryV1;
import com.example.repository.ReviewRepositoryV2;

@Service
public class CourseReviewServiceImpl implements CourseReviewService{
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ReviewRepositoryV1 reviewRepositoryV1;
	
	@Autowired
	private ReviewRepositoryV2 reviewRepositoryV2;

	@Override
	public List<ReviewV1> findAllReviewsByCourseV1(String title) {
		
		Course course = courseRepository.findById(title).get();
		
		return reviewRepositoryV1.findByCourse(course);
		
		
	}

	@Override
	public List<ReviewV2> findAllReviewsByCourseV2(String title) {
		
        Course course = courseRepository.findById(title).get();
		
		return reviewRepositoryV2.findByCourse(course);
	}

}
