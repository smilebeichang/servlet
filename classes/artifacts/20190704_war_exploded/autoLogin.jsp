<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <h2>${sessionScope.msg }</h2> --%>
	<h2>${msg }</h2>
	<form action="autoLogin" method="post" >
		用户名:<input type="text" name="username"><br> 
		密码:<input type="password" name="pwd"><br> 
	          自动登入：<input type="checkbox"  value="true" name="autoLogin"> 
		<input type="submit" value="提交">
	</form>
</body>
</html>