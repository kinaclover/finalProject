<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="d-block">
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>

<form action="insertCalDBPro.do" method="get">
		<fieldset>
		<legend>Calendar DB Insert(Temporary)</legend>
			<div class="input-group mb-3">
				<div class="form-group">
					<label for="inputId" class="">ID</label>
					<input type="text" id="inputId" name="id" required/>
				</div>
				<div class="form-group">
					<label for="inputYear" class="">Year</label>
					<input type="text" id="inputYear" name="fyear" required/>
				</div>
				<div class="form-group">
					<label for="inputMonth" class="">Month</label>
					<input type="text" id="inputMonth" name="fmonth" required/>
				</div>
				<div class="form-group">
					<label for="inputDate" class="">Date</label>
					<input type="text" id="inputDate" name="fdate" required/>
				</div>
				<div class="form-group">
					<label for="inputWeek" class="">Week</label>
					<input type="text" id="inputWeek" name="fweek" required/>
				</div>
				<div class="input-group-prepend">
					<label class="input-group-text" for="inputGroup04">요일</label>
				</div>
				<select class="custom-select" id="inputGroup04" name="fday">
					<option selected>선택하세요.</option>
					<option value="1">월요일</option>
					<option value="2">화요일</option>
					<option value="3">수요일</option>
					<option value="4">목요일</option>
					<option value="5">금요일</option>
				</select>
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


<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/menu.js"></script>
</body>
</html>