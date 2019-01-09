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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ots.dao.BlogDAO;
import kr.co.ots.dao.CafeListDAO;
import kr.co.ots.dao.UserDAO;
import kr.co.ots.vo.BlogRankVO;
import kr.co.ots.vo.CafeNameVO;

@Controller
@RequestMapping("/main")
public class MainContoller {

	@Inject
	private BlogDAO blogDAO;
	@Inject
	private UserDAO UserDAO;
	@Inject
	private CafeListDAO CafelistDAO;


	@RequestMapping(value = "/page") // 메인 페이지 들어가는 곳
	public String blogRank(Model model) {
		List<BlogRankVO> rank = blogDAO.blogRank();
		List<CafeNameVO> cafename = CafelistDAO.getCafeName();
		model.addAttribute("blogRank", rank); // 여기까지 블로그 랭킹
		model.addAttribute("cafeName", cafename); // 카페랭킹
		
		return "main";
	}
	

	@RequestMapping(value = "mainRank")
	public void mainView(HttpServletResponse response, String blog_img) {
		System.out.println("메인 페이지 : " + blog_img );
		try {
			File file = new File("D:\\img_file\\" + blog_img);
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
}
