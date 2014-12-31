<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page session="false" %> 
<c:set var="cp" value="${pageContext.request.contextPath}" scope="request"></c:set>
<!DOCTYPE html>
<html lang="ko">
<head>
<jsp:include page="../include/common_include.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../include/menu_include.jsp"></jsp:include>
<br/>
<div class="content" style="text-align:left">
	<div class="panel panel-default">
	  <div class="panel-heading">
	  	<h4>
	  		<c:if test="${!empty board.category }">
	  			<small>[${board.category }]</small>
	  		</c:if>
	  		${board.title }
	  	</h4>
	  </div>
	  <div class="panel-body">
	    <pre style="height:400px" class="boardContent">${board.content}</pre>
	    <div style="text-align:right">
	    	<c:if test="${!empty board.fileName }">
	    	<span>
	    		<a href="${cp}/board/${boardCode}/${board.id}/download.do?filePath=${board.filePath}&fileName=${board.fileName}" title="${board.filePath}">
	    		<i class="fa fa-file-archive-o"></i> <!-- 확장자에따라 아이콘 변경. -->
	    		${board.fileName}
	    		</a>
	    	</span>
	    	</c:if>
	    	<small>${board.wdateStr} - ${board.writer }</small>
	    </div>
	  </div>
	</div>
	<br/>
	<div style="text-align:center">
		<a href="${cp}/board/${boardCode}/list.do" class="btn btn-default btn-xs">
			<i class="fa fa-th-list"></i>
			목록으로
		</a>
	</div>
</div>
<br/>
<jsp:include page="../include/common_bottom.jsp"></jsp:include>
</body>
</html>