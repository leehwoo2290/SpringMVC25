package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	public String getTime2();
	//이 메서드 호출되면 마이 바티스에서 xml을 찾는다.
	//src/main/resources/org/zerock/mapper/TimeMapper.xml을 활용한다.
}
