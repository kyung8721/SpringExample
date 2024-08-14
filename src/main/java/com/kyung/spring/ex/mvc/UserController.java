package com.kyung.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyung.spring.ex.mvc.domain.User;
import com.kyung.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/mvc/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	// 사용자 정보 저장 기능
	@PostMapping("/create")
	public String createUser(Model model,
			@RequestParam("name")String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce){
//		int count = userService.addUser(name, birthday, email, introduce);
		
		//user 객체 생성
		User user = new User();
		// user 객체에 값 추가
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce);
		
		// 객체를 넘겨서 insert 과정 수행(service로 객체 전달)
		userService.addUserByObject(user);
		
		// id 가져오기
		int id = user.getId();
		
		// return "redirect:/mvc/user/info";
		model.addAttribute("result", user);
		return "mvc/userInfo";
	}
	
	// 입력화면 페이지
	@GetMapping("/input")
	public String userInput() {
		return "mvc/userInput";
	}
	
	
	
	
	// @RequestMapping(path = "/mvc/user/info", method=RequestMethod.GET) 원래는 이렇게 쓴 것
	@GetMapping("/info") // 이렇게 간단하게 쓸 수 있음
	public String userInfo(Model model) {
		
		User user =  userService.getLastUser();
		
		//model 매개체에 넣어 전달
		model.addAttribute("result", user);
		model.addAttribute("title", "회원정보");
		
		return "mvc/userInfo";
	}
}
