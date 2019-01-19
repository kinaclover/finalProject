<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${day>5}">
	<div class="text-center py-5">
		<h5>주말 추천은 개발중입니다!</h5>
	</div>
</c:if>

<c:if test="${day<=5}">
<!-- tabs - total -->
<div id="totalRankList">
	<nav>
		<div class="nav nav-tabs" id="totalTab" role="tablist">
			<a class="nav-item nav-link active" id="total-tab" data-toggle="tab" href="#totalT" role="tab">종합</a>
			<a class="nav-item nav-link" id="k-tab" data-toggle="tab" href="#koreanT" role="tab">한식</a>
			<a class="nav-item nav-link" id="j-tab" data-toggle="tab" href="#japaneseT" role="tab">일식</a>
			<a class="nav-item nav-link" id="c-tab" data-toggle="tab" href="#chineseT" role="tab">중식</a>
			<a class="nav-item nav-link" id="w-tab" data-toggle="tab" href="#westernT" role="tab">양식</a>
			<a class="nav-item nav-link" id="f-tab" data-toggle="tab" href="#fastT" role="tab">패스트푸드</a>
			<a class="nav-item nav-link" id="e-tab" data-toggle="tab" href="#etcT" role="tab">기타</a>
		</div>
	</nav>
	<!-- content -->
	<div class="tab-content" id="totalTabContent">
		<!-- total -->
		<div class="tab-pane fade show active" role="tabpanel" id="totalT">
			<c:if test="${totalRankMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!totalRankMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:25%;float:left;">
				<div class="pl-5">
					<c:forEach items="${totalRankMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="totalRankMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="totalRankMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div class="row" style="width:70%;float:right;">
				<div id="totalTabPie-total" class="col-6"></div>
				<c:forEach items="${totalClassifyMap}" var="map" varStatus="stat">
					<input type="hidden" class="totalClasMapKey-${stat.count}" value="${map.key}"/>
					<input type="hidden" class="totalClasMapValue-${stat.count}" value="${map.value}"/>
				</c:forEach>
				<div id="totalTabPie-totalB" class="col-6"></div>
			</div>
			</c:if>
		</div>
		<!-- 한식-Korean -->
		<div class="tab-pane fade" role="tabpanel" id="koreanT">
			<c:if test="${totalKMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!totalKMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:40%;float:left;" >
				<div class="pl-5">
					<c:forEach items="${totalKMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="totalKMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="totalKMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div id="totalTabPie-k" class="" style="width:50%;float:right;"></div>
			</c:if>
		</div>
		<!-- 일식-Japanese -->
		<div class="tab-pane fade" role="tabpanel" id="japaneseT">
			<c:if test="${totalJMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!totalJMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:40%;float:left;" >
				<div class="pl-5">
					<c:forEach items="${totalJMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="totalJMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="totalJMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div id="totalTabPie-j" class="" style="width:50%;float:right;"></div>
			</c:if>
		</div>
		<!-- 중식-Chinese -->
		<div class="tab-pane fade" role="tabpanel" id="chineseT">
			<c:if test="${totalCMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!totalCMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:40%;float:left;" >
				<div class="pl-5">
					<c:forEach items="${totalCMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="totalCMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="totalCMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div id="totalTabPie-c" class="" style="width:50%;float:right;"></div>
			</c:if>
		</div>
		<!-- 양식-Western -->
		<div class="tab-pane fade" role="tabpanel" id="westernT">
			<c:if test="${totalWMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!totalWMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:40%;float:left;" >
				<div class="pl-5">
					<c:forEach items="${totalWMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="totalWMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="totalWMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div id="totalTabPie-w" class="" style="width:50%;float:right;"></div>
			</c:if>
		</div>
		<!-- 패스트푸드/분식-Fast -->
		<div class="tab-pane fade" role="tabpanel" id="fastT">
			<c:if test="${totalFMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!totalFMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:40%;float:left;" >
				<div class="pl-5">
					<c:forEach items="${totalKMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="totalFMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="totalFMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div id="totalTabPie-f" class="" style="width:50%;float:right;"></div>
			</c:if>
		</div>
		<!-- 기타-Etc -->
		<div class="tab-pane fade" role="tabpanel" id="etcT">
			<c:if test="${totalEMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!totalEMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:40%;float:left;" >
				<div class="pl-5">
					<c:forEach items="${totalEMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="totalEMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="totalEMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div id="totalTabPie-e" class="" style="width:50%;float:right;"></div>
			</c:if>
		</div>
	</div>
</div>

