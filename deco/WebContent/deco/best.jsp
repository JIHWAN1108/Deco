<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="com.deco.controller.action.ActionForward"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home 화면</title>
<link rel="stylesheet" href="css/hotPlace.css">
<script src="https://kit.fontawesome.com/96c30f85d8.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="../top.jsp"%>
	<div class="decoList">
		<div class="hotplTitle">
			<div>DECO</div>
			<div>
				TOP<span>3</span>
			</div>
		</div>
		<div class="hotpleAll">
			<div class="category cafe">CAFE</div>
			<section class="lists cafe">
				<c:forEach var="vo" items="${CafeList}">
					<a class="list" href="cafe.deco?idx=${vo.idx}">
						<ul class="listContents">
							<li class="listName">${vo.content }</li>
							<li class="listText">수제 쿠키 맛집. 모든 재료는 직접 공수하며 매장에서 실제로 디저트를
								베이킹.</li>
							<li>
								<ul class="locationAndReveiwAndGrade">
									<li>${vo.location }</li>
									<li>리뷰 : ${reviewcnts[status.index]}</li>
									<li>평점 : ${vo.grade }</li>
								</ul>
							</li>
						</ul> 
						<img src="/image/${vo.outimage}" onerror="/image/${vo.outimage}" alt="cafe-out" class="img" width="200px" height="200px">
					</a>
				</c:forEach>
			</section>
			<div class="category restaurant">RESTAURANT</div>
			<section class="lists restaurant">
				<c:forEach var="vo" items="${FoodList}">
					<a class="list" href="food.deco?fidx=${vo.fidx}">
						<ul class="listContents">
							<li class="listName">${vo.content }</li>
							<li class="listText">수제 쿠키 맛집. 모든 재료는 직접 공수하며 매장에서 실제로 디저트를
								베이킹.</li>
							<li>
								<ul class="locationAndReveiwAndGrade">
									<li>${vo.location }</li>
									<li>리뷰 : ${reviewcnts[status.index]}</li>
									<li>평점 : ${vo.grade }</li>
								</ul>
							</li>
						</ul> <img src="/fimage/${vo.outimage}"
						onerror="/fimage/${vo.outimage}" alt="cafe-out" class="img"
						width="200px" height="200px">
					</a>
					</c:forEach>
			</section>
			<div class="category activity">ACTIVITY</div>
			<section class="lists activity">
				<c:forEach var="vo" items="${EtcList}">
					<a class="list" href="etc.deco?eidx=${vo.eidx}">
						<ul class="listContents">
							<li class="listName">${vo.content }</li>
							<li class="listText">수제 쿠키 맛집. 모든 재료는 직접 공수하며 매장에서 실제로 디저트를
								베이킹.</li>
							<li>
								<ul class="locationAndReveiwAndGrade">
									<li>${vo.location }</li>
									<li>리뷰 : ${reviewcnts[status.index]}</li>
									<li>평점 : ${vo.grade }</li>
								</ul>
							</li>
						</ul> <img src="/eimage/${vo.outimage}" onerror="/image/${vo.outimage}"
						alt="ecafe-out" class="img" width="200px" height="200px">
					</a>
				</c:forEach>
			</section>
			</div>
			</div>
			<%@ include file="../bottom.jsp"%>
</body>
</html>