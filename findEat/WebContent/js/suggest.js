/**
 * 	suggest javascript
 */

$(document).ready(function(){

	$('#userRankList').attr('hidden',true);
	var check	= document.getElementById('sessionCheck').value;
	
	if(check == 1){
		$('#totalRankList').attr('hidden',true);
		$('#userRankList').removeAttr('hidden');
	}
	
});