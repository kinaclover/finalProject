/**
 * 
 */

//datepicker
$(function(){
	$("#datepicker").datepicker({
		onSelect: function(){
			var data	= $(this).datepicker('getDate');
			var year	= data.getFullYear();
			var month	= data.getMonth();
			var date	= data.getDate();
			var day		= data.getDay();
			var week	= $.datepicker.iso8601Week(new Date(year,month,date));
			$("#fyear").val(year);
			$("#fmonth").val(Number(month)+Number(1));
			$("#fdate").val(date);
			$("#fday").val(day);
			$("#fweek").val(week);
		}
	});
});

$(document).ready(function(){
	$('.k').hide();
	$('.j').hide();
	$('.c').hide();
	$('.w').hide();
	$('.f').hide();
	$('.e').hide();
});

//select food section
$('#inputGroup03').change(function(){
	//class 이름으로 show(), hide()  설정 // 기본으로 전부 hide()설정함 //
	var state	= $('#inputGroup03 option:selected').val();
	if(state == 'k'){
		$('.k').show();
		$('.j').hide();
		$('.c').hide();
		$('.w').hide();
		$('.f').hide();
		$('.e').hide();
	} else if(state == 'j') {
		$('.k').hide();
		$('.j').show();
		$('.c').hide();
		$('.w').hide();
		$('.f').hide();
		$('.e').hide();
	} else if(state == 'c') {
		$('.k').hide();
		$('.j').hide();
		$('.c').show();
		$('.w').hide();
		$('.f').hide();
		$('.e').hide();
	} else if(state == 'w') {
		$('.k').hide();
		$('.j').hide();
		$('.c').hide();
		$('.w').show();
		$('.f').hide();
		$('.e').hide();
	} else if(state == 'f') {
		$('.k').hide();
		$('.j').hide();
		$('.c').hide();
		$('.w').hide();
		$('.f').show();
		$('.e').hide();
	} else if(state == 'e') {
		$('.k').hide();
		$('.j').hide();
		$('.c').hide();
		$('.w').hide();
		$('.f').hide();
		$('.e').show();
	}
});

///////////////////////////
//admin db 관리
$(document).ready(function(){
	$(".totalList").hide();
});
//datepicker - delete
$(function(){
	$("#datepicker2").datepicker({
		onSelect: function(){
			var data	= $(this).datepicker('getDate');
			var year	= data.getFullYear();
			var month	= Number(data.getMonth())+Number(1);
			var date	= data.getDate();
			var id		= $("#idList option:selected").val();
			$("#fyearDel").val(year);
			$("#fmonthDel").val(month);
			$("#fdateDel").val(date);
			$.ajax({
				async: true,
				type: 'POST',
				data: JSON.stringify({"id":id,"fyear":year,"fmonth":month,"fdate":date}),
				contentType: "application/json; charset=UTF-8",
				url: 'checkFname.do',
				success: function(data){
					$("#resultFname").val(data);
				},
				error: function(request,status,error) {
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		}
	});
});

function DelCheck() {
	var fname	= document.getElementById("resultFname").value;
	if(fname=="null") {
		alert("삭제할 값이 없습니다.");
		return false;
	}else {
		return true;
	}
}