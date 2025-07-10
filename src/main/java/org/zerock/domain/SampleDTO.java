package org.zerock.domain;

import lombok.Data;

@Data
public class SampleDTO {

	//자바 빈즈 규약
	//1. 필드는 private
	//2. 생성자 기본 생성자 필수
	//3. 게터/세터 사용
	//lombok을 이용하면 자동으로 생성된다.
	
	private String name;
	private int age;
	
}
