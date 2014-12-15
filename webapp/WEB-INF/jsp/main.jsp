<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String cp = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <jsp:include page="./include/common_include.jsp"></jsp:include>
  <script>
  function popupMobileAudio(){
	  window.open('http://www.meslap.com/mobile/sermon.htm', 'audio', 'height=600px,width=385px');
  }
  </script>
</head>
<body>
<jsp:include page="./include/menu_include.jsp"></jsp:include>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
 <!-- Indicators -->
 <ol class="carousel-indicators">
     <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
     <li data-target="#carousel-example-generic" data-slide-to="1"></li>
     <li data-target="#carousel-example-generic" data-slide-to="2"></li>
 </ol>

 <!-- Wrapper for slides -->
 <div class="carousel-inner">
     <div class="item active">
     	 <div style="width:100%;text-align:center">
         	<img src="<%=cp %>/images/main/main_slide01.jpg" alt="..." style="height:409px;">
         </div>
         <div class="carousel-caption">

         </div>
     </div>
     <div class="item">
         <div style="width:100%;text-align:center">
         	<img src="<%=cp %>/images/main/main_slide02.jpg" alt="..." style="height:409px;">
         </div>
         <div class="carousel-caption">
         </div>
     </div>
     <div class="item">
         <div style="width:100%;text-align:center">
         	<img src="<%=cp %>/images/main/main_slide03.jpg" alt="..." style="height:409px;">
         </div>
         <div class="carousel-caption">
         </div>
     </div>
     <div class="item">
         <div style="width:100%;text-align:center">
         	<img src="<%=cp %>/images/main_banner_1.jpg" alt="..." style="height:409px;">
         </div>
         <div class="carousel-caption">
         </div>
     </div>
 </div>

 <!-- Controls
 <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
     <span class="glyphicon glyphicon-chevron-left"></span>
 </a>
 <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
     <span class="glyphicon glyphicon-chevron-right"></span>
 </a>
 -->
</div>

<div class="main-banner">
 <!-- 메인 배너 하단 메뉴 - 1st --> 
 	<ul class="init-ul">
 		<li class="init-li">
 			<a href="<%=cp %>/about/gospel.do" style="padding-right:10px">
				<img src="<%=cp %>/images/body_menu_about_meslap.gif" alt="AboutMeslap" />
			</a>
 		</li>
 		<li class="init-li">
 			<a href="<%=cp %>/worship/view.do" style="padding-right:10px">
	            <img src="<%=cp %>/images/body_menu_worship.gif" alt="Worship" />
	        </a>
 		</li>
 		<li class="init-li">
 			<a href="<%=cp %>/mission/intro.do" style="padding-right:10px">
	            <img src="<%=cp %>/images/body_menu_mission.gif" alt="Mission" />
	        </a>
 		</li>
 		<li class="init-li">
 			<a href="<%=cp %>/board/notice/list.do">
	            <img src="<%=cp %>/images/body_menu_news.gif" alt="News" />
	        </a>
 		</li>
 	</ul>
</div>
<div class="sub-banner">
	<div class="sub-banner-body">
		<div class="sub-banner-body-left">
	        <!-- <img src="<%=cp %>/images/weekly_bible.gif" alt="WeeklyBible" style="float:left;padding-right:10px"/>  -->
	        <img src="<%=cp %>/worshipFiles/${recentWorship.mainBibleImageFileName}" style="float:left;padding-right:10px"/>
	        
	        <a href="<%=cp %>/worship/view.do" class="block-products-list-item-icon" style="float:left;padding-bottom:10px">
	            <img src="<%=cp %>/worshipFiles/${recentWorship.mainVideoImageFileName}" />
	        </a>
	        
	        <img src="<%=cp %>/images/replay.gif" alt="Replay" usemap="#replay_map">
	        <map name="replay_map">
	            <area shape="rect" coords="17,16,240,65" href="http://www.youtube.com/channel/UCXUHra_EuT3T2vD8j3BDuJQ" alt="replay_movie">
	            <area shape="rect" coords="251,16,473,65" href="javascript:popupMobileAudio()" alt="replay_audio">
	        </map>
		</div>
		<div class="sub-banner-body-right">
	       <a href="<%=cp%>/about/gospel.do"><img src="<%=cp %>/images/good_news.jpg" alt="GoodNews" style="float:left;padding-right:10px"/></a>
	       
		   <a href="<%=cp%>/about/times.do"><img src="<%=cp %>/images/worship_time_table.gif" alt="WorshipTimeTable" style="float:left;padding-bottom:10px"/></a>
	       
	       <a href="<%=cp %>/about/road.do" class="block-products-list-item-icon" style="float:left">
	           <img src="<%=cp %>/images/location.gif" alt="Location" />
	       </a>
		</div>
	</div>
</div>
<!-- 하단 주소 -->
<jsp:include page="./include/common_bottom.jsp"></jsp:include>
</body>
</html>
