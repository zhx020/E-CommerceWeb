<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goods</title>
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
			<a href="${contextPath}/shopping-car/pages/shopping/addGoods.jsp" class="btn btn-primary">Add Goods</a>
			<label for="name">Name:</label>
			<input type="text" id="name" name="name"/>
			<button onclick="queryGoods()" class="btn btn-primary">Query</button>
			<a href="${contextPath}/shopping-car/car/myCars" class="btn btn-primary">My Shopping Cart</a>
			<a href="${contextPath}/shopping-car/order/list" class="btn btn-primary">My Orders</a>
		</div>
	</div>
	<div class="content">
		<table class="table table-striped table-bordered">
			<thead>
				<tr class="active">
					<th width="300">Image</th>
					<th width="300">Name</th>
					<th width="300">Price</th>
					<th width="300">Left Amount</th>
					<th width="200">Add To Shopping Cart</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${goods}" var="item">
					<tr>
						<td><img src="/shopping-car/${item.image}" class="img-responsive" onclick="viewImage(${item.image})"></td>
						<td>${item.name}</td>
						<td>${item.price}</td>
						<td>${item.leftCount}</td>
						<td>
							<div class="btn-group btn-group-justified">
								<a href="#" class="btn btn-primary"
									onclick="addToCar(${item.id})">+</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
	function addToCar(id) {
		$.ajax({
			 type: 'POST',
			 url: "/shopping-car/car/add?goodsId="+id,
			 success:function(result){
				 window.location.reload();
			 }
		});
	}
	function queryGoods() {
		var name = $("#name")[0];
		var nameValue = name.value;
		window.location.href="/shopping-car/goods/list?name=" + nameValue;
	}
	function viewImage(path){
		window.location.href="/shopping-car/" + path;
	}
</script>
</html>