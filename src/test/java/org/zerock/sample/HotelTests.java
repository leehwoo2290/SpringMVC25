package org.zerock.sample;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.controller.Restaurant;
import org.zerock.controller.SampleHotel;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) //메서드 단위로 테스트용 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2 //Log4j 보안 취약으로 인한 교체
public class HotelTests {

	@Setter(onMethod_ = @Autowired)
	private SampleHotel hotel; //필드 선언
	
	@Test //메서드별 테스트 가능
	public void testExist() {
		//테스트용 메서드
		
		//객체가 null인지 판단
		assertNotNull(hotel);
		log.info(hotel);
		log.info("-----------");
		log.info(hotel.getChef());
		
	}
}
