 /*
  *  kakao login javascript
  */ 	
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('e8d9b38a8afd2bcec1ece996622e6d39');
      
     // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
    	// 로그인 성공시, API를 호출합니다.
    	console.log("access_token : "+authObj.access_token);
    	
        Kakao.API.request({
          url: '/v2/user/me',
          success: function(res) {
        	        	
        	 var email= res.kakao_account.email;
             var emailHead = email.split('@',1);
           	emailHead = JSON.stringify(emailHead).replace(/"/g, "");
     		emailHead = emailHead.replace(/[[\]]/g,'');
     		$.ajax({
     			async: true,
     			type: 'POST',
     			data: JSON.stringify(emailHead),
     			contentType: "application/json; charset=UTF-8",
     			url: 'kakaoIdCheck.do',
     			success: function(data) {
     				console.log(data)
     				if($.trim(data) != 0) { 
    					alert(emailHead+" 님 어서오세요!");
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
    							url: 'kakaoJoinPro.do',
    							success: function(data) {
    								
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
 