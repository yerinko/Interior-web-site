package kr.co.ots.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.ots.dao.BlogDAO;
import kr.co.ots.dao.UserDAO;
import kr.co.ots.dto.ModifyDataDTO;
import kr.co.ots.dto.ReviewDataDTO;
import kr.co.ots.dto.ScoreDataDTO;
import kr.co.ots.dto.TwoDTO;
import kr.co.ots.dto.WriteDataDTO;
import kr.co.ots.dto.myblogDTO;
import kr.co.ots.vo.MemberInfoVO;
import kr.co.ots.vo.ReviewListVO;
import kr.co.ots.vo.ScoreDataVO;
import kr.co.ots.vo.agesChartVO;
import kr.co.ots.vo.genderChartVO;

@Controller
@RequestMapping("/blog")
@SessionAttributes("session")
public class BlogController {
   
   @Inject
   private BlogDAO blogDAO;
   @Inject
   private UserDAO UserDAO;
   

   
   
   @RequestMapping(value="/list")
   public String blog(Model model) {
      model.addAttribute("blogMainList",blogDAO.blogMainList());
      return "blogMain";
   }
   
   @RequestMapping(value="detail") // 블로그 ->블로그리스트
   public String blogDetail(Model model, myblogDTO myDTO)  {
     //System.out.println("마이 디티오 : " + myDTO);
     MemberInfoVO member=UserDAO.memberInfo(myDTO.getBlog_userid());
     myblogDTO info = new myblogDTO();
     info.setStyle(member.getStyle());
     info.setBlog_userid(myDTO.getBlog_userid());
     model.addAttribute("tatesList",blogDAO.similarTastes(info)); // 같은 취향 리스트
      model.addAttribute("detailList",blogDAO.getBlogDetail(myDTO.getBlog_userid())); // 내 블로그 글 리스트
      model.addAttribute("memberinfo", UserDAO.memberInfo(myDTO.getBlog_userid())); // 회원 정보 리스트
      return "myBlog";
   }
   
   
   @RequestMapping(value="myBlogDetail", method = {RequestMethod.GET, RequestMethod.POST}) // 블로그 -> 마이 블로그 -> my블로그 디테일
   public String myBlogDetail(String bnum, Model model) {
      model.addAttribute("myBlogDetail", blogDAO.getMyBlogDetail(bnum)); //~번 블로그에 대한 디테일 띄우기
      model.addAttribute("reviewList", blogDAO.reviewList(bnum)); //~ 번 글에 대한 리뷰 띄우기
      return "myBlogDetail";
   }
   
   @RequestMapping(value="/review") 
   public @ResponseBody List<ReviewListVO> reviewData(ReviewDataDTO reviewDTO) {
      //System.out.println("넘어왔!" + reviewDTO.toString());
      blogDAO.reviewData(reviewDTO);
      List<ReviewListVO> reviewList = blogDAO.reviewList(reviewDTO.getWrited_bnum());
      return reviewList;
   }
   
   
   @RequestMapping(value="reviewDelete") // 리뷰삭제
   public String reviewDelete(String bnum, String writed_bnum) {
      System.out.println("이야압! :" + writed_bnum);
      System.out.println("리뷰 삭제 번호 : " + bnum);
      blogDAO.deleteReview(bnum);
      return "redirect:/blog/myBlogDetail?bnum="+writed_bnum;
   }
   @RequestMapping(value="sex")
   public @ResponseBody List<genderChartVO> genderchart(String blog_bnum){
      //System.out.println("차트데이터 넘어오나 : "+blog_bnum);
      List<genderChartVO> genderchart = blogDAO.genderchart(blog_bnum);
      return genderchart;
   }
   
   

   @RequestMapping(value="delete", method = {RequestMethod.GET}) //삭제 
   public String delete(String bnum, myblogDTO myDTO, RedirectAttributes rttr) throws UnsupportedEncodingException {
      System.out.println("블로그 유저 아이디 : " + myDTO);
      //String style = myDTO.getStyle();
      String style=URLEncoder.encode(myDTO.getStyle(), "UTF-8");
      String blog_userid = myDTO.getBlog_userid();
      
      blogDAO.delete(bnum);
      String detail = "redirect:/blog/detail?blog_userid="+blog_userid+"&style="+style;
      
      return detail;
      
   }

   
   @RequestMapping(value="age")
   public @ResponseBody List<agesChartVO> agesChart(String blog_bnum){
      //System.out.println("차트데이터 넘어오나 : "+blog_bnum);
      List<agesChartVO> agesChart = blogDAO.agesChart(blog_bnum);
      return agesChart;
   }
   
 
   @RequestMapping(value="getModify")
   public String modifyBlog(String bnum, Model model) { // 번호에 대한 셀렉트 원 해야됨
      System.out.println("겟 수정 : " + bnum);
      model.addAttribute("writedData", blogDAO.getMyBlogDetail(bnum));
      return "modifyData";
   }
   
   
   
