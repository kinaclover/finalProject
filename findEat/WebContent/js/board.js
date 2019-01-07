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
		var pw = $("#inputPw").val();
		$.ajax({
			async: true,
			type: 'POST',
			data: JSON.stringify(pw),
			contentType: "application/json; charset=UTF-8",
			url: 'articleCheck.do',
			success: function(data) {
				if($.trim(data)!=0) {
					$("#modifySub").removeAttr("hidden");
					$("#inputContent").removeAttr("readonly");
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