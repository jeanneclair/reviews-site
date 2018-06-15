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
	
	@Test
	public void getReviewsShouldReturnReviewsView() throws Exception {
		mvc.perform(get("/reviews")).andExpect(view().name(is(equalTo("reviews"))));
	}
	
	@Test
	public void getReviewsShouldBeSuccessful() throws Exception {
		mvc.perform(get("/reviews")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void getReviewsShouldReturnAllReviews() throws Exception {
		mvc.perform(get("/reviews")).andExpect(model().attribute("reviews", is(reviewRepository.getReviews())));
	}
	

	
}
