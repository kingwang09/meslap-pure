<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%String cp = request.getContextPath(); %>
<%String overMenu = (String)request.getAttribute("overMenu"); %>


<div class="subTitle" style="padding-bottom:21px">
	<a href="<%=cp%>/about/gospel.do">
		<img src="<%=cp%>/images/about/about_submenu01<%if("gospel".equals(overMenu)){%>_over<%}%>.jpg" />
	</a>
	
	<img src="<%=cp%>/images/about/about_submenu_repeat.jpg" />
	
	<a href="<%=cp%>/about/intro.do">
		<img src="<%=cp%>/images/about/about_submenu02<%if("intro".equals(overMenu)){%>_over<%}%>.jpg" />
	</a>
	
	<img src="<%=cp%>/images/about/about_submenu_repeat.jpg" />
	 
	<a href="<%=cp%>/about/members.do">
		<img src="<%=cp%>/images/about/about_submenu03<%if("members".equals(overMenu)){%>_over<%}%>.jpg" />
	</a>
	
	<img src="<%=cp%>/images/about/about_submenu_repeat.jpg" />
	 
	<a href="<%=cp%>/about/times.do">
		<img src="<%=cp%>/images/about/about_submenu04<%if("times".equals(overMenu)){%>_over<%}%>.jpg" />
	</a>
	
	<img src="<%=cp%>/images/about/about_submenu_repeat.jpg" /> 
	
	<a href="<%=cp%>/about/road.do">
		<img src="<%=cp%>/images/about/about_submenu05<%if("road".equals(overMenu)){%>_over<%}%>.jpg" />
	</a>
</div>
<div class="line_1px"></div>