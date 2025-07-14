package org.mbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mbc.domain.BoardVO;

public interface BoardMapper {
	// 그래서 xml를 이용하여 sql문 처리를 진행한다.
	// xml을 이용하려면 src/main/resources폴더 아래쪽에 org폴더 아래에 mbc 폴더 아래에 mapper 폴더를 만들고
	// 인터페이스와 이름이 같은 xml 파일을 생성한다.
	// 이것이 마이바티스 사용법이다.
	public List<BoardVO> getList2();
	// xml을 이용한 쿼리 처리 메퍼용 메서드
	
	public int update(BoardVO board); // xml에서 쿼리작성
	// 번호가 들어가면 필드 수정후 몇개가 수정됐는지 리턴한다.

}
