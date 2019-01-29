// 달력 그리는 스크립트들
// 주, 일 계산을 위한 변수들
// *주의사항* cal.js 는 함수를 불러오는 형식이 많기 때문에 함수 호출에 주의해야함.
/************** draw Calendar **************/
var today = new Date();
var year = today.getFullYear();
var month = today.getMonth();
var day = today.getDay();
var date = null;

month += 1;
 
function dayy(year, month){ // 각 월의 총 일수를 구함
    switch(month){
    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
    	return 31;
    case 4: case 6: case 9: case 11:
    	return 30;
    case 2:
    	if(((year%400)==0||(year%4)==0&&(year%100)!=0)){
    		return 29;
    	}
    	else{
    		return 28;
    	}
    }    
} 
 
function prevmonth(){ //이전 월로 가는 함수
	var ymda = document.getElementById("prev");
    var yg = document.getElementById("Ymd");
 
	month--; //month를 계속 감소시켜준다
	if(month < 1){ // month가 1보다 작아지면
	    month = 12; // month를 12로 만들어줌
	    year -= 1; //year를 1 감소시켜준다
	}
	if(year < 1970){ //1970년 밑으로는 내려가지 않음..
	    alert("기원전");
	    for(var i=1;i<100;i--){
		    window.top.moveTo(i ,i *=-1);
	    }
	}
	var ymda = year + "년" + (month)+"월";
	present();
} 

function nextmonth(){  //다음 월로 가는 함수 
	var ymda = document.getElementById("next");
	var yg = document.getElementById("Ymd");
 
	month++; //month 를 계속 증가시켜줌
	if(month > 12){ //만약 month가 12를 넘어가면
	    month = 1; // month를 1로 만듦
	    year += 1; //year을 1 증가시켜준다
	}
	var ymda = year + "년" + month+"월";
	present(); //present()함수를 호출하여 다시 찍어줌
}

/************** today action ***************/
function todayMonth(){
	year	= today.getFullYear();
	month	= Number(today.getMonth())+Number(1);
	present();
	loadDB(year,month);
}

function present(){ // 달력 출력
	var start = new Date(year, month-1, 1);	// 1월 클릭하면 1월 저장
	var end = new Date(year, month, 1); // 1월 클릭하면 2월 저장
	var ymda = document.getElementById("Ymd");
	var Tab = document.getElementById("tabBody");
	var row = null;
	var cnt = 0;
	
	var ym = year + "년 " + (month)+"월";

	ymda.innerHTML = ym;
	$("#calYear").val(year);
	while(tab.rows.length >1){     //테이블의 행의 길이가 2보다 크면 테이블의 행 제거함.
    	tab.deleteRow(tab.rows.length -1);
	}
	row = Tab.insertRow();
	
	for(var j = 0; j<start.getDay(); j++){ //달력의 시작 일 구함
		cell = row.insertCell();
    	cnt+=1;   	
	}

	for(var i = 0; i<dayy(year, month); i++){ //달력 일수만큼 찍어줌
		cell = row.insertCell();
		cell.innerHTML = "<strong>"+(i+1)+"</strong><br/><br/>&nbsp;";
		cell.setAttribute('class', 'cdate'); // 모든 셀에 cdate 클래스 지정 
		cell.setAttribute('id', i+1);		// cdate 클릭시 id 값 출력
		cell.setAttribute('onclick','modal_action(this)');
		cnt += 1;
		if(cnt%7 ==0){ //cnt가 7이면 행을 늘려줌
	    	row = tab.insertRow();
		}
   	}
	
	for(var k=0; k<7-end.getDay(); k++) { // 나머지 달력 공백을 채워줌
		if(end.getDay() != 0) {
			cell = row.insertCell();
		}
	}
	//오늘 날짜에 강조표시
	var currentYear = today.getFullYear();
	var calYear		= $("#calYear").val();
	var currentDate	= today.getDate();
	var currentMonth= Number(today.getMonth())+Number(1);
	var todayInfo	= "#"+currentDate;
	if(currentYear == calYear){
		if(month==currentMonth) $(todayInfo).addClass('table-success');
	}
}
/************** draw Calendar **************/


