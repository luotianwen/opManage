<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>




	<div class="tab-pane active">
		<div class="full-height-scroll">
			<div class="table-responsive">
				<table class="table table-striped table-hover">
					<thead>
					<tr>
						<c:if test="${searchVO.rowFields[0]=='1' }">
							<th >日期</th>
						</c:if>
						<c:if test="${searchVO.rowFields[0]=='3'||searchVO.rowFields[1]=='3' }">
							<th >渠道</th>
						</c:if>
						<th >付款金额</th>
						<th >成本</th>
						<th >利润</th>
						<th >购买数量</th>
						<th ></th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${orders}" var="list" >
						<tr>
							<c:if test="${searchVO.rowFields[0]=='1' }">
								<td><fmt:formatDate value="${list.create_time }" pattern="yyyy-MM-dd"/></td>
							</c:if>
							<c:if test="${searchVO.rowFields[0]=='3'||searchVO.rowFields[1]=='3' }">
							<td>
								<c:forEach items="${channels}"  var="channel2">
								   <c:if test="${list.channel==channel2.id}">${channel2.name}</c:if>
							    </c:forEach>
							</td>
							</c:if>

							<td>${list.retailPrice }</td>
							<td>${list.settlementPrice}</td>
							<td>${list.price }</td>
							<td>${list.count }</td>
							<td><a class="J_menuItem" data-index="0" href="ticket/allOrder.html?tabCode=pay<c:if test="${searchVO.rowFields[0]=='1' }">&create_time=<fmt:formatDate value="${list.create_time }" pattern="yyyy-MM-dd"/><c:if test="${searchVO.rowFields[1]=='3' }">&channel=${list.channel }</c:if></c:if><c:if test="${searchVO.rowFields[0]=='3' }">&channel=${list.channel }</c:if>"><button type="button" id="edit" class="btn btn-outline btn-success"><i class="fa fa-paste"></i> 查看订单</button></a></td>
						</tr>
					</c:forEach>

					</tbody>
				</table>
			</div>
		</div>


	</div>
<script type="text/javascript" src="static/js/spot/contabs.min.js"></script>