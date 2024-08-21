package com.kyung.spring.ex.ajax;

import org.springframework.stereotype.Controller;

@Controller
public class NewUserController {
	createUser(
			@RequestParam("name") String name
			, String birthday
			, String email
			, String introduce)
	
}
