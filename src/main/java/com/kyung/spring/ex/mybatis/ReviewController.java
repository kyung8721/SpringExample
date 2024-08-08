package com.kyung.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyung.spring.ex.mybatis.domain.Review;
import com.kyung.spring.ex.mybatis.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	// parameter로 전달받은 id와 일치하는 리뷰 정보를 json으로 Response에 담는다
	@ResponseBody
	@RequestMapping("/mybatis/review")
	public Review review(@RequestParam("id") int id) { // @RequestParam("id") : 파라미터로 전달된 변수, int id : 파라미터로 전달된 변수의 타입과 이름
		
		// request Parameter
		// request.getParameter("id");
		Review review = reviewService.getReview(id);
		
		return review;
	}
		
}
