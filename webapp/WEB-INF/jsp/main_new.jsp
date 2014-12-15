<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String cp = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <jsp:include page="./include/common_include.jsp"></jsp:include>
</head>
<body>
	 <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <!-- <a class="navbar-brand" href="<%=cp%>/index.do"><img src="<%=cp %>/images/main/meslap_logo.jpg" alt="MeslapLogo" /></a>  -->
          <img src="<%=cp %>/images/main/meslap_logo.jpg" alt="MeslapLogo" />
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active">
            	<!-- <a href="<%=cp%>/about/intro.do"> 
            	<img class="hoverImages" src="<%=cp %>/images/main/main_menu_about_meslap.jpg" imgName="main_menu_about_meslap" alt="AboutMeslap" />
            	</a>
            	-->
            	<img class="hoverImages" src="<%=cp %>/images/main/main_menu_about_meslap.jpg" imgName="main_menu_about_meslap" alt="AboutMeslap" />
            </li>
            <li>
            	<!-- <a href="<%=cp%>/worship/main.do"><img class="hoverImages" src="<%=cp %>/images/main/main_menu_worship_meslap.jpg" imgName="main_menu_worship_meslap" alt="WorshipMeslap" width="150"></a> -->
            	<img class="hoverImages" src="<%=cp %>/images/main/main_menu_worship_meslap.jpg" imgName="main_menu_worship_meslap" alt="WorshipMeslap" />
            </li>
            <li>
            	<!-- <a href="<%=cp%>/mission/intro.do"><img class="hoverImages" src="<%=cp %>/images/main/main_menu_mission_meslap.jpg" imgName="main_menu_mission_meslap" alt="MissionMeslap" width="150"></a> -->
            	<img class="hoverImages" src="<%=cp %>/images/main/main_menu_mission_meslap.jpg" imgName="main_menu_mission_meslap" alt="MissionMeslap" />
            </li>
            <li>
            	<!-- <a href="<%=cp%>/news.do"><img class="hoverImages" src="<%=cp %>/images/main/main_menu_news_meslap.jpg" imgName="main_menu_news_meslap" alt="NewsMeslap" width="150"></a> -->
            	<img class="hoverImages" src="<%=cp %>/images/main/main_menu_news_meslap.jpg" imgName="main_menu_news_meslap" alt="NewsMeslap" />
            </li>
            <li>
            	<img class="hoverImages" src="<%=cp %>/images/main/main_menu_contact_us_mail.gif" imgName="main_menu_contact_us_mail" ext="gif" />
            	<img class="hoverImages" src="<%=cp %>/images/main/main_menu_face_book.gif" imgName="main_menu_face_book" ext="gif" />
            	<img class="hoverImages" src="<%=cp %>/images/main/main_menu_kakao_music.gif" imgName="main_menu_kakao_music" ext="gif" />
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
	
</body>
</html>
