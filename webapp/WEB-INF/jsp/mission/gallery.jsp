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
	<img src="${cp}/images/mission/mission_submenu02.jpg" usemap="#mission_sub_map"/>
	<map name="mission_sub_map">
    	<area shape="rect" coords="0,56,71,76" href="${cp}/mission/intro.do" alt="미션 소개">
        <area shape="rect" coords="78,56,125,76" href="${cp}/mission/gallery.do" alt="갤러리">
    </map>
</div>
<div class="line_1px"></div>
<div class="content" style="height:600px">
	갤러리는 개발 중에 있습니다. 조금만 더 기다려주세요 ^^
</div>
<jsp:include page="../include/common_bottom.jsp"></jsp:include>
</body>
</html>