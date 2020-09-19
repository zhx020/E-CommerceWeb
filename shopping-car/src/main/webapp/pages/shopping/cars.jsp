<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
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
			<a href="${contextPath}/shopping-car/order/list" class="btn btn-primary">My Orders</a>
			<label>Total Count:</label>
			<input type="text" id="totalCount" value="${car.totalCount}" disabled="disabled"/>
			<label>Total Price:</label>
			<input type="text" id="totalPrice" value="${car.totalPrice}" disabled="disabled"/>
			<button onclick="subItem('','')" class="btn btn-primary">Clear All</button>
			<button onclick="buyAll('')" class="btn btn-primary">Buy All</button>
		</div>
	</div>
	<div class="content">
		<table class="table table-striped table-bordered">
			<thead>
				<tr class="active">
					<th width="300">Image</th>
					<th width="300">Name</th>
					<th width="300">Count</th>
					<th width="300">Total Price</th>
					<th width="200">Operation</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${car.list}" var="item">
					<tr>
						<td><img src="/shopping-car/${item.image}" class="img-responsive" onclick="viewImage(${item.image})"></td>
						<td>${item.name}</td>
						<td>${item.nums}</td>
						<td>${item.totalPrices}</td>
						<td>
							<div class="btn-group btn-group-justified">
								<a href="#" class="btn btn-primary" onclick="subItem(${item.id},1)">-</a>
								<a href="#" class="btn btn-primary" onclick="subItem(${item.id},'')">Sub All</a>
								<a href="#" class="btn btn-primary" onclick="buyAll(${item.id})">Buy All</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
	function subItem(id,count) {
		$.ajax({
			 type: 'POST',
			 url: "/shopping-car/car/delete?id="+id + "&count=" + count,
			 success:function(result){
				 window.location.reload();
			 }
		});
	}
	function buyAll(id) {
		$.ajax({
			 type: 'POST',
			 url: "/shopping-car/car/purchase?id="+id,
			 success:function(result){
				 window.location.reload();
			 }
		});
	}
</script>
</html>