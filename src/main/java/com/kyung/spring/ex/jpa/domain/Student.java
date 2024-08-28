package com.kyung.spring.ex.jpa.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "student") // 어느테이블에 매칭되는지
@Entity
public class Student {
	
	// primary key에 대응
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="phoneNumber") // 원래 컬럼에는 소문자_소문자로 써야하지만 편의를 위해서 소문자대문자 형식으로 썼음, 근데 그럼 jpa가 잘 못 찾아서 잘 찾게 도와주는 것
	private String phoneNumber; // @Column(name="테이블 컬럼 이름")
	
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	@CreationTimestamp // 자동으로 생성될 때 넣어줌
	@Column(name="createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // 자동으로 업데이트될 때 넣어줌
	@Column(name="updatedAt")
	private LocalDateTime updatedAt;
	
}
