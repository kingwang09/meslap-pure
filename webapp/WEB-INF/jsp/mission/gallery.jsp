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
	<img src="<%=cp %>/images/mission/mission_submenu02.jpg" usemap="#mission_sub_map"/>
	<map name="mission_sub_map">
    	<area shape="rect" coords="0,56,71,76" href="<%=cp %>/mission/intro.do" alt="replay_movie">
        <area shape="rect" coords="78,56,125,76" href="<%=cp %>/mission/gallery.do" alt="replay_movie">
    </map>    </map>
</div>
<div class="line_1px"></div>
<div class="content" style="height:400px">
	갤러리
</div>
<jsp:include page="../include/common_bottom.jsp"></jsp:include>
</body>
</html>