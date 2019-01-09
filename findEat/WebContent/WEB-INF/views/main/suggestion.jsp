<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h5 class="centered"> 추천 리스트</h5>

<div class="card text-center">
	<div class="card-header">
		<ul class="nav nav-tabs card-header-tabs">
			<div id="center" class="container">
				<li class="nav-item">
					<a class="nav-link active" href="#">한식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${totalclassifyk}" end="4">
							<a href="#" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">일식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${totalclassifyj}" end="4">
							<a href="#" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">중식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${totalclassifyc}" end="4">
							<a href="#" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">양식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${totalclassifyw}" end="4">
							<a href="#" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">패스트푸드</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${totalclassifyf}" end="4">
							<a href="#" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">기타</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${totalclassifye}" end="4">
							<a href="#" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
			</div>
		</ul>
	</div>
</div>
