<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Account</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- bootstrap label example -->
<link rel="stylesheet" href="css/floating-labels.css">
</head>
<body class="d-block">

<c:if test="${sessionScope.id==null}">
	<script type="text/javascript">
		alert("잘못된 접근입니다.");
		history.back();
	</script>
</c:if>
<c:if test="${sessionScope.id!=null}">
<div>
	<form class="form-signin" action="deletePro.do" method="post">
		<div class="text-center">
			<h3 class="mt-5 mb-3">Delete Process</h3>
			<p class="mt-3 mb-5">비밀번호를 입력해주세요.</p>
		</div>
		<div class="form-label-group">
			<input type="password" class="form-control" name="pw" id="inputPw" placeholder="PASSWORD" required/>
			<label for="inputPw">PASSWORD</label>
		</div>
		<input type="submit" class="btn-lg btn-outline-danger btn-block" id="deleteAccount" value="Delete Account"/>
		<input type="button" class="btn-md btn-secondary btn-block" onclick="history.back()" value="Cancel"/>
	</form>
</div>
</c:if>
<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/login.js"></script>
</body>
</html>