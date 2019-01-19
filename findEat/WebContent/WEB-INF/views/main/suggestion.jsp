<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="text-center">
<h5> 추천 리스트</h5>
</div>
<input type="hidden" id="totalCheck" value="0"/>
<div class="card text-center" id="totalclas">
	<div class="card-header">
		<ul class="nav nav-tabs card-header-tabs">
				<li class="nav-item">
				<div class="row">
				<div class="col-md-4">
					<a class="nav-link active" >한식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>

						<c:forEach var="list" items="${dtotalclassifyk}" end="2" varStatus="status">
						<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-danger custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-warning custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 2}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-primary custom">${list.key}</a>
						</c:if>

						</c:forEach>
						<c:forEach var="list" items="${wtotalclassifyk}" end="1" varStatus="status">
						<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-success custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-info custom">${list.key}</a>
						</c:if>
						
						</c:forEach>
					</div>
					</div>
					<div class="col-md-4">
					<a class="nav-link active" href="#">일식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dtotalclassifyj}" end="2" varStatus="status">
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-danger custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-warning custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 2}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-primary custom">${list.key}</a>
						</c:if>
						</c:forEach>
						<c:forEach var="list" items="${wtotalclassifyj}" end="1" varStatus="status">
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-success custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-info custom">${list.key}</a>
						</c:if>
						</c:forEach>
					</div>
					</div>
					<div class="col-md-4">
				<a class="nav-link active" href="#">중식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dtotalclassifyc}" end="2" varStatus="status">
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-danger custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-warning custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 2}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-primary custom">${list.key}</a>
						</c:if>
						</c:forEach>
						<c:forEach var="list" items="${wtotalclassifyc}" end="1" varStatus="status">
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-success custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-info custom">${list.key}</a>
						</c:if>
						</c:forEach>
					</div>
					</div>
				</div>
				</li>
				
				
				<li class="nav-item">
				<div class="row">
				<div class="col-md-4">
					<a class="nav-link active" href="#">양식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dtotalclassifyw}" end="2" varStatus="status">
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-danger custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-warning custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 2}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-primary custom">${list.key}</a>
						</c:if>
						</c:forEach>
						<c:forEach var="list" items="${wtotalclassifyw}" end="1" varStatus="status">
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-success custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-info custom">${list.key}</a>
						</c:if>
						</c:forEach>
					</div>
					</div>
					<div class="col-md-4">
					<a class="nav-link active" href="#">패스트푸드</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dtotalclassifyf}" end="2" varStatus="status">
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-danger custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-warning custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 2}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-primary custom">${list.key}</a>
						</c:if>
						</c:forEach>
						<c:forEach var="list" items="${wtotalclassifyf}" end="1" varStatus="status">
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-success custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-info custom">${list.key}</a>
						</c:if>
						</c:forEach>
					</div>
					</div>
					<div class="col-md-4">
					<a class="nav-link active" href="#">기타</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dtotalclassifye}" end="2" varStatus="status">
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-danger custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-warning custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 2}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-primary custom">${list.key}</a>
						</c:if>
						</c:forEach>
						<c:forEach var="list" items="${wtotalclassifye}" end="1" varStatus="status">
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-success custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-info custom">${list.key}</a>
						</c:if>
						</c:forEach>
					</div>
					</div>
					</div>
				</li>
		</ul>
	</div>
</div>

