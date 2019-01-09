<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="kr.co.ots.vo.CafeListVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
	
<body>
<table id="cafelist" border="1px" class="table table-striped">
 <tr>
 
  <td>
  	<h1>AA</h1>
	<div>
		<c:forEach items="${cafelist1}" var="cafeListVO">
				<a href="/ots/detail?bnum=${cafeListVO.bnum}&cafe_name=${cafeListVO.cafe_name}">제목 : ${cafeListVO.title}</a>
				조회수 : ${cafeListVO.hit_cnt}
				평점 : ${cafeListVO.score}
		</c:forEach>
	</div>
  </td>
  
  <td>
    <h1>BB</h1>
	<div>
		<c:forEach items="${cafelist2}" var="cafeListVO">
				<a href="/ots/detail?bnum=${cafeListVO.bnum}&cafe_name=${cafeListVO.cafe_name}">제목 : ${cafeListVO.title}</a>
				조회수 : ${cafeListVO.hit_cnt}
				평점 : ${cafeListVO.score}
		</c:forEach>
	</div>
  </td>
  
  <td>
    <h1>CC</h1>
	<div>
		<c:forEach items="${cafelist3}" var="cafeListVO">
				<a href="/ots/detail?bnum=${cafeListVO.bnum}&cafe_name=${cafeListVO.cafe_name}">제목 : ${cafeListVO.title}</a>
				조회수 : ${cafeListVO.hit_cnt}
				평점 : ${cafeListVO.score}
		</c:forEach>
	</div>
  </td>
  
  <td>
    <h1>DD</h1>
	<div>
		<c:forEach items="${cafelist4}" var="cafeListVO">
				<a href="/ots/detail?bnum=${cafeListVO.bnum}&cafe_name=${cafeListVO.cafe_name}">제목 : ${cafeListVO.title}</a>
				조회수 : ${cafeListVO.hit_cnt}
				평점 : ${cafeListVO.score}				
		</c:forEach>
	</div>
  </td>
  
 </tr>
</table>
<div id='cafedetail'></div>
</body>
</html>
