package kr.co.ots;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.ots.dao.BlogDAO;
import kr.co.ots.dto.ReviewDataDTO;
import kr.co.ots.vo.BlogDetailVO;
import kr.co.ots.vo.myBlogDetailVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class blogTest {

	@Inject
	private BlogDAO blogDAO;
	
//	@Test
//	public void blogList() {
//		List<BlogMainListVO> mainList = blogDAO.blogMainList();
//		
//		for(BlogMainListVO list : mainList) {
//			System.out.println(list);
//		}
//	}
////	
//	@Test
//	public void getBlogTest() {
//		List<BlogDetailVO> getDetail = blogDAO.getBlogDetail("kth1","1");
//		
//		for(BlogDetailVO list : getDetail) {
//			System.out.println(list.toString());
//		}
//	}
//	
//	@Test
//	public void insertDataTest() {
//	
//		InsertDataDTO insert = new InsertDataDTO();
//		
//		insert.setBlog_img("6435.jpg");
//		insert.setTitle("집에가자");
//		insert.setContents("우와와왕아ㅗ아");
//		insert.setStyle("북유럽풍");
//		insert.setUserid("kyl");
//
//		//System.out.println("들어가라");
//		blogDAO.insertData(insert);
//	}
	
	@Test
	public void reviewTest() {
		ReviewDataDTO review = new ReviewDataDTO();
		
		review.setContents("안녕하세요 잘보고 갑니다~");
		review.setReview_userid("아저씨");
		
		blogDAO.reviewData(review);
		
	}
	
	@Test
	public void mydetailTest() {
		myBlogDetailVO my = new myBlogDetailVO();
		my = blogDAO.getMyBlogDetail("1");
		System.out.println("디테일 디테일 호출 : "+ my.toString());
	}
	
	

	
}
