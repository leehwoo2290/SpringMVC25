package org.mbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mbc.domain.BoardVO;

public interface BoardMapper {
	// interface는 클래스와 다르게 메서드가 추상화처럼 되어 있다.
	// 추상메서드는 시그니쳐만 있으며 {실행문이 없다.} 그래서 ; 끝난다.
	
	@Select("SELECT * FROM tbl_board WHERE bno > 0") // bno > 0 pk로 선언되어있어서 인덱싱으로 빠른 추출
	public List<BoardVO> getList(); // 추상메서드
	
	//위 쿼리문 간단하지만 버그있음
	//그래서 xml이용하여 쿼리 처리
	//xml이용하려면 src/main/resources 폴더 아래쪽에 org 폴더 아래에 mbc 폴더 아래에 mapper 폴더를 만들고
	//인터페이스와 이름이 같은 xml 파일을 생성
	//이것이 마이바티스 사용법
	
	public List<BoardVO> getList2();
	
	// C:insert 데이터를 삽입하는 쿼리문
	//1 방법 insert 처리 후 결과 int로 받기
	//2 방법 pk 먼저 생성 후 insert하기
	public void insert(BoardVO board); //xml에서 쿼리 작성
	
	public void insertSelectKey(BoardVO board); //xml에서 쿼리 작성
	
	public BoardVO read(Long bno);
	//번호가 들어가면 객체로 나온다.
	
	public int delete(Long bno); //xml에서 쿼리 작성
	
	public int update(BoardVO board);
	//번호가 들어가면 필드 수정 후 몇개 수정 됐는 지 리턴
}
