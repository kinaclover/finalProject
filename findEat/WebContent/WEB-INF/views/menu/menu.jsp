<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- guest -->
<c:if test="${sessionScope.id==null}">
	<div class="text-right">
		<button class="btn btn-sm btn-outline-secondary" onclick="window.location='/findEat/list.do'">Board</button>
		<button class="btn btn-sm btn-outline-primary" onclick="window.location='/findEat/login.do'">Login</button>
		<button class="btn btn-sm btn-outline-info" onclick="window.location='/findEat/join.do'">Sign Up</button>
	</div>
</c:if>

<!-- client -->
<c:if test="${sessionScope.id!=null}">
	<div class="dropdown text-right">
		<button class="btn btn-sm btn-outline-secondary" onclick="window.location='/findEat/list.do'">Board</button>
		<button class="btn btn-sm btn-outline-success dropdown-toggle" type="button" id="dropDown" data-toggle="dropdown" aria-haspopup="true" aria-expended="false">My menu</button>
			<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropDown">
				<a class="dropdown-item" href="">Calendar</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="/findEat/modify.do">Modify</a>
				<c:if test="${sessionScope.id.equals('admin')}">
				<a class="dropdown-item" href="/findEat/insertFood.do">Food Administrator</a>
				</c:if>
			</div>
		<button class="btn btn-sm btn-danger" id="logoutBtn">Logout</button>
	</div>
</c:if>