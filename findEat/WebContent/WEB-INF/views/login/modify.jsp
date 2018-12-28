<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- bootstrap label example -->
<link href="https://getbootstrap.com/docs/4.1/examples/floating-labels/floating-labels.css" rel="stylesheet">

</head>
<body class="d-block">

<form class="form-signin" action="modifyPro.do" method="post" onsubmit="return modifyCheck();">
	<input type="hidden" id="mdCheck" value="0"/>
	<input type="hidden" id="bkPw" value="${loginVO.pw}"/>
	<input type="hidden" name="id" value="${loginVO.id}"/>
	<div class="text-center">
		<h1 class="text-center mb-4">FindEat</h1>
		<h5 class="mt-5">개인정보 수정</h5>
		<h5 class="mb-5 font-weight-light">오늘의 점심을 추천해드릴게요!</h5>
	</div>
	<div class="form-label-group">
		<input type="text" class="form-control" id="inputId" value="${loginVO.id}" disabled="disabled"/>
		<label for="inputId">ID</label>
	</div>
	<div class="form-label-group">
		<input type="email" class="form-control" id="inputEmail" name="email" value="${loginVO.email}" placeholder="E-mail" required/>
		<label for="inputEmail">E-mail</label>
	</div>
	<div class="text-center mb-3">
		<input type="button" class="btn-md btn-outline-warning text-center" id="chBtn" value="Change Password"/>
	</div>
	<div class="form-label-group" id="pw1" hidden="hidden">
		<input type="password" class="form-control" id="inputPw" name="pw" value="${loginVO.pw}" required/>
		<label for="inputPw">PASSWORD</label>
	</div>
	<div class="form-label-group" id="pw2" hidden="hidden">
		<input type="password" class="form-control" id="inputPwc" value="${loginVO.pw}" required/>
		<label for="inputPwc">PASSWORD CHECK</label>
	</div>
	<input type="submit" class="btn btn-lg btn-dark btn-block" value="Modify"/>
	<input type="button" class="btn btn-mid btn-danger btn-block" id="deleteBtn" value="Delete Account"/>
	<input type="button" class="btn btn-mid btn-info btn-block" onclick="window.location='/findEat/index.do'" value="Cancel"/>
	
	<p class="my-5 mb-3 text-muted text-center">&copy; 2018 <strong>GlobalIT AM Group 3</strong></p>
</form>

<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/login.js"></script>
</body>
</html>