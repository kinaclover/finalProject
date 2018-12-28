<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">
<style type="text/css">
.centered { display: table; margin-left: auto; margin-right: auto; }

.double {
      width:1700px;
　　      height:600px;
        border-style: double;
        box-sizing : border-box;
      }

</style>
</head>
<body class="d-block">
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>

<!-- login Check -->
<c:if test="${sessionScope.id==null}">
<input type="hidden" id="sessionCheck" value="0"/>
</c:if>
<c:if test="${sessionScope.id!=null}">
<input type="hidden" id="sessionCheck" value="1"/>
</c:if>

<!-- change button -->
<div class="btn-group" role="group" style="width:100%;">
	<div style="margin:0 auto;">
		<button type="button" id="totalBtn">Total</button>
		<button type="button" id="personalBtn">Personal</button>
	</div>
</div>

<!-- before weeks -->
<input type="hidden" id="beforeCheck" value="0"/>
<div class="mt-5 mb-3 list-group-horizontal text-center table-hover" id="beforeWeek">
	<div class="mon list-group-item btn-outline-danger">
		<p>M</p>
		<h6 class="font-weight-light">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<!-- 자주 먹은 음식동안 먹어던 음 -->
			<c:if test="${totalMonList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalMonList}" end="1">
					<li class="list-group-item btn-outline-danger">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음식 -->
			<c:if test="${totalWeekMonList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalWeekMonList}" end="0">
					<li class="list-group-item btn-outline-danger">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	<div class="tue list-group-item btn-outline-warning">
		<p>T</p>
		<h6 class="font-weight-light">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${totalTueList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalTueList}" end="1">
					<li class="list-group-item btn-outline-warning">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음식 -->
			<c:if test="${totalWeekTueList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalWeekTueList}" end="0">
					<li class="list-group-item btn-outline-warning">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	<div class="wed list-group-item btn-outline-primary">
		<p>W</p>
		<h6 class="font-weight-light">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${totalWedList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalWedList}" end="1">
					<li class="list-group-item btn-outline-primary">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음식 -->
			<c:if test="${totalWeekWedList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalWeekWedList}" end="0">
					<li class="list-group-item btn-outline-primary">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	<div class="thu list-group-item btn-outline-success">
		<p>T</p>
		<h6 class="font-weight-light">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${totalThuList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalThuList}" end="1">
					<li class="list-group-item btn-outline-success">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음식 -->
			<c:if test="${totalWeekThuList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalWeekThuList}" end="0">
					<li class="list-group-item btn-outline-success">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	<div class="fri list-group-item btn-outline-info">
		<p>F</p>
		<h6 class="font-weight-light">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${totalFriList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalFriList}" end="1">
					<li class="list-group-item btn-outline-info">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음 -->
			<c:if test="${totalWeekFriList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalWeekFriList}" end="0">
					<li class="list-group-item btn-outline-info">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
</div>

<!-- this week -->
<input type="hidden" id="thisCheck" value="0"/>
<div class="mt-5 mb-3 list-group-horizontal text-center table-hover" id="thisWeek">
	<div class="mon list-group-item btn-outline-danger">
		<p>M</p>
		<h6 class="font-weight-light">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<!-- 자주 먹은 음식-->
			<c:if test="${monList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${monList}" end="1">
					<li class="list-group-item btn-outline-danger">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음식 -->
			<c:if test="${weekList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${weekList}">
					<c:if test="${list.fday==1}">
						<li class="list-group-item btn-outline-danger">${list.fname}</li>
					</c:if>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	<div class="tue list-group-item btn-outline-warning">
		<p>T</p>
		<h6 class="font-weight-light">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${tueList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${tueList}" end="1">
					<li class="list-group-item btn-outline-warning">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음식 -->
			<c:if test="${weekList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${weekList}">
					<c:if test="${list.fday==2}">
						<li class="list-group-item btn-outline-warning">${list.fname}</li>
					</c:if>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	<div class="wed list-group-item btn-outline-primary">
		<p>W</p>
		<h6 class="font-weight-light">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${wedList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${wedList}" end="1">
					<li class="list-group-item btn-outline-primary">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음식 -->
			<c:if test="${weekList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${weekList}">
					<c:if test="${list.fday==3}">
						<li class="list-group-item btn-outline-primary">${list.fname}</li>
					</c:if>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	<div class="thu list-group-item btn-outline-success">
		<p>T</p>
		<h6 class="font-weight-light">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${thuList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${thuList}" end="1">
					<li class="list-group-item btn-outline-success">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음식 -->
			<c:if test="${weekList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${weekList}">
					<c:if test="${list.fday==4}">
						<li class="list-group-item btn-outline-success">${list.fname}</li>
					</c:if>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	<div class="fri list-group-item btn-outline-info">
		<p>F</p>
		<h6 class="font-weight-light">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${friList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${friList}" end="1">
					<li class="list-group-item btn-outline-info">${list.key}/${list.value}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음식 -->
			<c:if test="${weekList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${weekList}">
					<c:if test="${list.fday==5}">
						<li class="list-group-item btn-outline-info">${list.fname}</li>
					</c:if>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
</div>

<!-- suggestion -->
<div id="center" class="container">


<h5 class="centered"> 추천 리스트</h5>


<div class="card text-center">
  <div class="card-header">
   
   
    <ul class="nav nav-tabs card-header-tabs">
    <div id="center" class="container">
      <li class="nav-item">
        <a class="nav-link active" href="#">한식</a>
         <div class="card-body">
    <h5 class="card-title"></h5>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="#">일식</a>
         <div class="card-body">
    <h5 class="card-title"></h5>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
   <a href="#" class="btn btn-primary">Go somewhere</a>
   <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="#">중식</a>
         <div class="card-body">
    <h5 class="card-title"></h5>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
   <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="#">양식</a>
         <div class="card-body">
    <h5 class="card-title"></h5>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
      </li>
     <li class="nav-item">
        <a class="nav-link active" href="#">패스트푸드</a>
         <div class="card-body">
    <h5 class="card-title"></h5>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="#">기타</a>
         <div class="card-body">
    <h5 class="card-title"></h5>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
      </li>
      </div>
    </ul>
    </div>
  </div>
 
</div>

<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/main.js"></script>

</body>
</html>

