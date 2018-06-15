package org.wecancodeit.reviewssite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@RequestMapping("/reviews")
	public String getReviews(Model model) {
		model.addAttribute("reviewRepository", reviewRepository.getReviews());
		return "reviews";
	}
	

}
