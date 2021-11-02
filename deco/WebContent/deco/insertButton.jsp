<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::업체등록::</title>
</head>
<link rel="stylesheet" href="../css/cafe.css">
<body>
<%@ include file="../top.jsp" %>

<section>
<div >
 <input type="button" onclick="location.href='cafeInsert.deco'" value="카페업체등록"></input>
 <input type="button" onclick="location.href='foodInsert.deco'" value="식당업체등록"></input>
 <input type="button" onclick="location.href='showsInsert.deco'" value="공연 업체등록"></input>
 <input type="button" onclick="location.href='etcInsert.deco'" value="이색체험 업체등록"></input>
</div>
</section>

<%@ include file="../bottom.jsp" %>
</body>
</html>