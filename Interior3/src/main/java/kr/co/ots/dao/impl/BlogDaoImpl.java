package kr.co.ots.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class BlogDaoImpl implements NoticeDAO{

   private static final String namespace = "kr.co.sun.mapper.NoticeMapper.";
   
   @Inject
   private SqlSession sqlSession;
   
   
   
   @Override
   public List<NoticeDetailVO> getNoticeDetail(String Notice_userid) {
      return sqlSession.selectList(namespace + "NoticeDetail", Notice_userid);
   }

   @Override
   public void writetData(WriteDataDTO writeDTO) {
      sqlSession.insert(namespace + "insertData", writeDTO);
   }

   
   @Override
   public void modifyBlog(ModifyDataDTO modifyDTO) {
      sqlSession.update(namespace + "modify", modifyDTO);
   }
   
   
   @Override
   public List<BlogMainListVO> blogMainList() {
      return sqlSession.selectList(namespace + "mainBlogList");
   }

   @Override
   public int UpdatingCount(String bnum) {
      return sqlSession.update(namespace + "hit_cnt", bnum);
   }

   @Override
   public void delete(String bnum) {
      sqlSession.delete(namespace + "delete", bnum);
   }

   @Override // 리뷰 입력
   public void reviewData(ReviewDataDTO reviewDTO) {
      sqlSession.insert(namespace + "reviewWrite", reviewDTO);
   }
   @Override // 리뷰 삭제
   public void deleteReview(String bnum) {
      sqlSession.delete(namespace +"reviewDelete", bnum);
   }
   @Override // 리뷰 리스트로 출력
   public List<ReviewListVO> reviewList(String bnum) {
      //System.out.println("댓글 번호 받아라 : " + bnum);
      return sqlSession.selectList(namespace +"reviewList", bnum);
   }

   @Override
   public myBlogDetailVO getMyBlogDetail(String bnum) {
      UpdatingCount(bnum);
      return sqlSession.selectOne(namespace+"myBlogDetail", bnum);
   }

   @Override // 좋아요
   public void scoreData(ScoreDataDTO scoreDTO) {
      incScore(scoreDTO.getBlog_bnum()); // ~번 블로그에 대한 좋아요 증가
      sqlSession.insert(namespace+"scoreData" , scoreDTO);
   }

   @Override
   public int incScore(String bnum) { // 블로그 테이블의 score 증가
      return sqlSession.update(namespace+"incScore", bnum);
   }

   @Override // score테이블에 있는 데이터 삭제 bnum : 테이블에 있는 번호 블로그 번호 아님
   public void scoreDataDel(String userid) {
      //System.out.println("지울 데이터 아이디 : " + userid);
      sqlSession.delete(namespace+"scoreDataDel", userid);
   }

   @Override //카운트 감소
   public int decScore(String bnum) { // 블로그 비넘 받을거
      //System.out.println("카운트 감소 숫자 넘어옴 : " + bnum);
      return sqlSession.update(namespace+"decScore", bnum);
   }

   @Override //좋아요 데이터 출력  값 두개 넘겨서
   public ScoreDataVO score(TwoDTO two) { //score 테이블의 번호로 
      //System.out.println("two 넘어오는 값: " + two);
      return sqlSession.selectOne(namespace+"scoreSelect", two);
   }
   
   @Override // 성별 데이터
   public List<genderChartVO> genderchart(String blog_bnum) {
      return sqlSession.selectList(namespace+"genderChart", blog_bnum);
   }
   @Override //연령별 데이터
   public List<agesChartVO> agesChart(String blog_bnum) {
      return sqlSession.selectList(namespace+"agesChart", blog_bnum);
   }
   
   @Override // 같은취향 띄우기
   public List<BlogDetailVO> similarTastes(myblogDTO myDTO) {
      return sqlSession.selectList(namespace+"taste", myDTO);
   }
   
   

   



   

   
   
   
   

   
   
   
   
}