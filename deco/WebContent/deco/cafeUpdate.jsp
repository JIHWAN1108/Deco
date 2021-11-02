<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::dec::cafe수정</title>
<%@ include file="../top.jsp" %>
<link rel="stylesheet" href="css/cafeInsert.css">
</head>
<body>

<%-- <nav>
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
</nav> --%>


<section>
<hr>
 <article>
        <div class="container" role="main">
            <div class="logo-wrap">
                <h1 class="logo_txt">Cafe</h1>
            </div>
            <div class="form_wrap">
       <form name="form" id="form" role="form" method="post"
                    action="cafeModify.deco?page=${page }" enctype="multipart/form-data">
                    <input type="hidden" name="idx" value="${cafe.idx} }">
                    <div class="form-control-wrap">
                        <label for="title">지역</label>
                        <input type="text" class="form-control" name="title" id="title" placeholder="강남" value="${cafe.location}">
                    </div>
                    <div class="form-control-wrap">
                        <label for="name">상호</label>
                        <input type="text" class="form-control" name="name" id="name" placeholder="" value="${cafe.name}"}>
                    </div>
                    <div class="form-control-wrap">
                        <label for="grade">평점</label>
                        <input type="number" class="form-control" name="grade" id="grade" value="5" max="5" min="1">
                    </div>
                    <div class="form-control-wrap">
                        <label for="menu1">메뉴</label>
                            <div class="menu_container">
                                <div class="menu_123">
                                    <div class="menu_el">
                                        메뉴1<input type="text" class="form-control" name="menu1" id="menu1" placeholder="ex) 아메리카노">
                                    </div>
                                    <div class="menu_el">
                                        가격1<input type="text" class="form-control" name="price1" id="price1" placeholder="ex) 3,000">원
                                    </div>
                                </div>
                                <div class="menu_123">
                                    <div class="menu_el">
                                        메뉴2<input type="text" class="form-control" name="menu2" id="menu2" placeholder="">
                                    </div>
                                    <div class="menu_el">
                                        가격2<input type="text" class="form-control" name="price2" id="price2" placeholder="">원
                                    </div>
                                </div>
                                <div class="menu_123">
                                    <div class="menu_el">
                                        메뉴3<input type="text" class="form-control" name="menu3" id="menu3" placeholder="">
                                    </div>
                                    <div class="menu_el">
                                        가격3<input type="text" class="form-control" name="price3" id="price3" placeholder="">원
                                    </div>
                                </div>
                            </div>
                    </div>
                    <div class="form-control-wrap">
                        <label for="content">내용</label>
                        <textarea class="form-control" rows="5" name="content" id="content"
                            placeholder="내용을 입력해 주세요"></textarea>
                    </div>
                    <div class="form-control-wrap">
                        <label for="openTime" class="ft-tit">영업시간</label>
                        <div class="form-time-wrap">
                            <span class="ft-tit">Open</span>
                            <input type="time" class="form-time" name="openTime" id="openTime">
                            <span class="ft-tit">Close</span>
                            <input type="time" class="form-time" name="closeTime" id="closeTime">
                        </div>
                    </div>
                    <div class="form-control-wrap">
                        <div class="form-img">
                            <div>
                                <div for="" class="pre-thumbnail">외부 사진</div>
                                <label for="file-upload" class="file-upload">업로드</label>
                                <div id="image_container"></div>
                                <input type="file" id="file-upload" accept="image/*">
                            </div>
                            <div id="view-thumbnail" class="thubmbail"></div>
                        </div>
                    </div>
                    <div class="form-control-wrap">
                        <div class="form-img">
                            <div >
                                <div for="" class="pre-thumbnail">내부 사진</div>
                                <label for="file-upload2" class="file-upload">업로드</label>
                                <input type="file" id="file-upload2" accept="image/*">
                            </div>
                            <div id="view-thumbnail2" class="thubmbail"></div>
                        </div>
                    </div>
                    <div class="form-control-wrap">
                        <label for="member_post">주소</label>
                        <input name="addr" type="button" id="member_post" value="주소 찾기" class="member_post" onclick="findAddr()" >
                        <input name="addr" id="member_addr" class="joinInput">
                        <!-- <input type="text" class="form-control" name="tag" id="tag" placeholder=""> -->
                    </div>
                    <div class="form-control-wrap">
                        <label for="tag">전화번호</label>
                        <input type="text" class="form-control" name="tag" id="tag" placeholder="010XXXXXXXX">
                    </div>
                    <div class="form-btn">
                        <!-- <button type="submit" class="btn">저장</button>
                        <button type="reset" class="btn">다시쓰기</button> -->
                        <input type="submit" value="등록 완료" class="submit">
                    </div>
                </form>
 </div>
 </div>
<hr>
    </article>
<%-- <form  method="post" action="cafeModify.deco?page=${page}" enctype="multipart/form-data" >
<div style="width:80%; margin:auto;">
<h3>카페</h3>
<input type="hidden" name="idx" value="${cafe.idx}">
<ul > 
	<li> 
	 <ul >
	 	<li>지역</li>
	 	<li> <input type ="text" name="location" value="${cafe.location}" required="required"> </li>
	 	<li>상호</li>
	 	<li><input type ="text" name="name" value="${cafe.name}" required="required"></li>
	 	<li>평점</li>
	 	<li><input type ="text" name="grade" value="${cafe.grade}" required="required"> </li>
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
	 <li>수정 전 사진</li>
	  <li> 
	 	<img alt="cafe" src="/image/${cafe.inimage}">
	 	<img alt="cafe" src="/image/${cafe.outimage}">
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
	 <ul> 
	 	<li>수정후 외부 사진</li>
	 	 <li> 
 		<input type="file" name="outimage" accept="image/*" placeholder="이미지 파일을 선택해주세요"
 		onchange="setThumbnail(event);"> 
 	</li>
 	<li> 
 	 <div id="image_container"></div>
 	</li>
	 </ul>
	</li>
	<li> 
	 <ul> 
	 	<li>수정후 내부 사진</li>
	 	 <li> 
 		<input type="file" name="inimage" accept="image/*" placeholder="이미지 파일을 선택해주세요"
 		onchange="setThumbnail2(event);"> 
 	</li>
 	<li> 
 	 <div id="image_container2"></div>
 	</li>
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
	
</div>
</div>
</form> --%>
</section>
<script type="text/javascript">
function setThumbnail(event) {
	var reader = new FileReader(); 
	reader.onload = function(event) { 
	var img = document.createElement("img"); 
	img.setAttribute("src", event.target.result); 
	document.querySelector("div#image_container").appendChild(img); }; 
	reader.readAsDataURL(event.target.files[0]); }	
	
function setThumbnail2(event) {
	var reader = new FileReader(); 
	reader.onload = function(event) { 
	var img = document.createElement("img"); 
	img.setAttribute("src", event.target.result); 
	document.querySelector("div#image_container2").appendChild(img); }; 
	reader.readAsDataURL(event.target.files[0]); }	
	
</script>

</body>
<%@ include file="../bottom.jsp" %>
</html>