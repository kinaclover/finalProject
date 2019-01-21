/**
 * 	login javascript
 */

//join password check
function pwCheck() {
	var pw1		= document.getElementById("inputPw");
	var pw2		= document.getElementById("inputPwc");
	var idck	= document.getElementById("idCheck").value;	//confirm 'id check' action
	if(idck!=0){
		if(pw1.value==pw2.value) return true;
		else {
			alert("비밀번호가 일치하지 않습니다. 다시한번 입력해주세요.");
			pw2.focus();
			return false;
		}
	} else {
		alert("ID Check를 실행해주세요.");
		document.getElementById("inputId").focus();
		return false;
	}
}

//modify password check
function modifyCheck() {
	var mdCheck	= document.getElementById("mdCheck").value;	//check password status
	var pw1		= document.getElementById("inputPw");
	var pw2		= document.getElementById("inputPwc");
	if(mdCheck!=0) {
		if(pw1.value==pw2.value) return true;
		else {
			alert("비밀번호가 일치하지 않습니다. 다시한번 입력해주세요.");
			pw2.focus();
			return false;
		}
	} else {
		return true;
	}
}
//ID duplication check
$(function() {
	$("#idck").click(function(){
		var id = $('#inputId').val();
		if(id=="") {
			alert("아이디를 입력해주세요.");
			$('#inputId').focus();
		}else {
			$.ajax({
				async: true,
				type: 'POST',
				data: JSON.stringify(id),
				contentType: "application/json; charset=UTF-8",
				url: 'idCheck.do',
				success: function(data) {
					if($.trim(data) != 0) {
						alert("사용할 수 없는 아이디입니다.");
						$("#inputId").focus();
					} else {
						alert("사용할 수 있는 아이디입니다.");
						$("#inputEmail").focus();
						$('#idCheck').val(1);
					}
				},
				error: function(request,status,error) {
					alert("Error : "+error.d);
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		}
	});
});

//Password change check
$(function() {
	$("#chBtn").click(function(){
		var mdCheck = $('#mdCheck').val();
		var pw		= $('#bkPw').val();			//backup password
		if(mdCheck==0) {
			$('#pw1').removeAttr("hidden");
			$('#pw2').removeAttr("hidden");
			$('#inputPw').val("");
			$('#inputPwc').val("");
			$('#chBtn').removeClass('btn-outline-warning');
			$('#chBtn').addClass('btn-outline-secondary');
			$('#chBtn').val('Cancel');
			$('#mdCheck').val(1);
		}
		else {
			$('#pw1').attr("hidden",true);
			$('#pw2').attr("hidden",true);
			$('#inputPw').val(pw);
			$('#inputPwc').val(pw);
			$('#chBtn').removeClass('btn-outline-secondary');
			$('#chBtn').addClass('btn-outline-warning');
			$('#chBtn').val('Change Password');
			$('#mdCheck').val(0);
		}
	});
});

//Find Password >> Check Email value
function emailCheck() {
	var id		= document.getElementById("inputId").value;
	var email	= document.getElementById("inputEmail").value;
	var all		= {"id":id,"email":email};
	var result	= false;
	$.ajax({
		async: false,
		type: 'GET',
		data: all,
		url: 'emailCheck.do',
		success: function(data) {
			if($.trim(data)==1) {
				result = true;
			}
		},
		error: function(error) {
			alert("Error : "+error.d);
		}
	});
	if(result) {
		return result;
	} else {
		alert("이메일 주소를 확인해주세요.");
		$('#inputEmail').focus();
		return false;
	}
}

//delete - first action
$(function(){
	$('#deleteBtn').click(function(){
		if(confirm("정말 삭제하시겠습니까?")){
			window.location = "deletePro.do";
		}
	});
});

//delete - final action
$(function(){
	$('#deleteAccount').click(function(){
		var result	= confirm("정말로 삭제하시려는 건가요?");
		if(result) window.location	= "deletePro.do";
	});
});

