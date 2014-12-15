<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%String cp = request.getContextPath(); %>
<%String overMenu = (String)request.getAttribute("overMenu"); %>

<div class="subTitle" style="padding-top:18px;padding-bottom:8px">
	<img src="<%=cp%>/images/mission/sub_mission_title.jpg" />
</div>
<div class="subTitle" style="padding-bottom:21px">
	<a href="<%=cp%>/mission/intro.do">
		<img src="<%=cp%>/images/mission/mission_submenu01<%if("intro".equals(overMenu)){%>_over<%}%>.jpg" />
	</a>
	
	<img src="<%=cp%>/images/about/about_submenu_repeat.jpg" />
	
	<a href="<%=cp%>/mission/gallery.do">
		<img src="<%=cp%>/images/mission/mission_submenu02<%if("gallery".equals(overMenu)){%>_over<%}%>.jpg" />
	</a>
	
</div>
<div class="line_1px"></div>