/************** modal pop **************/
function modal_action(data) {
		var thisId	= "#"+$(data).attr('id')+" span";
		var menu	= $(thisId).text();
		
		if(menu==""){
			$("#menuModal").modal();
			date = $(data).attr("id"); // db 전달용
	    	// 다른 날짜 클릭시 이전에 선택한 것들 초기화
	    	$('.k').hide();
			$('.j').hide();
			$('.c').hide();
			$('.w').hide();
			$('.f').hide();
			$('.e').hide();
			$('#inputGroup03').val("none").prop('selected', true);
			$('#inputGroup04').val("none").prop('selected', true);
			
			$('#saveBtn').off("click").on('click', function() {
				save();
			});

			$("#addAndSave").on('click',function(){
				addAndSave();
			});
		} else {
			if(confirm("이미 값이 있습니다. 지우고 새로 입력하시겠습니까?")){
				var pStr = $(thisId).attr('value').split(',');
				var tdDate = $(thisId).parent('td').attr('id');
				var selName = pStr[0];
				var selClfiy = pStr[1];
				$.ajax ({
					async: true,
					url: "calFoodDelete.do",
					type: "post",
					contentType: "application/json; charset=UTF-8",
					data : JSON.stringify ({
						"year": year,
						"month": month,
						"date": tdDate,
						"selName": selName,
						"selClfiy": selClfiy
					}),
					success : function(s) {
						console.log(s);
						$(data).parent('span').remove();
					},
					error : function(xhr, status, error) {
			            console.log(JSON.stringify(error));
					}
				});
				//
				$("#menuModal").modal();
				date = $(data).attr("id"); // db 전달용
		    	// 다른 날짜 클릭시 이전에 선택한 것들 초기화
		    	$('.k').hide();
				$('.j').hide();
				$('.c').hide();
				$('.w').hide();
				$('.f').hide();
				$('.e').hide();
				$('#inputGroup03').val("none").prop('selected', true);
				$('#inputGroup04').val("none").prop('selected', true);
				
				$('#saveBtn').off('click').on('click', function() {
					save();
				});
			}
		}
}
/************** modal pop **************/


