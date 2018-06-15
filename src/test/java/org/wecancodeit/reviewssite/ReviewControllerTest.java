package org.wecancodeit.reviewssite;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.reviewssite.Review;
import org.wecancodeit.reviewssite.ReviewRepository;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)

public class ReviewControllerTest {
	
	@Resource
	MockMvc mvc;

	@MockBean
	ReviewRepository reviewRepository;

	@Mock
	Review review;
	
	@Test //Do i have a template?
	public void getReviewsShouldReturnReviewsView() throws Exception {
		mvc.perform(get("/reviews")).andExpect(view().name(is(equalTo("reviews"))));
	}
	
	@Test //Do i have a successful connection to the browser, client side?
	public void getReviewsShouldBeSuccessful() throws Exception {
		mvc.perform(get("/reviews")).andExpect(status().is2xxSuccessful());
	}
	
	@Test //Am I adding the attributes correctly?
	public void getReviewsShouldReturnAllReviews() throws Exception {
		mvc.perform(get("/reviews")).andExpect(model().attribute("reviews", is(reviewRepository.getReviews())));
	}
	
	@Test //fail
	public void getReviewShouldReturnReviewsView() throws Exception {
		mvc.perform(get("/reviews/12")).andExpect(view().name(is(equalTo("review"))));
	}
	
	@Test //fail
	public void getReviewShouldBeSuccessful() throws Exception {
		mvc.perform(get("/reviews/12")).andExpect(status().is2xxSuccessful());
		
	}
	
	@Test //fail
	public void getReviewShouldReturnOneReview() throws Exception {
		mvc.perform(get("/reviews/12")).andExpect(model().attribute("review", is(reviewRepository.findById(12L))));
	}

	
}
