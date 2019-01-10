<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- input comment -->
<div class="row">
	<input type="hidden" id="sessionId" value="${sessionScope.id}"/>
	<label for="inputComment" class="col-2 font-weight-bold">Comment</label>
	<textarea rows="4" cols="" class="col-8" id="inputComment"></textarea>
	<input type="button" class="col-2" id="confComm" value="댓글 달기"/>
</div>

<!-- comments -->
<div>
	<!-- Empty -->
	<c:if test="${commentsList.isEmpty()}">
		<div class="text-center mt-5">
			<h4>댓글이 없습니다.</h4>
		</div>
	</c:if>
	
	<!-- Not empty -->
	<c:if test="${!commentsList.isEmpty()}">
	<div class="mx-auto mt-5">
	<c:forEach items="${commentsList}" var="list">
		<form action="commAction.do?num=${list.num}" method="post">
			<div class="row my-3 comment-${list.num}">
				<div class="col-4">
					<input type="text" class="form-control-plaintext" name="id" value="${list.id}" readonly/>
					<c:if test="${list.id.equals(sessionScope.id)||sessionScope.id.equals('admin')}">
					<div class="btn-group">
						<input type="hidden" class="modiCheck-${list.num}" value="0"/>
						<button type="button" class="modBtn modBtn-${list.num} btn btn-sm btn-outline-warning" value="${list.num}">수정</button>
						<button type="button" class="modBtn2 modBtn2-${list.num} btn btn-sm btn-warning" hidden="hidden" value="${list.num}">수정</button>
						<button type="button" class="delBtn btn btn-sm btn-danger" value="${list.num}">삭제</button>
					</div>
					</c:if>
				</div>
				<textarea rows="4" cols="" class="col-8 comm-${list.num}" name="comment" readonly>${list.content}</textarea>
			</div>
		</form>
	</c:forEach>
	</div>
	</c:if>
</div>