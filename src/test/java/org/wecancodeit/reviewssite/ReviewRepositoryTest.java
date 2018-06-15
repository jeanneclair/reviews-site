package org.wecancodeit.reviewssite;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

public class ReviewRepositoryTest {

	ReviewRepository reviewRepo = new ReviewRepository();
	Review review = new Review(1L, "Test Title", "Test URL", "sci-fi", "content");
	
	
	@Test
	public void addReviewShouldAddtoRepo() {
		
		int sizeBeforeAddReview = reviewRepo.getSizeOfRepository();
		reviewRepo.addReview(review);
		int sizeAfterAddReview = reviewRepo.getSizeOfRepository();
		
		assertThat(sizeAfterAddReview, equalTo(sizeBeforeAddReview + 1));
		
	}
	
	@Test
	public void getReviewsShouldReturnAllValues() {
		
		Collection<Review> underTest = reviewRepo.getReviews();
		
		assertThat(underTest.size(), equalTo(3));
		
	}
	
	@Test
	public void getReviewsShouldReturnReviews() {
		Collection<Review> underTest = reviewRepo.getReviews();
		
		for (Review review : underTest) {
			
			assertTrue(review instanceof Review);
			
		}
	}
	
	@Test
	public void findByIdShouldReturnReview() {
		
		Review underTest = reviewRepo.findById(111L);
		
		assertThat(underTest.getTitle(), equalTo("The Flash"));
	}
	
}
