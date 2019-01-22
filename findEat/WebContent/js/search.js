/**
/ * search javascript
 */

// 마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new daum.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new daum.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new daum.maps.services.Places();  

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new daum.maps.InfoWindow({zIndex:1});

var keyword=$('input#keywordValue').val();
var address_name1=null,address_name2=null,address_name3=null;
getAddress();

if(keyword!="" && keyword!=null){
if (navigator.geolocation) {
	    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	        var lat = position.coords.latitude; // 위도
	        var lon = position.coords.longitude; // 경도
	        
	        
	        var locPosition = new daum.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
	        
	        // 마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition, message);
	       
	            //좌표 --> 주소명 변환
	        $.ajax({
				type : "GET",
				beforeSend: function(request) {
				    request.setRequestHeader("Authorization", "KakaoAK 6caec61a6ae3ea1078caf3f394ae525b");
				},
				url :  "https://dapi.kakao.com/v2/local/geo/coord2address.json?x="+lon+"&y="+lat+"&input_coord=WGS84",
				dataType : "json",
				contentType : "application/json",
				async:false,
			  	success : function(data){
					
					address_name1=data.documents[0].address.region_1depth_name;
					address_name2=data.documents[0].address.region_2depth_name;
					address_name3=data.documents[0].address.region_3depth_name;
					var option ={ category_group_code : "FD6" };
					var result_keyword=address_name1+" "+address_name2+" "+address_name3+" "+keyword;
					
				    ps.keywordSearch(result_keyword, placesSearchCB, option);
				}
			});
			});
	   
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    
	    var locPosition = new daum.maps.LatLng(33.450701, 126.570667),    
	        message = 'geolocation을 사용할수 없어요..'
	        
	    displayMarker(locPosition, address_name2);
	} 
	
	
}
function getPosition(){
	 var result_keyword=address_name1+" "+address_name2+" "+address_name3;
	 var option ={ category_group_code : "FD6" };
	 ps.keywordSearch(result_keyword, mylocationCallback, option);
	
}

//좌표 -> 시 군 구로 바꿔줌.
function getAddress(){
	
	if (navigator.geolocation) {
	    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	        var lat = position.coords.latitude; // 위도
	        var lon = position.coords.longitude; // 경도
	        
	        
	        var locPosition = new daum.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
	        
	        // 마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition, message);
	       
	            //좌표 --> 주소명 변환
	       	getTrans(lat, lon);
			});
	   
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    
	    var locPosition = new daum.maps.LatLng(33.450701, 126.570667),    
	        message = 'geolocation을 사용할수 없어요..'
	        
	    displayMarker(locPosition, address_name2);
	} 
}
function getTrans(lat, lon){
	 $.ajax({
			type : "GET",
			beforeSend: function(request) {
			    request.setRequestHeader("Authorization", "KakaoAK 6caec61a6ae3ea1078caf3f394ae525b");
			},
			url :  "https://dapi.kakao.com/v2/local/geo/coord2address.json?x="+lon+"&y="+lat+"&input_coord=WGS84",
			dataType : "json",
			contentType : "application/json",
			async:false,
		  	success : function(data){
				
				address_name1=data.documents[0].address.region_1depth_name;
				address_name2=data.documents[0].address.region_2depth_name;
				address_name3=data.documents[0].address.region_3depth_name;
				
			}
		});
}


function displayMarker(locPosition, message) {

    // 마커를 생성합니다
    var marker = new daum.maps.Marker({  
        map: map, 
        position: locPosition
    }); 
    
    var iwContent = message, // 인포윈도우에 표시할 내용
        iwRemoveable = true;

    // 인포윈도우를 생성합니다
    var infowindow = new daum.maps.InfoWindow({
        content : iwContent,
        removable : iwRemoveable
    });
    
    // 인포윈도우를 마커위에 표시합니다 
    infowindow.open(map, marker);
    
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);      
}    



// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {
    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
 	keyword = document.getElementById('keyword').value;
    var result_keyword=address_name1+" "+address_name2+" "+address_name3+" "+keyword;
    
    if(keyword=="" || keyword==null){
    	alert("검색어를 입력해주세요");
    	return;
    }
    
    var option ={ category_group_code : "FD6" };
    ps.keywordSearch(result_keyword, placesSearchCB, option);
    
}
function mylocationCallback(data, status, pagination){
	 if (status === daum.maps.services.Status.OK) {
	    	   
		 post_to_url2(address_name1, address_name2, address_name3,data,pagination);
	        

	    } else if (status === daum.maps.services.Status.ZERO_RESULT) {

	        alert('검색 결과가 존재하지 않습니다.');
	        return;

	    } else if (status === daum.maps.services.Status.ERROR) {

	        alert('검색 결과 중 오류가 발생했습니다.');
	        return;
	       

	    }
	
}
function post_to_url2(address_name1, address_name2, address_name3, params, pagination){
	$.ajax({
		type : "POST",
		url : "/findEat/myPosition.do?address_name1="+address_name1+"&address_name2="+address_name2+"&address_name3="+address_name3,
		dataType: 'json',
		contentType:'application/json',
		data : JSON.stringify(params),
		success : function(data){
			 var listEl = document.getElementById('placesList'), 
			    menuEl = document.getElementById('menu_wrap'),
			    fragment = document.createDocumentFragment(), 
			    bounds = new daum.maps.LatLngBounds(), 
			    listStr = '';
			 removeAllChildNods(listEl);
			 removeMarker();
			var save_imgs=new Array();
			
			for(var i=0; i<data.img.length; i++){
				save_imgs.push(data.img[i]);
			}
			
			for(var i=0; i<params.length; i++){
				makeitemEl(params[i], markers[i], params[i].place_name,params[i].address_name, params[i].phone, params[i].place_url, i, save_imgs[i],bounds,fragment);
			}
			
			// 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
		    listEl.appendChild(fragment);
		    menuEl.scrollTop = 0;

		    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
		    map.setBounds(bounds);		
						
		    displayPagination(pagination);				
		}
	});
	
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
	
    if (status === daum.maps.services.Status.OK) {
    	// 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
	  var id=data.id;
	   
       post_to_url(keyword,data,pagination, id);     
        

    } else if (status === daum.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === daum.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;
       

    }
}

