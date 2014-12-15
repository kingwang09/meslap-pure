<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%String cp = request.getContextPath(); %>
<%String overMenu = (String)request.getAttribute("overMenu"); %>

<div class="subTitle" style="padding-top:18px;padding-bottom:8px">
	<img src="<%=cp%>/images/worship/sub_worship_title.jpg" />
</div>
<div class="subTitle" style="padding-bottom:21px">
	<a href="<%=cp%>/worship/main.do">
		<img src="<%=cp%>/images/worship/worship_submenu01<%if("main".equals(overMenu)){%>_over<%}%>.jpg" />
	</a>
	
	<img src="<%=cp%>/images/about/about_submenu_repeat.jpg" />
	
	<a href="<%=cp%>/worship/board.do">
		<img src="<%=cp%>/images/worship/worship_submenu02<%if("board".equals(overMenu)){%>_over<%}%>.jpg" />
	</a>
	
</div>
<div class="line_1px"></div>