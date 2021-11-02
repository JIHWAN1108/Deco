<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DECO 당신의 하루를 꾸미다</title>
<%@ include file="../top.jsp" %>
<link rel="stylesheet" href="css/cafeList.css">
<script src="https://kit.fontawesome.com/96c30f85d8.js"
	crossorigin="anonymous"></script>
</head>
<body>


	<div class="decoList">
		<nav class="category">
			<a href="cafeList.deco">Cafe</a> <a href="foodList.deco">Restaurant</a>
			<a href="showsList.deco">Show</a> <a href="etcList.deco">Activity</a>
		</nav>

		<section class="checkbox main">
			<!-- 파라미터 남아있게 하는게 숙제.... -->
			<form class="checkbox" action="">
				<div class="subTitle">지역</div>
				<div class="checkboxes">
					<label for="강남"><input type="checkbox" id="강남"
						name="location" value="강남" onclick="noCheckLocationAll(this)">강남</label>
					<label for="인사동"><input type="checkbox" id="인사동"
						name="location" value="인사동" onclick="noCheckLocationAll(this)">인사동</label>
					<label for="상수"><input type="checkbox" id="상수"
						name="location" value="상수" onclick="noCheckLocationAll(this)">상수</label>
					<label for="연남동"><input type="checkbox" id="연남동"
						name="location" value="연남동" onclick="noCheckLocationAll(this)">연남동</label>
					<label for="명동"><input type="checkbox" id="명동"
						name="location" value="명동" onclick="noCheckLocationAll(this)">명동</label>
					<label for="이태원"><input type="checkbox" id="이태원"
						name="location" value="이태원" onclick="noCheckLocationAll(this)">이태원</label>
					<label for="익선동"><input type="checkbox" id="익선동"
						name="location" value="익선동" onclick="noCheckLocationAll(this)">익선동</label>
					<label for="건대"><input type="checkbox" id="건대"
						name="location" value="건대" onclick="noCheckLocationAll(this)">건대</label>
					<label for="대학로"><input type="checkbox" id="대학로"
						name="location" value="대학로" onclick="noCheckLocationAll(this)">대학로</label>
					<label for="홍대"><input type="checkbox" id="홍대"
						name="location" value="홍대" onclick="noCheckLocationAll(this)">홍대</label>
					<label for="동대문"><input type="checkbox" id="동대문"
						name="location" value="동대문" onclick="noCheckLocationAll(this)">동대문</label>
					<label for="가로수길"><input type="checkbox" id="가로수길"
						name="location" value="가로수길" onclick="noCheckLocationAll(this)">가로수길</label>
					<label for="all"><input type="checkbox" id="all"
						name="locationAll" value="all" checked="checked"
						onclick="checkOnlyLocationAll(this)">전체선택</label>
				</div>
				<div class="checkButton">
					<button type="submit">
						<i class="fas fa-search"></i>
					</button>
					<button type="reset">
						<i class="fas fa-redo-alt"></i>
					</button>
				</div>
			</form>
		</section>



		<div class="searchResult">검색 결과</div>





		<section class="lists">
			<c:set var="pno" value="${pageDto.currentPage}" />
			<c:forEach var="vo" items="${CafeList}" varStatus="status">
				<a class="list" href="cafe.deco?idx=${vo.idx}&page=${pno}"> <img
					src="/cimage/${vo.outimage}"
					onerror="this.src='srcimg/기본이미지.png'" alt="cafe-out"
					class="img" width="150px" height="150px">
					<ul class="listContents">
						<li class="listName">${vo.name }</li>
						<li class="listText">${vo.content }</li>
						<li>
							<ul class="locationAndReveiwAndGrade">
								<li>${vo.location }</li>
								<li>리뷰수 :${reviewcnts[status.index]} </li>
								<li>${vo.grade }</li>
							</ul>
						</li>
					</ul>
				</a>
			</c:forEach>
		</section>
		<!--  <div style="text-align: center;"> -->
		<hr>
		<!-- href="listAction.jsp?page=1" 요청url 은 현재와 같을때 생략하고 ? 뒤에 파라미터값만 변경합니다. -->
		<c:if test="${pageDto.startPage!=1}">
			<a class="pagenum" href="?page=1">&lt;&lt;</a>
			<a class="pagenum" href="?page=${pageDto.startPage-1}">&lt;</a>
			<!-- startPage를 현재 startPage -10 -->
			<!-- 현재페이지를 startPage값에서 -1로 변경하면 요청이 변경되면서 자동 계산 -->
		</c:if>
	
	<div class="pagebutton">
		<c:forEach var="i" begin="${pageDto.startPage}"
			end="${pageDto.endPage}">
			<a
				class="pagenum
      	<c:if test="${pageDto.currentPage == i}">current</c:if>
      "
				href="?page=${i}">${i}</a>
		</c:forEach>

		<c:if test="${pageDto.endPage!=pageDto.totalPage}">
			<a class="pagenum" href="?page=${pageDto.endPage+1}">&gt;</a>

			<a class="pagenum" href="?page=${pageDto.totalPage}">&gt;&gt;</a>
		</c:if>
	</div>



	<hr>




	<script type="text/javascript">
  
  function checkOnlyLocationAll(element){
 	const choice = document.getElementsByName(`location`);
	choice.forEach(ch => ch.checked=false)
  } 
  
  function noCheckLocationAll(element){
  	const choice = document.getElementsByName(`locationAll`);
  	choice.forEach(ch => ch.checked=false)
  }
  
  </script>
  <div class="topBtn">
        <a href="#" title="위로 가기"><i class="fas fa-arrow-up"></i></a>
      </div>
  <%@ include file="../bottom.jsp" %>
</body>
</html>













