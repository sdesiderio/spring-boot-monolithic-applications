package com.sistemi.informativi;


import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemi.informativi.entity.Course;
import com.sistemi.informativi.entity.Review;
import com.sistemi.informativi.repository.CourseReviewRepository;

@SpringBootApplication
public class SbJpaCrudOneToManyApplication implements CommandLineRunner{
	
	// CONSTRUCTOR DEPENDENCY INJECTION
	private CourseReviewRepository courseReviewRepository;
	
	public SbJpaCrudOneToManyApplication(CourseReviewRepository courseReviewRepository) {
		
		this.courseReviewRepository = courseReviewRepository;
	}
	// END CONSTRUCTOR DEPENDENCY INJECTION

	public static void main(String[] args) {
		SpringApplication.run(SbJpaCrudOneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Course course1 = new Course("Java SE","Basic Course");
		Course course2 = new Course("Java EE","Advanced Course");
		
		// INSERIMENTO DI DUE COURSE
		courseReviewRepository.addCourse(course1);
		courseReviewRepository.addCourse(course2);
		
		// ASSOCIAZIONE DI DUE REVIEW AL COURSE JAVA SE
		Review review1 = new Review("Rome",course1);
		Review review2 = new Review("Milan",course1);
		
		// ASSOCIAZIONE DI DUE REVIEW AL COURSE JAVA EE
		Review review3 = new Review("Florence",course2);
		Review review4 = new Review("Neaples",course2);
		
		
	    // INSERIMENTO DELLE REVIEW ASSOCIATE
		courseReviewRepository.addReview(review1);
		courseReviewRepository.addReview(review2);
		courseReviewRepository.addReview(review3);
		courseReviewRepository.addReview(review4);
		
		// CANCELLAZIONE COURSE CON IL CASCADE SULLE REVIEW
		courseReviewRepository.removeCourse(2);
		
		
		// RICERCA DI TUTTE LE REVIEWS RELATIVE AL COURSE CON id =1 (Java SE)
		List<Review> reviews = courseReviewRepository.findAllReviewsByCourse(1);
		
		for (Review review : reviews) {
			
			System.out.println(review.toString());
		}
		
		
		
	}

}
