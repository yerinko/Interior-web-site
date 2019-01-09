package kr.co.ots.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.ots.dao.UserDAO;
import kr.co.ots.dto.JoinDTO;
import kr.co.ots.dto.LoginDTO;
import kr.co.ots.dto.UserModifyDTO;
import kr.co.ots.vo.CheckUserIdVO;
import kr.co.ots.vo.LoginVO;


@Controller
@RequestMapping("/user")
@SessionAttributes("session")
public class UserController {

	@Inject
	private UserDAO UserDAO;

	// 로그인 폼 이동
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginform() throws Exception {
		return "/loginForm";
	}

	// 로그인
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(LoginDTO loginDTO, Model model, HttpSession session) {
		LoginVO loginVO = UserDAO.login(loginDTO);
		model.addAttribute("login", loginVO);

		if (loginVO == null) {
			System.out.println("로그인 실패 다시 이동");
			return "redirect:/user/loginForm.do";
		} else {
			session.setAttribute("loginUserid", loginVO.getUserid());
			session.setAttribute("profileImg", loginVO.getImg());
			session.setAttribute("style", loginVO.getStyle());

		}
		return "redirect:/main/page";
	}

	// 회원가입
	@RequestMapping(value = "/join")
	public String joinForm() throws Exception {
		return "/joinForm";
	}

	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/page";
	}

	// 회원 정보
	@RequestMapping(value = "/doJoin")
	public String join(MultipartHttpServletRequest req, JoinDTO joinDTO) {

		System.out.println(joinDTO.toString());
		MultipartFile mf = req.getFile("file");

		String path = "D:\\profile\\";
		File saveDir = new File(path);

		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		try {
			String originalFileName = new String(mf.getOriginalFilename().getBytes("8859_1"), "UTF-8");
			String saveFile = path + System.currentTimeMillis() + originalFileName;
			String img = System.currentTimeMillis() + originalFileName;

			joinDTO.setImg(img);
			joinDTO.setStyle((new String(req.getParameter("style").getBytes("8859_1"), "UTF-8")));
			joinDTO.setUsername((new String(req.getParameter("username").getBytes("8859_1"), "UTF-8")));
			joinDTO.setSex((new String(req.getParameter("sex").getBytes("8859_1"), "UTF-8")));

			UserDAO.join(joinDTO);

			mf.transferTo(new File(saveFile));

		} catch (Exception e) {

		}

		return "redirect:/main/page";
	}

	// 프로필 사진 불러오기
	@RequestMapping(value = "profileView")
	public void profile(HttpServletResponse response, String img) {

		try {
			File file = new File("D:\\profile\\" + img);
			FileInputStream in = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(in);

			byte[] buffer = new byte[65536];
			int readCnt = -1;

			OutputStream out = response.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(out);

			while ((readCnt = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, readCnt);
			}
			bis.close();
			bos.close();
		} catch (Exception e) {

		}
	}
	
	
	
	

	// 수정 폼 이동
	@RequestMapping(value ="/modUser", method = RequestMethod.GET)
	public String update(@RequestParam (value="userid",required=false)String userid, Model model) {
		model.addAttribute("ID ", userid);
		
		System.out.println("수정폼 왔어요");
		return "/modUser";
	}

	// 회원 정보 수정
	@RequestMapping("/goMod")
	public String modUser(Model model, UserModifyDTO userModifyDTO, MultipartHttpServletRequest req) {
		MultipartFile mf = req.getFile("file");

		String path = "D:\\profile\\";
		File saveDir = new File(path);

		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		try {
			String originalFileName = new String(mf.getOriginalFilename().getBytes("8859_1"), "UTF-8");
			String saveFile = path + System.currentTimeMillis() + originalFileName;
			String img = System.currentTimeMillis() + originalFileName;

			userModifyDTO.setImg(img);
			userModifyDTO.setStyle((new String(req.getParameter("style").getBytes("8859_1"), "UTF-8")));			

			UserDAO.modUser(userModifyDTO);

			mf.transferTo(new File(saveFile));

		} catch (Exception e) {

		}
		
		System.out.println("회원 정보 수정 끝 ! " + userModifyDTO);
		return "logout";
	}
	

	
	
	// 중복체크
	@RequestMapping("/check")
	public @ResponseBody CheckUserIdVO check(@RequestParam("userid") String userid) {
		return UserDAO.checkUser(userid);

	}

}
