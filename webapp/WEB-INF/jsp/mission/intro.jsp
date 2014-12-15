<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String cp = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <jsp:include page="../include/common_include.jsp"></jsp:include>    
</head>
<body>
<jsp:include page="../include/menu_include.jsp"></jsp:include>
<div class="subTitle">
	<img src="<%=cp %>/images/mission/mission_submenu01.jpg" usemap="#mission_sub_map"/>
	<map name="mission_sub_map">
    	<area shape="rect" coords="0,56,71,76" href="<%=cp %>/mission/intro.do" alt="replay_movie">
        <area shape="rect" coords="78,56,125,76" href="<%=cp %>/mission/gallery.do" alt="replay_movie">
    </map>
</div>
<div class="line_1px"></div>
<div class="content">
	<div>
		<img src="<%=cp %>/images/mission/ministry_txt.jpg" />
	</div>
	<!-- 
	<div style="float:left">
		<video width="320" height="240" controls>
		  <source src="<%=cp%>/videos/awana_video.mp4">
			Your browser does not support the video tag.
		</video>
	</div>
	 -->
	<div>
		<img src="<%=cp %>/images/mission/right_box.jpg" />
	</div>
</div>
<jsp:include page="../include/common_bottom.jsp"></jsp:include>
</body>
</html>