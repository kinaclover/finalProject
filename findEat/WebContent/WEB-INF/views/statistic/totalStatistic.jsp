<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식사 통계 페이지</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/statistic.css">
<link rel="stylesheet" href="css/billboard.css">
<script src="js/billboard.pkgd.js"></script>
<script src="js/moment.js"></script>
</head>
<body class="d-block">
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>
<c:if test="${sessionScope.id==null}">
	<script type="text/javascript">
		alert("잘못된 접근입니다.");
		history.back();
	</script>
</c:if>

<c:if test="${sessionScope.id!=null}">
<input type="hidden" id="sessionId" value="${sessionScope.id}"/>
<div>
	<div class="btn-group pl-5">
		<input type="button" class="btn-sm btn-outline-secondary" id="preMonth" value="&larr;"/>
		<input type="button" class="btn-sm btn-outline-secondary" id="nextMonth" value="&rarr;"/>
		<input type="button" class="btn-sm btn-outline-info" id="thisMonth" value=" T "/>
	</div>
	<div class="btn-group pl-3 align-top">
		<input type="hidden" id="btnChk" value="0"/>
		<button type="button" id="totalBtn" class="btn btn-sm btn-dark">Total</button>
		<button type="button" id="userBtn" class="btn btn-sm btn-light">User</button>
	</div>
	<input type="hidden" id="currentYear" value="${currentYear}"/>
	<input type="hidden" id="currentMonth" value="${currentMonth}"/>
	<span class="px-3 align-baseline font-weight-bold">
	<label class="changeYear">${currentYear}</label>년 <label class="changeMonth">${currentMonth}</label>월</span>
</div>
<div id="refreshSection">
	<!-- set list/maps -->
<input type="hidden" id="statisticList" value="${statisticList}"/>

