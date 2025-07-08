package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2 //콘솔 로그용
public class JDBCTests {

		static{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
			
			@Test			
			public void testConnection() {
				try {
					Connection con = DriverManager.getConnection(
							"jdbc:oracle:thin:@192.168.111.104:1521:xe",
							"book_ex",
							"book_ex");
					log.info(con);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
}
