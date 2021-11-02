<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/flexbox2.css?v=3">
</head>
<body>
<div>
<ul class = "container">
<li><a class="menu" href="list.deco">cafelist</a></li>
<li><a class="menu" href="logoutAction.deco">logout</a></li>
 
        <li id="logintest">
        <c:if test="${sessionScope.user == null}">
	<a href="login.deco">로그인</a>
	</c:if>
	<c:if test="${sessionScope.user != null}">
	<!-- 로그인 된 상태 -->
	<br>${user.name}(${user.email }) 님. 반갑습니다. <br>
	<a href="logout.deco" class="menu">로그아웃</a>
	</c:if>
	<a href="mypage.deco" class="menu">마이페이지</a>
	</li>
</ul>
		</div>
</body>
</html>