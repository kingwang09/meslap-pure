<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page session="false" %> 
<c:set var="cp" value="${pageContext.request.contextPath}" scope="request"></c:set>
<html>
<head>
<jsp:include page="../include/common_include.jsp"></jsp:include>
</head>
<body>
<a href="${cp}/boardAdmin/list.do">list</a><br/>
	<div>
		<span>boardTitle : ${boardAdmin.boardTitle}</span>
	</div>
	<div>
		<span>boardCode : ${boardAdmin.boardCode}</span>
	</div>
	<div>
		<span>description : ${boardAdmin.description}</span>
	</div>
	<div>
		<span>wdate : ${boardAdmin.wdate}</span>
	</div>
</body>
</html>