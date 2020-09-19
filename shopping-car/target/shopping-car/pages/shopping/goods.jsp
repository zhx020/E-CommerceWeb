<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
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
			<button onclick="queryGoods()">Query</button>
		</div>
	</div>
	<div class="content">
		<table class="table table-striped table-bordered">
			<thead>
				<tr class="active">
					<th>Image</th>
					<th>Name</th>
					<th>Price</th>
					<th>Left Count</th>
					<th>Add Car</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${goods}" var="item">
					<tr>
						<td><img src="/shopping-car/images/${item.image}"
							class="img-rounded"></td>
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
	function addToCar(${item.id})() {
		
	}
	function queryGoods() {
		
	}
</script>
</html>