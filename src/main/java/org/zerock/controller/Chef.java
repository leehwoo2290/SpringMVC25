package org.zerock.controller;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // 스프링이 의존성 처리해줘
@Data		//dto 처리용 게터세터 tostring equls등 자동화
public class Chef {

	private String age;
	private String name;
}
