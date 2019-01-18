<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body class="d-block">
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>

<!-- login Check -->
<c:if test="${sessionScope.id==null}">
<input type="hidden" id="sessionCheck" value="0"/>
</c:if>
<c:if test="${sessionScope.id!=null}">
<input type="hidden" id="sessionCheck" value="1"/>
</c:if>

<!-- change button -->
<div class="btn-group" role="group" style="width:100%;">
	<input type="hidden" id="dayValue" value="0"/>
	<div style="margin:0 auto;">
		<button type="button" id="totalBtn">Total</button>
		<button type="button" id="personalBtn">Personal</button>
		<c:if test="${sessionScope.id.equals('admin') }">
			<button type="button" class="btn btn-sm btn-outline-secondary align-baseline" id="dayBackward"> &laquo;</button>
			<button type="button" class="btn btn-sm btn-outline-secondary align-baseline" id="dayForward"> &raquo;</button>
		</c:if>
	</div>
</div>

<!-- week total/personal -->
<jsp:include page="${request.contextPath}/week.do"></jsp:include>

<!-- modals -->
<jsp:include page="${request.contextPath}/indexModal.do"></jsp:include>

<!-- suggestion -->
<div id="center" class="container">
	<jsp:include page="${request.contextPath}/suggestion.do"></jsp:include>
</div>

<!-- suggestion ver2 -->
<div>
	<jsp:include page="${request.contextPath}/suggestion2.do"></jsp:include>
</div>

<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/main.js"></script>
<script src="js/suggest.js"></script>
<script src="js/menu.js"></script>
</body>
</html>

