/**
 * 	suggest javascript
 */

$(document).ready(function(){

	$('#personalclas').attr('hidden',true);
	var check	= document.getElementById('sessionCheck').value;
	
	if(check == 1){
		$('#totalclas').attr('hidden',true);
		$('#personalclas').removeAttr('hidden');
	}
	
});

$(function(){
	$('#totalBtn').click(function(){
		var check	= $('#totalCheck').val();
		if(check == 0){
		$('#totalclas').removeAttr('hidden');
		$('#personalclas').attr('hidden',true);
		$('#totalclas').val(1);
		$('#personalclas').val(0);
		}
	});
});

$(function(){
	$('#personalBtn').click(function(){
		var check	= $('#personalCheck').val();
		if(check == 0){
		$('#personalclas').removeAttr('hidden');
		$('#totalclas').attr('hidden',true);
		$('#personalclas').val(1);
		$('#totalclas').val(0);
		}
		
	});
});