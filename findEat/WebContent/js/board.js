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
 * 	modBtn: 수정
 * 	delBtn: 삭제
 */
//modify
$(function(){
	$("#modBtn").click(function(){
		//수정버튼 클릭
	});
});

//delete
$(function(){
	$("#modBtn").click(function(){
		//삭제버튼 클릭
	});
});