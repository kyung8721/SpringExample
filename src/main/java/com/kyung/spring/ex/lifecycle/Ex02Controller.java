package com.kyung.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {
	
	@RequestMapping("/lifecycle/ex02")
	public String thymleafEx() {
		//@ResponseBody 없이 가야함!! 있으면 텍스트 그대로 리턴해버림.
		return "lifecycle/ex02";
	}
}
