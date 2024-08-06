package com.kyung.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 클래스의 모든 메소드는 ResponseBody가 적용됨
@RequestMapping("/lifecycle/ex01")
public class Ex01RestController {
	// 직접 만든 클래스 객체 리턴
	@RequestMapping("/3")
	public Person objectResponse() {
		Person me = new Person("김인규", 29);
		
		return me;
		
		//오류나면 만든 클래스에 게터 세터 만들었는지 확인
	}
	
	// status code 전달
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse() {
		Person me = new Person("김인규", 30);
		
		// HTTP Status Code
		// 200 ok
		// 404 NOT FOUND : 페이지가 없다(주소 확인)
		// 400 BAD REQUEST : 요청이 잘못 되었음(파라미터 일치 확인)
		// 405 METHOD NOT ALLOW : 허용되지 않는 메소드(메소드가 일치하지 않음)(Get, Post)
		// 500 INTERNAL SERVER ERROR : 서버 에러(내 코드 확인)
		
		
		return new ResponseEntity(me, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
