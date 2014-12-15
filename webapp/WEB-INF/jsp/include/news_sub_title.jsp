<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%String cp = request.getContextPath(); %>
<%String overMenu = (String)request.getAttribute("overMenu"); %>

<div class="subTitle" style="padding-top:18px;padding-bottom:8px">
	<img src="<%=cp%>/images/news/sub_news_title.jpg" />
</div>
<div class="subTitle" style="padding-bottom:21px">
	<a href="<%=cp%>/news.do">
		<img src="<%=cp%>/images/news/news_submenu<%if("news".equals(overMenu)){%>_over<%}%>.jpg" />
	</a>
	
</div>
<div class="line_1px"></div>