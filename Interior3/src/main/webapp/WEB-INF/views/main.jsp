<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인</title>
<!--  부트스트랩  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- 카카오맵 -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey= c28b1a5c9ff0a48fd84a6692ae5cebd0"></script>
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
	$(document).ready(function() {
		$('#myCarousel').carousel({
			interval : 10000
		})
	});
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
										<a href="/ots/user/loginForm.do"><img
											src="/ots/resources/image/login.png"></a> <a
											href="/ots/user/join"><img
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
									hspace=20 class="img-menu"></a> <a
									href="/ots/matching/matchingHome"><img
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
				<h4>
					<strong>블로그 랭킹</strong>
				</h4>
				<a class='right-box' href="/ots/blog/list">more</a>
			</header>
			<br>
			<!-- 이미지 슬라이드 -->
			<header class="container" style="padding: 0px 0px 0px 100px;"> 
			<div class="wrap_box" style="padding: 0px 0px 0px 0px;">
				<div class="visual">
					<div class="box">

						<c:forEach items="${blogRank}" var="blogRankVO">
							<a
								href="/ots/blog/detail?blog_userid=${blogRankVO.blog_userid}&bnum=${blogRankVO.bnum}">
								<img style="width:950px; height:400px;" class="pht" alt=""
								src="/ots/main/mainRank?blog_img=${blogRankVO.blog_img}" />
							</a>
						</c:forEach>


						<img src="/ots/resources/image/main_visual_prev.png" alt=""
							class="prev"> <img
							src="/ots/resources/image/main_visual_next.png" alt=""
							class="next">


						<ul class="control clear">
							<!-- page nav -->
							<li class="fl"><img
								src="/ots/resources/image/main_visual_control_on.png" alt=""></li>
							<li class="fl"><img
								src="/ots/resources/image/main_visual_control.png" alt=""></li>
							<li class="fl"><img
								src="/ots/resources/image/main_visual_control.png" alt=""></li>
						</ul>

						

					</div>
					<!-- box -->
				</div>
				<!-- visual -->
			</div>
			<!-- wrap_box -->
			</header>

			<hr width=100% color="lightgray" align="left" size=3 />

			<header>
				</br>
				<h4>
					<strong>카페 랭킹</strong>
				</h4>
				<a class='right-box' href="/ots/cafe">more</a>
			</header>
			</br>


				<!--  메인에 보여줄 카페 메인 이미지  -->

				<c:forEach items="${cafeName}" var="CafeNameVO">
				<div style="padding:0px 20px 0px 30px; float: left; border: 0; text-align: left;">
                     <a href="/ots/cafe?cafe_name=${CafeNameVO.cafe_name}&bnum=${CafeNameVO.bnum}">
                     <img class="img-rounded" style="width: 200px; height: 100px;"  alt="카페 랭킹 이미지" src="/ots/main/getMainImage?main_image=${CafeNameVO.main_image}"/></a>
                     </div>
                  </c:forEach>
                  
                  
                  
                  
