<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/search.css" rel="stylesheet">
</head>
<body>
<input type="hidden" id="keywordValue" value="${keyword}"/>
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>

<div class="container.fluid" style="height:90vh">
	<div class="row mx-3" style="height:90vh;">
	
	<!-- 지도 표시 -->
		<div class="col-8">
			<div class="map_wrap mx-3" style="height:90vh">
				<div id="map" style="width:100%;height:90vh;position:relative;overflow:hidden;"></div>
			</div>
		</div>

		<div class="col-4">    
			<div id="menu_wrap" class="bg_white">
				<div class="option">
					<h5 class="mt-1 mb-3">검색 키워드 </h5>
					<div class="my-1 mx-0">
						<input class="form-control" type="text" id="keyword" size="15"  placeholder="Search">
					</div>
					<div class="my-1 mx-0">
						<input type="button" class="btn btn-info btn-block mx-0" id="searchBtn" value="검색하기" onClick="searchPlaces()"/>

					</div>
					<!-- temporary -->
					<!-- <input type="hidden" id="menu" value="${menu}"/> -->
					<div class="mt-1 mb-3 mx-0">
						<button id="findLocal" class="btn btn-info btn-block mx-0" onClick="getPosition()">내위치 맛집찾기</button>
					</div>
				</div>
			</div>
			<!-- 식당 리스트와 정보들 -->
			<div style="width:100%;height:67vh">
				<ul class="px-0" id="placesList"></ul>
				<div class="text-center mb-1" id="pagination"></div>
			</div>
		</div>
    </div>
</div>

<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/menu.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e8d9b38a8afd2bcec1ece996622e6d39&libraries=services"></script>
<script src="js/search.js"></script>
</body>
</html>