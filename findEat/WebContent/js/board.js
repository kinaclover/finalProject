/*
 * 	Board javascript
 *	- 로그인 확인
 *	- 수정 버튼 동작
 */

//글 작성 로그인 유도
$(function(){
	$("#writeCheck").click(function(){
		var chkId	= $("#checkId").val();
		if(chkId==""){
			alert("로그인이 필요합니다.");
			if(confirm("로그인 하시겠습니까?")){
				window.location	= "/findEat/login.do";
			}
		}else {
			window.location	= "/findEat/insert.do";
		}
	});
});

//수정버튼 액션
//상황에 맞게 취소버튼 표시/숨김
$(function(){
	$("#chkBtn").click(function(){
		var chkNum = $("#chkNum").val();
		if(chkNum==0){		//클릭한 버튼을 취소버튼으로 수정
			$("#chkBtn").val("취소");
			$("#chkBtn").removeClass("btn-outline-warning");
			$("#chkBtn").addClass("btn-outline-info");
			$("#chkNum").val(1);
			$("#inputPw").focus();
		}else {				//클릭한 버튼을 수정버튼으로 수정
			$("#chkBtn").val("수정");
			$("#chkBtn").removeClass("btn-outline-info");
			$("#chkBtn").addClass("btn-outline-warning");
			$("#chkNum").val(0);
		}
	});
});

//글 삭제 확인
$(function(){
	$("#articleDelBtn").click(function(){
		if(confirm("정말 삭제하시겠습니까?")){
			var idx = $("#idx").val();
			window.location = '/findEat/deleteArticle.do?idx='+idx;
		}
	});
});


//글 수정 비밀번호 확인
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
					$("#radio1").removeAttr("disabled");
					$("#radio2").removeAttr("disabled");
					$("#modiBox").attr("hidden",true);
					$("#modifyDiv").attr("hidden",true);
					$("#chkBtn").val("수정");
					$("#chkNum").val(0);
					$("#inputPw").val("")
					//
					$("#collapsePw").removeClass("show");
					$("#showCont").attr("hidden",true);
					$("#modiCont").removeAttr("hidden");
					$("#modifyCancel").removeAttr("hidden");
					$("#chkBtn").attr("hidden",true);
					$("#chkBtn").removeClass("btn-outline-info");
					$("#chkBtn").addClass("btn-outline-warning");
					$("#confirmBtn").removeAttr("hidden");
					$("#modiArea").focus();
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

//수정 취소버튼
$(function(){
	$("#modifyCancel").click(function(){
		$("#radio1").attr("disabled",true);
		$("#radio2").attr("disabled",true);
		$("#showCont").removeAttr("hidden");
		$("#modiCont").attr("hidden",true);
		$("#modifyCancel").attr("hidden",true);
		$("#chkBtn").removeAttr("hidden");
		$("#confirmBtn").attr("hidden",true);
	});
});


/*
 * - comment action
 * 	modBtn: 수정 / 0
 * 	delBtn: 삭제 / 1
 */
//댓글 작성
$(function(){
	$("#confComm").click(function(){
		//댓글 입력
		var id = $("#sessionId").val();
		if(id==""){
			alert("로그인이 필요합니다.");
			window.location = '/findEat/login.do';
		}else {
			var comm	= $("#inputComment").val();		//댓글의 내용
			var idx		= $("#idx").val();				//해당 댓글이 달린 글의 idx
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

//댓글 수정 전작업 - 비밀번호 확인
$(function(){
	$(".modBtn").click(function(){
		//수정버튼 클릭
		var num			= $(event.target).val();
		var modBtn		= ".modBtn-"+num;
		var modBtn2		= ".modBtn2-"+num;
		var modiComm	= ".comm-"+num;
		var chkClass	= ".modiCheck-"+num;
		var chk			= $(chkClass).val();
		if(chk==0){											//수정 확인되면 해당 버튼을 취소로 바꾸고 댓글 내용의 readonly 제거
			$(modiComm).removeAttr("readonly");
			$(modiComm).focus();
			$(modBtn2).removeAttr("hidden");
			$(modBtn).html('취소');
			$(modBtn).removeClass("btn-outline-warning");
			$(modBtn).addClass("btn-outline-secondary");
			$(chkClass).val('1');
			
		} else {
			$(modiComm).attr("readonly",true);
			$(modBtn2).attr("hidden",true);
			$(modBtn).html('수정');
			$(modBtn).removeClass("btn-outline-secondary");
			$(modBtn).addClass("btn-outline-warning");
			$(chkClass).val('0');
		}
	});
});
//댓글 수정
$(function(){
	$(".modBtn2").click(function(){
		var num			= $(event.target).val();	//선택한 댓글의 num
		var modiComm	= ".comm-"+num;
		var comm		= $(modiComm).val();		//수정한 내용
		$.ajax({
			async: true,
			type: 'POST',
			data: JSON.stringify({"comm":comm,"num":num}),
			contentType: "application/json; charset=UTF-8",
			url: 'modifyComm.do',
			success: function(data){
				alert("댓글을 수정했습니다.");
				$("#commentsDiv").load(location.reload());
			},
			error: function(request,status,error) {
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	});
});


//댓글 삭제
$(function(){
	$(".delBtn").click(function(){
		//삭제버튼 클릭
		if(confirm("정말 삭제하시겠습니까?")){
			var num	= $(event.target).val();	//선택한 댓글의 num
			var idx	= $("#idx").val();			//현재 댓글이 있는 글의 idx
			$.ajax({
				async: true,
				type: 'POST',
				data: JSON.stringify({'num':num,'idx':idx}),
				contentType: "application/json; charset=UTF-8",
				url: 'deleteComm.do',
				success: function(data){
					if($.trim(data)==1) {
						alert("댓글을 삭제했습니다.");
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