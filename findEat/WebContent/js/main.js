/**
 * 	main javascript
 */

//total view
$(function(){
	$('#totalBtn').click(function(){
		var check	= $('#beforeCheck').val();
		if(check==0) {
			$('#beforeWeek').removeAttr('hidden');
			$('#thisWeek').attr('hidden',true);
			$('#totalBtn').removeClass('btn-light');
			$('#totalBtn').addClass('btn-dark');
			$('#personalBtn').removeClass('btn-dark');
			$('#personalBtn').addClass('btn-light');
			$('#beforeCheck').val(1);
			$('#thisCheck').val(0);
		}
	});
});

//personal view
$(function(){
	$('#personalBtn').click(function(){
		var check	= $('#thisCheck').val();
		if(check==0) {
			$('#thisWeek').removeAttr('hidden');
			$('#beforeWeek').attr('hidden',true);
			$('#totalBtn').removeClass('btn-dark');
			$('#totalBtn').addClass('btn-light');
			$('#personalBtn').removeClass('btn-light');
			$('#personalBtn').addClass('btn-dark');
			$('#beforeCheck').val(0);
			$('#thisCheck').val(1);
		}
	});
});

/*
 * 	Day number
 * 	- Mon : 1
 * 	- Tue : 2
 *  - Wed : 3
 *  - Thu : 4
 *  - Fri : 5
 */
$(document).ready(function(){
	var date	= new Date();
	var day		= date.getDay();
	var check	= document.getElementById('sessionCheck').value;
	if(check==0) {
		$('#thisWeek').attr("hidden",true);
		$('#totalBtn').addClass('btn-dark');
		$('#personalBtn').addClass('btn-light');
		$('#personalBtn').attr('hidden',true);
		$('#thisCheck').val(0);
		$('#beforeCheck').val(1);
	}else {
		$('#thisWeek').removeAttr('hidden');
		$('#beforeWeek').attr("hidden",true);
		$('#totalBtn').addClass('btn-light');
		$('#personalBtn').addClass('btn-dark');
		$('#personalBtn').removeAttr('hidden');
		$('#thisCheck').val(1);
		$('#beforeCheck').val(0);
	}
	if(day==1) {
		$('.mon p').html("Monday");
		$('.tue').addClass("disabled");
		$('.tue li').addClass("disabled");
		$('.wed').addClass("disabled");
		$('.wed li').addClass("disabled");
		$('.thu').addClass("disabled");
		$('.thu li').addClass("disabled");
		$('.fri').addClass("disabled");
		$('.fri li').addClass("disabled");
	} else if(day==2) {
		$('.mon').addClass("disabled");
		$('.mon li').addClass("disabled");
		$('.tue p').html("Tuesday");
		$('.wed').addClass("disabled");
		$('.wed li').addClass("disabled");
		$('.thu').addClass("disabled");
		$('.thu li').addClass("disabled");
		$('.fri').addClass("disabled");
		$('.fri li').addClass("disabled");
	} else if(day==3) {
		$('.mon').addClass("disabled");
		$('.mon li').addClass("disabled");
		$('.tue').addClass("disabled");
		$('.tue li').addClass("disabled");
		$('.wed p').html("Wednesday")
		$('.thu').addClass("disabled");
		$('.thu li').addClass("disabled");
		$('.fri').addClass("disabled");
		$('.fri li').addClass("disabled");
	} else if(day==4) {
		$('.mon').addClass("disabled");
		$('.mon li').addClass("disabled");
		$('.tue').addClass("disabled");
		$('.tue li').addClass("disabled");
		$('.wed').addClass("disabled");
		$('.wed li').addClass("disabled");
		$('.thu p').html("Thursday")
		$('.fri').addClass("disabled");
		$('.fri li').addClass("disabled");
	} else if(day==5) {
		$('.mon').addClass("disabled");
		$('.mon li').addClass("disabled");
		$('.tue').addClass("disabled");
		$('.tue li').addClass("disabled");
		$('.wed').addClass("disabled");
		$('.wed li').addClass("disabled");
		$('.thu').addClass("disabled");
		$('.thu li').addClass("disabled");
		$('.fri p').html("Friday");
	}
});