<!-- total statistic -->
<div id="statisticTotal" class="" style="width:100%;margin:0 auto">
	<!-- food -->
	<div>
		<c:forEach items="${foodTotal}" var="food" varStatus="stat">
			<input type="hidden" class="food-total-key-${stat.count}" value="${food.key}"/>
			<input type="hidden" class="food-total-value-${stat.count}" value="${food.value}"/>
		</c:forEach>
		<c:forEach items="${monFoodTotal}" var="food" varStatus="stat">
			<input type="hidden" class="monFood-total-key-${stat.count}" value="${food.key}"/>
			<input type="hidden" class="monFood-total-value-${stat.count}" value="${food.value}"/>
		</c:forEach>
		<c:forEach items="${tueFoodTotal}" var="food" varStatus="stat">
			<input type="hidden" class="tueFood-total-key-${stat.count}" value="${food.key}"/>
			<input type="hidden" class="tueFood-total-value-${stat.count}" value="${food.value}"/>
		</c:forEach>
		<c:forEach items="${wedFoodTotal}" var="food" varStatus="stat">
			<input type="hidden" class="wedFood-total-key-${stat.count}" value="${food.key}"/>
			<input type="hidden" class="wedFood-total-value-${stat.count}" value="${food.value}"/>
		</c:forEach>
		<c:forEach items="${thuFoodTotal}" var="food" varStatus="stat">
			<input type="hidden" class="thuFood-total-key-${stat.count}" value="${food.key}"/>
			<input type="hidden" class="thuFood-total-value-${stat.count}" value="${food.value}"/>
		</c:forEach>
		<c:forEach items="${friFoodTotal}" var="food" varStatus="stat">
			<input type="hidden" class="friFood-total-key-${stat.count}" value="${food.key}"/>
			<input type="hidden" class="friFood-total-value-${stat.count}" value="${food.value}"/>
		</c:forEach>
	</div>
	<!-- category -->
	<div>
		<c:forEach items="${categoryTotal}" var="category" varStatus="stat">
			<input type="hidden" class="category-total-key-${stat.count}" value="${category.key}"/>
			<input type="hidden" class="category-total-value-${stat.count}" value="${category.value}"/>
		</c:forEach>
		<c:forEach items="${monCategoryTotal}" var="category" varStatus="stat">
			<input type="hidden" class="monCategory-total-key-${stat.count}" value="${category.key}"/>
			<input type="hidden" class="monCategory-total-value-${stat.count}" value="${category.value}"/>
		</c:forEach>
		<c:forEach items="${tueCategoryTotal}" var="category" varStatus="stat">
			<input type="hidden" class="tueCategory-total-key-${stat.count}" value="${category.key}"/>
			<input type="hidden" class="tueCategory-total-value-${stat.count}" value="${category.value}"/>
		</c:forEach>
		<c:forEach items="${wedCategoryTotal}" var="category" varStatus="stat">
			<input type="hidden" class="wedCategory-total-key-${stat.count}" value="${category.key}"/>
			<input type="hidden" class="wedCategory-total-value-${stat.count}" value="${category.value}"/>
		</c:forEach>
		<c:forEach items="${thuCategoryTotal}" var="category" varStatus="stat">
			<input type="hidden" class="thuCategory-total-key-${stat.count}" value="${category.key}"/>
			<input type="hidden" class="thuCategory-total-value-${stat.count}" value="${category.value}"/>
		</c:forEach>
		<c:forEach items="${friCategoryTotal}" var="category" varStatus="stat">
			<input type="hidden" class="friCategory-total-key-${stat.count}" value="${category.key}"/>
			<input type="hidden" class="friCategory-total-value-${stat.count}" value="${category.value}"/>
		</c:forEach>
	</div>
	<div style="height:40vh" class="my-3 py-3 pl-5">
		<div class="foodMonth">
			<span class=""><label class="changeMonth">${currentMonth}</label>월 음식 Top 10</span>
			<div class="mx-auto" id="foodMonth-total"></div>
		</div>
		<div class="categoryMonth">
			<span class=""><label class="changeMonth">${currentMonth}</label>월 카테고리 통계</span>
			<div class="mx-auto" id="categoryMonth-total"></div>
		</div>
	</div>
	<div style="width:100%;height:40vh" class="list-group-horizontal text-center">
		<div style="height:40vh;width:19vw;" class="mon list-group-item">
			<p class="dayHead btn-outline-danger">Monday</p>
			<input type="hidden" class="MondayChk" value="0"/>
			<div id="Monday-food-total"></div>
			<div id="Monday-category-total" hidden="hidden"></div>
		</div>
		<div style="height:40vh;width:19vw;" class="tue list-group-item">
			<p class="dayHead btn-outline-warning">Tuesday</p>
			<input type="hidden" class="TuesdayChk" value="0"/>
			<div id="Tuesday-food-total"></div>
			<div id="Tuesday-category-total" hidden="hidden"></div>
		</div>
		<div style="height:40vh;width:19vw;" class="wed list-group-item">
			<p class="dayHead btn-outline-primary">Wednesday</p>
			<input type="hidden" class="WednesdayChk" value="0"/>
			<div id="Wednesday-food-total"></div>
			<div id="Wednesday-category-total" hidden="hidden"></div>
		</div>
		<div style="height:40vh;width:19vw;" class="thu list-group-item">
			<p class="dayHead btn-outline-success">Thursday</p>
			<input type="hidden" class="ThursdayChk" value="0"/>
			<div id="Thursday-food-total"></div>
			<div id="Thursday-category-total" hidden="hidden"></div>
		</div>
		<div style="height:40vh;width:19vw;" class="fri list-group-item">
			<p class="dayHead btn-outline-info">Friday</p>
			<input type="hidden" class="FridayChk" value="0"/>
			<div id="Friday-food-total"></div>
			<div id="Friday-category-total" hidden="hidden"></div>
		</div>
	</div>
</div>

