<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="kr.co.ots.vo.myBlogDetailVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  차트  -->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

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



<title>블로그 댓글</title>
<script>
$(document).ready(function(){
   var contents = $('#contents').val();
   $('#ajax_review').click(function(){
       var reviewDTO = {reviewer_img:$('#reviewer_img').val(), review_userid:$('#review_userid').val(),blog_userid:$('#blog_userid').val(),writed_bnum:$('#writed_bnum').val(),contents:$('#contents').val()};
         $.ajax({
           type:'POST',
            url:'/ots/blog/review',
            data:reviewDTO,
            dataType:'json',
            success:function(result){
               //alert(JSON.stringify(result))
               $('#review_list').html("");   
               result.forEach(function(data){
            	   var userid = "<c:out value='${loginUserid}'/>";
                   var comp = (userid === data.review_userid);
            	   var html = "<tr>" +
                                   "<td><img class='img-check img-circle' src='/ots/user/profileView?img="+data.reviewer_img+"'/>"+"</td>"+
                                    "<td>"+data.review_userid+"</td>"+
                                    "<td>"+data.contents+"</td>"+
                                    "<td>"+data.write_time+"</td>"+
                                    foo(comp, data)+
                                "</tr>"
                    $("#review_list").append(html);         
                })
            }
         })
   })
   function foo(comp, data){
	      return comp ? "<td><button type='button' class='close' ><a href='/ots/blog/reviewDelete?bnum="+data.bnum+"&writed_bnum="+data.writed_bnum+"'>x</a></td>" : "<td></td>";
	   }
   
   var blog_bnum = $('#writed_bnum').val();
   $.ajax({
      type:"POST",
      url:'/ots/blog/sex',
      data:{blog_bnum},
      dataType:'json',
      success:function(result){
         var table= [
                ['Sex', 'Count']
            ]
         result.forEach(function(element){
                // alert(JSON.stringify(element))
                var key = element.sex;
                var val = element.count;
                var value = parseInt(val);
                table.push([key, value])
            });
            
         google.charts.load("current", {packages:["corechart"]});
           google.charts.setOnLoadCallback(drawChart);
           function drawChart() {
              var data = new google.visualization.arrayToDataTable(table);
              
              var options = {
                       title: '남 , 여 중 누가 더 좋아할까?',
                       pieHole: 0.4,
                       slices: {
                           1: { color: 'skyblue' },
                           0: { color: 'pink' }
                         }
                   };
              var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
               
               chart.draw(data, options);
           };
      }
   })
  $.ajax({
      type:"POST",
      url:'/ots/blog/age',
      data:{blog_bnum},
      dataType:'json',
      success:function(result){
         var table = [
            ['연령','count']
         ]
         var ten=['10']
            var twenty=['20']
            var thirty=['30']
            var fourty=['40']
            var fifty=['50']
            
         result.forEach(function(element){
                var key = element.ages
                var val = element.count
                value = parseInt(val)
                if(key == '10'){
                    ten.push(value)
                }else if(key == '20'){
                    twenty.push(value)
                }else if(key == '30'){
                    thirty.push(value)
                }else if(key == '40'){
                    fourty.push(value)
                }else if(key == '50'){
                    fifty.push(value)
                }
            });
            var table= [
                ['나이', '명'],ten,twenty,thirty,fourty,fifty
            ]
            table.forEach(function(element){
                if(element.length != 2){
                    element.push(0)
                }
            })
            google.charts.load('current', {'packages':['bar']});
          google.charts.setOnLoadCallback(drawChart);
          function drawChart(){
             var data = new google.visualization.arrayToDataTable(table);
             var options = {
                      chart: {
                               title: '나이별 분석',
                             },
                      vAxis: {title:'Count',maxValue:1000,minValue:0},
                      hAxis: {title:'Feature'},
                      bar:'horizontal',
                        width: 300,
                        height: 400,
                    };
             var bar_chart = new google.charts.Bar(document.getElementById('barchart_material'));
                bar_chart.draw(data, options);
          }
            
      }
   })
   
$('#delete').click(function(){
      alert("정말 삭제하시겠습니까?")
   })
   
})





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
								hspace=20 class="img-menu"></a> <a
								href="/ots/matching/matchingHome"><img
								src="/ots/resources/image/funitures.png" hspace=20
								class="img-menu"></a>


						</div>
						<hr width=100% color="lightgray" align="left" size=3 />
					</div>

					<div style="text-align: right">
						<a href="/ots/blog/write"><img
							src="/ots/resources/image/writeblog.png" hspace=20
							class="img-menu"></a>
							
							
							
						<c:if
							test="${sessionScope.loginUserid eq myBlogDetail.blog_userid}">
							
						
							
							<!-- 수정 삭제 버튼 -->
							
						<a href="/ots/blog/getModify?bnum=${myBlogDetail.bnum }">
						<img src="/ots/resources/image/blogmodify.png" hspace=20
							class="img-menu" ></a>
							
							
                     <a href="/ots/blog/delete?bnum=${myBlogDetail.bnum }&blog_userid=${myBlogDetail.blog_userid}
                     &style=${myBlogDetail.style}" \><img
							src="/ots/resources/image/delite.png" hspace=20
							class="img-menu" id="delete" ></a>
            
						</c:if>
					</div>
					<hr width=100% color="lightgray" align="left" size=3 />
			</header>
		</div>
	</div>




	<section>
	<div class="container">
		<header> <!-- <div class="card mb-4 shadow-sm" style="float: center;"> -->
		<form name="myBlogDetail" method="post">

			<div>
				<!-- <label>이미지</label> -->
				<div style="float: left; width: 50%">
					<img alt=""
						src="/ots/blog/mainView?blog_img=${myBlogDetail.blog_img}"
						style="width: 700px; height: 700px; display: block; float: left;" />
				</div>

			</div>

		</form>



		<!-- 님의 블로그입니다 ! -->

		<div style="float: right; padding: 0px 0px 0px 200px;">
			<h4>
				<strong>${myBlogDetail.blog_userid}</strong>,님의 블로그
			</h4>
		</div>
		<div style="float: right; padding: 0px 0px 0px 200px;">
			<label>조회수</label>
			<td>${myBlogDetail.hit_cnt}</td> </br>
		</div>
		<div style="float: right; padding: 0px 0px 0px 200px;">
			<label>작성시간</label>
			<td>${myBlogDetail.write_time}</td> </br>
		</div>



		<!-- 좋아요  -->
		<form action="/ots/blog/score">
			<div style="float: right; padding: 0px 100px 0px 200px;">
				<input id="userid" type="hidden" name="userid"
					value="${sessionScope.loginUserid}"> <input
					id="blog_userid" type="hidden" name="blog_userid"
					value="${myBlogDetail.blog_userid}"> <input id="blog_bnum"
					type="hidden" name="blog_bnum" value="${myBlogDetail.bnum}">
				<button class="button2" type="submit" id="score-btn">
					<label>좋아요</label>
					<td>${myBlogDetail.score}</td> <img id="score1"
						src="/ots/resources/image/like.png" class="img-check" />
				</button>
			</div>


			<!-- 여기다가 차트 -->
			<!-- 성별차트 도넛차트 -->
			<div id="donutchart"
				style="width: 550px; height: 400px; float: right; padding: 0px 0px 0px 200px;"></div>
			<!-- 연령대 차트  막대 차트-->
			<div id="barchart_material"
				style="width: 550px; height: 200px; float: right; padding: 0px 0px 0px 200px;"></div>





			<div class="card-body">
				<div style="padding: 700px 0px 0px 0px;">


					</br> </br> </br>
					<!-- <label>TITLE</label> -->
					<strong><h4>${myBlogDetail.title}</h4></strong>
					<!--   <label>콘텐츠</label> -->
					<strong><h3>${myBlogDetail.contents}</h3></strong> </br> </br> </br> </br> <label>스타일</label>
					<td>${myBlogDetail.style}</td>

				</div>
			</div>

		</form>

		</header>
	</div>






	<div class="container">
		<div>
			</br> </br>

			<hr width=100% color="lightgray" align="left" size=3 />
		</div>



		<!-- 댓글 넘기는거 -->
		<input id="reviewer_img" type="hidden" name="reviewer_img"
			value="${sessionScope.profileImg}" /> <input id="review_userid"
			type="hidden" name="review_userid"
			value="${sessionScope.loginUserid}"> <input id="blog_userid"
			type="hidden" name="blog_userid" value="${myBlogDetail.blog_userid}">
		<div style='display: inline; float: left;'>
			<input id="writed_bnum" type="hidden" name="writed_bnum"
				value="${myBlogDetail.bnum}"> <input id="contents"
				class="form-control" name="contents" placeholder="댓글을 입력하세요"
				required style="width: 800px; height: 60px;"></input>
		</div>
		<div style='float: right; padding: 0px 200px 0px 0px;'>
			<button class="button2" id="ajax_review" type="submit">
				COMMENT</button>
		</div>
		</br> </br> </br> </br> </br>

		<div class="col-xs-12">
			<table class="table">
				<tbody id="review_list">
					<c:forEach items="${reviewList}" var="reviewList">
						<tr>
							<td><img class="img-check img-circle"
								src="/ots/user/profileView?img=${reviewList.reviewer_img}" /></td>
							<td></td>
							<td><h5>
									<strong>${reviewList.review_userid}</strong>
								</h5></td>
							<td>${reviewList.contents}</td>
							<td>${reviewList.write_time}</td>
							<c:choose>
								<c:when
									test="${sessionScope.loginUserid eq reviewList.review_userid}">
									<td>
										<button type="button" class="close">
											<a
												href="/ots/blog/reviewDelete?bnum=${reviewList.bnum}&writed_bnum=${reviewList.writed_bnum}">x</a>
										</button>
									</td>
								</c:when>
								<c:otherwise>
									<td></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

	</section>







	<hr width=100% color="lightgray" align="left" size=3 />


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
