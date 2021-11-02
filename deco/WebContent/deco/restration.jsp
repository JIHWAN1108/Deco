<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::deco::마이페이지</title>
<style>
.input{
text-align: left;
text-align: center;
text-align: right;
text-align: justify;
}
</style>
<link rel="stylesheet" href="css/mypage.css">
</head>
<body>
<%@ include file="../top.jsp" %>
<section>

<div class="menu-wrap">
      <h1>업체 등록</h1>
      <ul class="munu-list">
          <li><a href="cafeInsert.deco" class="btn-style">카페등록</a></li>
          <li><a href="foodInsert.deco" class="btn-style">식당등록</a></li>
          <li><a href="showsInsert.deco" class="btn-style">공연등록</a></li>
          <li><a href="etcInsert.deco" class="btn-style">이색등록</a></li>
      </ul>
  </div>
</section>
<%@ include file="../bottom.jsp" %>
	
</body>
</html>