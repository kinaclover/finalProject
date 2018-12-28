<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Restaurant</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="d-block">
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>
<!-- check login -->
<c:if test="">

</c:if>

<c:if test="${true}">
	<!-- change button -->
	<div class="btn-group" role="group" style="width:100%;">
		<div style="margin:0 auto;">
			<button type="button" id="insertBtn">Insert</button>
			<button type="button" id="deleteBtn">Delete</button>
		</div>
	</div>
	<!-- insert Restaurant -->
	<input type="hidden" id="insertCheck" value="0"/>
	<div style="width:60%;margin:0 auto" id="insertRestaurant">
		<form action="" method="get">
			<fieldset>
				<legend>Insert Restaurant</legend>
				<div class="input-group mb-3 ml-0 mr-0 row"> 
					<div class="form-control text-center col-3 list-group-item-secondary">
						<label for="inputGroup01">대분류</label>
					</div>
					<select class="custom-select col-9" id="inputGroup01" name="classify">
						<option selected>선택하세요.</option>
						<option value="k">한식</option>
						<option value="j">일식</option>
						<option value="c">중식</option>
						<option value="w">양식</option>
						<option value="f">페스트푸드/분식</option>
						<option value="e">기타</option>
					</select>
				</div>
				<div class="input-group mb-3 ml-0 mr-0 row">
				<div class="form-control text-center col-3 list-group-item-secondary">
						<label for="inputGroup01">소분류</label>
					</div>
					<select class="custom-select col-9" id="inputGroup02" name="fcode">
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
				<div class="input-group mb-3 ml-0 mr-0 row">
					<div class="form-control text-center col-3 list-group-item-secondary">
						<label>가게이름</label>
					</div>
					<input class="form-control col-9" type="text" name="rname" id="inputName" placeholder=""/>
				</div>
				<div class="input-group mb-3 ml-0 mr-0 row">
					<div class="form-control text-center col-3 list-group-item-secondary">
						<label>주소</label>
					</div>
					<input class="form-control col-9" type="text" name="radd" id="inputName" placeholder=""/>
				</div>
				<div class="input-group mb-3 ml-0 mr-0 row">
					<div class="form-control text-center col-3 list-group-item-secondary">
						<label>전화번호</label>
					</div>
					<input class="form-control col-9" type="text" name="rtel" id="inputName" placeholder=""/>
				</div>
				<div class="input-group mb-3 ml-0 mr-0 row">
					<div class="form-control text-center col-3 list-group-item-secondary">
						<label>이미지링크</label>
					</div>
					<input class="form-control col-9" type="text" name="rimg" id="inputName" placeholder=""/>
				</div>
				<div class="input-group mb-3 ml-0 mr-0 row">
					<div class="form-control text-center col-3 list-group-item-secondary">
						<label>다음리뷰 링크</label>
					</div>
					<input class="form-control col-9" type="text" name="rreview" id="inputName" placeholder=""/>
				</div>
				<div class="input-group mb-3 ml-0 mr-0 row">
					<div class="form-control text-center col list-group-item-secondary">
						<label>위도(latitude)</label>
					</div>
					<input class="form-control col" type="text" name="rlat" id="inputName" placeholder=""/>
					<div class="form-control text-center col list-group-item-secondary">
						<label>경도(longitude)</label>
					</div>
					<input class="form-control col" type="text" name="rlon" id="inputName" placeholder=""/>
				</div>
				<div class="input-group mb-3 ml-0 mr-0 row"> 
					<div class="form-control text-center col-3 list-group-item-secondary">
						<label for="inputGroup01">특별시/도</label>
					</div>
					<select class="custom-select col-9" id="inputRegion" name="rprov">
						<option selected>선택하세요.</option>
						<option value=""></option>
					</select>
				</div>
				<div class="input-group mb-3 ml-0 mr-0 row" id="city"> 
					<div class="form-control text-center col-3 list-group-item-secondary">
						<label for="inputGroup01">시</label>
					</div>
					<select class="custom-select col-9" id="inputRegion" name="rcity">
						<option selected>선택하세요.</option>
						<option value=""></option>
					</select>
				</div>
				<div class="input-group mb-3 ml-0 mr-0 row"> 
					<div class="form-control text-center col-3 list-group-item-secondary">
						<label for="inputGroup01">구</label>
					</div>
					<select class="custom-select col-9" id="inputRegion" name="rdist">
						<option selected>선택하세요.</option>
						<option value=""></option>
					</select>
				</div>
				
				<div class="input-group mb-3 ml-0 mr-0 row"> 
					<div class="form-control text-center col-3 list-group-item-secondary">
						<label for="inputGroup01">동</label>
					</div>
					<select class="custom-select col-9" id="inputRegion" name="rneigh">
						<option selected>선택하세요.</option>
						<option value=""></option>
					</select>
				</div>
			</fieldset>
		</form>
	</div>
	<!-- delete Restaurant -->
	<input type="hidden" id="deleteCheck" value="0"/>
	<div style="width:60%;margin:0 auto" id="deleteRestaurant">
	
	</div>
</c:if>

<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/restaurantInsert.js"></script>
</body>
</html>