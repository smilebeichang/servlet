<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post" onsubmit="return check();">
		用户名:<input type="text" name="username"><br> 
		密码:<input type="password" name="pwd"><br> 
	        
		<input type="submit" value="提交">
	</form>
</body>
</html>
<script type="text/javascript">
   function check(){
	   var username = document.getElementsByName("username")[0].value;
	   var pwd = document.getElementsByName("pwd")[0].value;
	   if(username==""){
		   alert("用户名不能为空");
		   return false;
	   }
	   if(pwd==""){
		   alert("密码不能为空");
		   return false;
	   }
   }
</script>