<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.jesus.meslap.entity.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String cp = request.getContextPath(); %>
<script>
function newPopup(){
	window.open('http://wowccm.net/player/autoplayer10.htm', 'music', 'height=200,width=150');
}
$(document).ready(function(){
	var changeImage = function(obj, hover){
		//console.log(obj);
		var imgName = $(obj).attr("imgName");
		var ext = $(obj).attr("ext");//확장자
		
		ext = ext ? ext : "jpg";
		imgName = hover? imgName+"_hover." : imgName+".";
		
		var imgFullName = "<%=cp%>/images/main/"+imgName+ext;
		$(obj).attr("src",imgFullName);
	};
	
	$(".hoverImages").hover(
			function(){
				//console.log(this);
				changeImage(this, true);
			},
			function(){
				changeImage(this, false);
			}
	);
	
	$(".mainMenu").mouseenter(function(){
		var left = $(this).position().left;
		var menuId = $(this).attr("menuId");
		var standardPosition = $("#stanardPosition").position();
		$(".main-dropdown").css({"visibility":"hidden"});
		$("#"+menuId).css({"left":standardPosition.left,"visibility":"visible"});
	});
	
	
	$(".main-dropdown").mouseleave(function(){
		console.log("mouseleave");
		$(".main-dropdown").css({"visibility":"hidden"});
	});
	
	$("body").click(function(){
		$(".main-dropdown").css({"visibility":"hidden"});
	});
});
</script>
<div id="form-progress-bar" class="form-progress-bar">
    <div></div>
</div>
<!-- 상단 메인 메뉴 -->
<!-- Meslap Logo -->
<div style="margin:0 auto;width:1000px;">
	<div class="site-navigation-item">
	    <a href="<%=cp%>/index.do"><img src="<%=cp %>/images/main/meslap_logo.jpg" alt="MeslapLogo" /></a>
	</div>
	<!-- About Meslap -->
	<div class="site-navigation-item site-navigation-about-meslap" style="padding-left:60px">
	    <span id="stanardPosition" class="site-navigation-about-meslap">
	        <a href="<%=cp%>/about/gospel.do"><img class="mainMenu hoverImages" src="<%=cp %>/images/main/main_menu_about_meslap.jpg" imgName="main_menu_about_meslap" alt="AboutMeslap" menuId="aboutMenu" /></a>
	    </span>
	    <div class="main-dropdown site-navigation-dropdown-about-meslap" id="aboutMenu">            
	        <!-- <img src="<%=cp %>/images/main/roll_about_meslap.jpg" width="600"/>  -->
	        <!-- 
	        	복음{187,125,225,154}
				교회소개{232,125,290,154}
				교인등록{297,125,354,154}
				예배안내{361,125,419,154} 
			-->
	        <img src="<%=cp %>/images/main/roll_about_meslap.jpg" usemap="#about_map"/>
	        <map name="about_map">
	        	<area shape="rect" coords="187,125,225,154" href="<%=cp %>/about/gospel.do" alt="replay_movie">
	            <area shape="rect" coords="232,125,290,154" href="<%=cp %>/about/intro.do" alt="replay_movie">
	            <area shape="rect" coords="297,125,354,154" href="<%=cp %>/about/members.do" alt="replay_audio">
	            <area shape="rect" coords="361,125,419,154" href="<%=cp %>/about/times.do" alt="replay_audio">
	            <area shape="rect" coords="427,125,492,154" href="<%=cp %>/about/road.do" alt="replay_audio">
	        </map>
	    </div>
	</div>
	<!-- Worship -->
	<div class="site-navigation-item site-navigation-worship-meslap">
	    <span class="site-navigation-worship-meslap">
	        <a href="<%=cp%>/worship/view.do"><img class="mainMenu hoverImages" src="<%=cp %>/images/main/main_menu_worship_meslap.jpg" imgName="main_menu_worship_meslap" alt="WorshipMeslap" menuId="worshipMenu"/></a>
	    </span>
	    <div class="main-dropdown site-navigation-dropdown-worship-meslap" id="worshipMenu">            
	        <img src="<%=cp %>/images/main/roll_worship_meslap.jpg" usemap="#worship_map"/>
	        <map name="worship_map">
	            <area shape="rect" coords="186,124,251,154" href="<%=cp%>/worship/view.do" alt="replay_movie">
	            <area shape="rect" coords="259,124,347,154" href="<%=cp%>/board/bibleStudy/list.do" alt="replay_audio">
	        </map>
	    </div>
	</div>
	<!-- Mission -->
	<div class="site-navigation-item site-navigation-mission-meslap">
	    <span class="site-navigation-mission-meslap">
	        <a href="<%=cp%>/mission/intro.do"><img class="mainMenu hoverImages" src="<%=cp %>/images/main/main_menu_mission_meslap.jpg" imgName="main_menu_mission_meslap" alt="MissionMeslap" menuId="missionMenu" /></a>
	    </span>
	    <div class="main-dropdown site-navigation-dropdown-mission-meslap" id="missionMenu">            
	        <img src="<%=cp %>/images/main/roll_mission_meslap.jpg" usemap="#mission_map"/>
	        <map name="mission_map">
	            <area shape="rect" coords="186,145,263,174" href="<%=cp %>/mission/intro.do" alt="replay_movie">
	            <area shape="rect" coords="269,145,319,174" href="<%=cp %>/mission/gallery.do" alt="replay_audio">
	        </map>
	    </div>
	</div>
	<!-- News -->
	<div class="site-navigation-item site-navigation-news-meslap" style="padding-right:30px">
	    <span class="site-navigation-news-meslap">
	        <a href="<%=cp%>/board/notice/list.do"><img class="mainMenu hoverImages" src="<%=cp %>/images/main/main_menu_news_meslap.jpg" imgName="main_menu_news_meslap" alt="NewsMeslap" menuId="newsMenu" /></a>
	    </span>
	    <div class="main-dropdown site-navigation-dropdown-news-meslap" id="newsMenu">            
	        <img src="<%=cp %>/images/main/roll_news_meslap.jpg" usemap="#news_map"/>
	        <map name="news_map">
	            <area shape="rect" coords="186,124,252,154" href="<%=cp %>/board/notice/list.do" alt="replay_movie">
	        </map>
	    </div>
	</div>
	<!-- e-mail 
	<div class="site-navigation-item site-navigation-email">
	</div>
	-->
	<img class="hoverImages" src="<%=cp %>/images/main/mail.jpg" imgName="mail" ext="jpg" style="padding-right:13px"/>
	<!-- facebook 
	<div class="site-navigation-item site-navigation-facebook">
	</div>
	-->
	<a href="https://www.facebook.com/meslap3" target="_new"><img class="hoverImages" src="<%=cp %>/images/main/facebook.jpg" imgName="facebook" ext="jpg" style="padding-right:13px"/></a>
	<!-- kakao music 
	<div class="site-navigation-item site-navigation-kakaomusic">
	
	http://wowccm.net/wow_winme/play01.html
	</div>
	-->
	<a href="javascript:newPopup();"><img class="hoverImages" src="<%=cp %>/images/main/kakao.jpg" imgName="kakao" ext="jpg" /></a>
	&nbsp;
	<!-- 
	<a href="<%=cp%>/admin/list.do"><i class="fa fa-cogs"></i></a>
	&nbsp;
	<%
		User user = (User)session.getAttribute(User.USER_ATTR); 
		if(user != null){
	%>
		<a href="<%=cp%>/admin/logout.do"><i class="fa fa-sign-out"></i></a>
	<%
		}
	%>
	 -->
</div>
<hr class="separator_top" >