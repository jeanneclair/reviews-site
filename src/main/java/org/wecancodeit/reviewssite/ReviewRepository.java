package org.wecancodeit.reviewssite;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ReviewRepository {
	
	private Map<Long, Review> reviewRepository = new HashMap<Long, Review>();
	
	public ReviewRepository() {
		Review reviewOne = new Review(111L, "The Flash", "URL HERE", "super hero", "content");
		Review reviewTwo = new Review(222L, "Ronja, the Robber's Daughter", "URL HERE", "anime", "content");
		Review reviewThree = new Review(333L, "The Office", "URL HERE", "comedy", "content");
		
		this.addReview(reviewOne);
		this.addReview(reviewTwo);
		this.addReview(reviewThree);
	}
		

	public Map<Long, Review> getReviewRepository() {
	
		return reviewRepository;
	}


	public void addReview(Review review) {
		
		reviewRepository.put(review.getId(), review);
						
	}
	
	public int getSizeOfRepository() {
		
		return reviewRepository.size();
	}


	public Collection<Review> getReviews() {
		return reviewRepository.values();
	}


	public Review findById(long l) {
		
		return reviewRepository.get(l);
	}

}
