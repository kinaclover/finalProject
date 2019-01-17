<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h5 class="centered"> 추천 리스트</h5>

<input type="hidden" id="totalCheck" value="0"/>
<div class="card text-center" id="totalclas">
	<div class="card-header">
		<ul class="nav nav-tabs card-header-tabs">
			<div id="center" class="container">
				<li class="nav-item">
					<a class="nav-link active" href="#">한식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dtotalclassifyk}" end="2">
							<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
						<c:forEach var="list" items="${wtotalclassifyk}" end="1">
						
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">일식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dtotalclassifyj}" end="2">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
						<c:forEach var="list" items="${wtotalclassifyj}" end="1">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">중식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dtotalclassifyc}" end="2">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
						<c:forEach var="list" items="${wtotalclassifyc}" end="1">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">양식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dtotalclassifyw}" end="2">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
						<c:forEach var="list" items="${wtotalclassifyw}" end="1">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">패스트푸드</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dtotalclassifyf}" end="2">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
						<c:forEach var="list" items="${wtotalclassifyf}" end="1">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">기타</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dtotalclassifye}" end="2">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
						<c:forEach var="list" items="${wtotalclassifye}" end="1">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
			</div>
		</ul>
	</div>
</div>

<input type="hidden" id="personalCheck" value="0"/>
<div class="card text-center" id="personalclas" >
	<div class="card-header">
		<ul class="nav nav-tabs card-header-tabs">
			<div id="center" class="container">
				<li class="nav-item">
					<a class="nav-link active" href="#">한식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dpersonalclassifyk}" end="2">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
						<c:forEach var="list" items="${wpersonalclassifyk}" end="1">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">일식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dpersonalclassifyj}" end="2">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
						<c:forEach var="list" items="${wpersonalclassifyj}" end="1">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">중식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dpersonalclassifyc}" end="2">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
						<c:forEach var="list" items="${wpersonalclassifyc}" end="1">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">양식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dpersonalclassifyw}" end="2">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
						<c:forEach var="list" items="${wpersonalclassifyw}" end="1">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">패스트푸드</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dpersonalclassifyf}" end="2">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
						<c:forEach var="list" items="${wpersonalclassifyf}" end="1">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">기타</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dpersonalclassifye}" end="2">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
						<c:forEach var="list" items="${wpersonalclassifye}" end="1">
							<a href="http://localhost:8080/findEat/search.do?listkeyword=${list.key}" class="btn btn-primary">${list.key}</a>
						</c:forEach>
					</div>
				</li>
			</div>
		</ul>
	</div>
</div>


