package kr.co.ots.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/*import com.fasterxml.jackson.core.JsonElement;
import comfasterxml.jackson.core.JsonObject;
import com.google.gson.JsonParser;*/

import kr.co.ots.dao.MatchingDAO;
import kr.co.ots.dto.FurnitureDTO;
import kr.co.ots.vo.ColorListVO;

@Controller
@RequestMapping("/matching")
public class MatchController {

   private static final Logger logger = LoggerFactory.getLogger(MatchController.class);
   

   @Inject
   MatchingDAO matchingDAO;
   @RequestMapping(value = "/fileupload", method = RequestMethod.GET)
   public String upload2() {
      return "matchingHome";
   }
   
   
   //파일 업로드
   @RequestMapping(value = "/fileupload", method = RequestMethod.POST )
   public String upload(MultipartHttpServletRequest request, Model model)  {
//      System.out.println("request :"+request);
      try {
         
      logger.info("fileupload 실행");
      
      MultipartFile mf = request.getFile("file");
      
      String path = "D:\\BigData\\spring-workspace\\Interior3\\src\\main\\webapp\\interior\\data\\furniture\\";
//      String path = "D:\\bigdata\\spring-workspace\\SP_SJK\\Interior3\\src\\main\\webapp\\interior\\data\\interiorIMG\\";

      File saveDirectory = new File(path);
      if (!saveDirectory.exists()) {
         saveDirectory.mkdir(); 
      }
         String originalFileName = new String(mf.getOriginalFilename().getBytes("8859_1"), "UTF-8");
         System.out.println("원본 파일명 : " + originalFileName);
         String saveFile = path + originalFileName;
         String FileName = originalFileName; 
         
         mf.transferTo(new File(saveFile));
         RestTemplate restTemplate = new RestTemplate();
         
//         String MatchPoint = restTemplate.postForObject("http://localhost:5000/bestColor" + "?image_name=" + FileName,
//               null, String.class);
         String MatchPoint = "3";
         System.out.println("파일 업로드 끝, MatchPoint: "+ MatchPoint);
         FurnitureDTO furnitureDTO = new FurnitureDTO();
         furnitureDTO.setFurniture_img(FileName);
         furnitureDTO.setColor_score(MatchPoint);
         matchingDAO.furnitureInfo(furnitureDTO);
         
         List<ColorListVO> MatchedColorList = matchingDAO.colorList(MatchPoint);
         for (ColorListVO Matched : MatchedColorList) {
            System.out.print("  inum :" + Matched.getInum() + ", score :" + Matched.getColor_score());
         
         }
         
         model.addAttribute("MatchedColorList", MatchedColorList);
         model.addAttribute("furnitureName",FileName);
         
         return "matching_Interior";
      
      } catch (Exception e) {
         System.out.println(e);
         return "matching_Interior";
      }
      
      
      
//      System.out.println("파일 업로드 끝");
//      return "matching_Interior";
      
   }
      
   @RequestMapping(value = "/otherColor")
   public String otherColor(String otherNumber, String furnitureName ,Model model) {
      System.out.println("여기는 otherColor");
      System.out.println("다른 색 번호" + otherNumber + "업로드 된 가구 이미지 이름" + furnitureName);
      
      List<ColorListVO> OtherColorList = matchingDAO.colorList(otherNumber);
      
      for (ColorListVO other : OtherColorList) {
         System.out.print("  inum :" + other.getInum() + ", score :" + other.getColor_score());
      }
      
      model.addAttribute("OtherColorList", OtherColorList);
      model.addAttribute("furnitureName",furnitureName);
      return "matching_otherColor";
   }
   
   
   @RequestMapping(value = "/showing_interior")
   public @ResponseBody void showing_interior(HttpServletResponse response, String FileName) {
      String path = "D:\\BigData\\spring-workspace\\Interior3\\src\\main\\webapp\\interior\\data\\interiorIMG\\";
//      String path = "D:\\bigdata\\spring-workspace\\SP_SJK\\Interior3\\src\\main\\webapp\\interior\\data\\interiorIMG\\";

      File file = new File(path + FileName);
      try {
         FileInputStream in = new FileInputStream(file);
         BufferedInputStream bis = new BufferedInputStream(in);
         byte[] buffer = new byte[65536];
         int readCnt = -1;
         
         OutputStream out = response.getOutputStream();
         BufferedOutputStream bos = new BufferedOutputStream(out);
         
         while ((readCnt = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, readCnt);
         }
         
         bos.close();
         bis.close();
      } catch (Exception e) {
         
      }
   }
   
