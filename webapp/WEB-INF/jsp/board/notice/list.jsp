<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.jesus.meslap.entity.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set var="cp" value="${pageContext.request.contextPath}" scope="request"></c:set>
<html>
<head>
<jsp:include page="../../include/common_include.jsp"></jsp:include>
<script>
function goPage(page){
	var form = document.boardForm;
	form.action = "${cp}/board/${boardCode}/list.do";
	form.cPage.value = page;
	form.submit();
}
function deleteBoard(boardCode, id){
	swal({
		title:'정말 삭제하시겠습니까?',
		text:'삭제하시면 게시물을 다시 복구할 수 없습니다!',
		type:'warning',
		showCancelButton:true,
		cancelButtonText:'삭제 취소',
		confirmButtonText:'삭제 완료',
		closeOnConfirm:false
	},function(isConfirm){
		if(isConfirm){
			var form = document.boardForm;
			form.action = "${cp}/board/"+boardCode+"/"+id+"/admin/delete.do";
			form.submit();
		}
	});
}

</script>
</head>
<body>
<jsp:include page="../../include/menu_include.jsp"></jsp:include>
<div class="subTitle">
	<img src="${cp }/images/news/news_submenu01.jpg" usemap="#news_sub_map"/>
</div>
<div class="line_1px"></div>
<div class="content" style="height:650px">
	<form id="boardForm" name="boardForm" method="get" action="${cp}/board/${boardCode}/list.do">
		<input type="hidden" name="cPage" value="${pMap.cPage}"/>
		<input type="hidden" name="boardCode" value="${boardCode}"/>
	</form>
	<%
		User user = (User)session.getAttribute(User.USER_ATTR); 
		if(user != null){
	%>
	<div class="pull-right">
		<a href="${cp}/board/${boardCode}/admin/write.do" class="btn btn-default btn-xs"><i class="fa fa-pencil"></i> 글작성</a><br/>	
	</div>
	<%	} %>
	<table class="table table-condensed">
		<thead>
			<tr>
				<th>분류</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<%if(user!=null){ %>
				<th>작업</th>
				<%} %>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty boards}">
				<tr>
					<td colspan="5" align="center">현재 게시글이 존재하지 않습니다.</td>
				</tr>
			</c:if>	
			
			<c:forEach var="board" items="${boards}">
			<tr>
				<td>${board.category}</td>
				<td><a href="${cp}/board/${board.boardCode}/${board.id}/view.do">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.wdateStr}</td>
				<%if(user!=null){ %>
				<td>
					<a href="${cp}/board/${board.boardCode}/${board.id}/admin/update.do" class="btn btn-default btn-xs"><i class="fa fa-pencil-square-o"></i> 수정</a>
					<a href="javascript:deleteBoard('${board.boardCode }','${board.id}')" class="btn btn-default btn-xs"><i class="fa fa-times"></i> 삭제</a>
				</td>
				<%} %>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	${pMap.pTag}
</div>
<jsp:include page="../../include/common_bottom.jsp"></jsp:include>
</body>
</html>