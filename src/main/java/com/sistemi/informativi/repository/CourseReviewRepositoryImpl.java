package com.sistemi.informativi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sistemi.informativi.entity.Course;
import com.sistemi.informativi.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class CourseReviewRepositoryImpl implements CourseReviewRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addCourse(Course course) {
		
		em.persist(course);
		
	}

	@Override
	public void addReview(Review review) {
		
		em.persist(review);
		
	}

	@Override
	public void removeCourse(int id) {
		
		Course course = em.find(Course.class, id);
		
		em.remove(course);
		
	}

	@Override
	public List<Review> findAllReviewsByCourse(int courseId) {
		
		
		Course course = em.find(Course.class, courseId);
		
		/*
		 * Hibernate eseguirà una query di JOIN
		 */
		return course.getReviews();
		
	}
	
	
	

}
