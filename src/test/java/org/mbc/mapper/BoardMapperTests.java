package org.mbc.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mbc.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {
	// board에서 사용하는 데이터베이스 테스트용!!!
	
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;  // 인터페이스로 만든 객체를 세터로 연결
	
	@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		board.setBno(26L);
		board.setTitle("이번 테스트 수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("테스트수정");
		
		int count = mapper.update(board);
		log.info("수정된 갯수 : " + count + "건");
		log.info("수정된 객체 출력 :" + board);
	
	}
}
