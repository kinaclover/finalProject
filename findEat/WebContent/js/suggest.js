/**
 * 	suggest javascript
 */

$(function(){

	$('#personalclas').attr('hidden',true);
	var check	= document.getElementById('sessionCheck').value;
	var dtkcheck	= document.getElementById('dpersonalclassifykCheck').value;
	var wtkcheck	= document.getElementById('wpersonalclassifykCheck').value;
	var dtjcheck	= document.getElementById('dpersonalclassifyjCheck').value;
	var wtjcheck	= document.getElementById('wpersonalclassifyjCheck').value;
	var dtccheck	= document.getElementById('dpersonalclassifycCheck').value;
	var wtccheck	= document.getElementById('wpersonalclassifycCheck').value;
	var dtwcheck	= document.getElementById('dpersonalclassifywCheck').value;
	var wtwcheck	= document.getElementById('wpersonalclassifywCheck').value;
	var dtfcheck	= document.getElementById('dpersonalclassifyfCheck').value;
	var wtfcheck	= document.getElementById('wpersonalclassifyfCheck').value;
	var dtecheck	= document.getElementById('dpersonalclassifyeCheck').value;
	var wtecheck	= document.getElementById('wpersonalclassifyeCheck').value;
	console.log("dtkcheck==="+dtkcheck);
	console.log("wtkcheck==="+dtkcheck);
	if(check == 1){
		$('#totalclas').attr('hidden',true);
		$('#personalclas').removeAttr('hidden');
	}
	if(dtkcheck == 0 && wtkcheck == 0){
		$('#ktag').attr('hidden',true);
		
	}
	if(dtjcheck == 0 && wtjcheck == 0){
		$('#jtag').attr('hidden',true);
		
	}
	if(dtccheck == 0 && wtccheck == 0){
		$('#ctag').attr('hidden',true);
		
	}
	if(dtwcheck == 0 && wtwcheck == 0){
		$('#wtag').attr('hidden',true);
		
	}
	if(dtfcheck == 0 && wtfcheck == 0){
		$('#ftag').attr('hidden',true);
		
	}
	if(dtecheck == 0 && wtecheck == 0){
		$('#etag').attr('hidden',true);
		
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