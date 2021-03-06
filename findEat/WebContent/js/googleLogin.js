/**
 *    suggest javascript
 */

        function onSignIn(googleUser) {
            // 구글 사용자 데이터 가져옴
            var profile = googleUser.getBasicProfile();
         
            // The ID token you need to pass to your backend:
            var id_token = googleUser.getAuthResponse().id_token;
            console.log("ID Token: " + id_token);
            
            //자동 로그인 해제
            var auth2 = gapi.auth2.getAuthInstance(); 
            auth2.disconnect(); 
        
            //이메일 앞부분 잘라서 id값으로 활용
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
                                 alert("Error Code(2) : "+error.d);                                    }
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