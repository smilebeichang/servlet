<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty user }">
		<h2><a href="autoLogin.jsp">还未登入，请点击登入</a></h2>
	</c:if>
	<c:if test="${not empty user }">
		<h2>欢迎你：${sessionScope.user.username }</h2>
	</c:if>
</body>
</html>