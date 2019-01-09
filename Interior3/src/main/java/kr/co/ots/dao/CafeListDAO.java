package kr.co.ots.dao;

import java.util.List;

import kr.co.ots.dto.CafeCommentDTO;
import kr.co.ots.dto.CafeCommentModifyDTO;
import kr.co.ots.dto.CafeListDTO;
import kr.co.ots.vo.CafeCommentVO;
import kr.co.ots.vo.CafeDetailVO;
import kr.co.ots.vo.CafeImageVO;
import kr.co.ots.vo.CafeListVO;
import kr.co.ots.vo.CafeNameVO;

public interface CafeListDAO {
	public void scoreCafe(String dnum);
	public void scoreMain(String bnum);
	public void hitMain(String bnum);
	List<CafeNameVO> getCafeName();
	List<CafeListVO> getCafeList();
	public void hitCafe(String dnum);
	CafeDetailVO getCafeDetail(String dnum);
	List<CafeCommentVO> getCafeComment(String dnum);
	List<CafeImageVO> getCafeImage(String dnum);
	public void insertComment(CafeCommentDTO cafeCommentDTO);
	public void deleteComment(String cnum);
}
