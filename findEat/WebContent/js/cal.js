// 달력 
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
 
function present(){ // 달력 출력
	var start = new Date(year, month-1, 1);	// 1월 클릭하면 1월 저장
	var end = new Date(year, month, 1); // 1월 클릭하면 2월 저장
	var ymda = document.getElementById("Ymd");
	var Tab = document.getElementById("tabBody");
	var row = null;
	var cnt = 0;

	var ym = year + "년" + (month)+"월";
    
	ymda.innerHTML = ym;
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
		cell.innerHTML = i+1;
		cell.setAttribute('class', 'cdate'); // 모든 셀에 cdate 클래스 지정 
		cell.setAttribute('id', i+1);		// cdate 클릭시 id 값 출력
		cell.setAttribute('onclick','modal_action()');
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
}

function modal_action() { // modal action
    $(".cdate").click(function(){
    	$("#myModal").modal();
    	date = $(this).attr("id"); // db 전달용
    });
}