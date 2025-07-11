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
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		//RedirectAttributes 성공후 이동할 경로 기입
		
		log.info("BoardController.register메서드 실행..");
		
		service.register(board);
		
		rttr.addFlashAttribute("result",board.getBno());
		//1회용 값 생성 나중에 프론트에서 alert로 활용
		
		return "redirect:/board/list";
		//성공 시 다음 페이지
	}
	
	@GetMapping("/get") //http://192/168/111/104:80/board/list
	public void get(@RequestParam("bno")Long bno, Model model) {

		//url을 통해서 넘어온 bno=5문자열 long타입으로 받는다.
		log.info("BoardController.get메서드 실행..");
		
		model.addAttribute("board", service.get(bno));
		//서비스에서 매퍼를 다녀와 객체를 가져온것을 모델객체에 추가
		//프론트에서 ${board.bno} 등으로 출력가능
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
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno")Long bno, RedirectAttributes rttr) {
		//RedirectAttributes 성공후 이동할 경로 기입
		
		log.info("BoardController.remove메서드 실행..");
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
			//성공시 프론트에 result이름으로 success전송
		}			
		//1회용 값 생성 나중에 프론트에서 alert로 활용
		
		return "redirect:/board/list";
		//성공 시 다음 페이지
	}
}
