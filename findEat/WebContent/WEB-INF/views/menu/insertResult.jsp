<<<<<<< Upstream, based on branch 'master' of https://github.com/kinaclover/finalProject
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<c:if test="${status==1}">
	<c:if test="${check==1}">
		<script>
			alert("입력완료.");
			window.location = "/findEat/insertFood.do";
		</script>
	</c:if>
	
	<c:if test="${check!=1}">
		<script>
			alert("입력되지 않았습니다. 다시 시도해주세요.");
			history.back();
		</script>
	</c:if>
</c:if>

<c:if test="${status==2}">
	<c:if test="${check==1}">
		<script>
			alert("삭제완료.");
			window.location = "/findEat/insertFood.do";
		</script>
	</c:if>
	
	<c:if test="${check!=1}">
		<script>
			alert("삭제되지 않았습니다. 다시 시도해주세요.");
			history.back();
		</script>
	</c:if>
</c:if>

</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<c:if test="${status==1}">
	<c:if test="${check==1}">
		<script>
			alert("입력완료.");
			window.location = "/findEat/insertFood.do";
		</script>
	</c:if>
	
	<c:if test="${check!=1}">
		<script>
			alert("입력되지 않았습니다. 다시 시도해주세요.");
			history.back();
		</script>
	</c:if>
</c:if>

<c:if test="${status==2}">
	<c:if test="${check==1}">
		<script>
			alert("삭제완료.");
			window.location = "/findEat/insertFood.do";
		</script>
	</c:if>
	
	<c:if test="${check!=1}">
		<script>
			alert("삭제되지 않았습니다. 다시 시도해주세요.");
			history.back();
		</script>
	</c:if>
</c:if>

</body>
>>>>>>> 22e41e1 search페이지 결과창 스타일 값 수정, admin음식 입력 결과확인을 위한 jsp파일 추가 - 1/24
</html>