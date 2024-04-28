package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Course;
import com.example.entity.ReviewV1;

public interface ReviewRepositoryV1 extends JpaRepository<ReviewV1, String> {
	
	public List<ReviewV1> findByCourse(Course course);

}
