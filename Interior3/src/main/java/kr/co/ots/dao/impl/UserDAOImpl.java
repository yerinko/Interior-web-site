package kr.co.ots.dao.impl;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ots.dao.UserDAO;
import kr.co.ots.dto.JoinDTO;
import kr.co.ots.dto.LoginDTO;
import kr.co.ots.dto.UserModifyDTO;
import kr.co.ots.vo.CheckUserIdVO;
import kr.co.ots.vo.LoginVO;
import kr.co.ots.vo.MemberInfoVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "kr.co.ots.mappers.UserMapper.";
	
	
	
	@Override
	public LoginVO login(LoginDTO loginDTO ){
		return sqlSession.selectOne(namespace+"login", loginDTO);
	}
	
	
	
	
	@Override
	public void join(JoinDTO joinDTO){
		System.out.println("여기는 DTO :" + joinDTO);
		sqlSession.insert(namespace+"join", joinDTO);
	}
	
	@Override
	public CheckUserIdVO checkUser(String joinid) {
		return sqlSession.selectOne(namespace+"checkUserId", joinid);
	}
	
	
	
	@Override
	public void modUser(UserModifyDTO userModifyDTO) {
		sqlSession.update(namespace + "modUser", userModifyDTO);		
		
	}
	
	@Override
	   public MemberInfoVO memberInfo(String userid) { // userid로 회원 정보 뽑기
	      return sqlSession.selectOne(namespace+"memberInfo", userid);
	   }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@Override
//	public MemberInfoVO memberInfo(String userid) {
//		return sqlSession.selectOne(namespace+"", userid);
//	}
}