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
	
	@Test // import org.junit.Test; (메서드 단위로 테스트)
	public void testGetList() {
		
		mapper.getList().forEach(board -> log.info(board) );
		// 인터페이스.메서드.for문   결과객체 
		//                             -> 람다식(인터페이스용)
		//                                log.info 콘솔에 출력(board.toString)
	
	}
	
	@Test // import org.junit.Test; (메서드 단위로 테스트)
	public void testGetListXML() {
		
		mapper.getList2().forEach(board -> log.info(board) );
		// 인터페이스.메서드.for문   결과객체 
		//                             -> 람다식(인터페이스용)
		//                                log.info 콘솔에 출력(board.toString)
	
	}
	
	@Test // import org.junit.Test; (메서드 단위로 테스트)
	public void testInsert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("오류 없어라");
		board.setContent("오류 오류");
		board.setWriter("이현우");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	@Test // import org.junit.Test; (메서드 단위로 테스트)
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		board.setTitle("오류 없어라");
		board.setContent("오류 오류");
		board.setWriter("이현우");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
		log.info("번호" + board.getBno());
	}
	
	@Test // import org.junit.Test; (메서드 단위로 테스트)
	public void testRead() {
		
		BoardVO board = mapper.read(1L);
		
		log.info(board);
	
	}
	
	@Test // import org.junit.Test; (메서드 단위로 테스트)
	public void testDelete() {
		
		int count = mapper.delete(1L);
		
		log.info("삭제된 갯수 출력" + count );
	
	}
	
	@Test // import org.junit.Test; (메서드 단위로 테스트)
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		board.setBno(0L);
		board.setTitle("오류 없어라");
		board.setContent("오류 오류");
		board.setWriter("이현우");
		
		int count = mapper.update(board);
	
		log.info("수정된 갯수" +count);
		log.info("수정된 객체" +board);
	
	}
}
