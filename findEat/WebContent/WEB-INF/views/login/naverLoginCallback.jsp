<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 처리중 </h2>

	<!-- (1) LoginWithNaverId Javscript SDK -->
	<script type="text/javascript" src="js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
	<script src="js/jquery-3.3.1.js"></script>

	<!-- (2) LoginWithNaverId Javscript 설정 정보 및 초기화 -->
	<script>
		var naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "XbLB49KVP66WsUyV0qUz",
				callbackUrl: "http://localhost:8080/findEat/naverLoginCallback.do",
				isPopup: false,
				callbackHandle: true
				/* callback 페이지가 분리되었을 경우에 callback 페이지에서는 callback처리를 해줄수 있도록 설정합니다. */
			}
		);
		console.log(naverLogin);
		
		/* (3) 네아로 로그인 정보를 초기화하기 위하여 init을 호출 */
		naverLogin.init();

		/* (4) Callback의 처리. 정상적으로 Callback 처리가 완료될 경우 main page로 redirect(또는 Popup close) */
		window.addEventListener('load', function () {
			naverLogin.getLoginStatus(function (status) {
				if (status) {
					/* (5) 필수적으로 받아야하는 프로필 정보가 있다면 callback처리 시점에 체크 */
					var uniqId = naverLogin.user.getId(); // 네이버 id 가 아닌 각 id 별 고유값 
					var email = naverLogin.user.getEmail();
					if( email == undefined || email == null || uniqId == undefined || uniqId == null) {
						alert("이메일, 별명, 아이디에 대한 정보제공을 동의해주세요.");
						/* (5-1) 사용자 정보 재동의를 위하여 다시 네아로 동의페이지로 이동함 */
						naverLogin.reprompt();
						return;
					}
					
					$.ajax({
						async: true,
						type: 'POST',
						data: JSON.stringify(uniqId),
						contentType: "application/json; charset=UTF-8",
						url: 'naverIdCheck.do',
						success: function(data) {
							alert("data"+data);
							if($.trim(data) != 0) { // 네이버 아이디 정보가 db 에 있을 때
								alert(email.split('@',1)+" 님 어서오세요!");
								$.ajax ({
									async: true,
									type: 'POST',
									data: {
										"id": uniqId,
										"pw": " "
									},
									url: 'naverLoginPro.do',
									success: function() {
										alert("nvr is in db : success");
									},
									complete: function() {
										
									},
									error: function(request,status,error) {
										alert("Error1 : "+error.d);
										alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
									}
								});
								alert("testest");
							} else {
								if (confirm("아직 가입하지 않은 사용자 입니다. 가입 하시겠습니까?") == true){    //확인
								    $('#idCheck').val(1);
									$.ajax ({	// 네이버 아이디 정보가 db 에 없을때
										async: true,
										type: 'POST',
										data: {
											"id": uniqId,
											"email": email,
											"pw": " "
										},
										url: 'naverJoinPro.do',
										success: function() {
											alert("nvr insert in db : success");
											$.ajax ({
												async: true,
												type: 'POST',
												data: {
													"id": uniqId,
													"pw": " "
												},
												url: 'naverLoginPro.do',
												success: function() {
													alert("nvr is in db (first time) : success");
												},
												error: function(request,status,error) {
													alert("Error2 : "+error.d);												}
											});
										},
										error: function(request,status,error) {
											alert("Error3 : "+error.d);
										}
									});
								}else{   //취소
								    alert("!!!");
									return;
								}
							}
						},
						error: function(request,status,error) {
							alert("Error : "+error.d);
							alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
						}
					});
					//window.location.href="http://localhost:8080/findEat/index.do";
					window.location.replace("http://" + window.location.hostname + ( (location.port==""||location.port==undefined)?"":":" + location.port) + "/findEat/index.do");
					// 보안상 replace 사용 (뒤로가기 안됨)
					
				} else {
					alert("callback 처리에 실패하였습니다.");
				}
			});
		});
	</script>
	
</body>
</html>