// 검색 결과 목록과 마커를 표출하는 함수입니다

function makeitemEl(places, marker, title, address, phone, url, i, imgs, bounds, fragment){
	// 마커를 생성하고 지도에 표시합니다
    var placePosition = new daum.maps.LatLng(places.y, places.x),
        marker = addMarker(placePosition, i),
        itemEl = getListItem(i, places); // 검색 결과 항목 Element를 생성합니다
		
                
        	
        bounds.extend(placePosition);
        
        event(places,marker, title, address, phone, url,i,imgs, itemEl);
        
        fragment.appendChild(itemEl);

}

function event(places,marker, title, address, phone, url,i,imgs,itemEl){
	 // 마커와 검색결과 항목에 mouseover 했을때
    // 해당 장소에 인포윈도우에 장소명을 표시합니다
    // mouseout 했을 때는 인포윈도우를 닫습니다
    	
     		
	 
        daum.maps.event.addListener(marker, 'click', function() {
            displayInfowindow(places,marker, title, address, phone, url, i, imgs);
        });

        daum.maps.event.addListener(marker, 'mouseout', function() {
            
        });

        itemEl.onmouseover =  function () {
            displayInfowindow(places,marker, title, address, phone, url, i, imgs);
        };

        itemEl.onmouseout =  function () {
            infowindow.close();
        };
     	

	
}


// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {
	
    var el = document.createElement('li'),
    itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
                '<div class="info">' +
                '   <h5><a href="'+places.place_url+'">' + places.place_name + '</a></h5>';

    if (places.road_address_name) {
        itemStr += '    <span>' + places.road_address_name + '</span>' +
                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
    } else {
        itemStr += '    <span>' +  places.address_name  + '</span>'; 
    }
                 
      itemStr += '  <span class="tel">' + places.phone  + '</span>' +
                '</div>';           
	el.innerHTML = itemStr;
    el.className = 'item';
    
    
    
    return el;
}

//place 데이터 전송

function post_to_url(keyword, params, pagination, id) {
		
		
		$.ajax({
			type : "POST",
			url : "/findEat/searchPro.do?address_name1="+address_name1+"&address_name2="+address_name2+"&address_name3="+address_name3+"&menu="+keyword+"&pageNum="+pagination.current,
			dataType: 'json',
			contentType:'application/json',
			data : JSON.stringify(params),
			success : function(data){
				 var listEl = document.getElementById('placesList'), 
				    menuEl = document.getElementById('menu_wrap'),
				    fragment = document.createDocumentFragment(), 
				    bounds = new daum.maps.LatLngBounds(), 
				    listStr = '';
				 removeAllChildNods(listEl);
				 removeMarker();
				var save_imgs=new Array();
				
				for(var i=0; i<data.img.length; i++){
					save_imgs.push(data.img[i]);
				}
				
				for(var i=0; i<params.length; i++){
					makeitemEl(params[i], markers[i], params[i].place_name,params[i].address_name, params[i].phone, params[i].place_url, i, save_imgs[i],bounds,fragment);
				}
				
				// 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
			    listEl.appendChild(fragment);
			    menuEl.scrollTop = 0;

			    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
			    map.setBounds(bounds);		
							
			    displayPagination(pagination);				
			}
		});
}


// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx) {
    var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new daum.maps.Size(36, 37),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new daum.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin : new daum.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new daum.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new daum.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
    var paginationEl = document.getElementById('pagination'),
        fragment = document.createDocumentFragment(),
        i; 

    // 기존에 추가된 페이지번호를 삭제합니다
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild (paginationEl.lastChild);
    }

    for (i=1; i<=pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i===pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function(i) {
                return function() {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(places,marker, title, address, phone, url, i,img) {
	
    var content =
    	'<div class="wrap">' + 
        '    <div class="info">' + 
        '        <div class="title">' +title+ 
        '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
        '        </div>' + 
        '        <div class="body">' + 
        '            <div class="img">' +	
        '				<img class="max-small" src="http://'+img+'"/>'+
        '           </div>' + 
        '            <div class="desc">' + 
        '                <div class="ellipsis">'+address+'</div>' + 
        '                <div class="jibun ellipsis">'+phone+'</div>' + 
        '                <div><a href="'+url+'" target="_blank" class="link">홈페이지</a></div>' + 
        '            </div>' + 
        '        </div>' + 
        '    </div>' +    
        '</div>';
      	
   
    infowindow.setContent(content);
    infowindow.open(map, marker);
    
    
}


 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {   
    while (el.hasChildNodes()) {
        el.removeChild (el.lastChild);
    }
}

function closeOverlay() {
	
	infowindow.close();   
}
