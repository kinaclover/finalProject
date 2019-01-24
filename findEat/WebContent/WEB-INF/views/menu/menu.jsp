<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="row mx-0 px-0">
<!-- notice -->
<div class="col-sm-1 text-center pl-3 pt-1">
	<label for="noticeDiv" class="text-info">Notice>></label>
</div>
<div class="col-sm-6 text-left" style="height:40px;overflow: hidden">
	<div id="noticeDiv">
		<c:if test="${noticeList==null}">
			<span>공지사항이 없습니다.</span>
		</c:if>
		<c:if test="${noticeList!=null}">
			<div class="noticeGroup list-group list-group-flush" style="position:relative;width:100%;">
				<c:forEach items="${noticeList}" var="list">
					<a class="noticeItem list-group-item form-control-plaintext pt-1 roll" href="${request.contextPath}/findEat/article.do?idx=${list.idx}">${list.subject}</a>
				</c:forEach>
			</div>
		</c:if>
	</div>
</div>

<!-- guest -->
<c:if test="${sessionScope.id==null}">
	<div class="col-sm-5 text-right">
		<button class="btn btn-sm btn-outline-info" id="indexButton" onclick="window.location='/findEat/index.do'">Index</button>
		<button class="btn btn-sm btn-outline-secondary" id="boardButton" onclick="window.location='/findEat/list.do'">Board</button>
		<button class="btn btn-sm btn-outline-dark" id="searchButton" onclick="window.location='/findEat/search.do'">Search</button>
		<button class="btn btn-sm btn-outline-primary" onclick="window.location='/findEat/login.do'">Login</button>
	</div>
</c:if>

<!-- client -->
<c:if test="${sessionScope.id!=null}">
	<div class="col-sm-5 text-right">
		<button class="btn btn-sm btn-outline-info" id="indexButton" onclick="window.location='/findEat/index.do'">Index</button>
		<button class="btn btn-sm btn-outline-secondary" id="boardButton" onclick="window.location='/findEat/list.do'">Board</button>
		<button class="btn btn-sm btn-outline-dark" id="searchButton" onclick="window.location='/findEat/search.do'">Search</button>
		<div class="btn-group">
		<button class="btn btn-sm btn-outline-success dropdown-toggle" type="button" data-toggle="dropdown">My menu</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="/findEat/cal.do">월간 식사 입력</a>
				<a class="dropdown-item" href="/findEat/statistic.do">식사 통계</a>
				<a class="dropdown-item" href="/findEat/search.do">음식점 검색</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="/findEat/modify.do">회원정보 수정</a>
				<c:if test="${sessionScope.id.equals('admin')}">
					<a class="dropdown-item" href="/findEat/insertFood.do">Food Administrator</a>
				</c:if>
			</div>
		</div>
		<button class="btn btn-sm btn-danger" id="logoutBtn">Logout</button>
	</div>
</c:if>

</div>