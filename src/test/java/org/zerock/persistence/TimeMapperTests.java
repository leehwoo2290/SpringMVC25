package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) // 메서드단위로 테스트용 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 테스트시 사용될 코드
@Log4j2 
public class TimeMapperTests {

	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		
		log.info("타입매퍼 테스트 getname : " + timeMapper.getClass().getName());
		log.info("타입매퍼 결과 : " + timeMapper.getTime());
		
	}
	
}
