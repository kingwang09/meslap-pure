<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.jesus.meslap.entity.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
	form.action = "${cp}/board/${boardCode}/admin/write.do";
	form.method = "post";
	form.submit();
}
</script>
</head>
<body>
<jsp:include page="../include/menu_include.jsp"></jsp:include>
<br/>
<div class="content">
<form id="boardForm" name="boardForm" action="${cp}/board/${boardCode}/admin/write.do" method="post" enctype="multipart/form-data" class="form-horizontal" role="form">
	<input type="hidden" name="boardCode" value="${boardCode}"/>
	<div class="form-group">
		<label for="mainVideoImage" class="col-sm-2 control-label"><i class="fa fa-check-circle-o"></i> 카테고리</label>
		<div class="col-sm-10">
			<select class="form-control">
				<option>없음</option>
			</select>
			<input type="text" name="category" class="form-control" placeholder="분류를 선택하거나, 직접입력해주세요."/>
		</div>
	</div>
	<div class="form-group">
		<label for="mainVideoImage" class="col-sm-2 control-label"><i class="fa fa-check-circle"></i> 제목</label>
		<div class="col-sm-10">
			<input type="text" name="title" class="form-control" placeholder="글 제목을 입력해주세요."/>
		</div>
	</div>
	<div class="form-group">
		<label for="mainVideoImage" class="col-sm-2 control-label"><i class="fa fa-check-circle"></i> 내용</label>
		<div class="col-sm-10">
			<textarea name="content" class="form-control" placeholder="내용을 입력해주세요." style="height:400px"></textarea>	
		</div>
	</div>
	
	<div class="form-group">
		<label for="mainVideoImage" class="col-sm-2 control-label"><i class="fa fa-check-circle"></i> 작성자</label>
		<div class="col-sm-10">
			<% 
			User user = (User)session.getAttribute(User.USER_ATTR); 
			%>
			<input type="text" name="writer" class="form-control" placeholder="작성자(자동)" value="<%=user.getUserId()%>"/>
		</div>
	</div>
	
	<div class="form-group">
		<label for="mainVideoImage" class="col-sm-2 control-label"><i class="fa fa-check-circle-o"></i> 첨부파일</label>
		<div class="col-sm-10">
			<input type="file" name="logicalFiles" class="form-control" placeholder="파일을 첨부해주세요."/>
		</div>
	</div>
	<br/>
	<div>
		<button class="btn btn-default btn-xs" onclick="write()">
			<i class="fa fa-floppy-o"></i>
			작성완료
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