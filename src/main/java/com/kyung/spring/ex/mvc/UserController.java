package com.kyung.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kyung.spring.ex.mvc.domain.User;
import com.kyung.spring.ex.mvc.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	// @RequestMapping(path = "/mvc/user/info", method=RequestMethod.GET) 원래는 이렇게 쓴 것
	@GetMapping("/mvc/user/info") // 이렇게 간단하게 쓸 수 있음
	public String userInfo(Model model) {
		
		User user =  userService.getLastUser();
		
		//model 매개체에 넣어 전달
		model.addAttribute("result", user);
		model.addAttribute("title", "회원정보");
		
		return "mvc/userInfo";
	}
}
