package org.zerock.controller;

import java.net.http.HttpHeaders;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Controller //servlet- context.xml 에서 <context:component-scan
//base-package="org.zerock.sample"></context:component-scan>
@RequestMapping("/sample/*") // http:192.168.111.104:80/controller/sample/ 모든것에 반응
@Log4j2 // resources폴더에 log4j2.xml 필수
public class SampleController {

	@RequestMapping("")// == http:192.168.111.104:80/controller/sample/
	public void basic() {
		
		log.info("SampleController.basic() 메서드 실행");
		log.info("리턴이 void 이기 때문에 basic.jsp 파일 찾는다.");
		log.info("현재 /web-inf/view/basic.jsp가 없으므로 크롬에는 오류남");
	}
	
	@RequestMapping(value= "/basic", method= {RequestMethod.GET, RequestMethod.POST})
	// == http:192.168.111.104:80/controller/sample/basic -> get ,post 메서드
	public void basicGet() {
		log.info("SampleController.basicGet() 메서드 실행");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2(){
		log.info("SampleController.basicGet2() 메서드 실행");
		
	}
	
	@PostMapping("/basicOnlyPost")
	public void basicPost3(){
		log.info("SampleController.basicPost3() 메서드 실행");
		
	}
	
	@GetMapping("/ex01") //== http:192.168.111.104:80/controller/sample/ex01?name=kkw&age=33
	public String ex01(SampleDTO dto) { //SampleDTO = new SampleDTO(
	
		log.info("SampleController.ex01() 메서드 실행");
		log.info("입력 dto 확인" + dto);
		return "ex01"; //WEB-INF/views/ex01.jsp ->servlet-context.xml이 하는일
	}
	
	@GetMapping("/ex02")
	public String ex02(
			@RequestParam("name") String name,
			@RequestParam("age") String age) {
		
		log.info("name" + name);
		log.info("age" + age);
		
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	//http://192.168.111.104:80/controller/sample/ex02List?ids=111&ids=222&ids=333
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		//리스트에 넘어오는 데이터 처리
		
		log.info("리스트로 넘어온 데이터 처리" + ids);
		log.info("리스트2번째 값" + ids.get(1));
		return "ex02List";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		//url 경로에 배열로 들어오는 파라미터
		// ex02Bean?list[0].name=kkw&list[2].age=33
		log.info("list SampleDTOs : " + list);
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		
		log.info("todo : " + todo);
		
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		// @ModelAttribute("page") 안쓰면 백엔드에 전달안됨
		log.info("dto : " + dto);
		log.info("page : " + page);
		return "/sample/ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("SampleController.ex05 실행");
		
		//리턴이 void면 /web-inf/view/sample/ex05.jsp찾음
		
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		//@ResponseBody json 타입으로 출력
		log.info("SampleController.ex06 메서드 실행");
		
		SampleDTO dto = new SampleDTO();
		dto.setName("kke");
		dto.setAge(33);
		
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		//ResponseEntity<String> 응답헤더 (200ok)를 만들어 리턴한다.
		
		log.info("SampleController.ex07 메서드 실행");
	
		String msg = "{\"name\":\"kkw\"}";//json타입으로 {name:kkw}
		
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders()
		//HttpHeaders header; //= new HttpHeaders();
		header.add("Content-type","application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(msg,header,HttpStatus.OK);
	}
}