   @RequestMapping(value="modify") // 수정데이터 입력 
   public String setModify(ModifyDataDTO modifyDTO ,MultipartHttpServletRequest req, RedirectAttributes rttr) {
      System.out.println("수정 데이터 : " + modifyDTO);
      rttr.addAttribute("blog_userid", modifyDTO.getBlog_userid());
      rttr.addAttribute("style", modifyDTO.getStyle());
      MultipartFile mf = req.getFile("file");

      String path = "D:\\img_file\\";
      File saveDir = new File(path);
      
      if(!saveDir.exists()) {
         saveDir.mkdir();
      }try {
          String originalFileName = new String(mf.getOriginalFilename().getBytes("8859_1"),"UTF-8");
            
          String saveFile = path + System.currentTimeMillis()+originalFileName;
          String blog_img = System.currentTimeMillis()+originalFileName;
         
          modifyDTO.setBlog_img(blog_img);
          modifyDTO.setStyle(new String(req.getParameter("style").getBytes("8859_1"),"UTF-8"));
          modifyDTO.setTitle(new String(req.getParameter("title").getBytes("8859_1"),"UTF-8"));
          modifyDTO.setContents(new String(req.getParameter("contents").getBytes("8859_1"),"UTF-8"));
          System.out.println(modifyDTO);
          blogDAO.modifyBlog(modifyDTO);
          mf.transferTo(new File(saveFile));
      
      }catch(Exception e) {
         
      }
      
      return "redirect:/blog/detail"; 
   }
   
   
   
   
   @RequestMapping(value="/write") //글쓰기 버튼 클릭!
   public String insert(){ 
      return "writeData"; //writeData.jsp로 이동
   }
   
   
   
   @RequestMapping(value="/writeData")
   public String writeData(MultipartHttpServletRequest req, WriteDataDTO writeDTO, RedirectAttributes rttr) {
      System.out.println("writeData 확인 : " + writeDTO);
      rttr.addAttribute("blog_userid", writeDTO.getBlog_userid());
      rttr.addAttribute("style", writeDTO.getStyle());
      MultipartFile mf = req.getFile("file");

      String path = "D:\\img_file\\";
      File saveDir = new File(path);
      
      if(!saveDir.exists()) {
         saveDir.mkdir();
      }
      try {
          String originalFileName = new String(mf.getOriginalFilename().getBytes("8859_1"),"UTF-8");
         
          String saveFile = path + System.currentTimeMillis()+originalFileName;
          String blog_img = System.currentTimeMillis()+originalFileName;
         
          writeDTO.setBlog_img(blog_img);
          writeDTO.setStyle(new String(req.getParameter("style").getBytes("8859_1"),"UTF-8"));
          writeDTO.setTitle(new String(req.getParameter("title").getBytes("8859_1"),"UTF-8"));
          writeDTO.setContents(new String(req.getParameter("contents").getBytes("8859_1"),"UTF-8"));
         
          System.out.println(writeDTO);
          
          blogDAO.writetData(writeDTO);
          mf.transferTo(new File(saveFile));
      
      }catch(Exception e) {
         
      }
      return "redirect:/blog/detail";   
   }
   
   @RequestMapping(value="mainView")
   public void mainView(HttpServletResponse response, String blog_img) {
         System.out.println("메인 페이지 : "+blog_img);
      try {
         File file = new File("D:\\img_file\\"+ blog_img);
         FileInputStream in = new FileInputStream(file);
         BufferedInputStream bis = new BufferedInputStream(in);
         
         byte []buffer = new byte[65536];
         int readCnt = -1;
         
         OutputStream out = response.getOutputStream();
         BufferedOutputStream bos = new BufferedOutputStream(out);
         
         while((readCnt = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, readCnt);
         }
         bis.close();
         bos.close();
         
      }catch(Exception e) {
         
      }
   }
   
//   @RequestMapping(value="/myblog")
//   public String myBlog() {
//      // 내 블로그에 띄어야 할거 
//      // (사진, 글) (댓글{프로필사진,글} 비슷한 스타일의 블로그
//      return "myBlog";
//   }
   
   @RequestMapping(value="score")
   public String scoreData(ScoreDataDTO scoreDTO) {
      System.out.println("넘어옴 : " + scoreDTO);
      
      TwoDTO two = new TwoDTO();
      two.setBlog_bnum(scoreDTO.getBlog_bnum());
      two.setUserid(scoreDTO.getUserid());
      ScoreDataVO score = blogDAO.score(two);
      
      
      if(score != null) {
         blogDAO.decScore(score.getBlog_bnum());
         blogDAO.scoreDataDel(score.getBnum());
      }else if(score == null) {
         MemberInfoVO member = UserDAO.memberInfo(scoreDTO.getUserid());
         scoreDTO.setAge(member.getAge());
         scoreDTO.setSex(member.getSex());
         blogDAO.scoreData(scoreDTO); //디비에 데이터 삽입
      }
      
      
      return "redirect:/blog/myBlogDetail?bnum="+scoreDTO.getBlog_bnum();
   
   }
   
   
 



   


   

}