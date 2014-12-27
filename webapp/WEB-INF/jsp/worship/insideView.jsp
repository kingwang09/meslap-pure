<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set var="cp" value="${pageContext.request.contextPath}" scope="request"></c:set>
<head>
<jsp:include page="../include/common_include.jsp"></jsp:include>
<script>
$(document).ready(function(){
     var changeImage = function(obj, hover){
 		var imgName = $(obj).attr("imgName");
 		var ext = $(obj).attr("ext");//확장자
 		
 		ext = ext ? ext : "jpg";
 		imgName = hover? imgName+"_hover." : imgName+".";
 		
 		var imgFullName = "${cp}/images/main/"+imgName+ext;
 		$(obj).attr("src",imgFullName);
 	};
 	
 	$(".hoverImages").hover(
 			function(){
 				//console.log(this);
 				changeImage(this, true);
 			},
 			function(){
 				changeImage(this, false);
 			}
 	);
});
function viewPage(id){
	var form = parent.document.worshipForm;
	form.cPage.value = "${pMap.cPage}";
	form.id.value = id;
	form.submit();
}
function goPage(page){
	var form = parent.document.worshipForm;
	form.cPage.value = page;
	location.href="${cp}/worship/insideView.do?cPage="+page;
}
</script>
</head>
<!-- iFrame start-->
<div class="worship-content" style="padding-left:25px">
    <div class="row">
    	<div class="col-md-12">
	    	<div class="pull-right">
	            <select class="form-control">
	                <option>주제별 설교보기</option>
	                <c:forEach var="category" items="${categorys}">
	                	<option value="${category }">${category }</option>
	                </c:forEach>
	            </select>
	        </div>
        </div>
    </div>
    <c:forEach var="w" items="${worships}">
    	<div class="media" style="border:1px solid #e7e7e7">
	         <a class="pull-left" href="#">
	         	<c:if test="${empty w.videoImageFileName }">
	             <img class="media-object" src="${cp}/images/worship/default_video.jpg" />
	         	</c:if>
	         	<c:if test="${!empty w.videoImageFileName }">
	         		<img class="media-object" src="${cp}/worshipFiles/${w.videoImageFileName}" />
	         	</c:if>
	         </a>
	         <div class="media-body" style="padding-left:25px;padding-top:25px">
	             <div class="h5 media-heading"><b><a href="javascript:viewPage('${w.id }')">${w.title}</a></b>
	             	<!-- <span class="label label-default">New</span>  -->
	             </div>
	             <div style="word-break: break-all">
	                 ${w.bibleIndex } <br/><small>${w.wdateStr }</small>
	                 <div class="pull-right" style="padding-right:15px">
	                 	 <c:if test="${!empty w.audioFileName}">
	                     	<span><a href="${cp}/worship/download.do?fileName=${w.audioFileName}"><img class="hoverImages" imgName="bt_audio" src="${cp}/images/main/bt_audio.jpg"/></a></span>
	                     </c:if>
	                     <c:if test="${!empty w.textFileName}">
	                     	<span><a href="${cp}/worship/download.do?fileName=${w.textFileName}"><img class="hoverImages" imgName="bt_ebook" src="${cp}/images/main/bt_ebook.jpg"/></a></span>
	                     </c:if>
	                 </div>
	             </div>
	         </div>
	     </div>
    </c:forEach>
	<div style="text-align:center">
		${pMap.pTag}
	</div>
</div>
<!-- iFrame start-->