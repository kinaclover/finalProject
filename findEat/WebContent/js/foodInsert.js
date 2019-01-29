/*
 * 
 *	관리자 전용 음식 관리 페이지 스크립트	
 *	- Food view/insert/delete
 *
 */

$(document).ready(function(){
	var check = $('#insertCheck').val();
	if(check==0) {
		$('#insertFood').removeAttr('hidden');
		$('#deleteFood').attr('hidden',true);
		$('#insertBtn').removeClass('btn-light');
		$('#insertBtn').addClass('btn-dark');
		$('#deleteBtn').removeClass('btn-dark');
		$('#deleteBtn').addClass('btn-light');
		$('#insertCheck').val(1);
		$('#deleteCheck').val(0);
		$('.k').hide();
		$('.j').hide();
		$('.c').hide();
		$('.w').hide();
		$('.f').hide();
		$('.e').hide();
	}
});

//food insert view
$(function(){
	$('#insertBtn').click(function(){
		var check	= $('#deleteCheck').val();
		if(check==1) {
			$('#insertFood').removeAttr('hidden');
			$('#deleteFood').attr('hidden',true);
			$('#insertBtn').removeClass('btn-light');
			$('#insertBtn').addClass('btn-dark');
			$('#deleteBtn').removeClass('btn-dark');
			$('#deleteBtn').addClass('btn-light');
			$('#insertCheck').val(1);
			$('#deleteCheck').val(0);
		}
	});
});

//food delete view
$(function(){
	$('#deleteBtn').click(function(){
		var check	= $('#insertCheck').val();
		if(check==1) {
			$('#deleteFood').removeAttr('hidden');
			$('#insertFood').attr('hidden',true);
			$('#deleteBtn').removeClass('btn-light');
			$('#deleteBtn').addClass('btn-dark');
			$('#insertBtn').removeClass('btn-dark');
			$('#insertBtn').addClass('btn-light');
			$('#deleteCheck').val(1);
			$('#insertCheck').val(0);
		}
	});
});

//select delete section
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
