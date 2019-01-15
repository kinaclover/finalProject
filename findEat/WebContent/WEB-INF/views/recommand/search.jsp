<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="css/bootstrap.css" rel="stylesheet">
    <style>
   
.max-small {
    width: auto; height: auto;
    max-width: 73px;
    max-height: 71px;
}
.wrap * {padding: 0;margin: 0;}
.wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
.wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
.info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
.info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
.info .close:hover {cursor: pointer;}
.info .body {position: relative;overflow: hidden;}
.info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
.desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
.desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
.info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
.info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
.info .link {color: #5085BB;}    
.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
.map_wrap {position:relative;width:100%;height:900px;}

.bg_white {background:#fff;}
#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
#menu_wrap .option{text-align: center;}
#menu_wrap .option p {margin:10px 0;}  
#menu_wrap .option button {margin-left:5px;}
#placesList li {list-style: none;}
#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
#placesList .item span {display: block;margin-top:4px;}
#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
#placesList .item .info{padding:10px 0 10px 55px;}
#placesList .info .gray {color:#8a8a8a;}
#placesList .info .jibun {padding-left:26px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
#placesList .info .tel {color:#009900;}
#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
#placesList .item .marker_1 {background-position: 0 -10px;}
#placesList .item .marker_2 {background-position: 0 -56px;}
#placesList .item .marker_3 {background-position: 0 -102px}
#placesList .item .marker_4 {background-position: 0 -148px;}
#placesList .item .marker_5 {background-position: 0 -194px;}
#placesList .item .marker_6 {background-position: 0 -240px;}
#placesList .item .marker_7 {background-position: 0 -286px;}
#placesList .item .marker_8 {background-position: 0 -332px;}
#placesList .item .marker_9 {background-position: 0 -378px;}
#placesList .item .marker_10 {background-position: 0 -423px;}
#placesList .item .marker_11 {background-position: 0 -470px;}
#placesList .item .marker_12 {background-position: 0 -516px;}
#placesList .item .marker_13 {background-position: 0 -562px;}
#placesList .item .marker_14 {background-position: 0 -608px;}
#placesList .item .marker_15 {background-position: 0 -654px;}
#pagination {margin:10px auto;text-align: center;}
#pagination a {display:inline-block;margin-right:10px;}
#pagination .on {font-weight: bold; cursor: default; color:#777;}
</style>


</head>
<body>
<c:set var="lk" value="${listkeyword }"/>

<div class="container.fluid">

<div class="row">
   
    <div class="col-sm">
    <div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
</div>
    </div>
    <div class="col-6 col-md-4" style="margin-top:30px;">
    
      <div id="menu_wrap" class="bg_white">
        <div class="option">
            
                <form onsubmit="searchPlaces(); return false;">
                
                <h5 class="mt-5">
                    검색 키워드   </h5>
                    <div class="row">
                    <input class="form-control mr-sm-2" type="text" id="keyword" size="15"  placeholder="Search"> 
                   </div>
                  <div class="row"> 
                    <button class="btn btn-mid btn-info btn-block" type="submit">검색하기</button> 
                </div>
                   
                </form>
                
                 <div class="row"> 
                    <button class="btn btn-mid btn-info btn-block" onClick="getPosition()">내위치 맛집찾기</button> 
                </div>
                
        </div>
       
    </div>

       <hr>
        <ul id="placesList"></ul>
        <div id="pagination"></div>

</div>
    </div>

</div>


<script src="js/bootstrap.js"></script>
<script src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e8d9b38a8afd2bcec1ece996622e6d39&libraries=services"></script>
<script>
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
var address_name=null;
var keyword=null;
var listkeyword='${lk}';
console.log(listkeyword);
if(listkeyword!=""){
	getPosition();
	
}






function getPosition(){
	if(navigator.geolocation) {
	    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	    	var lat = position.coords.latitude; // 위도
	    	var	lon = position.coords.longitude; // 경도
	        
	       var locPosition = new daum.maps.LatLng(lat, lon); // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	       var message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
	      
	       getAddress(lon, lat);
	        
	        // 마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition, message);
	            
	      });
	    
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    
	    var locPosition = new daum.maps.LatLng(33.450701, 126.570667),    
	        message = 'geolocation을 사용할수 없어요..'
	        
	    displayMarker(locPosition, message);
	}
	
}

function getAddress(lon, lat){
	$(document).ready(function(){
   		$.ajax({
   			type : "GET",
   			beforeSend: function(request) {
   			    request.setRequestHeader("Authorization", "KakaoAK 6caec61a6ae3ea1078caf3f394ae525b");
   			},
   			url :  "https://dapi.kakao.com/v2/local/geo/coord2address.json?x="+lon+"&y="+lat+"&input_coord=WGS84",
   			dataType : "json",
   			contentType : "application/json",
   			
   			success : function(data){
   				
   				address_name=data.documents[0].address.region_1depth_name+
   							" "+data.documents[0].address.region_2depth_name+
   							" "+data.documents[0].address.region_3depth_name;
   							
   				if(listkeyword!=null){
   					keyword =address_name+" "+listkeyword;
   					
   					searchGeo(keyword);
   				}
   				
   				
   			}
   			
   			
   		});
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

//내 현재위치 검색
function searchGeo(address_name) {
    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다.
    
    var option ={ category_group_code : "FD6" };
    ps.keywordSearch(address_name, placesSearchCB, option);
    
}


// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {
    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    
	keyword = document.getElementById('keyword').value;
    var option ={ category_group_code : "FD6" };
    ps.keywordSearch(keyword, placesSearchCB, option);
    
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === daum.maps.services.Status.OK) {
    	// 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다

        
       post_to_url(keyword,data,pagination);     
        

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

function post_to_url(keyword, params, pagination) {
		console.log(pagination.current);
		console.log(keyword);
	 	$.ajax({
			type : "POST",
			url : "/findEat/searchPro.do?keyword="+keyword+"&pageNum="+pagination.current,
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
				console.log(data);
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

</script>
</body>
</html>