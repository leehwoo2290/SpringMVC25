package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;

public interface BoardService {

	public boolean modify(BoardVO board);
	// 게시글 수정하기 (객체가 들어가서 수정이 됐는지 t/f)
	
	public List<BoardVO> getList();
	// 이 메서드가 호출되면 리스트타입으로 BoardVO객체 들이 넘어온다.
	// List : 동적리스트 / < > 제네릭 : 강제로 객체 타입을 정함.
	
	
}
