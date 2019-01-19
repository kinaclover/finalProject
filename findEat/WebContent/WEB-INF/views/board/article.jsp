<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Article</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="d-block">
<!-- menu -->
<div class="mt-0 mb-3" id="menu">
	<jsp:include page="${request.contextPath}/menu.do"></jsp:include>
</div>

<c:if test="${idx==null}">
	<script type="text/javascript">
		alert("잘못된 접근입니다.");
		history.back();
	</script>
</c:if>

<c:if test="${idx!=null}">
<div class="mx-auto my-3 d-block" style="width: 75%">
	<div class="btn-toolbar mb-3" role="toolbar">
		<div class="btn-group btn-group-sm mr-2">
			<button type="button" class="btn btn btn-outline-primary" onclick="window.location='/findEat/index.do'">메인으로</button>
			<c:if test="${boardVO.atype.equals('notice') }">
				<button type="button" class="btn btn btn-outline-secondary" onclick="window.location='/findEat/list.do?pageNum=1'">글 목록</button>
			</c:if>
			<c:if test="${!boardVO.atype.equals('notice') }">
				<button type="button" class="btn btn btn-outline-secondary" onclick="window.location='/findEat/list.do?pageNum=${pageNum}'">글 목록</button>
			</c:if>
		</div>
		<div class="btn-group btn-group-sm">
			<input type="button" class="btn btn-sm btn-outline-warning text-center" id="chkBtn" 
						data-toggle="collapse" data-target="#collapsePw" value="수정"/>
			<input type="button" class="btn btn-sm btn-outline-info text-center" id="modifyCancel" value="취소" hidden="hidden"/>
			<input type="submit" class="btn btn-sm btn-outline-warning" id="confirmBtn" value="글 수정" hidden="hidden"/>
			<input type="button" class="btn btn-sm btn-outline-danger text-center" id="articleDelBtn" value="삭제"/>
		</div>
	</div>
	<!-- article -->
	<div>
		<c:if test="${boardVO.atype.equals('notice')}">
			<h6 class="my-0 py-0">[공지사항]</h6>
		</c:if>
		<form class="form" action="boardModifyPro.do" method="post">
		<input type="hidden" id="idx" name="idx" value="${idx}"/>
			<!-- subject -->
			<c:if test="${sessionScope.id.equals('admin')}">
			<div class="mt-3 mb-3">
				<h3>${boardVO.subject}</h3>
				<input type="hidden" name="atype" value="${boardVO.atype}"/>
			</div>
			<div class="text-right">
				<div class="form-check form-check-inline col-sm-2">
					<input type="radio" class="form-check-input" id="radio1" name="atype" value="notice" checked disabled/>
					<label class="form-check-label" for="radio1">Notice</label>
				</div>
				<div class="form-check form-check-inline col-sm-2">
					<input type="radio" class="form-check-input" id="radio2" name="atype" value="normal" disabled/>
					<label class="form-check-label" for="radio2">Normal</label>
				</div>
			</div>
			</c:if>
			<c:if test="${!sessionScope.id.equals('admin')}">
			<div class="mt-3 mb-3">
				<h3 class="pb-5">${boardVO.subject}</h3>
				<input type="hidden" name="atype" value="${boardVO.atype}"/>
			</div>
			</c:if>
			<!-- info -->
			<div class="mt-3 mb-0">
				<table class="table table-sm mb-0">
					<tbody>
						<tr>
							<td class="font-weight-bold">작성자</td>
							<td>${boardVO.id}</td>
							<td class="font-weight-bold">작성일</td>
							<td><fmt:formatDate value="${boardVO.regDate}" pattern="yyyy-MM-dd HH:mm"/></td>
							<td class="font-weight-bold">조회</td>
							<td>${boardVO.vcount}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- contents -->
			<div class="dropdown-divider mt-0 mb-3"></div>
			<div class="mb-5" style="width:100%" id="showCont">${contents}</div>
			<div class="row mb-5 mx-0" hidden="hidden" id="modiCont">
				<textarea class="col-12 px-0" rows="10" cols="" id="modiArea" name="content">${boardVO.content}</textarea>
			</div>
			<c:if test="${!sessionScope.id.equals(boardVO.id)&&!sessionScope.id.equals('admin')}">
			<div class="dropdown-divider mb-5"></div>
			</c:if>
			<!-- modify -->
			<c:if test="${sessionScope.id.equals(boardVO.id)||sessionScope.id.equals('admin')}">
			<div class="dropdown-divider mb-3"></div>
			<input type="hidden" id="chkNum" value="0"/>
			
			<div class="collapse" id="collapsePw">
				<div class="mx-0 my-3 row" style="width:40%;">
					<input type="password" class="form-control col-8" id="inputPw" name="pw" placeholder="password"/>
					<input type="button" class="btn btn-sm btn-outline-secondary col-4" id="modifyBtn" value="Check"/>
				</div>
			</div>
			</c:if>
			<!-- comments -->
			<div class="mt-5 mb-3 mx-auto" style="width:90%;background-color: #e1efff;">
				<div></div>
				<div class="mt-3 mb-5 mx-auto" id="commentsDiv" style="width:100%">
					<jsp:include page="${request.contextPath}/comments.do"></jsp:include>
				</div>
			</div>
		
		</form>
	</div>
	
</div>
</c:if>

<!-- for bootstrap/jQuery/Popper -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/main.js"></script>
<script src="js/board.js"></script>
<script src="js/menu.js"></script>
</body>
</html>