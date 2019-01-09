<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 블로그 페이지</title>
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




						</div>
						<hr width=100% color="lightgray" align="left" size=3 />


						<div style="text-align: right">
							<a href="/ots/blog/write"><img
								src="/ots/resources/image/writeblog.png" hspace=20
								class="img-menu"></a>
						</div>
						<hr width=100% color="lightgray" align="left" size=3 />
						
						
						
							<!-- ---------------- 블로그 프로필 라인--------------------  -->
							

							<header>
								<form name="memberinfo" method="post">
								
									<div style="height: 250px; background-color:f2f2f2;">
									
										
									
										<div style="padding:15px 0px 0px 500px;">
										<div style="float:center; margin-right:10px;">						
										<img class="img-circle img-thumbnail" src="/ots/user/profileView?img=${memberinfo.img}" alt="프로필 사진" 
										style="width: 152px; height: 152px;"></div>			
										</br>
												 
										
											
											<div style="float:center; margin-right:10px;">
											<h5><strong>${memberinfo.userid}</strong>, 님의 블로그입니다🌿</h5></div>
											
											<div >
											<h5>'<strong>${memberinfo.style}</strong>'한 스타일을 좋아해요!</h5></div>
											
											</div>
											
										</div>
										
									
									</form>
							</header>
							
							<!--  ---------------------------------------------------- -->
			</header>
		</div>
	</div>














	<section>
		<div class="container">

			<header>
				</br>
				<hr width=100% color="lightgray" align="left" size=3 />
				<h4 style="display: inline-block">
					<strong> 작성한 글 </strong>
				</h4>
			</header>
			<br>
			<div class="card mb-4 shadow-sm">
				<c:forEach items="${ detailList }" var="BlogDetailVO">

					<div
						style="width: 33%; padding: 0px 0px 20px 0px; float: left; border: 0; text-align: center;">
						<a href="/ots/blog/myBlogDetail?bnum=${BlogDetailVO.bnum}"> 
						<%-- <div
						style="padding: 0px 0px -10px 0px; float: left;">
							<img class="img-circle" src="/ots/user/profileView?img=${memberinfo.img}" alt="프로필 사진" 
										style="width: 36px; height: 36px;"></div> --%>
						 
						<img
							class="img-rounded card-img-top"
							src="/ots/blog/mainView?blog_img=${BlogDetailVO.blog_img}"
							width=350px, height=350px display:
							block;" data-holder-rendered="true"
							style="padding: 50px 0px 0px 0px;"></a>
						<div class="card-body">							
							</br>


							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group"></div>
								<%-- <small class="text-muted"> <span class="card__img__view"
									style="display: inline-block;">조회수
										${BlogDetailVO.hit_cnt}</span></small> --%>
								<div>
									<strong>${BlogDetailVO.title}</strong></br> <label>작성일</label>
									${BlogDetailVO.write_time}
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>


			<hr width=100% color="lightgray" align="left" size=3 />

			<header>
				</br>
				<h4>
					<strong> 비슷한 취향의 블로그 추천 </strong>
				</h4>

			</header>
			<br>


			<div class="card mb-4 shadow-sm">
				<c:forEach items="${tatesList}" var="tatesList">
					<div
						style="width: 33%; padding: 20px 0px 20px 0px; float: left; border: 0; text-align: center;">
						<a href="/ots/blog/detail?blog_userid=${tatesList.blog_userid}"> <img
							class="img-rounded" alt=""
							src="/ots/blog/mainView?blog_img=${tatesList.blog_img}"
							width=350px, height=350px display:
							block;" data-holder-rendered="true"
							style="padding: 50px 0px 0px 0px;">
						</a>
						<div class="card-body">
							<%--   <p class="card-text"><h5><img class="img-circle"
							src="/ots/user/profileView?img=${UserDAO.blog_userid_img}"
							style="display: inline-block" /> --%>
							</br>

							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">

									<a
										href="/ots/blog/detail?blog_userid=${tatesList.blog_userid}">
										<button type="button" class="btn btn-sm btn-outline-secondary">놀러가기</button>
									</a>

								</div>
								
								<div>
									<strong>${tatesList.title}</strong></br> <h5>
									${tatesList.write_time}</h5>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>





			<hr width=100% color="lightgray" align="left" size=3 />




		</div>
	</section>
	</br>
	</br>

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
</body>
</html>
