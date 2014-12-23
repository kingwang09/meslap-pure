<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set var="cp" value="${pageContext.request.contextPath}" scope="request"></c:set>
<!DOCTYPE html>
<html lang="ko">
<head>
<jsp:include page="../../include/common_include.jsp"></jsp:include>
<script>
function goList(){
	location.href="${cp}/worship/admin/list.do";
}
function doSubmit(){
	var form = document.worshipForm;
	//validate
	form.submit();
}
</script>
</head>
<body>
<jsp:include page="../../include/menu_include.jsp"></jsp:include>
<br/>
<div class="content">
	<form action="${cp}/worship/admin/write.do" id="worshipForm" name="worshipForm" method="post" enctype="multipart/form-data" class="form-horizontal" role="form">
		<div class="gray-border">
			<div class="h4">메인 화면 이미지</div>
			<div class="form-group">
				<label for="mainBibleImage" class="col-sm-2 control-label">메인 암송 말씀 이미지</label>
				<div class="col-sm-10">
					<input type="file" name="mainBibleImage" id="mainBibleImage" class="form-control"/>
					<span class="help-block">기존 파일 : ${worship.mainBibleImageFileName}. 파일을 선택하실 경우, 새로운 파일로 대체 됩니다.</span>
				</div>
			</div>
			<div class="form-group">
				<label for="mainVideoImage" class="col-sm-2 control-label">말씀 동영상 링크 이미지</label>
				<div class="col-sm-10">
					<input type="file" name="mainVideoImage" id="mainVideoImage" class="form-control"/>
					<span class="help-block">기존 파일 : ${worship.mainVideoImageFileName}. 파일을 선택하실 경우, 새로운 파일로 대체 됩니다.</span>
				</div>
			</div>
		</div>
		<br/>
		
		<div class="gray-border">
			<div class="h4">말씀 목록</div>
			<div class="form-group">
				<label for="category" class="col-sm-2 control-label">분류</label>
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
					<input type="text" name="category" class="form-control" value="${worship.category}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">설교 제목</label>
				<div class="col-sm-10">
					<textarea name="title" id="title" class="form-control" style="width:100%;height:50px">${worship.title }</textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="bibleIndex" class="col-sm-2 control-label">본문 말씀 구절</label>
				<div class="col-sm-10">
					<textarea name="bibleIndex" id="bibleIndex" class="form-control" style="width:100%;height:50px">${worship.bibleIndex }</textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="bible" class="col-sm-2 control-label">본문 말씀</label>
				<div class="col-sm-10">
					<textarea name="bible" id="bible" class="form-control" style="width:100%;height:150px">${worship.bible }</textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="recitationBibleIndex" class="col-sm-2 control-label">암송 말씀 구절</label>
				<div class="col-sm-10">
					<textarea name="recitationBibleIndex" id="recitationBibleIndex" class="form-control" style="width:100%;height:50px">${worship.recitationBibleIndex }</textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="recitationBible" class="col-sm-2 control-label">암송 말씀</label>
				<div class="col-sm-10">
					<textarea name="recitationBible" id="recitationBible" class="form-control" style="width:100%;height:150px">${worship.recitationBible }</textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">유투브 URL</label>
				<div class="col-sm-10">
					<input type="text" name="youtubeUrl" id="youtubeUrl" value="${worship.youtubeUrl }"class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">동영상 이미지</label>
				<div class="col-sm-10">
					<input type="file" name="videoImage" id="videoImage" value="${worship.videoImage }" class="form-control"/>
					<span class="help-block">기존 파일 : ${worship.videoImageFileName}. 파일을 선택하실 경우, 새로운 파일로 대체 됩니다.</span>
				</div>
			</div>
		</div>
		<br/>
		
		<div class="gray-border">
			<div class="h4">말씀 첨부파일</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">말씀 오디오 파일</label>
				<div class="col-sm-10">
					<input type="file" name="audioFile" class="form-control"/>
					<span class="help-block">기존 파일 : ${worship.audioFileName}. 파일을 선택하실 경우, 새로운 파일로 대체 됩니다.</span>
				</div>
			</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">말씀 텍스트 파일</label>
				<div class="col-sm-10">
					<input type="file" name="textFile" class="form-control"/>
					<span class="help-block">기존 파일 : ${worship.textFileName}. 파일을 선택하실 경우, 새로운 파일로 대체 됩니다.</span>
				</div>
			</div>
			<div class="form-group">
				<label for="videoImage" class="col-sm-2 control-label">주보 파일</label>
				<div class="col-sm-10">
					<input type="file" name="juboFile01" class="form-control"/><br/>
					<input type="file" name="juboFile02" class="form-control"/><br/>
					<input type="file" name="juboFile03" class="form-control"/><br/>
					
					<span class="help-block">
					기존 파일 : <br/>
					${worship.juboFileName01},<br/>
					${worship.juboFileName02},<br/> 
					${worship.juboFileName03}.<br/> 
					파일을 선택하실 경우, 새로운 파일로 대체 됩니다.</span>
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
			<a href="${cp}/worship/admin/list.do" class="btn btn-default btn-xs">
				<i class="fa fa-th-list"></i> 목록으로
			</a>
		</div>
	</form>
</div>


<br/>
<jsp:include page="../../include/common_bottom.jsp"></jsp:include>
</body>
</html>