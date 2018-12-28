/**
 * 	- restaurant insert/delete - 
 */

//page start
$(document).ready(function(){
	var check = $('#insertCheck').val();
	if(check==0) {
		$('#insertRestaurant').removeAttr('hidden');
		$('#deleteRestaurant').attr('hidden',true);
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

//Restaurant insert view
$(function(){
	$('#insertBtn').click(function(){
		var check	= $('#deleteCheck').val();
		if(check==1) {
			$('#insertRestaurant').removeAttr('hidden');
			$('#deleteRestaurant').attr('hidden',true);
			$('#insertBtn').removeClass('btn-light');
			$('#insertBtn').addClass('btn-dark');
			$('#deleteBtn').removeClass('btn-dark');
			$('#deleteBtn').addClass('btn-light');
			$('#insertCheck').val(1);
			$('#deleteCheck').val(0);
		}
	});
});

//Restaurant delete view
$(function(){
	$('#deleteBtn').click(function(){
		var check	= $('#insertCheck').val();
		if(check==1) {
			$('#deleteRestaurant').removeAttr('hidden');
			$('#insertRestaurant').attr('hidden',true);
			$('#deleteBtn').removeClass('btn-light');
			$('#deleteBtn').addClass('btn-dark');
			$('#insertBtn').removeClass('btn-dark');
			$('#insertBtn').addClass('btn-light');
			$('#deleteCheck').val(1);
			$('#insertCheck').val(0);
		}
	});
});

//select section
$('#inputGroup01').change(function(){
	//class 이름으로 show(), hide()  설정 // 기본으로 전부 hide()설정함 //
	var state	= $('#inputGroup01 option:selected').val();
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
