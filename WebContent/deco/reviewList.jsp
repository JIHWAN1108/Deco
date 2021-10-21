<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<title>deco ::리뷰목록</title>
<body>
<div>
</div>
	<div>
	<form action="review.deco" method="get">
	<h3>리뷰리스트</h3>
	<c:forEach var="vo" items="${ReviewList}">
	<ul>
		<li>${vo.nickname }</li>
		<li>${vo.content }</li>
		<li>${vo.grade }</li>
	</ul>
	</c:forEach>
	</form>
	</div>
</body>
</html>