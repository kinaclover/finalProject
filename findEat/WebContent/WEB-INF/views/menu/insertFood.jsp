<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Foods</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="d-block">
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>

<c:if test="${!sessionScope.id.equals('admin')}">
	<script>
		alert("잘못된 접근입니다.");
		history.back();
	</script>
</c:if>

<c:if test="${sessionScope.id.equals('admin')}">

	<!-- change button -->
	<div class="btn-group" role="group" style="width:100%;">
		<div style="margin:0 auto;">
			<button type="button" id="insertBtn">Insert</button>
			<button type="button" id="deleteBtn">Delete</button>
		</div>
	</div>

	<!-- insert -->
	<input type="hidden" id="insertCheck" value="0"/>
	<div style="width:50%; margin:0 auto" id="insertFood">
	<form action="insertFoodPro.do" method="get">
		<fieldset>
		<legend>Food insert</legend>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label class="input-group-text" for="inputGroup01">대분류</label>
				</div>
				<select class="custom-select" id="inputGroup01" name="classify">
					<option selected>선택하세요.</option>
					<option value="k">한식</option>
					<option value="j">일식</option>
					<option value="c">중식</option>
					<option value="w">양식</option>
					<option value="f">페스트푸드/분식</option>
					<option value="e">기타</option>
				</select>
			</div>
			<div>
				<input class="input-group mb-3" type="number" name="fcode" placeholder="음식번호"/>
			</div>
			<div>
				<input class="input-group mb-3" type="text" name="fname" placeholder="음식이름"/>
			</div>
			<div>
				<input class="btn-secondary btn-md" type="submit" value="입력하기"/>
				<input class="btn-info btn-md" type="button" value="메인으로" onclick="window.location='/findEat/index.do'"/>
			</div>
		</fieldset>
	</form>
	</div>
	
	<!-- delete -->
	<input type="hidden" id="deleteCheck" value="0"/>
	<div style="width:50%; margin:0 auto" id="deleteFood">
	<form action="deleteFoodPro.do" method="get">
		<fieldset>
		<legend>Food delete</legend>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label class="input-group-text" for="inputGroup01">대분류</label>
				</div>
				<select class="custom-select" id="inputGroup03" name="classify">
					<option selected>선택하세요.</option>
					<option value="k">한식</option>
					<option value="j">일식</option>
					<option value="c">중식</option>
					<option value="w">양식</option>
					<option value="f">페스트푸드/분식</option>
					<option value="e">기타</option>
				</select>
			</div>
			<div class="input-group mb-3">
				<select class="custom-select" id="inputGroup04" name="fcode">
					<option selected>선택하세요.</option>
					<c:forEach items="${kGroup}" var="temp">
						<option class="${temp.classify}" value="${temp.fcode}">${temp.fname}</option>
					</c:forEach>
					<c:forEach items="${jGroup}" var="temp">
						<option class="${temp.classify}" value="${temp.fcode}">${temp.fname}</option>
					</c:forEach>
					<c:forEach items="${cGroup}" var="temp">
						<option class="${temp.classify}" value="${temp.fcode}">${temp.fname}</option>
					</c:forEach>
					<c:forEach items="${wGroup}" var="temp">
						<option class="${temp.classify}" value="${temp.fcode}">${temp.fname}</option>
					</c:forEach>
					<c:forEach items="${fGroup}" var="temp">
						<option class="${temp.classify}" value="${temp.fcode}">${temp.fname}</option>
					</c:forEach>
					<c:forEach items="${eGroup}" var="temp">
						<option class="${temp.classify}" value="${temp.fcode}">${temp.fname}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<input class="btn-secondary btn-md" type="submit" value="삭제하기"/>
				<input class="btn-info btn-md" type="button" value="메인으로" onclick="window.location='/findEat/index.do'"/>
			</div>
		</fieldset>
	</form>
	</div>
	
	<div class="mt-5 mb-3" style="width:50%; margin:0 auto">
		<div class="list-group">
			<a class="list-group-item d-flex justify-content-between align-items-center card-header" 
			id="head1" data-toggle="collapse" href="#col1" role="button" aria-expanded="false" aria-controls="col1">
			한식(k)
			<span class="badge badge-info badge-pill">${kTotal}</span>
			</a>
			<div id="col1" class="collapse">
				<p>
					<c:forEach items="${kGroup}" var="temp" varStatus="stat">
						<c:if test="${!stat.last}">${temp.fname}/${temp.fcode},</c:if>
						<c:if test="${stat.last}">${temp.fname}/${temp.fcode}</c:if>
					</c:forEach>
				</p>
			</div>
			<a class="list-group-item d-flex justify-content-between align-items-center card-header" 
			id="head1" data-toggle="collapse" href="#col2" role="button" aria-expanded="false" aria-controls="col2">
			일식(j)
			<span class="badge badge-info badge-pill">${jTotal}</span>
			</a>
			<div id="col2" class="collapse">
				<p>
					<c:forEach items="${jGroup}" var="temp" varStatus="stat">
						<c:if test="${!stat.last}">${temp.fname}/${temp.fcode},</c:if>
						<c:if test="${stat.last}">${temp.fname}/${temp.fcode}</c:if>
					</c:forEach>
				</p>
			</div>
			<a class="list-group-item d-flex justify-content-between align-items-center card-header" 
			id="head1" data-toggle="collapse" href="#col3" role="button" aria-expanded="false" aria-controls="col3">
			중식(c)
			<span class="badge badge-info badge-pill">${cTotal}</span>
			</a>
			<div id="col3" class="collapse">
				<p>
					<c:forEach items="${cGroup}" var="temp" varStatus="stat">
						<c:if test="${!stat.last}">${temp.fname}/${temp.fcode},</c:if>
						<c:if test="${stat.last}">${temp.fname}/${temp.fcode}</c:if>
					</c:forEach>
				</p>
			</div>
			<a class="list-group-item d-flex justify-content-between align-items-center card-header" 
			id="head1" data-toggle="collapse" href="#col4" role="button" aria-expanded="false" aria-controls="col4">
			양식(w)
			<span class="badge badge-info badge-pill">${wTotal}</span>
			</a>
			<div id="col4" class="collapse">
				<p>
					<c:forEach items="${wGroup}" var="temp" varStatus="stat">
						<c:if test="${!stat.last}">${temp.fname}/${temp.fcode},</c:if>
						<c:if test="${stat.last}">${temp.fname}/${temp.fcode}</c:if>
					</c:forEach>
				</p>
			</div>
			<a class="list-group-item d-flex justify-content-between align-items-center card-header" 
			id="head1" data-toggle="collapse" href="#col5" role="button" aria-expanded="false" aria-controls="col5">
			패스트푸드/분식(f)
			<span class="badge badge-info badge-pill">${fTotal}</span>
			</a>
			<div id="col5" class="collapse">
				<p>
					<c:forEach items="${fGroup}" var="temp" varStatus="stat">
						<c:if test="${!stat.last}">${temp.fname}/${temp.fcode},</c:if>
						<c:if test="${stat.last}">${temp.fname}/${temp.fcode}</c:if>
					</c:forEach>
				</p>
			</div>
			<a class="list-group-item d-flex justify-content-between align-items-center card-header" 
			id="head1" data-toggle="collapse" href="#col6" role="button" aria-expanded="false" aria-controls="col6">
			기타(e)
			<span class="badge badge-info badge-pill">${eTotal}</span>
			</a>
			<div id="col6" class="collapse">
				<p>
					<c:forEach items="${eGroup}" var="temp" varStatus="stat">
						<c:if test="${!stat.last}">${temp.fname}/${temp.fcode},</c:if>
						<c:if test="${stat.last}">${temp.fname}/${temp.fcode}</c:if>
					</c:forEach>
				</p>
			</div>
		</div>
	</div>
</c:if>


<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/foodInsert.js"></script>
<script src="js/menu.js"></script>
</body>
</html>