<!-- 
			<div>
				<div
					style="width: 33%; padding: 20px 0px 20px 0px; float: left; border: 0; text-align: left;">
					<img class='main_img' src="/ots/resources/image/main2.jpg">
				</div>
				<div
					style="width: 34%; padding: 20px 0px 20px 0px; float: left; border: 0; text-align: center;">
					<img class='main_img' src="/ots/resources/image/main1.jpg">
				</div>
				<div
					style="width: 33%; padding: 20px 0px 20px 0px; float: left; border: 0; text-align: right;">
					<img class='main_img' src="/ots/resources/image/img3.jpg">
				</div>
			</div> -->



			<hr width=100% color="lightgray" align="left" size=3 />



			<header>
				</br>
				<h4>
					<strong>매장 정보</strong>
				</h4>
				</br> </br>

				<div class="map_wrap">
					<div id="map"
						style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>

					<div id="menu_wrap" class="bg_white">
						<div class="option">
							<div>
								<form onsubmit="searchPlaces(); return false;">
									<input type="text" value="가구" id="keyword" size="15"
										style="display: none" readonly>
									<button type="submit" style="display: none">판매점 찾기</button>
								</form>
							</div>
						</div>
						<hr>
						<ul id="placesList"></ul>
						<div id="pagination"></div>
					</div>
				</div>

				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c28b1a5c9ff0a48fd84a6692ae5cebd0&libraries=services"></script>
				<script>
					// 마커를 담을 배열입니다
					var markers = [];

					var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
					mapOption = {
						center : new daum.maps.LatLng(37.498206, 127.027610), // 지도의 중심좌표
						level : 3
					// 지도의 확대 레벨
					};

					// 지도를 생성합니다    
					var map = new daum.maps.Map(mapContainer, mapOption);

					// 장소 검색 객체를 생성합니다
					var ps = new daum.maps.services.Places();
					// 지역만 검색 하려면 괄호 안에 map 넣기! 

					// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
					var infowindow = new daum.maps.InfoWindow({
						zIndex : 1
					});

					// 키워드로 장소를 검색합니다
					searchPlaces();

					// 키워드 검색을 요청하는 함수입니다
					function searchPlaces() {

						var keyword = document.getElementById('keyword').value;

						if (!keyword.replace(/^\s+|\s+$/g, '')) {
							alert('가구 판매점만 검색 가능합니다! ');
							return false;
						}

						// 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
						ps.keywordSearch(keyword, placesSearchCB);
						// 지역만 검색하려면 placesSearchCB 뒤에  {useMapBounds:true} 입력해야해융
					}

					// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
					function placesSearchCB(data, status, pagination) {
						if (status === daum.maps.services.Status.OK) {

							// 정상적으로 검색이 완료됐으면
							// 검색 목록과 마커를 표출합니다
							displayPlaces(data);

							// 페이지 번호를 표출합니다
							displayPagination(pagination);

						} else if (status === daum.maps.services.Status.ZERO_RESULT) {

							alert('가구 판매점만 검색 가능합니다.');
							return;

						} else if (status === daum.maps.services.Status.ERROR) {

							alert('검색 결과 중 오류가 발생했습니다.');
							return;

						}
					}

					// 검색 결과 목록과 마커를 표출하는 함수입니다
					function displayPlaces(places) {

						var listEl = document.getElementById('placesList'), menuEl = document
								.getElementById('menu_wrap'), fragment = document
								.createDocumentFragment(), bounds = new daum.maps.LatLngBounds(), listStr = '';

						// 검색 결과 목록에 추가된 항목들을 제거합니다
						removeAllChildNods(listEl);

						// 지도에 표시되고 있는 마커를 제거합니다
						removeMarker();

						for (var i = 0; i < places.length; i++) {

							// 마커를 생성하고 지도에 표시합니다
							var placePosition = new daum.maps.LatLng(
									places[i].y, places[i].x), marker = addMarker(
									placePosition, i), itemEl = getListItem(i,
									places[i]); // 검색 결과 항목 Element를 생성합니다

							// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
							// LatLngBounds 객체에 좌표를 추가합니다
							bounds.extend(placePosition);

							// 마커와 검색결과 항목에 mouseover 했을때
							// 해당 장소에 인포윈도우에 장소명을 표시합니다
							// mouseout 했을 때는 인포윈도우를 닫습니다
							(function(marker, title) {
								daum.maps.event.addListener(marker,
										'mouseover', function() {
											displayInfowindow(marker, title);
										});

								daum.maps.event.addListener(marker, 'mouseout',
										function() {
											infowindow.close();
										});

								itemEl.onmouseover = function() {
									displayInfowindow(marker, title);
								};

								itemEl.onmouseout = function() {
									infowindow.close();
								};
							})(marker, places[i].place_name);

							fragment.appendChild(itemEl);
						}

						// 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
						listEl.appendChild(fragment);
						menuEl.scrollTop = 0;

						// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
						map.setBounds(bounds);
					}

					// 검색결과 항목을 Element로 반환하는 함수입니다
					function getListItem(index, places) {

						var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
								+ (index + 1)
								+ '"></span>'
								+ '<div class="info">'
								+ '   <h5>'
								+ places.place_name + '</h5>';

						if (places.road_address_name) {
							itemStr += '    <span>' + places.road_address_name
									+ '</span>'
									+ '   <span class="jibun gray">'
									+ places.address_name + '</span>';
						} else {
							itemStr += '    <span>' + places.address_name
									+ '</span>';
						}

						itemStr += '  <span class="tel">' + places.phone
								+ '</span>' + '</div>';

						el.innerHTML = itemStr;
						el.className = 'item';

						return el;
					}

					// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
					function addMarker(position, idx, title) {
						var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
						imageSize = new daum.maps.Size(36, 37), // 마커 이미지의 크기
						imgOptions = {
							spriteSize : new daum.maps.Size(36, 691), // 스프라이트 이미지의 크기
							spriteOrigin : new daum.maps.Point(0,
									(idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
							offset : new daum.maps.Point(13, 37)
						// 마커 좌표에 일치시킬 이미지 내에서의 좌표
						}, markerImage = new daum.maps.MarkerImage(imageSrc,
								imageSize, imgOptions), marker = new daum.maps.Marker(
								{
									position : position, // 마커의 위치
									image : markerImage
								});

						marker.setMap(map); // 지도 위에 마커를 표출합니다
						markers.push(marker); // 배열에 생성된 마커를 추가합니다

						return marker;
					}

					// 지도 위에 표시되고 있는 마커를 모두 제거합니다
					function removeMarker() {
						for (var i = 0; i < markers.length; i++) {
							markers[i].setMap(null);
						}
						markers = [];
					}

					// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
					function displayPagination(pagination) {
						var paginationEl = document
								.getElementById('pagination'), fragment = document
								.createDocumentFragment(), i;

						// 기존에 추가된 페이지번호를 삭제합니다
						while (paginationEl.hasChildNodes()) {
							paginationEl.removeChild(paginationEl.lastChild);
						}

						for (i = 1; i <= pagination.last; i++) {
							var el = document.createElement('a');
							el.href = "#";
							el.innerHTML = i;

							if (i === pagination.current) {
								el.className = 'on';
							} else {
								el.onclick = (function(i) {
									return function() {
										pagination.gotoPage(i);
									}
								})(i);
							}

							fragment.appendChild(el);
						}
						paginationEl.appendChild(fragment);
					}

					// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
					// 인포윈도우에 장소명을 표시합니다
					function displayInfowindow(marker, title) {
						var content = '<div style="padding:5px;z-index:1;">'
								+ title + '</div>';

						infowindow.setContent(content);
						infowindow.open(map, marker);
					}

					// 검색결과 목록의 자식 Element를 제거하는 함수입니다
					function removeAllChildNods(el) {
						while (el.hasChildNodes()) {
							el.removeChild(el.lastChild);
						}
					}
				</script>
			</header>
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
