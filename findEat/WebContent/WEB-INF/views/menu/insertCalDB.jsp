<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body class="d-block">
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>

<c:if test="${!sessionScope.id.equals('admin')}">
	<script type="text/javascript">
		alert("잘못된 접근입니다.");
		window.location = "/findEat/index.do";
	</script>
</c:if>

<c:if test="${sessionScope.id.equals('admin')}">
<div style="width:75%;margin:0 auto;">
	<form action="insertCalDBPro.do" method="get">
		<fieldset>
		<legend>Calendar DB Insert(Temporary)</legend>
			<div class="input-group mb-3">
				<input type="text" id="inputId" name="id" placeholder="ID" required/>
			</div>
			<div class="input-group mb-3">
				<p>Date : <input type="text" id="datepicker"/></p>
				<input type="hidden" id="fyear" name="fyear" value=""/>
				<input type="hidden" id="fmonth" name="fmonth" value=""/>
				<input type="hidden" id="fdate" name="fdate" value=""/>
				<input type="hidden" id="fday" name="fday" value=""/>
				<input type="hidden" id="fweek" name="fweek" value=""/>
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label class="input-group-text" for="inputGroup03">대분류</label>
				</div>
				<select class="custom-select" id="inputGroup03" name="classify">
					<option selected>선택하세요.</option>
					<option value="k">한식</option>
					<option value="j">일식</option>
					<option value="c">중식</option>
					<option value="w">양식</option>
					<option value="f">페스트푸드/분식</option>
					<option value="e">기타</option>
				</select>
			</div>
			<div class="input-group mb-3">
				<select class="custom-select" id="inputGroup04" name="fcode">
					<option selected>선택하세요.</option>
					<c:forEach items="${kGroup}" var="temp">
						<option class="${temp.classify}" value="${temp.fcode}">${temp.fname}</option>
					</c:forEach>
					<c:forEach items="${jGroup}" var="temp">
						<option class="${temp.classify}" value="${temp.fcode}">${temp.fname}</option>
					</c:forEach>
					<c:forEach items="${cGroup}" var="temp">
						<option class="${temp.classify}" value="${temp.fcode}">${temp.fname}</option>
					</c:forEach>
					<c:forEach items="${wGroup}" var="temp">
						<option class="${temp.classify}" value="${temp.fcode}">${temp.fname}</option>
					</c:forEach>
					<c:forEach items="${fGroup}" var="temp">
						<option class="${temp.classify}" value="${temp.fcode}">${temp.fname}</option>
					</c:forEach>
					<c:forEach items="${eGroup}" var="temp">
						<option class="${temp.classify}" value="${temp.fcode}">${temp.fname}</option>
					</c:forEach>
				</select>
				<select class="custom-select" id="inputGroup06" name="fname">
					<option selected>----</option>
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
			<div>
				<input class="btn-info btn-md" type="submit" value="입력하기"/>
				<input class="btn-secondary btn-md" type="button" value="메인으로" onclick="window.location='/findEat/index.do'"/>
			</div>
		</fieldset>
	</form>
	
	<!-- DB data (temporary) / admin setting -->
	<fieldset class="mt-5">
		<legend>Calendar DB Delete(Temporary)</legend>
	<div class="mt-1">
		<div>
			<form action="deleteCalOne.do" method="post" onsubmit="return DelCheck()">
				<select class="custom-select" id="idList" name="id">
				<!-- ID List -->
					<option>----------</option>
					<c:forEach items="${idList}" var="list">
						<option value="${list}">${list}</option>
					</c:forEach>
				</select>
				<!-- Data -->
				<div class="input-group mt-3 mx-0 row">
					<label class="mb-0 col-2 text-right align-bottom" for="datepicker2">Date : </label>
					<input class="py-0 col-10 align-bottom" type="text" id="datepicker2"/>
					<input type="hidden" id="fyearDel" name="fyear" value=""/>
					<input type="hidden" id="fmonthDel" name="fmonth" value=""/>
					<input type="hidden" id="fdateDel" name="fdate" value=""/>
					<input type="hidden" id="fdayDel" name="fday" value=""/>
					<input type="hidden" id="fweekDel" name="fweek" value=""/>
				</div>
				<div class="input-group mt-3 mx-0 row">
					<label class="mb-0 col-2 text-right align-bottom" for="resultFname">Fname : </label>
					<input type="text" class="py-0 col-10 form-control-plaintext align-bottom" id="resultFname" value="" readonly/>
				</div>
				<div class="mt-3">
					<input class="btn-secondary btn-md" type="submit" value="삭제하기"/>
				</div>
			</form>
		</div>
	</div>
	</fieldset>
</div>


</c:if>
<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/menu.js"></script>
<script src="js/calDB.js"></script>
</body>
</html>