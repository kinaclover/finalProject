<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="mt-5 mb-5">
		<h2 class="text-center font-weight-normal">View article</h2>
	</div>
	<div style="width:60%;min-width:600px;margin:0 auto">
		<form class="form" action="boardModifyPro.do" method="post">
			<input type="hidden" id="idx" name="idx" value="${idx}"/>
			<div class="form-group row">
				<label for="staticId" class="col-sm-2 text-center form-control-plaintext font-weight-bold">ID</label>
				<input type="text" class="col-sm-10 form-control-plaintext" id="staticId" name="id" value="${boardVO.id}" readonly/>
				<input type="hidden" name="atype" value="${boardVO.atype}"/>
			</div>
			<div class="form-group row">
				<label for="inputSubject" class="col-sm-2 text-center form-control-plaintext font-weight-bold">Subject</label>
				<input type="text" class="col-sm-10 form-control-plaintext" id="inputSubject" name="subject" value="${boardVO.subject}" readonly/>
			</div>
			<div class="form-group row">
				<label for="inputContent" class="col-sm-2 text-center form-control-plaintext font-weight-bold">Content</label>
				<textarea rows="10" cols="" class="col-sm-10" id="inputContent" name="content" readonly>${boardVO.content}</textarea>
			</div>
			<c:if test="${sessionScope.id==boardVO.id}">
			<!-- modify -->
			<div class="form-group row" id="modiBox">
				<div class="col-sm-8" id="modifyDiv" hidden="hidden">
					<div class="row">
					<span class="col-sm-3 font-weight-bold px-0 text-center">Password</span>
					<input type="password" class="col-sm-6 px-0" id="inputPw" name="pw"/>
					<input type="button" class="col-sm-3 text-center btn-sm btn-outline-secondary" id="modifyBtn" value="Check"/>
					</div>
				</div>
				<div class="col-sm-4">
					<input type="hidden" id="chkNum" value="0"/>
					<input type="button" class="btn-md btn-outline-warning text-center" id="chkBtn" value="수정"/>
					<input type="button" class="btn-md btn-danger text-center" id="articleDelBtn" value="삭제"/>
				</div>
			</div>
			<div class="form-group text-right" id="modifySub" hidden="hidden">
				<input type="submit" class="btn btn-outline-primary" value="글 수정"/>
				<input type="button" class="btn btn-outline-secondary" id="modifyCancel" value="취소"/>
			</div>
			</c:if>
		</form>
	</div>
	<!-- comment -->
	<div class="mt-3 mb-5 mx-auto" id="commentsDiv" style="width:60%">
		<jsp:include page="${request.contextPath}/comments.do"></jsp:include>
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