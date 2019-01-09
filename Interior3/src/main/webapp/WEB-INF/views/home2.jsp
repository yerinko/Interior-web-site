<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카페 메인</title>
<!--  부트스트랩  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!--  이미지 슬라이드  -->
<link href="/ots/resources/css/nd_slider.css" rel="stylesheet"
	type="text/css">
<script src="/ots/resources/js/jquery-1.8.0.min.js"
	type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"
	type="text/javascript"></script>
<script src="/ots/resources/js/nd_slider.js" type="text/javascript"></script>
<!-- 슬라이드 바 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" href="/ots/resources/css/slidebars.css">
<link rel="stylesheet" href="/ots/resources/css/style.css">
<!-- 메인 css -->
<link rel="stylesheet" href="/ots/resources/css/main_style.css">
<script>
	var slideIndex = 1;
	showDivs(slideIndex);

	function plusDivs(n) {
		showDivs(slideIndex += n);
	}

	function currentDiv(n) {
		showDivs(slideIndex = n);
	}

	function showDivs(n) {
		var i;
		var x = document.getElementsByClassName("cafeimage");
		var dots = document.getElementsByClassName("demo");
		if (n > x.length) {
			slideIndex = 1
		}
		if (n < 1) {
			slideIndex = x.length
		}
		;
		for (i = 0; i < x.length; i++) {
			x[i].style.display = "none";
		}
		for (i = 0; i < dots.length; i++) {
			dots[i].className = dots[i].className.replace(" w3-red", "");
		}
		x[slideIndex - 1].style.display = "block";
		dots[slideIndex - 1].className += " w3-red";
	}
</script>
</head>



