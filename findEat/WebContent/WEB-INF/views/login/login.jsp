<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id" content="1038690535673-jifm9rrcjmm9pcb4d6kbelenh7umudr8.apps.googleusercontent.com">

<title>Login Page</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- bootstrap label example -->
<link rel="stylesheet" href="css/floating-labels.css">
<!-- login css -->
<link rel="stylesheet" href="css/login.css">
<!-- naver login js -->
<script type="text/javascript" src="js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>

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
		<div class="btn-group" style="width:100%;">
		<input type="submit" class="btn btn-md btn-primary btn-block" value="Sign in"/>
		<button class="btn btn-md btn-info" onclick="window.location='/findEat/join.do'">Sign Up</button>
		<button class="btn btn-md btn-secondary" onclick="window.location='/findEat/index.do'">Go to Index</button>
	</div>
	<div class="btn-group" style="width:100%;">
		<div id="naverIdLogin" class="btn btn-group-item px-0" style="float:left;width:33%;"></div>  <!-- 버튼이 들어갈 위치 선언. ID는 반드시 지정된 값으로 설정하여야 합니다.-->
		<div class="g-signin2 btn btn-group-item pl-3" 
		data-onsuccess="onSignIn" data-theme="dark" data-height="40px" data-width="104.95px" style="float:left;"></div> <!-- Google login -->
	</div>

	<script type="text/javascript">
		var naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "XbLB49KVP66WsUyV0qUz",
				callbackUrl: "http://localhost:8080/findEat/naverLoginCallback.do",
				isPopup: false, /* 팝업을 통한 연동처리 여부 */
				loginButton: {color: "green", type: 2, height: 40} /* 로그인 버튼의 타입을 지정 */
			}
		);	
		  /* 설정정보를 초기화하고 연동을 준비 */
		naverLogin.init();
	</script>




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
<script src="js/googleLogin.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
</body>
</html>