<input type="hidden" id="personalCheck" value="0"/>
<div class="card text-center" id="personalclas" >
<div class="card-header">
		<ul class="nav nav-tabs card-header-tabs center-block">
				<li class="nav-item center-block" >
				<div class="row">
				<div class="col-md-4">
					<a class="nav-link active center-block" id="ktag">한식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dpersonalclassifyk}" end="2" varStatus="status">
						<c:if test="${list.key == null}">
						<input type="hidden" id="dpersonalclassifykCheck" value="0"/>
						</c:if>
						
						<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-danger custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-warning custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 2}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-primary custom">${list.key}</a>
						</c:if>
						</c:forEach>
						
						<c:forEach var="list" items="${wpersonalclassifyk}" end="1" varStatus="status">
						<c:if test="${list.key == null}">
						<input type="hidden" id="wpersonalclassifykCheck" value="0"/>
						</c:if>
						
						<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-success custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-info custom">${list.key}</a>
						</c:if>
						</c:forEach>
					</div>
					</div>
					<div class="col-md-4">
					<a class="nav-link active center-block" id="jtag">일식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dpersonalclassifyj}" end="2" varStatus="status">
						<c:if test="${list.key == null}">
						<input type="hidden" id="dpersonalclassifyjCheck" value="0"/>
						</c:if>
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-danger custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-warning custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 2}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-primary custom">${list.key}</a>
						</c:if>
						</c:forEach>
						<c:forEach var="list" items="${wpersonalclassifyj}" end="1" varStatus="status">
						<c:if test="${list.key == null}">
						<input type="hidden" id="wpersonalclassifyjCheck" value="0"/>
						</c:if>
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-success custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-info custom">${list.key}</a>
						</c:if>
						</c:forEach>
					</div>
					</div>
					<div class="col-md-4">
				<a class="nav-link active center-block" id="ctag">중식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dpersonalclassifyc}" end="2" varStatus="status">
						<c:if test="${list.key == null}">
						<input type="hidden" id="dpersonalclassifycCheck" value="0"/>
						</c:if>
						<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-danger custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-warning custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 2}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-primary custom">${list.key}</a>
						</c:if>
						</c:forEach>
						<c:forEach var="list" items="${wpersonalclassifyc}" end="1" varStatus="status">
						<c:if test="${list.key == null}">
						<input type="hidden" id="wpersonalclassifycCheck" value="0"/>
						</c:if>
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-success custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-info custom">${list.key}</a>
						</c:if>
						</c:forEach>
					</div>
					</div>
				</div>
				</li>
				
				
				<li class="nav-item center-block">
				<div class="row">
				<div class="col-md-4">
					<a class="nav-link active center-block" id="wtag">양식</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dpersonalclassifyw}" end="2" varStatus="status">
						<c:if test="${list.key == null}">
						<input type="hidden" id="dpersonalclassifywCheck" value="0"/>
						</c:if>
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-danger custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-warning custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 2}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-primary custom">${list.key}</a>
						</c:if>
						</c:forEach>
						<c:forEach var="list" items="${wpersonalclassifyw}" end="1" varStatus="status">
						<c:if test="${list.key == null}">
						<input type="hidden" id="wpersonalclassifywCheck" value="0"/>
						</c:if>
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-success custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-info custom">${list.key}</a>
						</c:if>
						</c:forEach>
					</div>
					</div>
					<div class="col-md-4">
					<a class="nav-link active center-block" id="ftag">패스트푸드</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dpersonalclassifyf}" end="2" varStatus="status">
						<c:if test="${list.key == null}">
						<input type="hidden" id="dpersonalclassifyfCheck" value="0"/>
						</c:if>
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-danger custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-warning custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 2}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-primary custom">${list.key}</a>
						</c:if>
						</c:forEach>
						<c:forEach var="list" items="${wpersonalclassifyf}" end="1" varStatus="status">
						<c:if test="${list.key == null}">
						<input type="hidden" id="wpersonalclassifyfCheck" value="0"/>
						</c:if>
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-success custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-info custom">${list.key}</a>
						</c:if>
						</c:forEach>
					</div>
					</div>
					<div class="col-md-4">
					<a class="nav-link active center-block" id="etag">기타</a>
					<div class="card-body">
						<h5 class="card-title"></h5>
						<c:forEach var="list" items="${dpersonalclassifye}" end="2" varStatus="status">
						<c:if test="${list.key == null}">
						<input type="hidden" id="dpersonalclassifyeCheck" value="0"/>
						</c:if>
							<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-danger custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-warning custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 2}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-primary custom">${list.key}</a>
						</c:if>
						</c:forEach>
						<c:forEach var="list" items="${wpersonalclassifye}" end="1" varStatus="status">
						<c:if test="${list.key == null}">
						<input type="hidden" id="wpersonalclassifyeCheck" value="0"/>
						</c:if>
						<c:if  test="${status.index eq 0}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-success custom">${list.key}</a>
						</c:if>
						<c:if  test="${status.index eq 1}">
						<a href="http://localhost:8080/findEat/search.do?menu=${list.key}" class="btn btn-outline-info custom">${list.key}</a>
						</c:if>
						</c:forEach>
					</div>
					</div>
					</div>
				</li>
		</ul>
	</div>
</div>
