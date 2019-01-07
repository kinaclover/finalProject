<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- board status -->

<!-- insert -->
<c:if test="${status==1}">
	<!-- success -->
	<c:if test="${check==1}">
		<script type="text/javascript">
			alert("글 작성 완료.");
			window.location = "/findEat/list.do";
		</script>
	</c:if>
	<!-- fail -->
	<c:if test="${check!=1}">
		<script type="text/javascript">
			alert("오류가 발생했습니다. 다시 시도해주시길 바랍니다.");
			history.back();
		</script>
	</c:if>
</c:if>

<!-- update -->
<c:if test="${status==2}">
	<!-- success -->
	<c:if test="${check==1}">
		<script type="text/javascript">
			alert("글 수정 완료.");
			window.location = "/findEat/list.do?idx="+${idx};
		</script>
	</c:if>
	<!-- fail -->
	<c:if test="${check!=1}">
		<script type="text/javascript">
			alert("오류가 발생했습니다. 다시 시도해주시길 바랍니다.");
			history.back();
		</script>
	</c:if>
</c:if>

<!-- delete -->