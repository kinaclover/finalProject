<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/statics.css">
<link rel="stylesheet" href="css/billboard.css">
<script src="js/billboard.pkgd.js"></script>
<script src="js/moment.js"></script>
</head>
<body class="d-block">
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>

<!-- total statistic -->

<!-- food -->
<c:forEach var="food" items="${food-total}" varStatus="stat">
	<input type="hidden" class="food-total-key-${stat.count}" value="${food.key}"/>
	<input type="hidden" class="food-total-value-${stat.count}" value="${food.value}"/>
</c:forEach>
<c:forEach items="${monFood-total}" var="food" varStatus="stat">
	<input type="hidden" class="monFood-total-key-${stat.count}" value="${food.key}"/>
	<input type="hidden" class="monFood-total-value-${stat.count}" value="${food.value}"/>
</c:forEach>
<c:forEach items="${tueFood-total}" var="food" varStatus="stat">
	<input type="hidden" class="tueFood-total-key-${stat.count}" value="${food.key}"/>
	<input type="hidden" class="tueFood-total-value-${stat.count}" value="${food.value}"/>
</c:forEach>
<c:forEach items="${wedFood-total}" var="food" varStatus="stat">
	<input type="hidden" class="wedFood-total-key-${stat.count}" value="${food.key}"/>
	<input type="hidden" class="wedFood-total-value-${stat.count}" value="${food.value}"/>
</c:forEach>
<c:forEach items="${thuFood-total}" var="food" varStatus="stat">
	<input type="hidden" class="thuFood-total-key-${stat.count}" value="${food.key}"/>
	<input type="hidden" class="thuFood-total-value-${stat.count}" value="${food.value}"/>
</c:forEach>
<c:forEach items="${friFood-total}" var="food" varStatus="stat">
	<input type="hidden" class="friFood-total-key-${stat.count}" value="${food.key}"/>
	<input type="hidden" class="friFood-total-value-${stat.count}" value="${food.value}"/>
</c:forEach>
<!-- category -->
<c:forEach items="${category-total}" var="category" varStatus="stat">
	<input type="hidden" class="category-total-key-${stat.count}" value="${category.key}"/>
	<input type="hidden" class="category-total-value-${stat.count}" value="${category.value}"/>
</c:forEach>
<c:forEach items="${monCategory-total}" var="category" varStatus="stat">
	<input type="hidden" class="monCategory-total-key-${stat.count}" value="${category.key}"/>
	<input type="hidden" class="monCategory-total-value-${stat.count}" value="${category.value}"/>
</c:forEach>
<c:forEach items="${tueCategory-total}" var="category" varStatus="stat">
	<input type="hidden" class="tueCategory-total-key-${stat.count}" value="${category.key}"/>
	<input type="hidden" class="tueCategory-total-value-${stat.count}" value="${category.value}"/>
</c:forEach>
<c:forEach items="${wedCategory-total}" var="category" varStatus="stat">
	<input type="hidden" class="wedCategory-total-key-${stat.count}" value="${category.key}"/>
	<input type="hidden" class="wedCategory-total-value-${stat.count}" value="${category.value}"/>
</c:forEach>
<c:forEach items="${thuCategory-total}" var="category" varStatus="stat">
	<input type="hidden" class="thuCategory-total-key-${stat.count}" value="${category.key}"/>
	<input type="hidden" class="thuCategory-total-value-${stat.count}" value="${category.value}"/>
</c:forEach>
<c:forEach items="${friCategory-total}" var="category" varStatus="stat">
	<input type="hidden" class="friCategory-total-key-${stat.count}" value="${category.key}"/>
	<input type="hidden" class="friCategory-total-value-${stat.count}" value="${category.value}"/>
</c:forEach>
<div id="staticsTotal" class="" style="width:95%;margin:0 auto">
	<div>
		<div class="btn-group pl-5">
			<input type="button" class="btn-sm btn-outline-secondary" id="preMonth" value="&larr;"/>
			<input type="button" class="btn-sm btn-outline-secondary" id="nextMonth" value="&rarr;"/>
			<input type="button" class="btn-sm btn-outline-info" id="thisMonth" value="T"/>
			<span id="currentMonth"></span>
		</div>
	</div>
	<div style="height:40vh" class="my-3 py-3 pl-5">
		<div class="foodMonth">
			<label for="foodMonth-total" class="">이번달 먹은 음식 Top 10</label>
			<div class="mx-auto" id="foodMonth-total"></div>
		</div>
		<div class="categoryMonth">
			<label for="foodMonth-total" class="">카테고리</label>
			<div class="mx-auto" id="categoryMonth-total"></div>
		</div>
	</div>
	<div style="height:40vh" class="list-group-horizontal text-center">
		<div style="height:100%" class="mon list-group-item btn-outline-danger">
			<p class="dayHead">Monday</p>
			<input type="hidden" class="MondayChk" value="0"/>
			<div id="Monday-food-total"></div>
			<div id="Monday-category-total" hidden="hidden"></div>
		</div>
		<div style="height:100%" class="tue list-group-item btn-outline-warning">
			<p class="dayHead">Tuesday</p>
			<input type="hidden" class="TuesdayChk" value="0"/>
			<div id="Tuesday-food-total"></div>
			<div id="Tuesday-category-total" hidden="hidden"></div>
		</div>
		<div style="height:100%" class="wed list-group-item btn-outline-primary">
			<p class="dayHead">Wednesday</p>
			<input type="hidden" class="WednesdayChk" value="0"/>
			<div id="Wednesday-food-total"></div>
			<div id="Wednesday-category-total" hidden="hidden"></div>
		</div>
		<div style="height:100%" class="thu list-group-item btn-outline-success">
			<p class="dayHead">Thursday</p>
			<input type="hidden" class="ThursdayChk" value="0"/>
			<div id="Thursday-food-total"></div>
			<div id="Thursday-category-total" hidden="hidden"></div>
		</div>
		<div style="height:100%" class="fri list-group-item btn-outline-info">
			<p class="dayHead">Friday</p>
			<input type="hidden" class="FridayChk" value="0"/>
			<div id="Friday-food-total"></div>
			<div id="Friday-category-total" hidden="hidden"></div>
		</div>
	</div>
</div>

<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/menu.js"></script>
<script src="js/statisticTotal.js"></script>
</body>
</html>