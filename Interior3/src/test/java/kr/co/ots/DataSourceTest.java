package kr.co.ots;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {

		@Inject
		private DataSource dataSource; 
		
		@Test
		public void testConnection() throws Exception{
			System.out.println("ds 점검 :" + dataSource);
			try(Connection con = dataSource.getConnection()){
				System.out.println("연결 성공" + con);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
}
