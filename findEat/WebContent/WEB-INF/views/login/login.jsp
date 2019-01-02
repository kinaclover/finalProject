<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- bootstrap label example -->
<link rel="stylesheet" href="css/floating-labels.css">
<!-- login css -->
<link rel="stylesheet" href="css/login.css">
</head>
<body class="d-block">

<c:if test="${sessionScope.id!=null}">
	<script type="text/javascript">
		alert("잘못된 접근입니다.");
		history.back();
	</script>
</c:if>
<c:if test="${sessionScope.id==null}">
<form class="form-signin" action="loginPro.do" method="post">
	<div class="text-center">
		<h1 class="text-center mb-4" id="title" onclick="window.location='/findEat/index.do'">FindEat</h1>
		<h5 class="mt-5">오늘의 점심을 찾으시나요?</h5>
		<h5 class="mb-5 font-weight-normal">로그인하세요!</h5>
	</div>
	<div class="form-label-group">
		<input type="text" class="form-control" id="inputId" name="id" placeholder="ID" required autofocus/>
		<label for="inputId">ID</label>
	</div>
	<div class="form-label-group">
		<input type="password" class="form-control" id="inputPw" name="pw" placeholder="PASSWORD" required/>
		<label for="inputPw">PASSWORD</label>
	</div>
	<input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in"/>
	<button class="btn btn-mid btn-info btn-block" onclick="window.location='/findEat/join.do'">Sign Up</button>
	<p class="my-2 font-italic text-center"> <a class="badge badge-light" href="findPassword.do">Forgot Password?</a> </p>
	
	<p class="my-5 mb-3 text-muted text-center">&copy; 2018 <strong>GlobalIT AM Group 3</strong></p>
</form>
</c:if>
<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/login.js"></script>
</body>
</html>