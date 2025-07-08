package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) //메서드 단위로 테스트용 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2 //Log4j 보안 취약으로 인한 교체
public class TimeMapperTests {

	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		//인터페이스 추상 메서등서 실행
		log.info("타임메퍼 테스트" + timeMapper.getClass().getName());
		log.info("타임메퍼 결과" + timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2Log4jdbc() {
		//인터페이스 추상메서드 메퍼로 xml 사용
		log.info("타임메퍼2 테스트" + timeMapper.getClass().getName());
		log.info("타임메퍼2 결과" + timeMapper.getTime2());
	}
}
