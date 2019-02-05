 /*
  *  kakao login javascript
  */ 	
// 사용할 앱의 JavaScript 키를 설정.
Kakao.init('e8d9b38a8afd2bcec1ece996622e6d39');

//AJAX를 이용하여 유효성 검사이후 로그인을 하는 과정의 코드입니다.

//custom button login - start
function loginWithKakao(){
	Kakao.Auth.login({
		success: function(authObj) {
			// 로그인 성공시, API를 호출합니다.
			console.log("access_token : "+authObj.access_token);
			
		    Kakao.API.request({
		      url: '/v2/user/me',
		      success: function(res) {
		    	  console.log(JSON.stringify(res));
		    	 //이메일 데이터를 가져와 아이디를 분리합니다.       	
		    	 var email= res.kakao_account.email;
		         var emailHead = email.split('@',1);
		       	emailHead = JSON.stringify(emailHead).replace(/"/g, "");
		 		emailHead = emailHead.replace(/[[\]]/g,'');
		 		$.ajax({
		 			//데이터베이스에 아이디를 체크, 0 = 가입이 안된 상태,0!= 가입된 상태 입니다.
		 			async: true,
		 			type: 'POST',
		 			data: JSON.stringify(emailHead),
		 			contentType: "application/json; charset=UTF-8",
		 			url: 'kakaoIdCheck.do',
		 			success: function(data) {
		 				console.log(data)
		 				if($.trim(data) != 0) { 
							alert(emailHead+" 님 어서오세요!");
							//아이디를 넘겨 자동으로 로그인을 시킵니다.
							$.ajax ({
								async: true,
								type: 'POST',
								data: {
									"id": emailHead,
									"pw": " "
								},
								url: 'kakaoLoginPro.do',
								success: function(data) {
									window.location="/findEat/index.do";
									
								},
								error: function(request,status,error) {
									alert("Error Code(1) : "+error.d);
									alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
								}
							});
						} else {
							//가입이 안된상태 
							if (confirm("아직 가입하지 않은 사용자 입니다. 가입 하시겠습니까?") == true){    //확인
							    $('#idCheck').val(1);
							    //아이다와 이메일, 비밀번호(공백으로정함)을 넘겨 자동으로 가입이 됩니다.
								$.ajax ({	
									async: true,
									type: 'POST',
									data: {
										"id": emailHead,
										"email": email,
										"pw": " "
									},
									url: 'kakaoJoinPro.do',
									success: function(data) {
										//가입을 한뒤 자동 로그인이 됩니다.
										$.ajax ({
											async: true,
											type: 'POST',
											data: {
												"id": emailHead,
												"pw": " ",
												
											},
											url: 'kakaoLoginPro.do',
											success: function(data) {
												alert(emailHead+" 님 어서오세요!");
												window.location="/findEat/index.do"; //로그인이 된후 index페이지로 이동합니다. 
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
							    alert("error!");
							    window.location="/findEat/login.do";
							}
						}
		 				
		 			},
		 			error: function(request,status,error) {
						alert("Error Code(4) : "+error.d);
						alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    			}
		     			
		             });
		           
		            
		          },
		          fail: function(error) {
		            alert(JSON.stringify(error));
		          }
		        });
		      },
		      fail: function(err) {
		        alert(JSON.stringify(err));
		      }
      });
}

//custom button login - end
