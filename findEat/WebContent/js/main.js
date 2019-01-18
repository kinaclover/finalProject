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
			$('#userRankList').attr('hidden',true);
			$('#totalRankList').removeAttr('hidden');
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
			$('#totalRankList').attr('hidden',true);
			$('#userRankList').removeAttr('hidden');
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
	$("#dayValue").val(day);
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


//day change for admin
$(function(){
	$("#dayForward").click(function(){
		var day	= Number($("#dayValue").val())+Number(1);
		if(day>5) day = 1;
		$("#dayValue").val(day);
		if(day==1) {
			$('.mon p').html("Monday");
			$('.mon').removeClass("disabled");
			$('.mon li').removeClass("disabled");
			$('.tue p').html("T");
			$('.tue').addClass("disabled");
			$('.tue li').addClass("disabled");
			$('.wed p').html("W");
			$('.wed').addClass("disabled");
			$('.wed li').addClass("disabled");
			$('.thu p').html("T");
			$('.thu').addClass("disabled");
			$('.thu li').addClass("disabled");
			$('.fri p').html("F");
			$('.fri').addClass("disabled");
			$('.fri li').addClass("disabled");
		} else if(day==2) {
			$('.mon p').html("M");
			$('.mon').addClass("disabled");
			$('.mon li').addClass("disabled");
			$('.tue p').html("Tuesday");
			$('.tue').removeClass("disabled");
			$('.tue li').removeClass("disabled");
			$('.wed p').html("W");
			$('.wed').addClass("disabled");
			$('.wed li').addClass("disabled");
			$('.thu p').html("T");
			$('.thu').addClass("disabled");
			$('.thu li').addClass("disabled");
			$('.fri p').html("F");
			$('.fri').addClass("disabled");
			$('.fri li').addClass("disabled");
		} else if(day==3) {
			$('.mon p').html("M");
			$('.mon').addClass("disabled");
			$('.mon li').addClass("disabled");
			$('.tue p').html("T");
			$('.tue').addClass("disabled");
			$('.tue li').addClass("disabled");
			$('.wed p').html("Wednesday");
			$('.wed').removeClass("disabled");
			$('.wed li').removeClass("disabled");
			$('.thu p').html("T");
			$('.thu').addClass("disabled");
			$('.thu li').addClass("disabled");
			$('.fri p').html("F");
			$('.fri').addClass("disabled");
			$('.fri li').addClass("disabled");
		} else if(day==4) {
			$('.mon p').html("M");
			$('.mon').addClass("disabled");
			$('.mon li').addClass("disabled");
			$('.tue p').html("T");
			$('.tue').addClass("disabled");
			$('.tue li').addClass("disabled");
			$('.wed p').html("W");
			$('.wed').addClass("disabled");
			$('.wed li').addClass("disabled");
			$('.thu p').html("Thursday");
			$('.thu').removeClass("disabled");
			$('.thu li').removeClass("disabled");
			$('.fri p').html("F");
			$('.fri').addClass("disabled");
			$('.fri li').addClass("disabled");
		} else if(day==5) {
			$('.mon p').html("M");
			$('.mon').addClass("disabled");
			$('.mon li').addClass("disabled");
			$('.tue p').html("T");
			$('.tue').addClass("disabled");
			$('.tue li').addClass("disabled");
			$('.wed p').html("W");
			$('.wed').addClass("disabled");
			$('.wed li').addClass("disabled");
			$('.thu p').html("T");
			$('.thu').addClass("disabled");
			$('.thu li').addClass("disabled");
			$('.fri p').html("Friday");
			$('.fri').removeClass("disabled");
			$('.fri li').removeClass("disabled");
		}
	});
});
$(function(){
	$("#dayBackward").click(function(){
		var day	= Number($("#dayValue").val())-Number(1);
		if(day<1) day = 5;
		$("#dayValue").val(day);
		if(day==1) {
			$('.mon p').html("Monday");
			$('.mon').removeClass("disabled");
			$('.mon li').removeClass("disabled");
			$('.tue p').html("T");
			$('.tue').addClass("disabled");
			$('.tue li').addClass("disabled");
			$('.wed p').html("W");
			$('.wed').addClass("disabled");
			$('.wed li').addClass("disabled");
			$('.thu p').html("T");
			$('.thu').addClass("disabled");
			$('.thu li').addClass("disabled");
			$('.fri p').html("F");
			$('.fri').addClass("disabled");
			$('.fri li').addClass("disabled");
		} else if(day==2) {
			$('.mon p').html("M");
			$('.mon').addClass("disabled");
			$('.mon li').addClass("disabled");
			$('.tue p').html("Tuesday");
			$('.tue').removeClass("disabled");
			$('.tue li').removeClass("disabled");
			$('.wed p').html("W");
			$('.wed').addClass("disabled");
			$('.wed li').addClass("disabled");
			$('.thu p').html("T");
			$('.thu').addClass("disabled");
			$('.thu li').addClass("disabled");
			$('.fri p').html("F");
			$('.fri').addClass("disabled");
			$('.fri li').addClass("disabled");
		} else if(day==3) {
			$('.mon p').html("M");
			$('.mon').addClass("disabled");
			$('.mon li').addClass("disabled");
			$('.tue p').html("T");
			$('.tue').addClass("disabled");
			$('.tue li').addClass("disabled");
			$('.wed p').html("Wednesday");
			$('.wed').removeClass("disabled");
			$('.wed li').removeClass("disabled");
			$('.thu p').html("T");
			$('.thu').addClass("disabled");
			$('.thu li').addClass("disabled");
			$('.fri p').html("F");
			$('.fri').addClass("disabled");
			$('.fri li').addClass("disabled");
		} else if(day==4) {
			$('.mon p').html("M");
			$('.mon').addClass("disabled");
			$('.mon li').addClass("disabled");
			$('.tue p').html("T");
			$('.tue').addClass("disabled");
			$('.tue li').addClass("disabled");
			$('.wed p').html("W");
			$('.wed').addClass("disabled");
			$('.wed li').addClass("disabled");
			$('.thu p').html("Thursday");
			$('.thu').removeClass("disabled");
			$('.thu li').removeClass("disabled");
			$('.fri p').html("F");
			$('.fri').addClass("disabled");
			$('.fri li').addClass("disabled");
		} else if(day==5) {
			$('.mon p').html("M");
			$('.mon').addClass("disabled");
			$('.mon li').addClass("disabled");
			$('.tue p').html("T");
			$('.tue').addClass("disabled");
			$('.tue li').addClass("disabled");
			$('.wed p').html("W");
			$('.wed').addClass("disabled");
			$('.wed li').addClass("disabled");
			$('.thu p').html("T");
			$('.thu').addClass("disabled");
			$('.thu li').addClass("disabled");
			$('.fri p').html("Friday");
			$('.fri').removeClass("disabled");
			$('.fri li').removeClass("disabled");
		}
	});
});

