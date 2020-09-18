<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<script src="${contextPath}/shopping-car/js/jquery.min.js"></script>
<link rel="stylesheet" href="${contextPath}/shopping-car/css/bootstrap.min.css">
<script src="${contextPath}/shopping-car/js/bootstrap.min.js"></script>
<script src="${contextPath}/shopping-car/js/ajaxfileupload.js"></script>

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
				<form action="/shopping-car/user/register" method="post" role="form">
					<div class="input-group input-group-md">
						<span class="input-group-addon" id="sizing-addon1"><i
							class="glyphicon glyphicon-user" aria-hidden="true"></i></span> <input
							type="text" class="form-control" id="name" name="name"
							placeholder="Please input Name" />
					</div>
					<div class="input-group input-group-md">
						<span class="input-group-addon" id="sizing-addon1"><i
							class="glyphicon glyphicon-lock"></i></span> <input type="text"
							class="form-control" id="price" name="price" onblur="isNum('price')"
							placeholder="Please input Price" />
					</div>
					<div class="input-group input-group-md">
						<span class="input-group-addon" id="sizing-addon1"><i
							class="glyphicon glyphicon-lock"></i></span> <input type="text"
							class="form-control" id="leftCount" name="leftCount" onblur="isNum('leftCount')"
							placeholder="Please input Count" />
					</div>
					<div class="input-group input-group-md">
						<span class="input-group-addon" id="sizing-addon1"><i
							class="glyphicon glyphicon-lock"></i></span> <input type="file"
							class="form-control" id="file" name="file" onchange="uploadField('file')"/>
					</div>
					<div class="input-group input-group-md">
						<span class="input-group-addon" id="sizing-addon1"><i
							class="glyphicon glyphicon-lock"></i></span>
						<input type="hidden" name="image" id="image" value="">
						<img src="#" id="img">
					</div>
					<br/>
					<button type="submit" class="btn btn-success btn-block">Register</button>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function isNum(id) {
		var obj = $("#" + id)[0];
		var val = obj.value;
		if(isNaN(val)){
			
		}
		
	}
	function uploadField(id) {
		$.ajaxFileUpload
        (
            {
                url: '/shopping-car/goods/fileUpload', //用于文件上传的服务器端请求地址
                secureuri: false, //是否需要安全协议，一般设置为false
                fileElementId: id, //文件上传域的ID
                dataType: 'json', //返回值类型 一般设置为json
                success: function (data, status)  //服务器成功响应处理函数
                {
                    $("#img").attr("src", data.data);
                },
                error: function (data, status, e)//服务器响应失败处理函数
                {
                	var response = JSON.parse(data.responseText);
                	$("#img").attr("src", response.data);
                }
            }
        )
        return false;
	}
</script>
</html>