<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set var="cp" value="${pageContext.request.contextPath}" scope="request"></c:set>
<!DOCTYPE html>
<html lang="ko">
<head>
    <jsp:include page="../include/common_include.jsp"></jsp:include>    
</head>
<body>
<jsp:include page="../include/menu_include.jsp"></jsp:include>
<div class="subTitle">
	<img src="${cp}/images/mission/mission_submenu01.jpg" usemap="#mission_sub_map"/>
	<map name="mission_sub_map">
     	<area shape="rect" coords="0,56,71,76" href="${cp}/mission/intro.do" alt="미션 소개">
        <area shape="rect" coords="78,56,125,76" href="${cp}/mission/gallery.do" alt="갤러리">
    </map>
</div>
<div class="line_1px"></div>
<div class="content">
	<div>
		<img src="${cp}/images/mission/ministry_txt.jpg" />
	</div>
	<!-- 
	<div style="float:left">
		<video width="320" height="240" controls>
		  <source src="${cp}/videos/awana_video.mp4">
			Your browser does not support the video tag.
		</video>
	</div>
	 -->
	<div>
		<img src="${cp}/images/mission/right_box.jpg" />
	</div>
</div>
<jsp:include page="../include/common_bottom.jsp"></jsp:include>
</body>
</html>