<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="d-block">
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>

<!-- board List -->
<c:if test="${check==0}">
<div class="mx-auto my-3 d-block" style="width: 75%">
	<div class="btn-group btn-group-sm">
	<button type="button" class="btn btn btn-outline-primary" onclick="window.location='/findEat/index.do'">메인으로</button>
	<c:if test="${sessionScope.id!=null}">
		<button type="button" class="btn btn-outline-secondary" onclick="window.location='/findEat/insert.do'">글 작성</button>
	</c:if>
	</div>
	<div class="text-center mt-5 mb-5">
		<h2>게시글이 존재하지 않습니다.</h2>
	</div>
</div>
</c:if>

<c:if test="${check==1}">
<div class="mx-auto my-3 d-block" style="width: 75%">
	<div class="btn-group btn-group-sm mb-3">
	<button type="button" class="btn btn btn-outline-primary" onclick="window.location='/findEat/index.do'">메인으로</button>
	<c:if test="${sessionScope.id!=null}">
		<button type="button" class="btn btn-outline-secondary" onclick="window.location='/findEat/insert.do'">글 작성</button>
	</c:if>
	</div>
	<div id="boardList" class="mb-3">
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr class="d-flex">
					<th scope="col" class="col-1 text-center">#</th>
					<th scope="col" class="col-5">Subject</th>
					<th scope="col" class="col-2 text-center">Writer</th>
					<th scope="col" class="col-3">Date</th>
					<th scope="col" class="col-1 text-center">View</th>
				</tr>
			</thead>
			<tbody>
				<!-- notice -->
				<c:if test="${noticeList!=null}">
				<c:forEach items="${noticeList}" var="list">
					<tr class="d-flex table-warning">
						<th scope="row" class="col-1 text-center">!</th>
						<td class="col-5">${list.subject}</td>
						<td class="col-2 text-center">${list.id}</td>
						<td class="col-3">${list.regDate}</td>
						<td class="col-1 text-center">${list.vcount}</td>
					</tr>
				</c:forEach>
				</c:if>
				<!-- article -->
				<c:if test="${normalList!=null}">
				<c:forEach items="${normalList}" var="list">
					<tr class="d-flex">
						<th scope="row" class="col-1 text-center">
							<c:out value="${count}"/>
							<c:set var="count" value="${count-1}"/>
						</th>
						<td class="col-5">
							<a class="form-control-plaintext pt-0" href="${request.contextPath}/article.do?idx=${list.idx}">${list.subject}</a>
						</td>
						<td class="col-2 text-center">${list.id}</td>
						<td class="col-3">
							<fmt:formatDate value="${list.regDate}" pattern="yy/MM/dd"/>
						</td>
						<td class="col-1 text-center">${list.vcount}</td>
					</tr>
				</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>

	<!-- board section -->
	<div id="boardSection" class="">
		<nav class="">
			<ul class="pagination">
				<c:if test="${startPage > 10}">
					<li class="page-item">
						<a class="page-link" aria-label="Previous" href="${request.contextPath}/list.do?pageNum=${startPage-10}">
							<span aria-hidden="true">&laquo;</span></a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<li class="page-item">
						<a class="page-link" href="${request.contextPath}/list.do?pageNum=${i}">${i}</a></li>
				</c:forEach>
				<c:if test="${endNum > 10}">
					<li class="page-item">
						<a class="page-link" aria-label="Next" href="${request.contextPath}/list.do?pageNum=${endPage+1}">
							<span aria-hidden="true">&raquo;</span></a>
					</li>
				</c:if>
			</ul>
		</nav>
	</div>
</div>
</c:if>



<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/main.js"></script>
</body>
</html>