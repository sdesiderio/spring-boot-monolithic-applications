package com.example.service;

import java.util.List;

import com.example.entity.ReviewV1;
import com.example.entity.ReviewV2;

public interface CourseReviewService {
	
	public List<ReviewV1> findAllReviewsByCourseV1(String title);
	
	public List<ReviewV2> findAllReviewsByCourseV2(String title);

}
