<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- input comment -->
<div class="row">
	<textarea rows="4" cols="" class="col-8" id="inputComment"></textarea>
	<input type="button" class="col-4 my-auto" id="confCom" value="댓글 달기"/>
</div>

<!-- comments -->
<div>
	<c:forEach items="${commentsList}" var="list">
		<form action="commAction.do?num=${list.num}" method="post" onsubmit="">
			<input type="hidden" id="actionType" name="actionType" value="0"/>
			<div class="row my-3 comment-${list.num}">
				<div class="col-4">
					<input type="text" class="" name="id" value="${list.id}"/>
					<c:if test="${list.id.equals(sessionScope.id)}">
					<div class="btn-group">
						<button type="button" id="modBtn" class="btn btn-sm btn-outline-warning">수정</button>
						<button type="button" id="delBtn" class="btn btn-sm btn-outline-danger">삭제</button>
					</div>
					</c:if>
				</div>
				<textarea rows="4" cols="" class="col-8" name="comment" readonly>${list.content}</textarea>
			</div>
		</form>
	</c:forEach>
</div>