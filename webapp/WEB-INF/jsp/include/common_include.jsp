<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set var="cp" value="${pageContext.request.contextPath}" scope="request"></c:set>
<!-- include/common_include.jsp start -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meslap: Message For Love And Peace</title>
<meta name="viewport" content="width=device-width">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="${cp}/frameworks/bootstrap/css/bootstrap-theme.css">
<link rel="stylesheet" href="${cp}/frameworks/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="${cp}/frameworks/bootstrap/css/datepicker3.css">
<link rel="stylesheet" href="${cp}/frameworks/fontawsome/css/font-awesome.css">
<link rel="stylesheet" href="${cp}/frameworks/jquery-magnific/magnific-popup.css">
<link rel="stylesheet" href="${cp}/frameworks/sweet-alert/sweet-alert.css">
<link rel="stylesheet" type="text/css" href="${cp}/css/default.css?v=1">

<!-- Latest compiled and minified JavaScript -->
<script src="${cp}/frameworks/jquery/jquery-1.11.1.js"></script>
<script src="${cp}/frameworks/bootstrap/js/bootstrap.js"></script>
<script src="${cp}/frameworks/bootstrap/js/bootstrap-datepicker.js"></script>
<script src="${cp}/frameworks/bootstrap/js/locales/bootstrap-datepicker.kr.js"></script>
<script src="${cp}/frameworks/jquery-magnific/jquery.magnific-popup.js"></script>
<script src="${cp}/frameworks/sweet-alert/sweet-alert.min.js"></script>
<!-- include/common_include.jsp end --> 
<style>
    .row{
        margin-right:0px;
    }
    th{
    	text-align:center
    }
</style>
<script>
$(document).ready(function(){
	console.log($(".input-group.date"));
	$(".input-group.date").datepicker({
	    format: "yyyy-mm-dd",
	    language: "kr",
	    todayHighlight: true
	});	
});
</script>