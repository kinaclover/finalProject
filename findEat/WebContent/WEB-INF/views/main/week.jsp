<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- before weeks -->
<input type="hidden" id="beforeCheck" value="0"/>
<div class="mt-5 mb-3 list-group-horizontal text-center table-hover" id="beforeWeek">
	<!-- Monday / total -->
	<div class="mon list-group-item btn-outline-danger">
		<p>M</p>
		<h6 class="font-weight-light" id="total-before-mon" data-toggle="modal" data-target="#totalBeforeMon">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<!-- 자주 먹은 음식동안 먹어던 음 -->
			<c:if test="${totalMonList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalMonList}" end="1">
					<li class="list-group-item btn-outline-danger">${list.key}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light" id="total-this-mon" data-toggle="modal" data-target="#totalThisMon">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음식 -->
			<c:if test="${totalWeekMonList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalWeekMonList}" end="0">
					<li class="list-group-item btn-outline-danger">${list.key}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	
	<!-- Tuesday / total -->
	<div class="tue list-group-item btn-outline-warning">
		<p>T</p>
		<h6 class="font-weight-light" id="total-before-tue" data-toggle="modal" data-target="#totalBeforeTue">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${totalTueList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalTueList}" end="1">
					<li class="list-group-item btn-outline-warning">${list.key}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light" id="total-this-tue" data-toggle="modal" data-target="#totalThisTue">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음식 -->
			<c:if test="${totalWeekTueList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalWeekTueList}" end="0">
					<li class="list-group-item btn-outline-warning">${list.key}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	
	<!-- Wednesday / total -->
	<div class="wed list-group-item btn-outline-primary">
		<p>W</p>
		<h6 class="font-weight-light" id="total-before-wed" data-toggle="modal" data-target="#totalBeforeWed">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${totalWedList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalWedList}" end="1">
					<li class="list-group-item btn-outline-primary">${list.key}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light" id="total-this-wed" data-toggle="modal" data-target="#totalThisWed">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음식 -->
			<c:if test="${totalWeekWedList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalWeekWedList}" end="0">
					<li class="list-group-item btn-outline-primary">${list.key}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	
	<!-- Thursday / total -->
	<div class="thu list-group-item btn-outline-success">
		<p>T</p>
		<h6 class="font-weight-light" id="total-before-thu" data-toggle="modal" data-target="#totalBeforeThu">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${totalThuList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalThuList}" end="1">
					<li class="list-group-item btn-outline-success">${list.key}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light" id="total-this-thu" data-toggle="modal" data-target="#totalThisThu">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음식 -->
			<c:if test="${totalWeekThuList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalWeekThuList}" end="0">
					<li class="list-group-item btn-outline-success">${list.key}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	
	<!-- Friday / total -->
	<div class="fri list-group-item btn-outline-info">
		<p>F</p>
		<h6 class="font-weight-light" id="total-before-fri" data-toggle="modal" data-target="#totalBeforeFri">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${totalFriList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalFriList}" end="1">
					<li class="list-group-item btn-outline-info">${list.key}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
		<h6 class="font-weight-light" id="total-this-fri" data-toggle="modal" data-target="#totalThisFri">이번주</h6>
		<div class="dropdown-divider line"></div>
		<div class="bot">
			<!-- 이번주에 먹은 음 -->
			<c:if test="${totalWeekFriList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${totalWeekFriList}" end="0">
					<li class="list-group-item btn-outline-info">${list.key}</li>
				</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
</div>

<!-- this week -->
<input type="hidden" id="thisCheck" value="0"/>
<div class="mt-5 mb-3 list-group-horizontal text-center table-hover" id="thisWeek">
	<!-- Monday / personal -->
	<div class="mon list-group-item btn-outline-danger">
		<p>M</p>
		<h6 class="font-weight-light" data-toggle="modal" data-target="#personBeforeMon">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<!-- 자주 먹은 음식-->
			<c:if test="${monList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${monList}" end="1">
					<li class="list-group-item btn-outline-danger">${list.key}</li>
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
	
	<!-- Tuesday / personal -->
	<div class="tue list-group-item btn-outline-warning">
		<p>T</p>
		<h6 class="font-weight-light" data-toggle="modal" data-target="#personBeforeTue">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${tueList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${tueList}" end="1">
					<li class="list-group-item btn-outline-warning">${list.key}</li>
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
	
	<!-- Wednesday / personal -->
	<div class="wed list-group-item btn-outline-primary">
		<p>W</p>
		<h6 class="font-weight-light" data-toggle="modal" data-target="#personBeforeWed">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${wedList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${wedList}" end="1">
					<li class="list-group-item btn-outline-primary">${list.key}</li>
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
	
	<!-- Thursday / personal -->
	<div class="thu list-group-item btn-outline-success">
		<p>T</p>
		<h6 class="font-weight-light" data-toggle="modal" data-target="#personBeforeThu">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${thuList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${thuList}" end="1">
					<li class="list-group-item btn-outline-success">${list.key}</li>
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
	
	<!-- Friday / personal -->
	<div class="fri list-group-item btn-outline-info">
		<p>F</p>
		<h6 class="font-weight-light" data-toggle="modal" data-target="#personBeforeFri">자주 먹은 음식</h6>
		<div class="dropdown-divider line"></div>
		<div class="mid">
			<c:if test="${friList!=null}">
				<ul class="list-group">
				<c:forEach var="list" items="${friList}" end="1">
					<li class="list-group-item btn-outline-info">${list.key}</li>
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


<!-- modals -->
<jsp:include page="${request.contextPath}/indexModal.do"></jsp:include>