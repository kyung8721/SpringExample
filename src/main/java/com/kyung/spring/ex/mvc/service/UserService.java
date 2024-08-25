package com.kyung.spring.ex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.spring.ex.mvc.domain.User;
import com.kyung.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	// 가장 최근 등록된 사용자 정보 리턴
	public User getLastUser() {
		User lastUser = userRepository.selectLastUser();
		
		return lastUser;
	}
	
	public int addUser(
			String name
			, String birthday
			, String email
			, String introduce){
		int count = userRepository.insertUser(name, birthday, email, introduce);
		
		return count;
	}
	
	public int addUserByObject(User user) {
		int count = userRepository.insertUserByObject(user);
		return count;
	}
	
	// 전달받은 email이 중복된 상태인지 알려주는 기능
	public boolean isDuplicateEmail(String email) {
		int count = userRepository.selectCountByEmail(email);
		
		if(count == 0) {
			return false; // 중복 안됨
		}else {
			return true; // 중복됨
		}
	}
}
