package kr.co.ots.dao;

import javax.servlet.http.HttpSession;

import kr.co.ots.dto.InsertDataDTO;
import kr.co.ots.dto.JoinDTO;
import kr.co.ots.dto.LoginDTO;
import kr.co.ots.dto.ModifyDataDTO;
import kr.co.ots.dto.UserModifyDTO;
import kr.co.ots.vo.CheckUserIdVO;
import kr.co.ots.vo.LoginVO;
import kr.co.ots.vo.MemberInfoVO;

public interface UserDAO {
	
	public void join(JoinDTO joinDTO ); //회원 가입
	
	public LoginVO login(LoginDTO loginDTO ); //로그인
	
	public CheckUserIdVO checkUser(String joinid); // 로그인 중복체크
	
	
	void modUser(UserModifyDTO userModifyDTO); // 회원 정보 수정 
	
	public MemberInfoVO memberInfo(String userid);


	}

		

	

	

	/*public void updateUser(JoinDTO joinDTO);*/
	
	//public MemberInfoVO memberInfo(String userid); //회원 정보 뽑아오기


	