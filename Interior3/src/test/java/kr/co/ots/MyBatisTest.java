package kr.co.ots;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}		)
public class MyBatisTest {

		@Inject
		private SqlSessionFactory sqlFactory;
		
		@Test
		public void testFactory() {
			if(sqlFactory != null) {
				System.out.println("sqlFactory 주입이 정상적으로 되었습니다. " + sqlFactory);
			}
		}
		
		@Test
		public void testSqlSessionFactory() {
			try(SqlSession sqlSession = sqlFactory.openSession()){
				System.out.println("session 객체: " + sqlSession);
			}
		}
}

