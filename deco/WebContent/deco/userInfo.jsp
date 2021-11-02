<%@page import="com.deco.dao.UsersDao"%>
<%@page import="com.deco.dto.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::deco::회원정보</title>
<!-- 스타일 참고  -->
<link rel="stylesheet" href="css/userInfo.css">
</head>
<body>
<%@ include file="../top.jsp" %>
<form action="userinfoUpdate.deco" name="frmReg" method="post" class="decoJoin">
  <div class="decoJoinLogo">회원정보</div>
    <ul class="joinContens">
      <li class="joinEmail">
         
        <div class="joinTitle">이메일</div>
        <input type="text" name="email" id="str_email01" class="joinInput" readonly value="${dto.email }"> 
      </li>
      
      <!-- <li>
        <div class="joinTitle">비밀번호</div>
        <input type="password" name="password" placeholder="비밀번호" class="joinInput">
      </li>
      <li>
        <div class="joinTitle">비밀번호 확인</div>
        <input type="password" name="password1" placeholder="비밀번호 확인" class="joinInput">
      </li> -->
      <li>
        <div class="joinTitle">이름</div>
        <input type="text" name="name" placeholder="이름" class="joinInput" readonly value="${dto.name }">
      </li>
      <li class="joinGenderAge">
        <div class="gender">
          <div class="joinTitle">성별</div>
          <div class="genderInput">
            <input type="text" value="${dto.gender }" name="gender" id="male" class="joinInput" readonly>
          </div>
        </div>
        <div class="age">
          <div class="joinTitle">나이</div>
          <input type="number" name="age" min="10" max="99" class="joinInput" readonly	value="${dto.age }">
        </div>
      </li>
      <li>
        <div class="joinTitle">전화번호</div>
        <input type="text" name="phone" placeholder="전화번호를 입력하세요" class="joinInput" readonly value="${dto.phone }">
      </li>
      <li class="joinAddrLi">
        <div class="joinTitle">주소</div>
        <input name="addr" id="member_addr" class="joinInput" readonly value="${dto.addr }">
      </li>
      <li>
        <div class="joinTitle">닉네임</div>
        <input type="text" name="nickname" placeholder="닉네임을 입력하세요" class="joinInput" value="${dto.nickname }" readonly>
      </li>
      <li>
        <input type="button" value="수정 하기" class="joinInput submit" onclick = "location.href='userInfoUpdate.deco'">
      </li>
    </ul>
</form>
<%@ include file="../bottom.jsp" %>
</body>
</html>