<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
</head>
<script src="${contextPath}/shopping-car/js/jquery.min.js"></script>
<link rel="stylesheet" href="${contextPath}/shopping-car/css/bootstrap.min.css">
<script src="${contextPath}/shopping-car/js/bootstrap.min.js"></script>

</head>
<style>
	/*web background*/
	.container {
		display: table;
		height: 100%;
	}
	
	.row {
		display: table-cell;
		vertical-align: middle;
	}
	/* centered columns styles */
	.row-left {
		text-align: left;
	}
	.row-right {
		text-align: right;
	}
	
	.col-centered {
		display: inline-block;
		float: none;
		text-align: left;
		margin-right: -4px;
	}
</style>
<body>
	<div class="row">
		<div class="row row-left">
			<a href="${contextPath}/shopping-car/goods/list" class="btn btn-primary">Goods</a>
			<a href="${contextPath}/shopping-car/car/myCars" class="btn btn-primary">My Shopping Cart</a>
		</div>
	</div>
	<div class="content">
		<table class="table table-striped table-bordered">
			<thead>
				<tr class="active">
					<th width="300">Order No</th>
					<th width="300">Goods</th>
					<th width="300">Price</th>
					<th width="300">Count</th>
					<th width="300">Total Price</th>
					<th width="300">Order Time</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orders}" var="item">
					<tr>
						<td>${item.orderNo}</td>
						<td>${item.goodsName}</td>
						<td>${item.price}</td>
						<td>${item.nums}</td>
						<td>${item.totalPrice}</td>
						<td>${item.fdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>