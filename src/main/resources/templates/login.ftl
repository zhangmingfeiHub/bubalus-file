<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="">
		<meta name="keywords" content="">
		<meta name="viewport"
		      content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp"/>
		<title>文件服务管理系统</title>
		<link rel="shortcut icon" href=" /favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="/css/login/login.css">
		<link rel="stylesheet" type="text/css" href="/plugins/layui/css/layui.css">
	</head>
	<body>
		<div class="myapp-login">
			<div class="myapp-login-block">
				<div class="myapp-login-logo">
					<span></span>
				</div>
				<div class="myapp-login-logo-text">
					<span>文件系统</span>管理后台
				</div>
				
				<form class="layui-form" action="" lay-filter="example">
				  <div class="layui-form-item">
				    <label class="layui-form-label">输入框</label>
				    <div class="layui-input-block">
				      <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">密码框</label>
				    <div class="layui-input-block">
				      <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
				    </div>
				  </div>
				</form>
			</div>
		</div>
	</body>
</html>