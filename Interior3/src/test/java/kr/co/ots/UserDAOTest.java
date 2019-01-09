package kr.co.ots;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.ots.dao.UserDAO;
import kr.co.ots.dto.JoinDTO;
import kr.co.ots.dto.LoginDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"} )
public class UserDAOTest {

	@Inject
	private UserDAO userDAO;
	
	@Test
	public void joinUserTest() {
		JoinDTO joinDTO = new JoinDTO();
		
		joinDTO.setUserid("rin");
		joinDTO.setUserpw("2222");
		joinDTO.setUsername("yerfin3");
		joinDTO.setBirth_date("19950620");
		joinDTO.setSex("f");
		joinDTO.setImg("yerin.jpg");
		joinDTO.setStyle("diy&리폼");
		
		
		System.out.println("dto는 " + joinDTO);
		userDAO.join(joinDTO);
		System.out.println("가입성공");
	}
	
	@Test
	public void loginTest() {
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserid("rin");
		loginDTO.setUserpw("2222");
		System.out.println("디티오 : "+loginDTO);
		
		userDAO.login(loginDTO);
		
		System.out.println("로그인 성공");
		
	} 

}

