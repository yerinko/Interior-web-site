package kr.co.ots;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.ots.dao.UserDAO;
import kr.co.ots.dto.LoginDTO;
import kr.co.ots.dto.UserModifyDTO;


@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration( locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"} )
	public class UserModifyTest {

	
	
	
		@Inject
		private UserDAO userDAO;
		
	
		
		@Test
		public void modBoardTest() {
			UserModifyDTO userModifyDTO = new UserModifyDTO();
			
			
			userModifyDTO.setUserpw("11111111");

			userModifyDTO.setImg("modify.img");

			userModifyDTO.setStyle("modern");	
			userModifyDTO.setUserid("yerinko");
			userModifyDTO.getUserid("yerinko");
					
			

			System.out.println("회원정보 수정 완료 " + userModifyDTO);
		}
		
		
	}

