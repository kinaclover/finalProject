<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 1. login -->
<c:if test="${status==1}">
	<c:if test="${mdCheck==1}">
		<script type="text/javascript">
			alert("비밀번호를 변경해주세요!");
			window.location = "/findEat/modify.do";
		</script>
	</c:if>
	<c:if test="${idCheck!=1}">
		<script type="text/javascript">
			alert("가입먼저 해주세요! :)");
			if(confirm("가입페이지로 이동할까요?")){
				window.location	= "/findEat/join.do";
			}
		</script>
	</c:if>
	<c:if test="${check==1}">
		<script type="text/javascript">
			window.location = "/findEat/index.do";
		</script>
	</c:if>
	<c:if test="${check!=1}">
		<script type="text/javascript">
			alert("비밀번호를 확인해주세요.");
			history.back();
		</script>
	</c:if>
</c:if>

<!-- 2. update -->
<c:if test="${status==2}">
	<c:if test="${check==1}">
		<script type="text/javascript">
			alert("성공적으로 변경되었습니다.");
			window.location = "/findEat/index.do";
		</script>
	</c:if>
	<c:if test="${check!=1}">
		<script type="text/javascript">
			alert("오류가 발생했습니다. 다시한번 해주세요.");
			history.back();
		</script>
	</c:if>
</c:if>

<!-- 3. join -->
<c:if test="${status==3}">
	<c:if test="${check==1}">
		<script type="text/javascript">
			alert("환영합니다! :) 로그인해주세요.");
			window.location = "/findEat/login.do";
		</script>
	</c:if>
	<c:if test="${check!=1}">
		<script type="text/javascript">
			alert("문제가 발생하였습니다. 문제가 계속될 경우 의견을 보내주시길 바랍니다.");
			history.back();
		</script>
	</c:if>
</c:if>

<!-- 4. delete -->
<c:if test="${status==4}">
	<c:if test="${check>=2}">
		<script type="text/javascript">
			alert("안녕히가세요.");
			window.location = "/findEat/index.do";
		</script>
	</c:if>
	<c:if test="${check!=2}">
		<script type="text/javascript">
			alert("비밀번호를 확인해주세요.");
			history.back();
		</script>
	</c:if>
</c:if>

<!-- 5. find password -->
<c:if test="${status==5}">
	<c:if test="${check==1}">
		<script type="text/javascript">
			alert("임시 비밀번호를 보내드렸습니다. 메일을 확인해주세요.");
			window.location = "/findEat/index.do";
		</script>
	</c:if>
	<c:if test="${check!=1}">
		<script type="text/javascript">
			alert("죄송합니다. 다시 시도해주세요.");
			history.back();
		</script>
	</c:if>
</c:if>

<!-- error -->
<c:if test="${status>4 || status<1}">
	<script type="text/javascript">
		alert("잘못된 접근입니다.");
		history.back();
	</script>
</c:if>