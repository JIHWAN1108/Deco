<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cafe글 수정하기</title>
</head>
<body>
<h1 id="title"><img id="icon" alt="icon" src="../img/icon2.png">deco</h1>

<nav>
	<ul>
	<li id="login" >
    <c:if test="${sessionScope.user == null }">
		<a href="login.do" class="menu">로그인</a>
	</c:if>
		<c:if test="${sessionScope.user != null }">
		<!-- 로그인된 상태 -->
		<br>${user.name }(${user.email })  님 반갑습니다. <br>
		<a href="logout.do" class="menu">로그아웃</a>
		<a href="" >마이페이지</a>
	</c:if>
    	</li>
    </ul>
</nav>


<section>
<hr>
<form  method="post" action="edit.deco" >
<div style="width:80%; margin:auto;">
<h3>카페</h3>
<input type="hidden" name="idx"value="${cafe.idx}">
<ul > 
	<li> 
	 <ul >
	 	<li>지역</li>
	 	<li> <input type ="text" name="location"value="${cafe.location}" required="required"> </li>
	 	<li>상호</li>
	 	<li><input type ="text" name="name"value="${cafe.name}" required="required"></li>
	 	<li>평점</li>
	 	<li><input type ="text" name="grade"value="${cafe.grade}" required="required"> </li>
	 </ul>
	</li>
	<li> 
		<ul >
		 <li>내용</li>
		 <li><input type ="text" name="content"value="${cafe.content}" required="required"></li>
		</ul>
	</li>
	<li> 
	 	<ul>
	 	 <li> 메뉴</li>
	 	 <li>  <input type ="text" name="menu"value="${cafe.menu}" required="required"></li>
	 	</ul>
	</li>
	<li> 
	 <ul >
	  <li> 
	 	<img alt="cafe" src="">
	  </li>
	 </ul>
	</li>
	<li> 
	 <ul >
	 	
		<li>영업시간</li>
		<li><input type ="text" name="opentime"value="${cafe.opentime}" required="required"></li>
		<li><input type ="text" name="closetime"value="${cafe.closetime}" required="required"></li>
	 </ul>
	</li>
	<li> 
		<ul >
			<li> 주소 </li>
			<li> <input type ="text" name="addr"value="${cafe.addr}" required="required"></li>
		</ul>
	</li>
	 <li> 
	  <ul >
	  	<li> 전화 번호</li>
	  	<li> <input type ="text" name="phone"value="${cafe.phone}" required="required"></li>
	  </ul>
	 </li>
</ul>
<div>
	<input type="submit" value="저장" class="">
	<input type="reset" value="다시쓰기" class="">
	<input type="button" value="목록" onclick="location.href='list.deco'" class="">
	
</div>
</div>
</form>
</section>




</body>
</html>