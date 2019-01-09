package kr.co.ots.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.co.ots.dao.MatchingDAO;
import kr.co.ots.dto.FurnitureDTO;
import kr.co.ots.vo.ColorListVO;
import kr.co.ots.vo.ImgListVO;
import kr.co.ots.vo.MoreListVO;

@Repository
public class MatchingDAOImpl implements MatchingDAO {
	private static final Logger logger = LoggerFactory.getLogger(MatchingDAOImpl.class);
	@Inject 
	private SqlSession sqlSession;
	private static final String namespace = "kr.co.ots.mapper.MatchMapper.";
	@Override
	public List<ImgListVO> imgList() {
		logger.info("ImgList impl start");
		return sqlSession.selectList(namespace+"imgList");
	}
	
//	@Override
//	public void boardWriter(BoardWriterDTO boardWriterDTO) {
//		logger.info("boardWriter impl start");
//		sqlSession.insert(namespace+"boardWriter", boardWriterDTO);
//		
//	}
	@Override
	public void furnitureInfo(FurnitureDTO furnitureDTO) {
		logger.info("furniture insert impl start ");
		sqlSession.insert(namespace+"furnitureInfo", furnitureDTO);
	}
	
	@Override
	public List<ColorListVO> colorList(String matchPoint) {
		logger.info("colorList impl start");
		return sqlSession.selectList(namespace+"colorList", matchPoint);
	}

	@Override
	public List<ColorListVO> moreList(MoreListVO moreListVO) {
		logger.info("moreList impl start");
		System.out.println(moreListVO);
		return sqlSession.selectList(namespace+"moreList", moreListVO);
	}
	
	
	
}