<body>
	<div class="container">
		<div class="fixed-menu">
			<header>
				<div>
					<div id="nav_menu">
						<h1 id="siteName" text-align: center>
							<a href="/ots/main/page"> <img id='max-small'
								src="/ots/resources/image/logo.png" alt="house">
						</h1>







						<ul class='right-box'>
							</br>
							<a href="#" class="js-open-right-slidebar"> <img
								src="/ots/resources/image/if_hamburger_1954554.png"
								class="img-line""js-open-right-slidebar">
							</a>
						</ul>



						<!--  슬라이드 바 내용  -->
						<div off-canvas="slidebar-2 right shift">



							<a href="#" class="js-close-right-slidebar"><img
								src="/ots/resources/image/if_00-ELASTOFONT-STORE-READY_close_2703079.png"
								class="img-x""js-close-right-slidebar"></a> </br> </br>


							<c:choose>
								<c:when test="${not empty login }">
									<div>
										<h6>
											<img src="/ots/resources/image/people.png" class="img-x">
											<strong>${sessionScope.loginUserid}</strong>님,안녕하세요!
										</h6>
										<div>
											<a href="/ots/user/logout"><img
												src="/ots/resources/image/logout.png"></a> <a
												href="/ots/blog/detail?blog_userid=${sessionScope.loginUserid}"><img
												src="/ots/resources/image/myblog.png"></a> <a
												href="/ots/user/modUser?user_userid=${sessionScope.loginUserid}" />
											<img src="/ots/resources/image/modify.png"></a>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div>
										<h6>
											<img src="/ots/resources/image/lock.png" class="img-x">
											로그인해주세요!
										</h6>
										<a href="./user/loginForm.do"><img
											src="/ots/resources/image/login.png"></a> <a
											href="./user/join"><img
											src="/ots/resources/image/join.png"></a>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
						<!-- ------------------------------------------- -->



						<hr width=100% color="lightgray" align="left" size=3 />
						<div>
							<div>

								<a href="/ots/main/page"><img
									src="/ots/resources/image/home.png" hspace=20 class="img-menu"></a>
								<a href="/ots/blog/list"><img
									src="/ots/resources/image/blog.png" hspace=20 class="img-menu"></a>
								<a href="/ots/cafe"><img src="/ots/resources/image/cafe.png"
									hspace=20 class="img-menu"></a> <a href="/ots/matching/matchingHome"><img
									src="/ots/resources/image/funitures.png" hspace=20
									class="img-menu"></a>


							</div>
							<hr width=100% color="lightgray" align="left" size=3 />
						</div>
			</header>
		</div>
	</div>


	<section>
		<div class="container">

			<header>
				</br> </br>
				<h4 style="display: inline-block">
					<strong> 가구 정보  </strong>
				</h4>
			</header>
			<br>
	</section>





	<!-- ----------------- 가구 정보------------------------  -->

	<section>
		<div class="container">
			<hr width=100% color="lightgray" align="left" size=3 />
			</br> </br>

			<header>
				<div>
					<div style="float: left; width: 50%">
						<c:forEach items="${cafeimage}" var="cafeimage">
							<img class="cafeimage img-thumbnail""
								style="width: 500px; height: 500px; display: block; float: left;"
								alt=""
								src="/ots/getCafeImage?cafe_image=${cafeimage.cafe_image}" />
						</c:forEach>
					</div>
				</div>



				<!-- 	<div class="w3-center">
				<div class="w3-section">
					<button class="w3-btn" onclick="plusDivs(-1)">❮ Prev</button>
					<button class="w3-btn" onclick="plusDivs(1)">Next ❯</button>
				</div>
				<button class="w3-btn demo" onclick="currentDiv(1)">1</button>
				<button class="w3-btn demo" onclick="currentDiv(2)">2</button>
				<button class="w3-btn demo" onclick="currentDiv(3)">3</button>
			</div> -->




				<div class="card mb-4 shadow-sm" id="cafelist"
					style="width: 33%; padding: 20px 0px 20px 0px; float: left; border: 0; text-align: left;">
					<tr items="${cafedetail}" var="cafedetail">
						<th name="cafe_name" value="${cafedetail.cafe_name}">카페이름 :<strong>${cafedetail.cafe_name}</strong></th>
						</br>
						<th><h3>
								<strong> ${cafedetail.title}</strong>
							</h3></th>
						</br>
						<th>조회수 : <strong>${cafedetail.hit_cnt}</strong></th>
						</br>
						<th>평점 : <strong>${cafedetail.score}</strong></th>
						</a>
						</th>
						</br>
						</br>
						<a href="${cafedetail.url}">상품 보러가기</a>
						</br>
					</tr>



					<!-- 좋아요  -->
					</br>
					<div style="float: right; padding: 0px 260px 0px 200px;">
						<input id="userid" type="hidden" name="userid"
							value="${sessionScope.loginUserid}"> <input
							id="blog_userid" type="hidden" name="blog_userid"
							value="${myBlogDetail.blog_userid}"> <input
							id="blog_bnum" type="hidden" name="blog_bnum"
							value="${myBlogDetail.bnum}">
						<button class="button2" type="submit" id="score-btn">
							<a href="/ots/scoreCafe?dnum=${cafedetail.dnum}"> <label>좋아요</label>
								<td>${cafedetail.good}</td> <img id="score1"
								src="/ots/resources/image/like.png" class="img-check" />
							</a>
						</button>
					</div>

				</div>
			</header>
	</section>

	<section>
		<!--  댓글 입력창  -->

		<div class="container">
		<hr width=100% color="lightgray" align="left" size=3 />
			</br> </br>
			<form id="fileForm" action="/ots/setCommentImage"
				enctype="multipart/form-data" method="post">
				<input type="hidden" id="dnum" name="dnum"
					value="${cafedetail.dnum}"> 
				<input id="file" type="file" name="file">
			
				<div>
					
					 <input class="form-control" type="hidden"
						id="userid" name="userid" style="width: 100px;" 
						value="${sessionScope.loginUserid}" readonly /> 
						<label for="score">평점</label> 
						<select class="form-control" name="score" id="score"required style="width:200px;">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						</select>
				</div>
				
				
				
				
								
				<div style='display: inline; float: left;'>
					<input id="writed_bnum" type="hidden" name="writed_bnum"
						value="${cafedetail.dnum}"> <input id="contents"
						class="form-control" name="contents" placeholder="댓글을 입력하세요"
						required style="width: 800px; height: 60px;"></input>
				</div>
				<div style='float: right; padding: 0px 200px 0px 0px;'>
					<button class="button2" id="insert" type="submit">COMMENT</button>
				</div>

			</form>





			<!--  댓글창 -->

			<div id="comment" class="col-xs-12">
				<table class="table">

					<tbody>
						<c:forEach items="${cafecomment}" var="cafeCommentVO">
							<form id="modify" action="/ots/deleteComment" method="post">
								<input type="hidden" id="cnum" name="cnum"
									value="${cafeCommentVO.cnum}">
								<tr>
									<td><img class="img-check img-circle" alt=""
										src="/ots/getCommentImage?image=${cafeCommentVO.image}" /></td>

									<td></td>
									<td><h5>
											<strong> ${cafeCommentVO.userid}</strong>
										</h5>
									<td><h5>${cafeCommentVO.contents}</h5>
									<td><h5>
											<strong>평점 :</strong> ${cafeCommentVO.score}
										</h5>
									<td><h5>${cafeCommentVO.write_time}</h5>
									<td>
										<button type="hidden" class="close" id="dnum" name="dnum"value="${cafedetail.dnum}">
											x
										</button>
									</td>
								</tr>
								<%-- <input type="hidden" id="dnum" name="dnum"
									value="${cafedetail.dnum}"> <input type="submit"
									value="삭제">
									 --%>
									
								
									
									
									
							</form>
						</c:forEach>
					</tbody>

				</table>
			</div>
			<div id="test"></div>


		</div>






		<hr width=100% color="lightgray" align="left" size=3 />




		</div>
		</div>
	</section>
	</br>
	</br>



	<!--  하단 로고   -->
	<footer>
		<div style="height: 250px; background-color: papayawhip">
			<div class="container">
				</br>
				<div style="display: inline-block">
					<img class='img-sns' src="/ots/resources/image/instagram.png">
				</div>
				<div style="display: inline-block">
					<img class='img-sns' src="/ots/resources/image/facebook-logo.png">
				</div>
				<div style="display: inline-block">
					<img class='img-sns' src="/ots/resources/image/blogger-botton.png">
				</div>
				<div>
					<h4>
						<strong>FIVE TEA SPOON , 5TS</strong>
					</h4>
					</br>
					<h6>고예린, 김선종, 김승환, 김태훈</h6>
					<h6>집,가 (집에 가!) 이메일 : interior_5ts@naver.com</h6>
					<h6>Copyright © 2018 by Five Tea Spoon. All Rights Reserved.</h6>
					<h6>본 페이지에 사용된 이미지와 사진, 설명등을 무단 도용시 정보통신망법에 의거 형사처벌 됨을 알려드립니다.</h6>

				</div>
			</div>
		</div>
	</footer>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="/ots/resources/js/slidebars.js"></script>
	<script src="/ots/resources/js/scripts.js"></script>

	<div id='cafedetail'></div>
</body>
</html>
