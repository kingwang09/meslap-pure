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
	<img src="${cp}/images/about/about_submenu02.jpg" usemap="#about_sub_map"/>
	<map name="about_sub_map">
    	<area shape="rect" coords="0,56,35,76" href="${cp}/about/gospel.do" alt="복음">
        <area shape="rect" coords="41,56,99,76" href="${cp}/about/intro.do" alt="교회소개">
        <area shape="rect" coords="106,56,164,76" href="${cp}/about/members.do" alt="교인등록">
        <area shape="rect" coords="170,56,229,76" href="${cp}/about/times.do" alt="교회시간">
        <area shape="rect" coords="235,56,296,76" href="${cp}/about/road.do" alt="교회 오시는길">
    </map>
</div>
<div class="line_1px"></div>
<div class="content" style="heigth:600px">
	교회소개 페이지는 현재 공사중입니다 ^^
</div>
<jsp:include page="../include/common_bottom.jsp"></jsp:include>
</body>
</html>