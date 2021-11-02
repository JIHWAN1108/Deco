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
      <h1>마이페이지</h1>
      <ul class="munu-list">
          <li><a href="userInfo.deco" class="btn-style">회원정보</a></li>
          <li><a href="reviewList.deco" class="btn-style">리뷰목록</a></li>
          <li><a href="cafeDibsList.deco" class="btn-style">찜목록</a></li>
          <li><a href="" onclick = "deleteCmt()" class="btn-style">회원탈퇴</a></li>
      </ul>
  </div>
</section>
<%@ include file="../bottom.jsp" %>

<script>
function deleteCmt(){
		const yn = confirm('아이디를 삭제하시겠습니까?');
		if(yn){
			location.href='userInfoDelete.deco';
		}else {
			alert('아이디 삭제를 취소합니다.');
		}
	}
</script>	
</body>
</html>