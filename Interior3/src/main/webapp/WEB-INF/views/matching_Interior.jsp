<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가구매칭</title>
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
<!-- 메칭 스크립트 -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script src="//d3js.org/d3.v3.min.js"></script>
<script src="//d3js.org/d3.geo.projection.v0.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/themes/base/jquery-ui.css" />




<script type="text/javascript">
	setTimeout(
			function() {
				$(document)
						.ready(
								function() {
									function unpack(rgb) {
										rgb = rgb.replace(/[^0-9,.,,]/g, " ");
										//rgb = rgb.replace(" ", ",");
										rgb = "(" + rgb + ")"
										return rgb;
									}
									var furnitureName = $('#hide1').val();
									var labelList = []
									var jsonData = $
											.ajax({
												url : "other_color_score",
												data : {
													'furnitureName' : furnitureName
												},
												dataType : 'json',
												async : false,
												success : function(result) {
													/* alert(result.cols[1].label)
													alert(unpack(result.cols[0].pattern)) */
													var html = "</br><span>"
															+ "<strong>다른 색으로 보기</strong></br>"
															+ "</span>"
															+ ""
															+ "<a href='/ots/matching/otherColor?otherNumber="
															+ result.cols[0].label + "&furnitureName=" + furnitureName 
															+ "'><img height='30' width='30' src='/ots/resources/image/round.png' style='background: rgb"
															+ unpack(result.cols[0].pattern)
															+ ";'></a>"
															+ "<a href='/ots/matching/otherColor?otherNumber="
															+ result.cols[1].label + "&furnitureName=" + furnitureName 
															+ "'><img height='30' width='30' src='/ots/resources/image/round.png' style='background: rgb"
															+ unpack(result.cols[1].pattern)
															+ ";'></a>"
															+ "<a href='/ots/matching/otherColor?otherNumber="
															+ result.cols[2].label + "&furnitureName=" + furnitureName 
															+ "'><img height='30' width='30' src='/ots/resources/image/round.png' style='background: rgb"
															+ unpack(result.cols[2].pattern)
															+ ";'></a>"
															+ "<a href='/ots/matching/otherColor?otherNumber="
															+ result.cols[3].label + "&furnitureName=" + furnitureName 
															+ "'><img height='30' width='30' src='/ots/resources/image/round.png' style='background: rgb"
															+ unpack(result.cols[3].pattern)
															+ ";'></a>"
															+ "<a href='/ots/matching/otherColor?otherNumber="
															+ result.cols[4].label + "&furnitureName=" + furnitureName 
															+ "'><img height='30' width='30' src='/ots/resources/image/round.png' style='background: rgb"
															+ unpack(result.cols[4].pattern)
															+ ";'></a>"
													$("#otherColorAjax")
															.append(html);

												}
											}).responseText;

								})
			}, 2500);
</script>
<style>
    .js-load {
        display: none;
    }
    .js-load.active {
        display: block;
    }
    .is_comp.js-load:after {
        display: none;
    }
    .btn-wrap, .lists, .main {
    	
        display: block;
    }
    .main {
        max-width: 640px;
        margin: 0 auto;
    }
    .btn-wrap {
        text-align: center;
    }
</style>

<script>
	$(window).on('load', function() {
		load('#js-load', '9');
		$("#js-btn-wrap .button").on("click", function() {
			load('#js-load', '9', '#js-btn-wrap');
		})
	});
	function load(id, cnt, btn) {
		var load_list = id + " .js-load:not(.active)";
		var load_length = $(load_list).length;
		var load_total_cnt;
		if (cnt < load_length) {
			load_total_cnt = cnt;
		} else {
			load_total_cnt = load_length;
			$('.button').hide()
		}
		$(load_list + ":lt(" + load_total_cnt + ")").addClass("active");
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
					<strong> 가구 매칭 </strong> <img
						src="/ots/resources/image/picture.png" class="img-check"
						style="display: inline-block" >
				</h4>
			</header>
			<br> <img height="450" width="450" class="img-thumbnail"
				src="/ots/matching/showing_furniture?FileName=${furnitureName}">

			<input type="hidden" name="hide1" id="hide1" value="${furnitureName}">

			<div id="otherColorAjax"  ></div>
			</section>





			

			<!-- 매칭 완료된 이미지-->
			<section>
			<div class="container">
			<hr width=100% color="lightgray" align="left" size=3 />
			<h4 style="display: inline-block">
					<strong> 매칭 리스트 </strong> 
				</h4>
				</br></br>
				</br>
			<div id="js-load">
				<c:forEach items="${MatchedColorList}" var="MatchedColorList">
					<div class="lists__item js-load"
						style="width: 33%; float: left; text-align: center;">
						<a href="${MatchedColorList.interior_url}"> <img height="350"
							width="350"
							src="/ots/matching/showing_interior?FileName=${MatchedColorList.interior_img}" class="img-rounded">
						</a>
						<p class="text-center"></p>
					</div>
				</c:forEach>
			</div>

		</div>
	


		<hr width=100% color="lightgray" align="left" size=3 />

		<br>


		<div id="js-btn-wrap" class="btn-wrap">
			<a href="javascript:;" class="button"><h3>더보기</h3></a>
		</div>
		
		<hr width=100% color="lightgray" align="left" size=3 />

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
