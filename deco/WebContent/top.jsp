<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">

  <title>Document</title>
  <link rel="stylesheet" href="top_bottom.css">
  <script src="top.js" defer>
  	
  </script>
</head>
<body>
<header class="topheader">
    <a href="home.deco" class="logo">
      <div class="toplogo">
        DECO
      </div>
    </a>
    <ul class="topmenu">
      <li><a href="cafeList.deco">Search</a></li>
      <li><a href="best.deco">Hot Place</a></li>
      <li><a href="restration.deco">Registration</a></li>
      <li><a href="mypage.deco">My Page</a></li>
    </ul>
    <div class="topnickname">
      <a href="">${user.name }</a>
      <span> 님 반갑습니다.</span>
      <a href="logout.deco" class="topmenu">로그아웃</a>
    </div>
    <a href="#" class="hamburger"><i class="fas fa-bars"></i></a>
  </header>



<%-- 
  <header class="header">
  <a href="home.deco" class="logo">
    <div class="logo">
      DECO
    </div>
    </a>
    <ul class="menu">
      <li><a href="cafeList.deco">Search</a></li>
      <li><a href="best.deco">Hot Place</a></li>
      <li><a href="mypage.deco">My Page</a></li>
      <li><a href="restration.deco">Restration</a></li>
         
    </ul>
    <div class="nickname">
     <!-- <li id="logintest"> -->
        <c:if test="${sessionScope.user == null}">
	<a href="home_login.deco">로그인</a>
	</c:if>
	<c:if test="${sessionScope.user != null}">
	<!-- 로그인 된 상태 -->
	<br>(${user.nickname }) 님. 반갑습니다. <br>
	<a href="logout.deco" class="menu">로그아웃</a>
	</c:if>
	<a href="mypage.deco" class="menu">마이페이지</a>
	<!-- </li> -->
    </div>
    <a href="#" class="hamburger"><i class="fas fa-bars"></i></a>
  </header> --%>
</body>
</html>