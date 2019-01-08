/**
 * 	- for board
 */


//show/hide article modify button
$(function(){
	$("#chkBtn").click(function(){
		var chkNum = $("#chkNum").val();
		if(chkNum==0){
			$("#modifyDiv").removeAttr("hidden");
			$("#chkBtn").val("취소");
			$("#chkNum").val(1);
			$("#inputPw").focus();
		}else {
			$("#modifyDiv").attr("hidden",true);
			$("#chkBtn").val("수정");
			$("#chkNum").val(0);
		}
	});
});

//delete article
$(function(){
	$("#articleDelBtn").click(function(){
		if(confirm("정말 삭제하시겠습니까?")){
			var idx = $("#idx").val();
			window.location = '/findEat/deleteArticle.do?idx='+idx;
		}
	});
});


//password Check
$(function(){
	$("#modifyBtn").click(function(){
		var idx		= $("#idx").val();
		var pw		= $("#inputPw").val();
		$.ajax({
			async: true,
			type: 'POST',
			data: JSON.stringify({'idx':idx,'pw':pw}),
			contentType: "application/json; charset=UTF-8",
			url: 'articleCheck.do',
			success: function(data) {
				if($.trim(data)!=0) {
					$("#modifySub").removeAttr("hidden");
					$("#inputSubject").removeAttr("readonly");
					$("#inputContent").removeAttr("readonly");
					$("#modiBox").attr("hidden",true);
					$("#modifyDiv").attr("hidden",true);
					$("#chkBtn").val("수정");
					$("#chkNum").val(0);
					$("#inputPw").val("")
					$("#inputContent").focus();
				} else {
					alert("비밀번호를 확인해주세요.");
				}
			},
			error: function(request,status,error) {
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	});
});
//modify cancel
$(function(){
	$("#modifyCancel").click(function(){
		$("#modiBox").removeAttr("hidden");
		$("#modifySub").attr("hidden",true);
		$("#inputSubject").attr("readonly",true);
		$("#inputContent").attr("readonly",true);
	});
});


/*
 * - comment action
 * 	modBtn: 수정 / 0
 * 	delBtn: 삭제 / 1
 */
//insert
$(function(){
	$("#confComm").click(function(){
		//댓글 입력
		var id = $("#sessionId").val();
		if(id==""){
			alert("로그인이 필요합니다.");
			window.location = '/findEat/login.do';
		}else {
			var comm	= $("#inputComment").val();
			var idx		= $("#idx").val();
			$.ajax({
				async: true,
				type: 'POST',
				data: JSON.stringify({'idx':idx,'id':id,'content':comm}),
				contentType: "application/json; charset=UTF-8",
				url: 'insertComm.do',
				success: function(data){
					if($.trim(data)==1) {
						alert("댓글을 입력하였습니다.");
						$("#commentsDiv").load(location.reload());
					}else {
						alert("오류가 발생했습니다. 다시 시도해주세요.");
					}
				},
				error: function(request,status,error) {
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		}
	});
});

//modify
$(function(){
	$("#modBtn").click(function(){
		//수정버튼 클릭
	});
});

//delete
$(function(){
	$("#delBtn").click(function(){
		if(confirm("정말 삭제하시겠습니까?")){
			var num	= $("#commNum").val();
			$.ajax({
				async: true,
				type: 'POST',
				data: JSON.stringify(num),
				contentType: "application/json; charset=UTF-8",
				url: 'deleteComm.do',
				success: function(data){
					if($.trim(data)==1) {
						alert("댓글을 삭제했습니다.");
						$("#commentsDiv").load(location.reload());
					}else {
						alert("오류가 발생했습니다. 다시 시도해주세요.");
					}
				}
			});
		}
	});
});