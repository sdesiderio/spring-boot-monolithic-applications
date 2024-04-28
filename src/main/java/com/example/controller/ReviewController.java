package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.ReviewV1;
import com.example.entity.ReviewV2;
import com.example.service.CourseReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	
	// URI VERSIONING
	
	@Autowired
	private CourseReviewService courseReviewService;
	
	@GetMapping("/v1/{title}")
	public List<ReviewV1> findAllReviewsByCourseV1(@PathVariable String title){
		
		return courseReviewService.findAllReviewsByCourseV1(title);
	}
	
	@GetMapping("/v2/{title}")
	public List<ReviewV2> findAllReviewsByCourseV2(@PathVariable String title){
		
		return courseReviewService.findAllReviewsByCourseV2(title);
	}
	
	// END URI VERSIONING
	
	
	// Request Parameters
	@GetMapping(value="/{title}/param", params="version=1")  
    public List<ReviewV1> findAllReviewsByCourseVersion1(@PathVariable String title){
		
		return courseReviewService.findAllReviewsByCourseV1(title);
	} 
	
	@GetMapping(value="/{title}/param", params="version=2")  
    public List<ReviewV2> findAllReviewsByCourseVersion2(@PathVariable String title){
		
		return courseReviewService.findAllReviewsByCourseV2(title);
	} 
	
	// End Request Parameters
	
	// Request Headers
	    @GetMapping(value="/{title}/header", headers="review-API-Version=1")   
	    public List<ReviewV1> findAllReviewsByCourseVers1(@PathVariable String title){
			
			return courseReviewService.findAllReviewsByCourseV1(title);
		} 
		
	    @GetMapping(value="/{title}/header", headers="review-API-Version=2")  
	    public List<ReviewV2> findAllReviewsByCourseVers2(@PathVariable String title){
			
			return courseReviewService.findAllReviewsByCourseV2(title);
		} 
		
		// End Request Headers
	    
	 // Accept Headers - content negotiation
	    @GetMapping(value="/{title}/produces", produces="application/vnd.review.app-v1+json")    
	    public List<ReviewV1> findAllReviewsByCourseVer1(@PathVariable String title){
			
			return courseReviewService.findAllReviewsByCourseV1(title);
		} 
		
	    @GetMapping(value="/{title}/produces", produces="application/vnd.review.app-v2+json")  
	    public List<ReviewV2> findAllReviewsByCourseVer2(@PathVariable String title){
			
			return courseReviewService.findAllReviewsByCourseV2(title);
		} 
		
		// End Accept Headers - content negotiation


}
