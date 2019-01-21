<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- bootstrap label example -->
<link rel="stylesheet" href="css/floating-labels.css">
<!-- login css -->
<link rel="stylesheet" href="css/login.css">
</head>
<body class="d-block">

<div>
	<form class="form-signin" action="findPasswordPro.do" method="post" id="findForm" onsubmit="return emailCheck();">
		<div class="text-center">
			<h3 class="mt-5 mb-3">Find Password Process</h3>
			<p class="mt-3 mb-5">가입시 입력했던 아이디와 이메일 주소를 입력해주세요.</p>
		</div>
		<div class="form-label-group">
			<input type="text" class="form-control" name="id" id="inputId" placeholder="ID" required/>
			<label for="inputId">ID</label>
		</div>
		<div class="form-label-group">
			<input type="email" class="form-control" name="email" id="inputEmail" placeholder="E-mail" required/>
			<label for="inputEmail">E-mail</label>
		</div>
		<input type="submit" class="btn-lg btn-outline-Info btn-block" id="findBtn" value="Find password"/>
		<input type="button" class="btn-md btn-secondary btn-block" onclick="history.back()" value="Cancel"/>
	</form>
</div>

<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/login.js"></script>
</body>
</html>