<!-- user statistic -->
<div id="statisticUser" class="" style="width:100%;margin:0 auto" hidden="hidden">
	<!-- food -->
	<div>
		<c:forEach items="${foodUser}" var="food" varStatus="stat">
			<input type="hidden" class="food-user-key-${stat.count}" value="${food.key}"/>
			<input type="hidden" class="food-user-value-${stat.count}" value="${food.value}"/>
		</c:forEach>
		<c:forEach items="${monFoodUser}" var="food" varStatus="stat">
			<input type="hidden" class="monFood-user-key-${stat.count}" value="${food.key}"/>
			<input type="hidden" class="monFood-user-value-${stat.count}" value="${food.value}"/>
		</c:forEach>
		<c:forEach items="${tueFoodUser}" var="food" varStatus="stat">
			<input type="hidden" class="tueFood-user-key-${stat.count}" value="${food.key}"/>
			<input type="hidden" class="tueFood-user-value-${stat.count}" value="${food.value}"/>
		</c:forEach>
		<c:forEach items="${wedFoodUser}" var="food" varStatus="stat">
			<input type="hidden" class="wedFood-user-key-${stat.count}" value="${food.key}"/>
			<input type="hidden" class="wedFood-user-value-${stat.count}" value="${food.value}"/>
		</c:forEach>
		<c:forEach items="${thuFoodUser}" var="food" varStatus="stat">
			<input type="hidden" class="thuFood-user-key-${stat.count}" value="${food.key}"/>
			<input type="hidden" class="thuFood-user-value-${stat.count}" value="${food.value}"/>
		</c:forEach>
		<c:forEach items="${friFoodUser}" var="food" varStatus="stat">
			<input type="hidden" class="friFood-user-key-${stat.count}" value="${food.key}"/>
			<input type="hidden" class="friFood-user-value-${stat.count}" value="${food.value}"/>
		</c:forEach>
	</div>
	<!-- category -->
	<div>
		<c:forEach items="${categoryUser}" var="category" varStatus="stat">
			<input type="hidden" class="category-user-key-${stat.count}" value="${category.key}"/>
			<input type="hidden" class="category-user-value-${stat.count}" value="${category.value}"/>
		</c:forEach>
		<c:forEach items="${monCategoryUser}" var="category" varStatus="stat">
			<input type="hidden" class="monCategory-user-key-${stat.count}" value="${category.key}"/>
			<input type="hidden" class="monCategory-user-value-${stat.count}" value="${category.value}"/>
		</c:forEach>
		<c:forEach items="${tueCategoryUser}" var="category" varStatus="stat">
			<input type="hidden" class="tueCategory-user-key-${stat.count}" value="${category.key}"/>
			<input type="hidden" class="tueCategory-user-value-${stat.count}" value="${category.value}"/>
		</c:forEach>
		<c:forEach items="${wedCategoryUser}" var="category" varStatus="stat">
			<input type="hidden" class="wedCategory-user-key-${stat.count}" value="${category.key}"/>
			<input type="hidden" class="wedCategory-user-value-${stat.count}" value="${category.value}"/>
		</c:forEach>
		<c:forEach items="${thuCategoryUser}" var="category" varStatus="stat">
			<input type="hidden" class="thuCategory-user-key-${stat.count}" value="${category.key}"/>
			<input type="hidden" class="thuCategory-user-value-${stat.count}" value="${category.value}"/>
		</c:forEach>
		<c:forEach items="${friCategoryUser}" var="category" varStatus="stat">
			<input type="hidden" class="friCategory-user-key-${stat.count}" value="${category.key}"/>
			<input type="hidden" class="friCategory-user-value-${stat.count}" value="${category.value}"/>
		</c:forEach>
	</div>
	<div style="height:40vh" class="my-3 py-3 pl-5">
		<div class="foodMonth">
			<span class=""><label class="changeMonth">${currentMonth}</label>월 음식 Top 10</span>
			<div class="mx-auto" id="foodMonth-user"></div>
		</div>
		<div class="categoryMonth">
			<span class=""><label class="changeMonth">${currentMonth}</label>월 카테고리 통계</span>
			<div class="mx-auto" id="categoryMonth-user"></div>
		</div>
	</div>
	<div style="height:40vh" class="list-group-horizontal text-center">
		<div style="height:40vh;width:19vw;" class="mon list-group-item">
			<p class="dayHead btn-outline-danger">Monday</p>
			<input type="hidden" class="MondayChk" value="0"/>
			<div id="Monday-food-user"></div>
			<div id="Monday-category-user" hidden="hidden"></div>
		</div>
		<div style="height:40vh;width:19vw;" class="tue list-group-item">
			<p class="dayHead btn-outline-warning">Tuesday</p>
			<input type="hidden" class="TuesdayChk" value="0"/>
			<div id="Tuesday-food-user"></div>
			<div id="Tuesday-category-user" hidden="hidden"></div>
		</div>
		<div style="height:40vh;width:19vw;" class="wed list-group-item">
			<p class="dayHead btn-outline-primary">Wednesday</p>
			<input type="hidden" class="WednesdayChk" value="0"/>
			<div id="Wednesday-food-user"></div>
			<div id="Wednesday-category-user" hidden="hidden"></div>
		</div>
		<div style="height:40vh;width:19vw;" class="thu list-group-item">
			<p class="dayHead btn-outline-success">Thursday</p>
			<input type="hidden" class="ThursdayChk" value="0"/>
			<div id="Thursday-food-user"></div>
			<div id="Thursday-category-user" hidden="hidden"></div>
		</div>
		<div style="height:40vh;width:19vw;" class="fri list-group-item">
			<p class="dayHead btn-outline-info">Friday</p>
			<input type="hidden" class="FridayChk" value="0"/>
			<div id="Friday-food-user"></div>
			<div id="Friday-category-user" hidden="hidden"></div>
		</div>
	</div>
</div>

</div>
</c:if>
<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/menu.js"></script>
<script src="js/statisticTotal.js"></script>
<script src="js/statisticMenu.js"></script>
</body>
</html>