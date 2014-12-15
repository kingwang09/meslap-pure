<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page session="false" %> 
<c:set var="cp" value="${pageContext.request.contextPath}" scope="request"></c:set>
<html>
<head>
<jsp:include page="../include/common_include.jsp"></jsp:include>
<script>
function goList(){
	//location.href="${cp}/board/${boardCode}/list.do";
	var form = document.boardForm;
	form.action = "${cp}/board/${boardCode}/list.do";
	form.method = "post";
	form.submit();
}
function write(){
	//validation
	var form = document.boardForm;
	form.action = "${cp}/board/${boardCode}/${board.id}/admin/update.do";
	form.method = "post";
	form.submit();
}
</script>
</head>
<body>
<jsp:include page="../include/menu_include.jsp"></jsp:include>
<br/>
<div class="content" style="text-align:left">
<form id="boardForm" name="boardForm" action="${cp}/board/${boardCode}/${board.id}/admin/update.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="boardCode" value="${boardCode}"/>
	<input type="hidden" name="id" value="${board.id}"/>
	<div class="input-group input-group-sm" style="z-index:2">
		<span class="input-group-addon"><i class="fa fa-check-circle-o"></i></span>
		<select class="form-control">
			<option>없음</option>
		</select>
		<input type="text" name="category" class="form-control" placeholder="카테고리" value="${board.category}"/>
	</div>
	<div class="input-group input-group-sm" style="z-index:2">
		<span class="input-group-addon"><i class="fa fa-check-circle"></i></span>
		<input type="text" name="title" class="form-control" placeholder="글제목" value="${board.title}"/>
	</div>
	<textarea name="content" class="form-control" placeholder="내용" style="height:400px">${board.content}</textarea>
	<div class="input-group input-group-sm">
		<span class="input-group-addon"><i class="fa fa-check-circle"></i></span>
		<input type="text" name="writer" class="form-control" placeholder="작성자(자동)" value="${board.writer}"/>
	</div>
	<div class="input-group input-group-sm">
		<span class="input-group-addon"><i class="fa fa-check-circle-o"></i></span>
		<input type="file" name="logicalFiles" class="form-control" placeholder="파일을 첨부해주세요."/>
	</div>
	<br/>
	<div style="text-align:center">
		<button class="btn btn-default btn-xs" onclick="write()">
			<i class="fa fa-floppy-o"></i>
			수정완료
		</button>
		&nbsp;
		<button class="btn btn-default btn-xs" onclick="goList()">
			<i class="fa fa-th-list"></i>
			목록으로
		</button>
	</div>
</form>
</div>
<br/>
<jsp:include page="../include/common_bottom.jsp"></jsp:include>
</body>
</html>