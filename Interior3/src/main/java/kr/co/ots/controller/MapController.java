package kr.co.ots.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class MapController {
	   private static final Logger logger = LoggerFactory.getLogger(MapController.class);
	   
	   @Autowired
	   private MongoTemplate mongoTemplate;//세션템플릿과 비슷한 역할
	   
	   
	   
	   
	   @RequestMapping(value="/searchAllConv", produces="application/json; charset=utf-8")//리스폰스 할 때 항상 utf-8 제이슨으로 받겠다.
	   public @ResponseBody String searchAllConv() {
	      Query query = new Query();
	      
	      List<String> results = mongoTemplate.find(query, String.class, "ots_search_local");
	      
	      for(String result : results) {
	         System.out.println(result);
	      }
	      
	      return results.toString();
	      
	   }
	
	 
	   
	   
}
