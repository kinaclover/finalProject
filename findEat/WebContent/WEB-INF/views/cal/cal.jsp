<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar Page</title>

<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/cal.css">
<!-- calendar -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/cal.js"></script>
<script src="js/jquery-ui.min.js"></script>
</head>
<body>
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>

<input type="hidden" id="calIdCheck" value="${sessionScope.id}"/>

<!-- login Check -->
<c:if test="${sessionScope.id==null}">
	<script type="text/javascript">
		alert("로그인이 필요합니다.");
		window.location = "/findEat/login.do";
	</script>
</c:if>

<c:if test="${sessionScope.id!=null}">
<!-- title -->
<div>
	<h5 class="text-center font-weight-bold">나의 월간 식단표</h5>
</div>
<div id="container" style="width:100%" class="mb-3"> 

    <div id="position" style="width:90%;margin:0 auto">
    
    <!-- 메뉴 바 -->
    <div class="row mt-3 mb-3">
    	<div id="top-menu">
    		<div class="btn-group" role="group" style="width:100%;">
				<div style="margin:0 auto;" class="align-bottom">
        			<button type="button" id="prev" class="btn-custom btn-default btn-outline-info" onclick="prevmonth();">
						<i class="calendar-icon ic-arrow-line-left align-baseline" data-action="move-prev"></i>
       				</button>
        			<button type="button" id="next" class="btn-custom btn-default btn-outline-info btn-sm-custom" onclick="nextmonth();">
        				<i class="calendar-icon ic-arrow-line-right align-baseline" data-action="move-next"></i>
        			</button>
        			<button type="button" id="todayBtn" class="btn-custom btn-default btn-outline-primary btn-sm-custom" onclick="todayMonth();">
        				<i class="calendar-icon align-baseline">T</i>
        			</button>
        			<input type="hidden" id="calYear" value=""/>
        			<label id="Ymd" class="ml-3"></label>
        		</div>
			</div>
		</div>
  	</div>  
	<!-- 메뉴 바 -->

  	<!-- 달력 -->
   	<div class="col-md-12">
       	  <table class="table table-bordered table-hover-cells" id="tab">
       	    <thead class="thead text-center">
				<tr align="center">
           			<th scope="col" style="min-width:120px;max-width:150px">일</th>
           			<th scope="col"  style="min-width:120px;max-width:150px">월</th>
           			<th scope="col"  style="min-width:120px;max-width:150px">화</th>
           			<th scope="col"  style="min-width:120px;max-width:150px">수</th>
           			<th scope="col"  style="min-width:120px;max-width:150px">목</th>
           			<th scope="col"  style="min-width:120px;max-width:150px">금</th>
           			<th scope="col"  style="min-width:120px;max-width:150px">토</th>  
       			</tr>
			</thead>
			<tbody id="tabBody"> <!-- 달력 출력 -->
       			<script>present();</script>
       			<!-- 달력에 음식 정보 출력 -->
			</tbody>
         	</table>
       	</div>
   	</div>  
    <!-- 달력 -->	
    	

    	
    	
    <!-- Modal -->
  	<div class="modal fade" id="menuModal" role="dialog">
    	<input type="hidden" id="modalStat" value="0"/>
    <div class="modal-dialog" style="width:276px;">
    
	<!-- Modal content-->
	<div class="modal-content">
		<h3 class="popover-header">Food Select
		<button type="button" class="close" data-dismiss="modal">×</button>
		</h3>
		<div class="modal-body">
			<!-- 음식 선택창 -->
			<div ><!-- style="width:50%; margin:0 auto" -->
				<fieldset> <!-- 음식 분류 정보는 spring 을 통해서 db 에서 가져오고 메서드로 setting 해줌 -->
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="inputGroup01">대분류</label>
						</div>
						<select class="custom-select" id="inputGroup03" name="classify"> <!-- 선택한 옵션의 value 값을 js 에서 참조해서 아래 그룹의 속성변경 -->
							<option value="none" selected>선택하세요.</option>
							<option value="k">한식</option>
							<option value="j">일식</option>
							<option value="c">중식</option>
							<option value="w">양식</option>
							<option value="f">페스트푸드/분식</option>
							<option value="e">기타</option>
						</select>
					</div>
					<div class="input-group mb-3">
						<select class="custom-select" id="inputGroup04" name="fcode"> <!-- 메서드에서 setting 한 db 음식 분류 정보를 출력하고 위 옵션에 따라 속성을 변경해가며 보여준다 -->
							<option value="none" selected>선택하세요.</option>
							<c:forEach items="${kGroup}" var="temp">
								<option class="${temp.classify}" value="${temp.fname}">${temp.fname}</option>
							</c:forEach>
							<c:forEach items="${jGroup}" var="temp">
								<option class="${temp.classify}" value="${temp.fname}">${temp.fname}</option>
							</c:forEach>
							<c:forEach items="${cGroup}" var="temp">
								<option class="${temp.classify}" value="${temp.fname}">${temp.fname}</option>
							</c:forEach>
							<c:forEach items="${wGroup}" var="temp">
								<option class="${temp.classify}" value="${temp.fname}">${temp.fname}</option>
							</c:forEach>
							<c:forEach items="${fGroup}" var="temp">
								<option class="${temp.classify}" value="${temp.fname}">${temp.fname}</option>
							</c:forEach>
							<c:forEach items="${eGroup}" var="temp">
								<option class="${temp.classify}" value="${temp.fname}">${temp.fname}</option>
							</c:forEach>
						</select>
					</div>
				</fieldset>
			</div>
			<!-- 음식 선택창  -->

			<!-- 음식 추가입력 -->
			<div><!-- style="width:50%; margin:0 auto" -->
				<p class="text-center">
					<a class="btn btn-sm btn-info" id="colAction" data-toggle="collapse" href="#addFoodCategory">찾으시는 음식이 없으신가요?</a>
				</p>
				<div class="collapse" id="addFoodCategory">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="addGroup01">대분류</label>
						</div>
						<select class="custom-select" id="addGroup01" name="classify"> <!-- 선택한 옵션의 value 값을 js 에서 참조해서 아래 그룹의 속성변경 -->
							<option value="none" selected>선택하세요.</option>
							<option value="k">한식</option>
							<option value="j">일식</option>
							<option value="c">중식</option>
							<option value="w">양식</option>
							<option value="f">페스트푸드/분식</option>
							<option value="e">기타</option>
						</select>
					</div>
					<input type="text" name="fname" id="addFname" class="form-control mb-3"/>
				</div>
			</div>
        </div>
        <!-- 음식 추가입력 -->
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal" id="saveBtn"> 저장 </button>
			<button type="button" class="btn btn-default" data-dismiss="modal" id="addAndSave" hidden="hidden">입력 후 저장</button>
			<button type="button" class="btn btn-default" data-dismiss="modal" id="close"> 취소 </button>
		</div>
	</div>
	</div>
	</div>
<!-- Modal -->

<!-- Modal2 --> <!-- 삭제시 팝업되는 모달창 -->
<div class="modal fade" id="deleteModal" role="dialog">
  <div class="modal-dialog"  style="width:276px;">
    <div class="modal-content">
      <h3 class="popover-header">
        <!-- 닫기(x) 버튼 -->
        <button type="button" class="close" data-dismiss="modal">×</button>
      </h3>
      <!-- body -->
      <div class="modal-body" id="delete_contents" >
            정말 삭제하시겠습니까?
      </div>
     <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="delete_confirm">확인</button>
      </div>
    </div>
  </div>
</div>
<!-- Modal2 -->
</div>
</c:if>
	
<!-- for bootstrap/jQuery/Popper -->
<script src="js/bootstrap.bundle.js"></script>
<script src="js/menu.js"></script>
</body>
</html>