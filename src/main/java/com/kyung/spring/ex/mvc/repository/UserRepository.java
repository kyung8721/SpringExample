package com.kyung.spring.ex.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.kyung.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository {

		// 가장 최근에 등록된 사용자 행 조회
		public User selectLastUser();
}
