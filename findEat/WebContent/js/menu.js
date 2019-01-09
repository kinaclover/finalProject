/**
 * 	menu javascript
 */

//logout button
$(function() {
	$("#logoutBtn").click(function(){
		var result	= confirm("로그아웃 하시겠습니까?");
		if(result) window.location = "logout.do";
	});
});

//notice rolling
$(document).ready(function(){
	var height	= 41;
	var num		= $(".roll").length;
	var max		= height * num;
	var move	= 0;
	function noticeRolling() {
		move	+= height;
		$(".noticeGroup").animate({"top":-move},600,function(){
			if(move >= max){
				$(this).css("top",0);
				move = 0;
			}
		});
		
	}
	noticeRollingOff = setInterval(noticeRolling,4000);
	$(".noticeGroup").append($(".noticeItem").first().clone());
});