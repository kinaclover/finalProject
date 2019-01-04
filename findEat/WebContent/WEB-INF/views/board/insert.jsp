<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert article</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="d-block">
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>
<!-- login check -->
<c:if test="${sessionScope.id==null}">
	<script type="text/javascript">
		alert("로그인부터 해주세요!");
		window.location = "/findEat/login.do";
	</script>
</c:if>

<c:if test="${sessionScope.id!=null}">
	<div class="mt-5 mb-5">
		<h2 class="text-center font-weight-normal">Insert article</h2>
	</div>
	<div style="width:60%;min-width:600px;margin:0 auto">
		<form class="form" action="insertPro.do" method="post">
			<c:if test="${sessionScope.id.equals('admin')}">
			<div class="form-group row">
				<label for="staticId" class="col-sm-2 text-center form-control-plaintext font-weight-bold">ID</label>
				<input type="text" class="col-sm-4 form-control-plaintext" id="staticId" name="id" value="${sessionScope.id}" readonly/>
				<div class="form-check form-check-inline col-sm-2">
					<input type="radio" class="form-check-input" id="radio1" name="atype" value="notice"/>
					<label class="form-check-label" for="radio1">Notice</label>
				</div>
				<div class="form-check form-check-inline col-sm-2">
					<input type="radio" class="form-check-input" id="radio2" name="atype" value="normal"/>
					<label class="form-check-label" for="radio2">Normal</label>
				</div>
			</div>
			</c:if>
			<c:if test="${!sessionScope.id.equals('admin')}">
			<div class="form-group row">
				<label for="staticId" class="col-sm-2 text-center form-control-plaintext font-weight-bold">ID</label>
				<input type="text" class="col-sm-10 form-control-plaintext" id="staticId" name="id" value="${sessionScope.id}" readonly/>
				<input type="hidden" name="atype" value="normal"/>
			</div>
			</c:if>
			<div class="form-group row">
				<label for="inputSubject" class="col-sm-2 text-center form-control-plaintext font-weight-bold">Subject</label>
				<input type="text" class="col-sm-10" id="inputSubject" name="subject"/>
			</div>
			<div class="form-group row">
				<label for="inputContent" class="col-sm-2 text-center form-control-plaintext font-weight-bold">Content</label>
				<textarea rows="10" cols="" class="col-sm-10" id="inputContent" name="content"></textarea>
			</div>
			<div class="form-group row">
				<label for="inputPw" class="col-sm-2 text-center form-control-plaintext font-weight-bold">Password</label>
				<input type="password" class="col-sm-4" id="inputPw" name="pw"/>
			</div>
			<div class="form-group text-right">
				<input type="submit" class="btn btn-outline-primary" value="글 작성"/>
				<input type="reset" class="btn btn-outline-dark" value="리셋"/>
				<input type="button" class="btn btn-outline-secondary" value="돌아가기" onclick="history.back()"/>
			</div>
		</form>
	</div>
</c:if>

<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/main.js"></script>
</body>
</html>