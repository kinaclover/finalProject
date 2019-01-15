<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!-- Monday / total -->
<div class="modal fade" id="totalBeforeMon">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Top 5 - <strong class="text-danger">월요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${totalMonList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${totalMonList}" end="4">
							<li class="list-group-item btn-outline-danger">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="totalThisMon">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">이번주 Top 5 - <strong class="text-danger">월요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${totalWeekMonList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${totalWeekMonList}" end="4">
							<li class="list-group-item btn-outline-danger">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
	
	
<!-- Tuesday / total -->
<div class="modal fade" id="totalBeforeTue">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Top 5 - <strong class="text-warning">화요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${totalTueList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${totalTueList}" end="4">
							<li class="list-group-item btn-outline-warning">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="totalThisTue">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">이번주 Top 5 - <strong class="text-warning">화요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${totalWeekTueList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${totalWeekTueList}" end="4">
							<li class="list-group-item btn-outline-warning">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<!-- Wednesday / total -->
<div class="modal fade" id="totalBeforeWed">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Top 5 - <strong class="text-primary">수요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${totalWedList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${totalWedList}" end="4">
							<li class="list-group-item btn-outline-primary">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="totalThisWed">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">이번주 Top 5 - <strong class="text-primary">수요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${totalWeekWedList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${totalWeekWedList}" end="4">
							<li class="list-group-item btn-outline-primary">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<!-- Thursday / total -->
<div class="modal fade" id="totalBeforeThu">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Top 5 - <strong class="text-success">목요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${totalThuList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${totalThuList}" end="4">
							<li class="list-group-item btn-outline-success">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="totalThisThu">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">이번주 Top 5 - <strong class="text-success">목요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${totalWeekThuList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${totalWeekThuList}" end="4">
							<li class="list-group-item btn-outline-success">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<!-- Friday / total -->
<div class="modal fade" id="totalBeforeFri">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Top 5 - <strong class="text-info">금요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${totalFriList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${totalFriList}" end="4">
							<li class="list-group-item btn-outline-info">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="totalThisFri">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">이번주 Top 5 - <strong class="text-info">금요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${totalWeekFriList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${totalWeekFriList}" end="4">
							<li class="list-group-item btn-outline-info">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

<!-- Monday / personal -->
<div class="modal fade" id="personBeforeMon">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Top 5 - <strong class="text-danger">월요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${monList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${monList}" end="4">
							<li class="list-group-item btn-outline-danger">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- Tuesday / personal -->
<div class="modal fade" id="personBeforeTue">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Top 5 - <strong class="text-warning">화요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${tueList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${tueList}" end="4">
							<li class="list-group-item btn-outline-warning">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- Wednesday / personal -->
<div class="modal fade" id="personBeforeWed">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Top 5 - <strong class="text-primary">수요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${monList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${monList}" end="4">
							<li class="list-group-item btn-outline-primary">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- Thursday / personal -->
<div class="modal fade" id="personBeforeThu">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Top 5 - <strong class="text-success">목요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${thuList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${thuList}" end="4">
							<li class="list-group-item btn-outline-success">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- Friday / personal -->
<div class="modal fade" id="personBeforeFri">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Top 5 - <strong class="text-info">금요일</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${friList!=null}">
					<ul class="list-group">
						<c:forEach var="list" items="${friList}" end="4">
							<li class="list-group-item btn-outline-info">${list.key}/${list.value}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>