package org.zerock.controller;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
//@AllArgsConstructor
@RequiredArgsConstructor
public class SampleHotel {
	//스프링의 의존성 주입은 생성자 주입과 세터 주입을 자주 사용한다.
	//생성자 주입은 롬북이 알아서 파라미터 만들어줌
	// 세터 주입은 값을 저장할 시 자동으로 생성
	
	private Chef chef;
	
	private Restaurant restaurant;
	
	@NonNull	
	private String name;
}
