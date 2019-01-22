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
	<input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in"/>
	<button class="btn btn-mid btn-info btn-block" onclick="window.location='/findEat/join.do'">Sign Up</button>
	
	<div id="naverIdLogin"></div>  <!-- 버튼이 들어갈 위치 선언. ID는 반드시 지정된 값으로 설정하여야 합니다.-->
	
	<script type="text/javascript">
	var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "XbLB49KVP66WsUyV0qUz",
			callbackUrl: "http://localhost:8080/findEat/naverLoginCallback.do",
			isPopup: false, /* 팝업을 통한 연동처리 여부 */
			loginButton: {color: "green", type: 3, height: 40} /* 로그인 버튼의 타입을 지정 */
		}
	);	
   /* 설정정보를 초기화하고 연동을 준비 */
	naverLogin.init();
</script>
 <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark">dfd</div>
    <script>
        function onSignIn(googleUser) {
            // Useful data for your client-side scripts:
            var profile = googleUser.getBasicProfile();
            console.log("ID: " + profile.getId()); // Don't send this directly to your server!
            console.log('Full Name: ' + profile.getName());
            console.log('Given Name: ' + profile.getGivenName());
            console.log('Family Name: ' + profile.getFamilyName());
            console.log("Image URL: " + profile.getImageUrl());
            console.log("Email: " + profile.getEmail());
			
            // The ID token you need to pass to your backend:
            var id_token = googleUser.getAuthResponse().id_token;
            console.log("ID Token: " + id_token);
        
        
        var email= profile.getEmail();
        var emailHead = email.split('@',1);
		emailHead = JSON.stringify(emailHead).replace(/"/g, "");
		emailHead = emailHead.replace(/[[\]]/g,'');
		
		$.ajax({
			async: true,
			type: 'POST',
			data: JSON.stringify(emailHead),
			contentType: "application/json; charset=UTF-8",
			url: 'googleIdCheck.do',
			success: function(data) {
				if($.trim(data) != 0) { //
					alert(emailHead+" 님 어서오세요!");
					$.ajax ({
						async: true,
						type: 'POST',
						data: {
							"id": emailHead,
							"pw": " "
						},
						url: 'googleLoginPro.do',
						success: function(data) {
							window.location="/findEat/index.do";
						},
						error: function(request,status,error) {
							alert("Error Code(1) : "+error.d);
							alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
						}
					});
				} else {
					if (confirm("아직 가입하지 않은 사용자 입니다. 가입 하시겠습니까?") == true){    //확인
					    $('#idCheck').val(1);
						$.ajax ({	
							async: true,
							type: 'POST',
							data: {
								"id": emailHead,
								"email": email,
								"pw": " "
							},
							url: 'googleJoinPro.do',
							success: function(data) {
								$.ajax ({
									async: true,
									type: 'POST',
									data: {
										"id": emailHead,
										"pw": " "
									},
									url: 'googleLoginPro.do',
									success: function(data) {
										alert(emailHead+" 님 어서오세요!");
										window.location="/findEat/index.do";
									},
									error: function(request,status,error) {
										alert("Error Code(2) : "+error.d);												}
								});
							},
							error: function(request,status,error) {
								alert("Error Code(3) : "+error.d);
							}
						});
					}else{   //취소
					    //alert("error!");
					    window.location="/findEat/login.do";
					}
				}
			},
			error: function(request,status,error) {
				alert("Error Code(4) : "+error.d);
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});					
        };
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
<script src="https://apis.google.com/js/platform.js" async defer></script>
</body>
</html>