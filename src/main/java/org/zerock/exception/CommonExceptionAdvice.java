package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {
	//mvc에서 예외처리를 담당하는 공통적인 지원 클래스
	
	@ExceptionHandler(Exception.class)
	public String execpt(Exception ex, Model model) {
						//예외처리			//스프링의 데이터 관리용 객체
	
		log.error("CommonExceptionAdvice. execpt()...");
		model.addAttribute("exception", ex); //예외 발생 값 모델객체로 보냄
		log.error("예외 발생" + ex.getMessage()); //콘솔에 찍히는 에러
		log.error(model); //모델에 저장된 예외문구 처리
		return "error _page";
	} // 예외처리도 스프링이 관리를 해야한다. servlet-context.xml에 scan해야함
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)//404오류에 대한 핸들링
	public String handle404(NoHandlerFoundException ex) {
		
		return "custom404"; //custom404.jsp 로 감
	}
}
