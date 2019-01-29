/*
 * statistic menu - move month
 */

$("#preMonth").click(function(){
	var currentYear		= $("#currentYear").val();
	var currentMonth	= $("#currentMonth").val();
	var changeYear		= 0;
	var changeMonth		= 0;
	var sessionId		= $("#sessionId").val();
	//현재 년/월을 기준으로 한 달 전
	if(currentMonth==1){
		changeYear	= Number(currentYear) - Number(1);
		changeMonth	= 12;
	}else {
		changeYear	= currentYear;
		changeMonth	= Number(currentMonth) - Number(1);
	}
	$("#currentYear").val(changeYear);
	$("#currentMonth").val(changeMonth);
	$(".changeYear").html(changeYear);
	$(".changeMonth").html(changeMonth);
	window.location = "/findEat/statistic.do?year="+changeYear+"&month="+changeMonth;
	//$("#refreshSection").load("/findEat/statisticGraph.do?year="+changeYear+"&month="+changeMonth);
});

$("#nextMonth").click(function(){
	var currentYear		= $("#currentYear").val();
	var currentMonth	= $("#currentMonth").val();
	var changeYear		= 0;
	var changeMonth		= 0;
	var sessionId		= $("#sessionId").val();
	//현재 년/월을 기준으로 한 달 후
	if(currentMonth==12){
		changeYear	= Number(currentYear) + Number(1);
		changeMonth	= 1
	}else {
		changeYear	= currentYear;
		changeMonth	= Number(currentMonth) + Number(1);
	}
	$("#currentYear").val(changeYear);
	$("#currentMonth").val(changeMonth);
	$(".changeYear").html(changeYear);
	$(".changeMonth").html(changeMonth);
	window.location = "/findEat/statistic.do?year="+changeYear+"&month="+changeMonth;
	//$("#refreshSection").load("/findEat/statisticGraph.do?year="+changeYear+"&month="+changeMonth);
});

$("#thisMonth").click(function(){
	var year	= $("#fixedYear").val();
	var month	= $("#fixedMonth").val();
	window.location = "/findEat/statistic.do?year="+year+"&month="+month;
});