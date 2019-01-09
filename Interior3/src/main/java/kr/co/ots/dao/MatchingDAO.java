package kr.co.ots.dao;

import java.util.List;

import kr.co.ots.dto.FurnitureDTO;
import kr.co.ots.vo.ColorListVO;
import kr.co.ots.vo.ImgListVO;
import kr.co.ots.vo.MoreListVO;

public interface MatchingDAO {

	public List<ImgListVO> imgList();
	
	public List<ColorListVO> colorList(String matchPoint);
	
	public List<ColorListVO> moreList(MoreListVO morListVO);
	
	public void furnitureInfo(FurnitureDTO furnitureDTO);
	
//	public void boardWriter(BoardWriterDTO boardWriterDTO);
}
