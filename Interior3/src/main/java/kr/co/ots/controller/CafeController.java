package kr.co.ots.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.ots.dao.CafeListDAO;
import kr.co.ots.dto.CafeCommentDTO;
import kr.co.ots.dto.CafeListDTO;
import kr.co.ots.vo.CafeListVO;

@Controller
public class CafeController {

	@Inject
	private CafeListDAO cafeListDAO;

	@RequestMapping(value = "/cafe", method = RequestMethod.GET)
	public String cafeList(Model model) {

		model.addAttribute("cafename", cafeListDAO.getCafeName());
		model.addAttribute("cafelist", cafeListDAO.getCafeList());
		System.out.println(cafeListDAO.getCafeName());
		return "cafemain";
	}
	
	@RequestMapping(value = "/hitMain", method = RequestMethod.GET)
	public String hitMain(String bnum, String cafe_url) {
		cafeListDAO.hitMain(bnum);
		return "redirect:" + cafe_url;
	}
	
	
	@RequestMapping(value = "/scoreMain", method = RequestMethod.GET)
	public String scoreMain(String bnum) {
		cafeListDAO.scoreMain(bnum);
		return "redirect:/cafe";
	}
	
	@RequestMapping(value = "/scoreCafe", method = RequestMethod.GET)
	public String scoreCafe(HttpSession session, String dnum) {
		
		cafeListDAO.scoreCafe(dnum);
		session.setAttribute("dnum", dnum);

		return "redirect:/ajaxcomment";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String cafeDetail1(HttpServletRequest request, String dnum, Model model) {
		

		cafeListDAO.hitCafe(dnum);
		
		model.addAttribute("cafedetail", cafeListDAO.getCafeDetail(dnum));
		model.addAttribute("cafecomment", cafeListDAO.getCafeComment(dnum));
		model.addAttribute("cafeimage", cafeListDAO.getCafeImage(dnum));
		
		return "home2";

	}
	
	
	@RequestMapping(value = "/getTitleImage", method = RequestMethod.GET)
	public @ResponseBody void getTitleImage(HttpServletResponse response, HttpServletRequest request,
			String title_image) {

		try {
			File file = new File("D:\\cafe_image\\" + title_image);
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
	
	@RequestMapping(value = "/getMainImage", method = RequestMethod.GET)
	public @ResponseBody void getMainImage(HttpServletResponse response, HttpServletRequest request,
			String main_image) {

		try {
			File file = new File("D:\\cafe_image\\" + main_image);
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
	
	@RequestMapping(value = "/getCafeImage", method = RequestMethod.GET)
	public @ResponseBody void getCafeImage(HttpServletResponse response, HttpServletRequest request,
			String cafe_image) {

		try {
			File file = new File("D:\\cafe_image\\" + cafe_image);
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

	@RequestMapping(value = "/setCommentImage", method = RequestMethod.POST)
	public String setCommentImage(HttpSession session, MultipartHttpServletRequest request,
			CafeCommentDTO cafeCommentDTO, Model model) {
		try {
			MultipartFile mf = request.getFile("file");
			String path = "D:\\comment_image\\";
			File saveDir = new File(path);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}

			String originalFileName = new String(mf.getOriginalFilename().getBytes("8859_1"), "UTF-8");
			String contents = new String(request.getParameter("contents").getBytes("8859_1"), "UTF-8");
			String score = new String(request.getParameter("score").getBytes("8859_1"), "UTF-8");
			String userid = new String(request.getParameter("userid").getBytes("8859_1"), "UTF-8");
			String dnum = new String(request.getParameter("dnum").getBytes("8859_1"), "UTF-8");

			long fileSize = mf.getSize();

			String saveFile = path + System.currentTimeMillis() + originalFileName;
			String image = System.currentTimeMillis() + originalFileName;
			cafeCommentDTO.setDnum(dnum);
			cafeCommentDTO.setUserid(userid);
			cafeCommentDTO.setImage(image);
			cafeCommentDTO.setContents(contents);
			cafeCommentDTO.setScore(score);

			cafeListDAO.insertComment(cafeCommentDTO);
			System.out.println("cafecommentDTO ------" + cafeCommentDTO);
			
			session.setAttribute("dnum", dnum);
			mf.transferTo(new File(saveFile));

		} catch (Exception e) {
			System.out.println("사진 업로드 예외 발생");
		}

		return "redirect:/ajaxcomment";
	}
	
	@RequestMapping(value = "/ajaxcomment", method = RequestMethod.GET)
	public String ajaxcomment(CafeListDTO cafeListDTO, HttpSession session, HttpServletRequest request, Model model) {
		
		String dnum = (String) session.getAttribute("dnum");
		cafeListDTO.setBnum(dnum);
		model.addAttribute("cafedetail", cafeListDAO.getCafeDetail(dnum));
		model.addAttribute("cafecomment", cafeListDAO.getCafeComment(dnum));
		model.addAttribute("cafeimage", cafeListDAO.getCafeImage(dnum));	

		return "home2";

	}
	
	@RequestMapping(value="/getCommentImage", method = RequestMethod.GET)
	public @ResponseBody void getCommentImage(HttpServletResponse response, HttpServletRequest request, String image) {
		try {
			File file = new File("D:\\comment_image\\" + image );
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
	
	@RequestMapping(value="/deleteComment", method = RequestMethod.POST)
	public String deleteComment(String cnum, String dnum, HttpSession session, HttpServletRequest request) {
			
		cafeListDAO.deleteComment(cnum);	
		session.setAttribute("dnum", dnum);

		return "redirect:/ajaxcomment";
	}
	
	
}
