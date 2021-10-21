<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cafe글 상세보기</title>
</head>
<link rel="stylesheet" href="../css/cafe.css">
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
<div style="width:80%; margin:auto;">
<h3>카페</h3>
<ul > 
	<li> 
	 <ul >
	 	<li>지역</li>
	 	<li>${cafe.location}</li>
	 	<li>상호</li>
	 	<li>${cafe.name}</li>
	 	<li>평점</li>
	 	<li>${cafe.grade}</li>
	 </ul>
	</li>
	<li> 
		<ul >
		 <li>내용</li>
		 <li>${cafe.content}</li>
		</ul>
	</li>
	<li> 
	 	<ul>
	 	 <li> 메뉴</li>
	 	 <li>${cafe.menu}</li>
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
		<li>${cafe.opentime} ~ ${cafe.closetime}</li>
	 </ul>
	</li>
	<li> 
		<ul >
			<li> 주소 </li>
			<li>${cafe.addr}</li>
		</ul>
	</li>
	 <li> 
	  <ul >
	  	<li> 전화 번호</li>
	  	<li>${cafe.phone}</li>
	  </ul>
	 </li>
</ul>
<div>
	<a class="button" href="cafeUpdate.jsp">수정</a>
	<a class="button" href="">삭제</a>
	<a class="button" href="">좋아요</a>
	<a class="button" href="">메인화면</a>
</div>
</div>
<!--  -------------------------------------------------------  -->
<!-- 리뷰 -->
<form action=""method="post" enctype="multipart/form-data">
	<input type="hidden" value="{}">
	<hr class="line">
	<div>
	<span> 리뷰</span>
	<span>리뷰수{}</span>
	</div>
	<hr class="line">
 <ul>
 <li>
  <ul>
  	<li> 작성자</li>
  	<li> <input type="text" class="input" value="user 아이디">  </li>
  	 <li> 점수</li>
  	 <li> <input type="text" class="input"> </li>
  </ul>
 </li>
 <li> 
 	<ul>
 		<li> 
 			<textarea rows="3" cols="80" placeholder ="리뷰를 작성해주세요"
 			class="input" required></textarea>
 		</li>
 	</ul>
 </li>
 <li>
 	<ul>
 	<li> 
 		<input type="file" name="pic" accept="image/*" placeholder="이미지 파일을 선택해주세요"> <br>
 	</li>
 	<li> 
 		<input type="submit" value="저장" class="button small">
		<input type="reset" value="취소" class="button small">
 	</li>
 	</ul>
  </li>

 <hr>
 <%--  <c:forEach var="" items="{}"></c:forEach> --%>
  <li> 
 	<ul>
 		<li>{작성자 아이디}</li>
 		<li> 리뷰점수 : {리뷰 점수}</li>
 		<li><a href="" >삭제</a></li>
 	</ul>
  </li>
   <li> 
   	<ul>
   	  <pre> {작성 리뷰}</pre>
   	</ul>
   </li>
   <li> 
   	<ul>
   		<div> 
   			<img alt="cafe" src="">
   		</div>
   	</ul>
   </li>
</ul>
 </form>
</section>
<hr>

</body>
</html>