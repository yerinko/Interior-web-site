package kr.co.ots.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.ots.dao.CafeListDAO;
import kr.co.ots.dto.CafeCommentDTO;
import kr.co.ots.dto.CafeCommentModifyDTO;
import kr.co.ots.dto.CafeListDTO;
import kr.co.ots.vo.CafeCommentVO;
import kr.co.ots.vo.CafeDetailVO;
import kr.co.ots.vo.CafeImageVO;
import kr.co.ots.vo.CafeListVO;
import kr.co.ots.vo.CafeNameVO;

@Repository
public class CafeListDAOImpl implements CafeListDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "kr.co.ots.mapper.CafeMapper.";
	
	
	@Override
	public void scoreCafe(String dnum) {
		sqlSession.update(namespace+"scorecafe", dnum);
	}
	
	@Override
	public void scoreMain(String bnum) {
		sqlSession.update(namespace+"scoremain", bnum);
	}
	
	
	@Override
	public void hitMain(String bnum) {
		sqlSession.update(namespace+"hitmain", bnum);
	}
	
	@Override
	public void hitCafe(String dnum) {
		sqlSession.update(namespace+"hitcafe", dnum);
	}
	
	@Override
	public CafeDetailVO getCafeDetail(String dnum) {
		return sqlSession.selectOne(namespace+"detailcafe", dnum);
	}
	
	@Override
	public List<CafeCommentVO> getCafeComment(String dnum) {
		return sqlSession.selectList(namespace+"cafecomment", dnum);
	}
	
	@Override
	public List<CafeImageVO> getCafeImage(String dnum) {
		return sqlSession.selectList(namespace+"cafeimage", dnum);
	}
	
	@Override
	public void insertComment(CafeCommentDTO cafeCommentDTO) {
		sqlSession.insert(namespace+"insertcomment", cafeCommentDTO);
	}
	
	@Override
	public void deleteComment(String cnum) {
		sqlSession.update(namespace+"deletecomment", cnum);
	}
	
	@Override
	public List<CafeListVO> getCafeList() {
		
		return sqlSession.selectList(namespace+"cafelist");
	}
	
	@Override
	public List<CafeNameVO> getCafeName() {
		return sqlSession.selectList(namespace+"cafename");
	}
	
}
