package org.mbc.controller;

import org.mbc.domain.BoardVO;
import org.mbc.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller //url분기와 jsp 연동을 담당한다.
@Log4j2
@RequestMapping("/board/*")//http://192/168/111/104:80/board/*(모든경로 담당)
@AllArgsConstructor //생성자 자동생성(모든 필드를 보고 생성자 만듬)
public class BoardController {

	//리스트와 crud담당하는 분기 설정 (url)
	
	private BoardService service;
	
	@GetMapping("/list") //http://192/168/111/104:80/board/list
	public void list(Model model) {
		//Model-> 스프링에서 데이터 관리용 객체임	
		log.info("BoardController.list메서드 실행..");
		
		model.addAttribute("list", service.getList());
		//프론트에서 ${list}로 저장
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		//RedirectAttributes 성공후 이동할 경로 기입
		
		log.info("BoardController.modify메서드 실행..");
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
			//성공시 프론트에 result이름으로 success전송
		}			
		//1회용 값 생성 나중에 프론트에서 alert로 활용
		
		return "redirect:/board/list";
		//성공 시 다음 페이지
	}
}
