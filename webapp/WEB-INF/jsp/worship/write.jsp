<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%String cp = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<jsp:include page="../include/common_include.jsp"></jsp:include>
<script>
function goList(){
	location.href="<%=cp%>/worship/admin/list.do";
}
function doSubmit(){
	var form = document.worshipForm;
	//validate
	form.submit();
}
</script>
</head>
<body>
<jsp:include page="../include/menu_include.jsp"></jsp:include>
<br/>
<div class="content">
	<form action="<%=cp %>/worship/admin/write.do" id="worshipForm" name="worshipForm" method="post" enctype="multipart/form-data" class="form-horizontal" role="form">
		<div style="border:1px solid #e7e7e7">
		<div class="h4">메인 화면 이미지</div>
		<div class="form-group">
			<label for="mainBibleImage" class="col-sm-2 control-label">말씀 이미지</label>
			<div class="col-sm-10">
				<input type="file" name="mainBibleImage" id="mainBibleImage" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="mainVideoImage" class="col-sm-2 control-label">말씀 동영상 링크 이미지</label>
			<div class="col-sm-10">
				<input type="file" name="mainVideoImage" id="mainVideoImage" class="form-control"/>
			</div>
		</div>
		</div>
		<br/>
		
		<div style="border:1px solid #e7e7e7">
			<div class="h4">말씀 목록</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">동영상 이미지</label>
				<div class="col-sm-10">
					<input type="file" name="videoImage" id="videoImage" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="titleWorshipFile" class="col-sm-2 control-label">타이틀 이미지</label>
				<div class="col-sm-10">
					<input type="file" name="titleWorshipFile" id="titleWorshipFile" class="form-control"/>
				</div>
			</div>
		</div>
		<br/>
		
		<div style="border:1px solid #e7e7e7">
			<div class="h4">말씀 등록(Font-적용)</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">제목 </label>
				<div class="col-sm-10">
					<input type="text" name="title" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">말씀위치(장/절)</label>
				<div class="col-sm-10">
					<input type="text" name="bibleIndex" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">말씀구절 </label>
				<div class="col-sm-10">
					<textarea name="bible" class="form-control"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">암송구절(장/절)</label>
				<div class="col-sm-10">
					<input type="text" name="recitationBible" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">암송구절 </label>
				<div class="col-sm-10">
					<input type="text" name="recitationBibleIndex" class="form-control"/>
				</div>
			</div>
		</div>
		<div style="border:1px solid #e7e7e7">
			<div class="h4">말씀 등록</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">카테고리</label>
				<div class="col-sm-10">
					<!-- 기존 등록된 카테고리 Distinct 목록 -->
					<select class="form-control">
						<c:forEach var="category" items="${categorys }">
							<option value="${category }">
								<c:if test="${empty category}">
									없음
								</c:if>
								${category}
							</option>
						</c:forEach>
					</select>
					<input type="text" name="category" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">유투브 URL</label>
				<div class="col-sm-10">
					<input type="text" name="youtubeUrl" id="youtubeUrl" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="mainWorshipFile" class="col-sm-2 control-label">말씀 메인이미지</label>
				<div class="col-sm-10">
					<input type="file" name="mainWorshipFile" id="mainWorshipFile" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="subWorshipFile" class="col-sm-2 control-label">말씀 서브이미지</label>
				<div class="col-sm-10">
					<input type="file" name="subWorshipFile" id="subWorshipFile" class="form-control"/>
				</div>
			</div>
		</div>
		
		 <div style="border:1px solid #e7e7e7">
			<div class="h4">말씀 첨부파일</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">말씀 오디오 파일</label>
				<div class="col-sm-10">
					<input type="file" name="audioFile" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">말씀 텍스트 파일</label>
				<div class="col-sm-10">
					<input type="file" name="textFile" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">주보 파일</label>
				<div class="col-sm-10">
					<input type="file" name="juboFile01" class="form-control"/><br/>
					<input type="file" name="juboFile02" class="form-control"/><br/>
					<input type="file" name="juboFile03" class="form-control"/><br/>
				</div>
			</div>
		</div>
		<div style="text-algin:center">
			<a href="javascript:doSubmit();" class="btn btn-default btn-xs">
				<i class="fa fa-floppy-o"></i> 등록 완료
			</a>
			&nbsp;
			<!-- 
			<input type="button" value="미리보기" class="btn btn-default btn-xs" />
			&nbsp;
			 -->
			<a href="<%=cp %>/worship/admin/list.do" class="btn btn-default btn-xs">
				<i class="fa fa-th-list"></i> 목록으로
			</a>
		</div>
	</form>
</div>


<br/>
<jsp:include page="../include/common_bottom.jsp"></jsp:include>
</body>
</html>