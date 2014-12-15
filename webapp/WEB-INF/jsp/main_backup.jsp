<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String cp = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <jsp:include page="./include/common_include.jsp"></jsp:include>
</head>
<body>
        
		<jsp:include page="./include/menu_include.jsp"></jsp:include>
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -8->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="<%=cp %>/images/main_banner_1.jpg" alt="..." style="height:409px;">
                    <div class="carousel-caption">

                    </div>
                </div>
                <div class="item">
                    <img src="<%=cp %>/images/main_banner_1.jpg" alt="..." style="height:409px;">
                    <div class="carousel-caption">

                    </div>
                </div>
                <div class="item">
                    <img src="<%=cp %>/images/main_banner_1.jpg" alt="..." style="height:409px;">
                    <div class="carousel-caption">

                    </div>
                </div>
                <div class="item">
                    <img src="<%=cp %>/images/main_banner_1.jpg" alt="..." style="height:409px;">
                    <div class="carousel-caption">

                    </div>
                </div>
            </div>

            <!-- Controls
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
            -->
        </div>

		<br />


        <!-- 메인 배너 하단 메뉴 - 1st --> 
        <div id="body_menu_1st">
            <div class="like-cell-body-padding-right">
                <a href="<%=cp %>/about/intro.do" class="block-products-list-item-icon">
                    <img src="<%=cp %>/images/body_menu_about_meslap.gif" alt="AboutMeslap" width="240">
                </a>
            </div>
            <div class="like-cell-body-padding-left-right">
                <a href="<%=cp %>/worship/main.do" class="block-products-list-item-icon">
                    <img src="<%=cp %>/images/body_menu_worship.gif" alt="Worship" width="240">
                </a>
            </div>
            <div class="like-cell-body-padding-left-right">
                <a href="<%=cp %>/mission/intro.do" class="block-products-list-item-icon">
                    <img src="<%=cp %>/images/body_menu_mission.gif" alt="Mission" width="240">
                </a>
            </div>
            <div class="like-cell-body-padding-left">
                <a href="<%=cp %>/news.do" class="block-products-list-item-icon">
                    <img src="<%=cp %>/images/body_menu_news.gif" alt="News" width="240">
                </a>
            </div>
        </div>
 
        <!-- 메인 배너 하단 메뉴 - 2nd -->
 
        <div id="body_menu_2nd">
            <div class="like-cell-body-padding-right">
                <div>
                    <div class="like-row-body-padding-right">
                        <div class="like-cell-body-padding-right">
                            <a href="/" class="block-products-list-item-icon">
                                <img src="<%=cp %>/images/weekly_bible.gif" alt="WeeklyBible" width="240">
                            </a>
                        </div>
                        <div class="like-cell-body-padding-left">
                            <a href="/" class="block-products-list-item-icon">
                                <img src="<%=cp %>/images/preaching.gif" alt="Preaching" width="240">
                            </a>
                        </div>
                    </div>
                </div>
                <div class="like-row-body-padding-right">
                    <img src="<%=cp %>/images/replay.gif" alt="Replay" width="490" usemap="#replay_map">
                    <map name="replay_map">
                        <area shape="rect" coords="18,52,232,96" href="/" alt="replay_movie">
                        <area shape="rect" coords="255,52,468,96" href="/" alt="replay_audio">
                    </map>
                    
                </div>
            </div>
            <div class="like-cell-body-padding-left-right">
                <a href="/" class="block-products-list-item-icon">
                    <img src="<%=cp %>/images/good_news.gif" alt="GoodNews" width="240">
                </a>
            </div>
            <div class="like-cell-body-padding-left">
                <div class="like-cell-body-padding-bottom">
                    <a href="/" class="block-products-list-item-icon">
                        <img src="<%=cp %>/images/worship_time_table.gif" alt="WorshipTimeTable" width="240">
                    </a>
                </div>
                <div class="like-row-body-padding-left">
                    <a href="/" class="block-products-list-item-icon">
                        <img src="<%=cp %>/images/location.gif" alt="Location" width="240">
                    </a>
                </div>
            </div>
        </div>

        <hr class="separator2">

        <!-- 하단 주소 -->
        <div id="bottom">            
            <div class="like-cell-body-padding-right">
                <img src="<%=cp %>/images/bottom_address.gif" alt="Address" width="990">
            </div>
        </div>
</body>
</html>
