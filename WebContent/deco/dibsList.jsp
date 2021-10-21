<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DECO 당신의 하루를 꾸미다.</title>
</head>
<body>
	<div>
		<c:if test="${sessionScope.user != null }">
			<!-- 로그인된 상태 -->
			<br>${user.name }(${user.email })  님 반갑습니다. <br>
			<a href="logout.deco" class="menu">로그아웃</a>
			<a href="" >마이페이지</a>
		</c:if>
		<h1>찜목록</h1>
	</div>
	<div>
		<ul>
			<li><a>카페</a></li>
			<li><a>맛집</a></li>
			<li><a>공연/전시</a></li>
			<li><a>체험/이색데이트</a></li>
		</ul>
	</div>
	<div>
		<c:forEach var="vo" items="${dibsCafe}">
			<ul>
		    	<li>${vo.name }</li>
		       	<li>${vo.content }</li>
		       	<li>연락처 : ${vo.phone }</li>
		       	<li>주소 : ${vo.addr }</li>
		       	<li>메뉴 : ${vo.menu }</li>
		       	<li>평점 : ${vo.grade }</li>
		       	<li>영업시간 : ${vo.opentime} ~ ${vo.closetime}</li>
		       	<li>${vo.location }</li>
		    </ul>
		</c:forEach>
	</div>
	
</body>
</html>




