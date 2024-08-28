package com.kyung.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyung.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	//  extends JpaRepository<엔티티 클래스, primary key타입>
	
	// 1행 insert기능이 이미 포함되어 있음
	
}
