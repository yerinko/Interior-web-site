package kr.co.ots;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.ots.dao.CafeListDAO;
import kr.co.ots.vo.CafeListVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DAOTest {

	// 인터페이스를 통한 주입 받기
	@Inject
	private CafeListDAO cafeListDAO;

	@Test
	public void testshow() throws Exception {
		
		List<CafeListVO> cafeListVO = cafeListDAO.getCafeList();
//		cafeListVO.setTitle1("aa");
//		cafeListVO.setTitle2("aa");
//		cafeListVO.setTitle3("aa");
//		cafeListVO.setTitle4("aa");
//		cafeListVO.setTitle5("aa");
		
		System.out.println(cafeListVO);

	}

	// @Test
	// public void testupload() throws Exception{
	//
	// ImageDTO imageDTO = new ImageDTO();
	//
	// imageDAO.upload(imageDTO);
	//
	// }
}
