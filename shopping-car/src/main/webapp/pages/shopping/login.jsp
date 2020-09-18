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
<script src="${request.contextPath}/shopping-car/js/jquery.min.js"></script>
<link rel="stylesheet"
	href="${contextPath}/shopping-car/css/bootstrap.min.css">
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
.row-centered {
	text-align: center;
}

.col-centered {
	display: inline-block;
	float: none;
	text-align: left;
	margin-right: -4px;
}
</style>
<body>
	<div class="container">
		<div class="row row-centered">
			<div class="well col-md-6 col-centered">
				<h2>Shopping Cart</h2>
				<form action="/shopping-car/user/login" method="post" role="form">
					<div class="input-group input-group-md">
						<span class="input-group-addon" id="sizing-addon1"><i
							class="glyphicon glyphicon-user" aria-hidden="true"></i></span> <input
							type="text" class="form-control" id="userName" name="userName"
							placeholder="Please input UserName" />
					</div>
					<div class="input-group input-group-md">
						<span class="input-group-addon" id="sizing-addon1"><i
							class="glyphicon glyphicon-lock"></i></span> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Please input Password" />
					</div>
					<br/>
					<button type="submit" class="btn btn-success btn-block">Login</button>
					<button type="button" class="btn btn-success btn-block" onclick="toRegisterPage()">Register</button>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function toRegisterPage() {
		window.location.href= "/shopping-car/pages/shopping/register.jsp"
	}
</script>
</html>