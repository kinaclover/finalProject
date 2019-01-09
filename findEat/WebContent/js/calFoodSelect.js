$(document).ready(function(){ // 페이지 시작 시 모두 가리고 시작
		$('.k').hide();		  // 옵션 세부(음식 분류 세팅)은 CalendarAction.java // foodAction.java 와 비슷한 부분 있음
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

		$('.cdate').click(function () { // 다른 날짜 클릭시 이전에 선택한 것들 초기화
			$('.k').hide();
			$('.j').hide();
			$('.c').hide();
			$('.w').hide();
			$('.f').hide();
			$('.e').hide();
			$('#inputGroup03').val("none").prop('selected', true);
			$('#inputGroup04').val("none").prop('selected', true);
		});
		
		$('#saveBtn').click(function () { // db 전달 파라미터 // id; fyear; fmonth; fdate; fday; fweek; fname; fcode;
			var cToday = new Date(year,month-1,date); // 클릭한 위치의 날짜
			var cTodays_day = cToday.getDay();
			var week = $.datepicker.iso8601Week(cToday); // week of year // 주 시작 : (월) - 끝 : (일)
			console.log(year+" "+month+" "+date+" "+cTodays_day);
			
			var sel_menu_code = $('#inputGroup04 option:selected').val();
			var sel_menu_name = $('#inputGroup04 option:selected').text();
			var sel_menu_classify= $('#inputGroup04 option:selected').attr('class');
			var id = "admin";
			
			$.ajax({
	              url : "calFoodInsert.do",
	              method : "post",
	  //            async:false, // 전역변수에 값을 넣기 위한 동기 설정
	              data : {
	            	  "id": id,
	            	  "fyear": year,
	            	  "fmonth": month,
	            	  "fdate": date,
	            	  "fday": cTodays_day,
	            	  "fweek": week,
	            	  "fname": sel_menu_name,
	            	  "fcode": sel_menu_code,
	            	  "classify": sel_menu_classify
	              },
	  //            dataType : 'json',
	              success : function() {//data) {
	                    console.log("insert Success!");
	  //                  console.log("json test : " + data);
	              },
	              complete : function() {
	  //                  console.log('not success but complete');
	              },
	              error : function(xhr, status, error) {
	                    console.log("error ! status : " + status + ", xhr : " + xhr + ", error : "+ error);
	              }
	        });
		});

});