<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="d-block">
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>

<!-- board List -->
<div id="boardList" class="mb-3">
	<table class="table table-hover">
		<thead class="thead-dark">
			<tr>
				<th class="col">#</th>
				<th class="col">Subject</th>
				<th class="col">Writer</th>
				<th class="col">Date</th>
				<th class="col">View</th>
			</tr>
		</thead>
		<tbody>
			<!-- notice -->
			<tr>
				<th class="row">#</th>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<!-- article -->
			<tr>
				<th class="row"></th>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>

<!-- board section -->
<div id="boardSection" class="">

</div>


<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.bundle.js"></script>
</body>
</html>