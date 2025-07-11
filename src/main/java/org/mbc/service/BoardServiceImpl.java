package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;
import org.mbc.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service // 이 클래스는 서비스 계층임을 명시한다.
@AllArgsConstructor // 생성자 자동 주입 (new BoardServiceImpl(mapper);
@Log4j2 // 로깅 처리용
public class BoardServiceImpl implements BoardService{
	// 조원이 실행문을 생성하는 용도로 활용 필수 : implements BoardService (구현클래스)
	
	//private MemberMapper m_mapper;
	private BoardMapper mapper ; // db 쿼리용 객체(CRUD)
	
	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		
		log.info("BoardServiceImpl.register 실행");
		
		mapper.insertSelectKey(board);
		log.info("정상등록 후 리스트 출력테스트");
		mapper.getList2();
	}

	@Override
	public BoardVO get(Long bno) {

		log.info("BoardServiceImpl.get 실행");
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {

		log.info("BoardServiceImpl.modify 실행");
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {

		log.info("BoardServiceImpl.remove 실행");
		
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		
		log.info("BoardServiceImpl.getList 실행");
		
		return mapper.getList2();
	}
	

}