<!-- tabs - user -->
<div id="userRankList">
	<nav>
		<div class="nav nav-tabs" id="userTab" role="tablist">
			<a class="nav-item nav-link active" id="total-tab" data-toggle="tab" href="#totalU" role="tab">종합</a>
			<a class="nav-item nav-link" id="k-tab" data-toggle="tab" href="#koreanU" role="tab">한식</a>
			<a class="nav-item nav-link" id="j-tab" data-toggle="tab" href="#japaneseU" role="tab">일식</a>
			<a class="nav-item nav-link" id="c-tab" data-toggle="tab" href="#chineseU" role="tab">중식</a>
			<a class="nav-item nav-link" id="w-tab" data-toggle="tab" href="#westernU" role="tab">양식</a>
			<a class="nav-item nav-link" id="f-tab" data-toggle="tab" href="#fastU" role="tab">패스트푸드</a>
			<a class="nav-item nav-link" id="e-tab" data-toggle="tab" href="#etcU" role="tab">기타</a>
		</div>
	</nav>
	<!-- content -->
	<div class="tab-content" id="userTabContent">
		<!-- total -->
		<div class="tab-pane fade show active" role="tabpanel" id="totalU">
			<c:if test="${userRankMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!userRankMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:25%;float:left;">
				<div class="pl-5">
					<c:forEach items="${userRankMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="userRankMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="userRankMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div class="row" style="width:70%;float:right;">
				<div id="userTabPie-total" class="col-6"></div>
				<c:forEach items="${totalClassifyMap}" var="map" varStatus="stat">
					<input type="hidden" class="userClasMapKey-${stat.count}" value="${map.key}"/>
					<input type="hidden" class="userClasMapValue-${stat.count}" value="${map.value}"/>
				</c:forEach>
				<div id="userTabPie-totalB" class="col-6"></div>
			</div>
			</c:if>
		</div>
		<!-- 한식-Korean -->
		<div class="tab-pane fade" role="tabpanel" id="koreanU">
			<c:if test="${userKMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!userKMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:40%;float:left;" >
				<div class="pl-5">
					<c:forEach items="${userKMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="userKMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="userKMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div id="userTabPie-k" class="" style="width:50%;float:right;"></div>
			</c:if>
		</div>
		<!-- 일식-Japanese -->
		<div class="tab-pane fade" role="tabpanel" id="japaneseU">
			<c:if test="${userJMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!userJMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:40%;float:left;" >
				<div class="pl-5">
					<c:forEach items="${userJMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="userJMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="userJMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div id="userTabPie-j" class="" style="width:50%;float:right;"></div>
			</c:if>
		</div>
		<!-- 중식-Chinese -->
		<div class="tab-pane fade" role="tabpanel" id="chineseU">
			<c:if test="${userCMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!userCMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:40%;float:left;" >
				<div class="pl-5">
					<c:forEach items="${userCMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="userCMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="userCMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div id="userTabPie-c" class="" style="width:50%;float:right;"></div>
			</c:if>
		</div>
		<!-- 양식-Western -->
		<div class="tab-pane fade" role="tabpanel" id="westernU">
			<c:if test="${userWMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!userWMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:40%;float:left;" >
				<div class="pl-5">
					<c:forEach items="${userWMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="userWMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="userWMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div id="userTabPie-w" class="" style="width:50%;float:right;"></div>
			</c:if>
		</div>
		<!-- 패스트푸드/분식-Fast -->
		<div class="tab-pane fade" role="tabpanel" id="fastU">
			<c:if test="${userFMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!userFMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:40%;float:left;" >
				<div class="pl-5">
					<c:forEach items="${userFMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="userFMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="userFMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div id="userTabPie-f" class="" style="width:50%;float:right;"></div>
			</c:if>
		</div>
		<!-- 기타-Etc -->
		<div class="tab-pane fade" role="tabpanel" id="etcU">
			<c:if test="${userEMap.isEmpty()}">
				<h3 class="py-5 px-5">데이터가 부족합니다.</h3>
			</c:if>
			<c:if test="${!userEMap.isEmpty()}">
			<div class="py-3 pl-5" style="width:40%;float:left;" >
				<div class="pl-5">
					<c:forEach items="${userEMap}" var="map" end="4" varStatus="stat">
						<input type="hidden" class="userEMapKey-${stat.count}" value="${map.key}"/>
						<input type="hidden" class="userEMapValue-${stat.count}" value="${map.value}"/>
						<p class="">${stat.count}위. <a href="${request.contextPath}/findEat/search.do?item=${map.key}">${map.key}</a></p>
					</c:forEach>
				</div>
			</div>
			<div id="userTabPie-e" class="" style="width:50%;float:right;"></div>
			</c:if>
		</div>
	</div>
</div>
</c:if>