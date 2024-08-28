package com.kyung.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyung.spring.ex.jpa.domain.Student;
import com.kyung.spring.ex.jpa.service.StudentService;

@Controller
public class StrundentController {
	@Autowired
	private StudentService studentService;
	
	// C, U, D
	@GetMapping("/jpa/student/create")
	@ResponseBody
	public Student createStudent() {
		// 김인규, 010-1234-5678, lecture@hagulu.com, 개발자
		Student student = studentService.addStudent("김인규", "010-1234-5678", "lece@hagulu.com", "개발자");
		
		return student;
	}
	
	
	
	@GetMapping("/jpa/lombok/test")
	@ResponseBody
	public Student lombokTest() {
		/*
		 * Student student = new Student(10, "김인규", "010-1111-2222",
		 * "lecture@jagulu.com", "프로그래머", null, null);
		 * student.setPhoneNumber("010-0000-9999");
		 */
		
		Student student = Student.builder()
				.name("김인규")
				.phoneNumber("010-2222-2222")
				.dreamJob("프로그래머")
				.email("lecture@hagulu.com")
				.build();
		
		return student;
		
	}
}