/************** reload when page start **************/
$(function (){ // 페이지 시작 시 모두 가리고 시작
	$('.k').hide();		  // 옵션 세부(음식 분류 세팅)은 CalendarAction.java // foodAction.java 를 참고함
	$('.j').hide();
	$('.c').hide();
	$('.w').hide();
	$('.f').hide();
	$('.e').hide();

	//select delete section
	$('#inputGroup03').change(function(){
		//class 이름으로 show(), hide()  설정 // 기본으로 전부 hide()설정함 //
		var state = $('#inputGroup03 option:selected').val();
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
	loadDB(year,month); // 새로고침 시 로드
	$('#prev, #next').off("click").on('click', function() { // 달력 넘길 시 로드 // click 들이 연동되서 누적되는 오류를 방지하기 위해 off 해줌
		loadDB(year,month); // 넘겨진 달력의 연,월 전달
	});
});
/************** reload when page start **************/


/************** modal save btn action **************/
function save() {
	 // db 전달 파라미터 // id; fyear; fmonth; fdate; fday; fweek; fname; fcode;
		var cToday = new Date(year,month-1,date); // 클릭한 위치의 날짜
		var cTodays_day = cToday.getDay();
		var week = $.datepicker.iso8601Week(cToday); // week of year // 주 시작 : (월) - 끝 : (일)
		console.log('ymd day: '+year+" "+month+" "+date+" "+cTodays_day);
		
//		var sel_menu_code = $('#inputGroup04 option:selected').val();
		var sel_menu_name = $('#inputGroup04 option:selected').text();
		var sel_menu_classify= $('#inputGroup04 option:selected').attr('class');
		var id = $("#calIdCheck").val();
		
		$.ajax({
			async: true,
	        url : "calFoodInsert.do",
	        type : "post",
	        data : {
	      	  "id": id,
	      	  "fyear": year,
	      	  "fmonth": month,
	      	  "fdate": date,
	      	  "fday": cTodays_day,
	      	  "fweek": week,
	      	  "fname": sel_menu_name,
	      	  "classify": sel_menu_classify
	        },
	        success : function() {
	        	var html_btn = '<button type="button" class="close" onclick="deleteMenu(this)">×</button>';
	        	$('#'+date).html("<strong>"+date+"</strong>"+'<br/><br/>'+'<span class="sel_menu" value="'+sel_menu_name+","+sel_menu_classify+
	        			'">'+sel_menu_name+html_btn+'</span>');
	        	console.log("insert Success!");
	        },
	        error : function(xhr, status, error) {
	            console.log("error ! status : " + status + ", xhr : " + xhr+ ", error : "+ error);
	        }
	  });
};

function addAndSave() {
	// db 전달 파라미터 // id; fyear; fmonth; fdate; fday; fweek; fname;
	var cToday = new Date(year,month-1,date); // 클릭한 위치의 날짜
	var cTodays_day = cToday.getDay();
	var week = $.datepicker.iso8601Week(cToday); // week of year // 주 시작 : (월) - 끝 : (일)
	var sel_menu_name = $('#addFname').val();
	var sel_menu_classify= $('#addGroup01 option:selected').val();
	var id = $("#calIdCheck").val();
	$.ajax({
		async: true,
        url : "calFoodAddAndInsert.do",
        type : "post",
        data : {
      	  "id": id,
      	  "fyear": year,
      	  "fmonth": month,
      	  "fdate": date,
      	  "fday": cTodays_day,
      	  "fweek": week,
      	  "fname": sel_menu_name,
      	  "classify": sel_menu_classify
        },
        success : function() {
        	var html_btn = '<button type="button" class="close" onclick="deleteMenu(this)">×</button>';
        	$('#'+date).html("<strong>"+date+"</strong>"+'<br/><br/>'+'<span class="sel_menu" value="'+sel_menu_name+","+sel_menu_classify+
        			'">'+sel_menu_name+html_btn+'</span>');
        },
        error : function(xhr, status, error) {
            console.log("error ! status : " + status + ", xhr : " + xhr+ ", error : "+ error);
        }
	});
}
/************** modal save btn action **************/


/************** menu delete btn action **************/
function deleteMenu(data) {
	event.stopPropagation();
	$("#deleteModal").modal();
	$("#delete_confirm").off("click").on('click',function(d) { 
		var pStr = $(data).parent('span').attr('value').split(',');
		var tdDate = $(data).parent('span').parent('td').attr('id');
		var selName = pStr[0];
		var selClfiy = pStr[1];
		$.ajax ({
			async: true,
			url: "calFoodDelete.do",
			type: "post",
			contentType: "application/json; charset=UTF-8",
			data : JSON.stringify ({
				"year": year,
				"month": month,
				"date": tdDate,
				"selName": selName,
				"selClfiy": selClfiy
			}),
			success : function(s) {
				console.log(s);
				$(data).parent('span').remove();
			},
			error : function(xhr, status, error) {
	            console.log(JSON.stringify(error));
			}
		});
	});
}
/************** menu delete btn action **************/


/************** load all menu of this month **************/
function loadDB(now_year,now_month) {
	$.ajax({ // 시작 시 db 에서 데이터 가져옴 
	  url : "calFoodSelect.do",
	  type: "get",
	  data : { "id" : $("#calIdCheck").val() },
	  dataType: 'json',
	  success : function(data) {
		  // 현재 월의 데이터를 가져옴
		  console.log('now_month : '+now_month);
		  var html_btn = '<button type="button" class="close" onclick="deleteMenu(this)"><span>&times;</span></button>';
	      dataset = JSON.parse(data); // json -> 배열 // 요소 접근을 위해 필요함.
		  for(var i in dataset.CalVOList) {
			  if(dataset.CalVOList[i].fyear == now_year) {
			  	if(dataset.CalVOList[i].fmonth == now_month) { // 해당 달의
			  		for(var k=0; k<32; k++) {
			  			if($('#'+k).attr('id') == dataset.CalVOList[i].fdate) { // 해당 일에 추가
			  				$('#'+k).html("<strong>"+dataset.CalVOList[i].fdate+"</strong>"+'<br/><br/><span class="sel_menu" value="'+dataset.CalVOList[i].fname+
			  						','+dataset.CalVOList[i].classify+'">'+dataset.CalVOList[i].fname+html_btn+'</span>');
			  			}
			  		}
			  	}
			  }
		  };
	  },
	  error : function(xhr, status, error) {
	  	console.log("error ! status : " + status + ", xhr : " + xhr + ", error : "+ error);
	  }
	});
};
/************** load all menu of this month **************/

/************** add foot category action **************/

$(function(){
	$(".close").click(function(){
		$(".collapse").removeClass("show");
		changeSaveBtn();
	});
});

$(function(){
	$("#colAction").click(function(){
		setTimeout(function(){changeSaveBtn()},500);
	});
});

function changeSaveBtn(){
	if($("#addFoodCategory").hasClass("show")){
		$("#saveBtn").attr("hidden",true);
		$("#addAndSave").removeAttr("hidden");
	}else {
		$("#saveBtn").removeAttr("hidden");
		$("#addAndSave").attr("hidden",true);
	}
}

/************** add foot category action **************/
