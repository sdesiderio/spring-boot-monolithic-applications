package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Course;
import com.example.entity.ReviewV2;

public interface ReviewRepositoryV2 extends JpaRepository<ReviewV2, String> {
	
	public List<ReviewV2> findByCourse(Course course);

}
