F<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>블로그 글쓰기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style type="text/css">


</style>


</head>
<body class="container">
	
	<form name="insertData" action="insertData" method="post" enctype="multipart/form-data">
		
			
			<button class="btn btn-default img-circle" ><input class="img-circle" type="file" name="file"/></button>
		
		<div>
			<label>스타일</label>
				<select class="form-control" name="style" id="style">
				  <option value="모던">모던</option>
				  <option value="북유럽">북유럽</option>
				  <option value="빈티지">빈티지</option>
				  <option value="내츄럴">내츄럴</option>
				  <option value="프로방스&로맨틱">프로방스&로맨틱</option>
				  <option value="클래식&엔틱">클래식&엔틱</option>
				</select>
			
				<input type="hidden" name="blog_userid" id="blog_userid" value="${sessionScope.loginUserid}" /><br/>
			
			<label>title</label>
				<input name="title" id="title" placeholder="제목을 입력해 주세요">
		</div>
		
		<div class="form-group has-warning">
			<textarea class="form-control" colspan="8" name="contents" id="contents" placeholder="내용을 입력하세요"></textarea>
		</div>
		
		<input class="btn btn-default" type="submit" value="전송"/>
	</form>
	
</body>
</html>