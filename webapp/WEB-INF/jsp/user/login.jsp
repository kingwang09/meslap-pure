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
<jsp:include page="../include/menu_include.jsp"></jsp:include>
<div class="content" style="width:300px;">
	<c:if test="${!empty mesg}">
		<div class="alert alert-danger" role="alert">${mesg}</div>
	</c:if>
	<form class="form-signin" name="user" role="form" method="post" action="${cp}/admin/login.do">
        <div class="h2 form-signin-heading">
        	<img src="${cp}/images/admin_icon.jpg" alt="Meslap" class="img-circle" style="width:140px;height:140px">
        </div>
        <label for="inputUserId" class="sr-only">관리자 아이디</label>
        <input type="text" name="userId" id="inputUserId" class="form-control" placeholder="관리자 아이디" required autofocus>
        <label for="inputPassword" class="sr-only">비밀번호</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="관리자 패스워드" required>
        <!-- 
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
         -->
        <button class="btn btn-lg btn-primary btn-block" type="submit">관리자 로그인</button>
      </form>
</div>
<jsp:include page="../include/common_bottom.jsp"></jsp:include>
</body>
</html>