   @RequestMapping(value="/other_color_score")
   public @ResponseBody String other_color_score(String furnitureName) {
      System.out.println();
      System.out.println("Hello here other_color_score~" + furnitureName);
      RestTemplate restTemplate = new RestTemplate();
      
//      String res = restTemplate.postForObject("http://localhost:5000/colorList" + "?image_name=" + furnitureName,
//               null, String.class);
      String res = "{\"cols\":[{\"pattern\":\"[254.58785163 254.34165678 254.16020714]\",\"label\":\"6\"},{\"pattern\":\"[131.53731718  72.60970476  54.93367653]\",\"label\":\"8\"},{\"pattern\":\"[208.25727033 178.93903873 163.98783208]\",\"label\":\"1\"},{\"pattern\":\"[71.84861907 24.43197366 16.49667231]\",\"label\":\"0\"},{\"pattern\":\"[168.5959127  118.98931091  98.74893026]\",\"label\":\"13\"}]}";
//      String res = "{\"cols\":[{\"id\":\"\",\"label\":\"colorPoint\",\"pattern\":\"\",\"type\":\"string\"},{\"id\":\"\",\"pattern\":\"[30.62015961 35.52945871 20.9111381 ]\",\"label\":\"0\",\"type\":\"number\"},{\"id\":\"\",\"pattern\":\"[ 93.95496704 161.64984379  60.41115344]\",\"label\":\"3\",\"type\":\"number\"},{\"id\":\"\",\"pattern\":\"[224.69137562 216.26407698 239.55087313]\",\"label\":\"2\",\"type\":\"number\"},{\"id\":\"\",\"pattern\":\"[123.16137708 172.63554554  85.91542272]\",\"label\":\"3\",\"type\":\"number\"},{\"id\":\"\",\"pattern\":\"[75.74748939 90.47065142 57.01750712]\",\"label\":\"10\",\"type\":\"number\"}],\"rows\":[{\"c\":[{\"v\":\"percent\"},{\"v\":0.115396},{\"v\":0.408696},{\"v\":0.044896},{\"v\":0.356416},{\"v\":0.074596}]}]}";
      JsonParser parser = new JsonParser();
      JsonElement jsonElement = parser.parse(res);
      
      JsonObject jsonObject = jsonElement.getAsJsonObject();
      
      System.out.println(jsonObject.toString());
      
      return jsonObject.toString();
      
   }
   
   @RequestMapping(value = "/showing_furniture")
   public @ResponseBody void showing_furniture(HttpServletResponse response, String FileName) {
      String path = "D:\\BigData\\spring-workspace\\Interior3\\src\\main\\webapp\\interior\\data\\furniture\\";
//      String path = "D:\\bigdata\\spring-workspace\\SP_SJK\\Interior3\\src\\main\\webapp\\interior\\data\\furniture\\";

      File file = new File(path + FileName);
      try {
         FileInputStream in = new FileInputStream(file);
         BufferedInputStream bis = new BufferedInputStream(in);
         byte[] buffer = new byte[65536];
         int readCnt = -1;
         
         OutputStream out = response.getOutputStream();
         BufferedOutputStream bos = new BufferedOutputStream(out);
         
         while ((readCnt = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, readCnt);
         }
         
         bos.close();
         bis.close();
      } catch (Exception e) {
         
      }
   }
   
   @RequestMapping(value = "/matchingHome", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      logger.info("home 컨트롤러 실행");

      
      return "matchingHome";
   }

}