package kr.co.ots.dao;

import java.util.List;

import kr.co.ots.dto.ModifyDataDTO;
import kr.co.ots.dto.ReviewDataDTO;
import kr.co.ots.dto.ScoreDataDTO;
import kr.co.ots.dto.TwoDTO;
import kr.co.ots.dto.WriteDataDTO;
import kr.co.ots.dto.myblogDTO;
import kr.co.ots.vo.BlogDetailVO;
import kr.co.ots.vo.BlogMainListVO;
import kr.co.ots.vo.BlogRankVO;
import kr.co.ots.vo.ReviewListVO;
import kr.co.ots.vo.ScoreDataVO;
import kr.co.ots.vo.agesChartVO;
import kr.co.ots.vo.myBlogDetailVO;
import kr.co.ots.vo.genderChartVO;

public interface BlogDAO {

   
   public List<BlogRankVO> blogRank();
   
   public void writetData(WriteDataDTO writeDTO);
   
   public List<BlogMainListVO> blogMainList(); // 메인 화면 블로그
   
   public List<BlogDetailVO> getBlogDetail(String blog_userid);
   //메인 화면 블로그 클릭시 들어가는곳 리스트로
   public List<BlogDetailVO> similarTastes(myblogDTO myDTO);
   
   public myBlogDetailVO getMyBlogDetail(String bnum);
   
   public int UpdatingCount(String bnum);
   
   public void delete(String bnum); //블로그 댓글 삭제
   
   public void modifyBlog(ModifyDataDTO modifyDTO); // 수정 데이터 입력
   
   public void reviewData(ReviewDataDTO reviewDTO); //리뷰 입력
   
   public void deleteReview(String bnum); // 리뷰 번호로 삭제
   
   public List<ReviewListVO> reviewList(String bnum);
   
   public void scoreData(ScoreDataDTO scoreDTO); // 좋아요 데이터 입력
   
   public int incScore(String bnum); // 좋아요 증가 
   
   public void scoreDataDel(String userid); 
   
   public int decScore(String bnum); // 좋아요 카운트 감소 bnum : tb_blog의 비넘
   
   public ScoreDataVO score(TwoDTO two); 
   
   public List<genderChartVO> genderchart(String blog_bnum); //성별 차트
   
   public List<agesChartVO> agesChart(String blog_bnum); // 연령대별 차트

   
}; 