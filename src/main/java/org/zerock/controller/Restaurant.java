package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component // 스프링이 의존성 처리해줘
@Data		//dto 처리용 게터세터 tostring equls등 자동화

public class Restaurant {
 
	@Setter(onMethod_ = @Autowired)
	private Chef chef;

}
