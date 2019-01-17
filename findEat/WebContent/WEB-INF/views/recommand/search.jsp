<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/search.css" rel="stylesheet">
</head>
<body>
<c:set var="menu" value="${menu }"/>
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>

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
                
                <!-- temporary -->
                <input type="hidden" id="menu" value="${menu}"/>
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


<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/menu.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e8d9b38a8afd2bcec1ece996622e6d39&libraries=services"></script>
<script src="js/search.js"></script>
</body>
</html>